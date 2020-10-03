package titlesParser.tokenizer;

import java.io.*;

public class Tokenizer {

    private int line;
    private int column;
    private BufferedReader reader;
    private CKTitles token;
    private int integer;
    private float decimalValue;
    private boolean truth;
    private String id;

    public Tokenizer(String sourceFile) {
        try {
            line = 1;
            column = 1;
            reader = new BufferedReader(new FileReader(sourceFile));

            reader.mark(1);
            if (reader.read() != 0xFEFF) {  // UTF-8 BOM
                reader.reset();
            }

            nextToken();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // get the next token
    public void nextToken() {
        int c = getChar();

        // remove whitespace
        while (c != -1 && Character.isWhitespace(c) || Character.isSpaceChar(c)) {
            c = getChar();
        }
        // end of file
        if (c == -1) {
            token = CKTitles.EOF;
            return;
        }

        while (c == '#') {                      // remove # and everything after on the line
            while (c != -1 && c != '\r') {
                c = getChar();
            }
            c = getChar();  // \n
            while (c != -1 && Character.isWhitespace(c)) { // remove any whitespace before next char
                c = getChar();
            }
        }
        // end of file
        if (c == -1) {
            token = CKTitles.EOF;
            return;
        }

        // make sure char is valid symbol
        if (!isValidCharacter(c)) {
            System.err.println("Error: Unrecognized symbol: " + Character.toString(c));
            System.err.println("line " + line + " column " + column);
            System.exit(1);
        }

        // single character symbols
        switch (c) {
            case '{' -> {
                token = CKTitles.LBRACKET;
                return;
            }
            case '}' -> {
                token = CKTitles.RBRACKET;
                return;
            }
            case '=' -> {
                token = CKTitles.EQUAL;
                return;
            }
        }

        // construct word
        StringBuilder word = new StringBuilder(Character.toString(c));
        while (isValidID(peekChar())) {
            c = getChar();
            word.append(Character.toString(c));
        }

        // see if word is an integer or float
        try {
            integer = Integer.parseInt(word.toString());
            token = CKTitles.INTEGER;
            return;
        } catch (NumberFormatException ignored) {}

        try {
            decimalValue = Float.parseFloat(word.toString());
            token = CKTitles.DECIMAL;
            return;
        } catch (NumberFormatException ignored) {}

        switch (word.toString()) {
            // --- symbols ---
            case "{":
                token = CKTitles.LBRACKET;
                return;
            case "}":
                token = CKTitles.RBRACKET;
                return;
            case "=":
                token = CKTitles.EQUAL;
                return;
            // --- attributes ---
            case "province":
                token = CKTitles.PROVINCE;
                return;
            case "color":
                token = CKTitles.COLOR;
                return;
            case "color2":
                token = CKTitles.COLOR2;
                return;
            case "definite_form":
                token = CKTitles.DEFINITE_FORM;
                return;
            case "capital":
                token = CKTitles.CAPITAL;
                return;
            case "ruler_uses_title_name":
                token = CKTitles.RULER_USES_TITLE_NAME;
                return;
            case "landless":
                token = CKTitles.LANDLESS;
                return;
            case "no_automatic_claims":
                token = CKTitles.NO_AUTOMATIC_CLAIMS;
                return;
            case "always_follows_primary_heir":
                token = CKTitles.ALWAYS_FOLLOWS_PRIMARY_HEIR;
                return;
            case "destroy_if_invalid_heir":
                token = CKTitles.DESTROY_IF_INVALID_HEIR;
                return;
            case "ai_primary_priority":
                token = CKTitles.AI_PRIMARY_PRIORITY;
                return;
            case "cultural_names":
                token = CKTitles.CULTURAL_NAMES;
                return;
            case "male_names":
                token = CKTitles.MALE_NAMES;
                return;
            //  --- yes/no ---
            case "yes":
                token = CKTitles.TRUTH;
                truth = true;
                return;
            case "no":
                token = CKTitles.TRUTH;
                truth = false;
                return;
            case "if":
                token = CKTitles.IF;
                return;
            case "limit":
                token = CKTitles.LIMIT;
                return;
            case "culture":
                token = CKTitles.CULTURE;
                return;
            case "OR":
                token = CKTitles.OR;
                return;
            case "NOT":
                token = CKTitles.NOT;
                return;
            case "trigger_if":
                token = CKTitles.TRIGGER_IF;
                return;
            case "can_create":
                token = CKTitles.CAN_CREATE;
                return;
            case "de_jure_drift_disabled":
                token = CKTitles.DE_JURE_DRIFT_DISABLED;
                return;
            case "faith":
                token = CKTitles.FAITH;
                return;
            case "is_ai":
                token = CKTitles.IS_AI;
                return;
            case "culture_group":
                token = CKTitles.CULTURE_GROUP;
                return;
            case "has_title":
                token = CKTitles.HAS_TITLE;
                return;
            case "exists":
                token = CKTitles.EXISTS;
                return;
            case "always":
                token = CKTitles.ALWAYS;
                return;
            case "has_culture_group":
                token = CKTitles.HAS_CULTURE_GROUP;
                return;
            case "hsv":
                token = CKTitles.HSV;
                return;
            case "add":
                token = CKTitles.ADD;
                return;
            case "can_be_named_after_dynasty":
                token = CKTitles.CAN_BE_NAMED_AFTER_DYNASTY;
                return;
            case "religion_tag":
                token = CKTitles.RELIGION_TAG;
                return;
            case "has_doctrine":
                token = CKTitles.HAS_DOCTRINE;
                return;
            case "can_create_on_partition":
                token = CKTitles.CAN_CREATE_ON_PARTITION;
                return;
            default:
                break;
        }

        // --- variables ---
        if (word.charAt(0) == '@') {
            token = CKTitles.VARIABLE;
            id = word.toString();
            return;
        }

        // --- titles ---
        try {
            switch (word.substring(0, 2)) {
                case "e_":
                    token = CKTitles.EMPIRE;
                    id = word.toString();
                    return;
                case "k_":
                    token = CKTitles.KINGDOM;
                    id = word.toString();
                    return;
                case "d_":
                    token = CKTitles.DUCHY;
                    id = word.toString();
                    return;
                case "c_":
                    token = CKTitles.COUNTY;
                    id = word.toString();
                    return;
                case "b_":
                    token = CKTitles.BARONY;
                    id = word.toString();
                    return;
                default:
                    break;
            }
        } catch (Exception ignored) { }

        // if it's not anything else then it's an id (e.g. a cultural or male name)
        token = CKTitles.ID;
        id = word.toString();

    }

    // get the current token in file
    public CKTitles getToken() {
        return this.token;
    }

    public boolean getTruth() {
        return truth;
    }

    public int getInteger() {
        return integer;
    }

    public String getId() {
        return id;
    }

    public float getDecimalValue() {
        return decimalValue;
    }

    // used to look at next char
    public int peekChar() {
        int c = -1;
        try {
            reader.mark(1);
            c = reader.read();
            reader.reset();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return c;
    }

    // retrieves a character from the reader and keeps track of line and column position
    private int getChar() {
        try {
            int c = reader.read();

            if (c == '\r') {
                line++;
                column = 1;
            } else if (c != '\n') {
                column++;
            }

            return c;
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }

    // determines if the parameter character is valid for the language
    private boolean isValidCharacter(int c) {
        boolean output = false;
        if (c != -1 && Character.isLetterOrDigit(c)) {
            output = true;
        } else {
            switch (c) {
                case '_':
                case '.':
                case '=':
                case '{':
                case '}':
                case '@':
                case ':':
                case '-':
                case '\'':
                    output = true;
                    break;
            }
        }
        return output;
    }

    // used only for multi-character strings
    // difference is no =, {, or {
    private boolean isValidID(int c) {
        boolean output = false;
        if (c != -1 && Character.isLetterOrDigit(c)) {
            output = true;
        } else {
            switch (c) {
                case '_':
                case '.':
                case '@':
                case ':':
                case '-':
                case '\'':
                    output = true;
                    break;
            }
        }
        return output;
    }

    public int getLine() {
        return this.line;
    }

    public int getColumn() {
        return this.column;
    }

    // only used for debug purposes
    public void printContents() {
        System.err.println("line: " + line);
        System.err.println("column: " + column);
        System.err.println("currentToken: " + token.toString());
        System.err.println("integer: " + integer);
        System.err.println("decimal: " + decimalValue);
        System.err.println("truth: " + truth);
        System.err.println("id: " + id);
    }

}

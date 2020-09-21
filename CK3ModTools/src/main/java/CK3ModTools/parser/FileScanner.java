package CK3ModTools.parser;

import CK3ModTools.parser.Token;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileScanner {

    private Scanner scanner;
    private Token currentToken;
    private String titleName;
    private String variable;
    private int constant;
    private boolean truth;
    private String id;

    public FileScanner(String sourceFile) {
        File file = new File(sourceFile);

        try {
            scanner = new Scanner(file);
            scanner.useDelimiter("\\s|#.+");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    // get the next token
    public void nextToken() {
        // stop scanning if file scanner has no more strings
        if (!scanner.hasNext()) {
            currentToken = Token.EOF;
            return;
        }

        // ignore empty strings
        String word = scanner.next();
        while (word.length() < 1) {
            word = scanner.next();
        }

        // variables and constants
        if (word.charAt(0) == '@') {
            currentToken = Token.VARIABLE;
            variable = word;
            return;
        } else if (Character.isDigit(word.charAt(0))) {
            currentToken = Token.CONSTANT;
            constant = Integer.parseInt(word);
            return;
        }

        switch(word) {
            // --- symbols ---
            case "{":
                currentToken = Token.LBRACKET;
                return;
            case "}":
                currentToken = Token.RBRACKET;
                return;
            case "=":
                currentToken = Token.EQUAL;
                return;
            // --- attributes ---
            case "province":
                currentToken = Token.PROVINCE;
                return;
            case "color":
                currentToken = Token.COLOR;
                return;
            case "color2":
                currentToken = Token.COLOR2;
                return;
            case "definite_form":
                currentToken = Token.DEFINITE_FORM;
                return;
            case "capital":
                currentToken = Token.CAPITAL;
                return;
            case "ruler_uses_title_name":
                currentToken = Token.RULER_USES_TITLE_NAME;
                return;
            case "landless":
                currentToken = Token.LANDLESS;
                return;
            case "no_automatic_claims":
                currentToken = Token.NO_AUTOMATIC_CLAIMS;
                return;
            case "always_follows_primary_heir":
                currentToken = Token.ALWAYS_FOLLOWS_PRIMARY_HEIR;
                return;
            case "destroy_if_invalid_heir":
                currentToken = Token.DESTROY_IF_INVALID_HEIR;
                return;
            case "ai_primary_priority":
                currentToken = Token.AI_PRIMARY_PRIORITY;
                return;
            case "cultural_names":
                currentToken = Token.CULTURAL_NAMES;
                return;
            case "males_names":
                currentToken = Token.MALE_NAMES;
                return;
            //  --- yes/no ---
            case "yes":
                currentToken = Token.TRUTH;
                truth = true;
                return;
            case "no":
                currentToken = Token.TRUTH;
                truth = false;
            default:
                break;
        }
        // --- titles ---
        switch (word.substring(0, 2)) {
            case "e_":
                currentToken = Token.EMPIRE;
                titleName = word;
                return;
            case "k_":
                currentToken = Token.KINGDOM;
                titleName = word;
                return;
            case "d_":
                currentToken = Token.DUCHY;
                titleName = word;
                return;
            case "c_":
                currentToken = Token.COUNTY;
                titleName = word;
                return;
            case "b_":
                currentToken = Token.BARONY;
                titleName = word;
                return;
            default:
                break;
        }

        // if it's not anything else then it's an id (e.g. a cultural or male name)

        currentToken = Token.ID;
        id = word;

        // I think all bases are covered but I'm probably wrong
    }

    // get the current token in file
    public Token getCurrentToken() {
        return this.currentToken;
    }

    public boolean getTruth() {
        return truth;
    }

    public String getVariable() {
        return variable;
    }

    public int getConstant() {
        return constant;
    }

    public String getTitleName() {
        return titleName;
    }

    public String getId() {
        return id;
    }

}

package titlesParser;

import titlesParser.titles.*;
import titlesParser.tokenizer.*;
import titlesParser.logic.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

import static titlesParser.tokenizer.CKTitles.EMPIRE;

public class FileParser {

    Tokenizer tokenizer;
    HashMap<String, Integer> variables;
    ArrayList<Title> titles;

    public FileParser(Tokenizer tokenizer) {
        this.tokenizer = tokenizer;
        variables = new HashMap<>();
        titles = new ArrayList<>();
    }

    public void parse() {

        while (tokenizer.getToken() != CKTitles.EOF) {
            switch (tokenizer.getToken()) {
                case EMPIRE -> titles.add(parseEmpire());
                case KINGDOM -> titles.add(parseKingdom());
                case DUCHY -> titles.add(parseDuchy());
                case COUNTY -> titles.add(parseCounty());
                case BARONY -> titles.add(parseBarony());
                case VARIABLE -> variables.put(tokenizer.getId(), parseInt());
                default -> {
                    System.err.println("Unexpected token " + tokenizer.getToken().toString());
                    var e = new RuntimeException();
                    e.printStackTrace();
                    tokenizer.printContents();
                    System.exit(1);
                }
            }
        }

    }

    private Empire parseEmpire() {
        Empire empire = new Empire();

        empire.setName(tokenizer.getId());
        tokenizer.nextToken();
        tokenizer.nextToken();    // =
        tokenizer.nextToken();    // {

        while (tokenizer.getToken() != CKTitles.RBRACKET) {
            switch (tokenizer.getToken()) {
                case KINGDOM -> empire.addKingdom(parseKingdom());
                case DUCHY -> empire.addDuchy(parseDuchy());
                case COUNTY -> empire.addCounty(parseCounty());
                case BARONY -> empire.addBarony(parseBarony());
                case COLOR -> empire.setColor(parseColor());
                case COLOR2 -> empire.setColor2(parseColor());
                case DEFINITE_FORM -> empire.setDefiniteForm(parseBoolean());
                case CAPITAL -> empire.setCapital(parseString());
                case RULER_USES_TITLE_NAME -> empire.setRulerUsesTitleName(parseBoolean());
                case LANDLESS -> empire.setLandless(parseBoolean());
                case NO_AUTOMATIC_CLAIMS -> empire.setNoAutomaticClaims(parseBoolean());
                case ALWAYS_FOLLOWS_PRIMARY_HEIR -> empire.setAlwaysFollowsPrimaryHeir(parseBoolean());
                case DESTROY_IF_INVALID_HEIR -> empire.setDestroyIfInvalidHeir(parseBoolean());
                case CAN_BE_NAMED_AFTER_DYNASTY -> empire.setCanBeNamedAfterDynasty(parseBoolean());
                case AI_PRIMARY_PRIORITY -> empire.setAiPrimaryPriority(parsePriority());
                case CAN_CREATE -> empire.setCanCreate(parseCanCreate());
                case DE_JURE_DRIFT_DISABLED -> empire.setDejureDriftDisabled(parseBoolean());
                case CULTURAL_NAMES -> empire.setCulturalNames(parseCulturalNames());
                case MALE_NAMES -> empire.setMaleNames(parseMaleNames());
                case CAN_CREATE_ON_PARTITION -> empire.setCanCreateOnPartition(parseCanCreateOnPartition());
                default -> {
                    System.out.println("Unexpected token " + tokenizer.getToken().toString());
                    var e = new RuntimeException();
                    e.printStackTrace();
                    tokenizer.printContents();
                    System.exit(1);
                }
            }
        }
        tokenizer.nextToken();    // }

        return empire;
    }

    private Kingdom parseKingdom() {
        Kingdom kingdom = new Kingdom();

        kingdom.setName(tokenizer.getId());
        tokenizer.nextToken();
        tokenizer.nextToken();    // =
        tokenizer.nextToken();    // {

        while (tokenizer.getToken() != CKTitles.RBRACKET) {
            switch (tokenizer.getToken()) {
                case DUCHY -> kingdom.addDuchy(parseDuchy());
                case COUNTY -> kingdom.addCounty(parseCounty());
                case BARONY -> kingdom.addBarony(parseBarony());
                case COLOR -> kingdom.setColor(parseColor());
                case COLOR2 -> kingdom.setColor2(parseColor());
                case DEFINITE_FORM -> kingdom.setDefiniteForm(parseBoolean());
                case CAPITAL -> kingdom.setCapital(parseString());
                case RULER_USES_TITLE_NAME -> kingdom.setRulerUsesTitleName(parseBoolean());
                case LANDLESS -> kingdom.setLandless(parseBoolean());
                case NO_AUTOMATIC_CLAIMS -> kingdom.setNoAutomaticClaims(parseBoolean());
                case ALWAYS_FOLLOWS_PRIMARY_HEIR -> kingdom.setAlwaysFollowsPrimaryHeir(parseBoolean());
                case DESTROY_IF_INVALID_HEIR -> kingdom.setDestroyIfInvalidHeir(parseBoolean());
                case CAN_BE_NAMED_AFTER_DYNASTY -> kingdom.setCanBeNamedAfterDynasty(parseBoolean());
                case AI_PRIMARY_PRIORITY -> kingdom.setAiPrimaryPriority(parsePriority());
                case CAN_CREATE -> kingdom.setCanCreate(parseCanCreate());
                case CAN_CREATE_ON_PARTITION -> kingdom.setCanCreateOnPartition(parseCanCreateOnPartition());
                case DE_JURE_DRIFT_DISABLED -> kingdom.setDejureDriftDisabled(parseBoolean());
                case CULTURAL_NAMES -> kingdom.setCulturalNames(parseCulturalNames());
                case MALE_NAMES -> kingdom.setMaleNames(parseMaleNames());
                default -> {
                    System.out.println("Unexpected token " + tokenizer.getToken().toString());
                    tokenizer.printContents();
                    var e = new RuntimeException();
                    e.printStackTrace();
                    System.exit(1);
                }
            }
        }
        tokenizer.nextToken();    // }

        return kingdom;
    }

    private Duchy parseDuchy() {
        Duchy duchy = new Duchy();

        duchy.setName(tokenizer.getId());
        tokenizer.nextToken();
        tokenizer.nextToken();    // =
        tokenizer.nextToken();    // {

        while (tokenizer.getToken() != CKTitles.RBRACKET) {
            switch (tokenizer.getToken()) {
                case COUNTY -> duchy.addCounty(parseCounty());
                case BARONY -> duchy.addBarony(parseBarony());
                case COLOR -> duchy.setColor(parseColor());
                case COLOR2 -> duchy.setColor2(parseColor());
                case DEFINITE_FORM -> duchy.setDefiniteForm(parseBoolean());
                case CAPITAL -> duchy.setCapital(parseString());
                case RULER_USES_TITLE_NAME -> duchy.setRulerUsesTitleName(parseBoolean());
                case LANDLESS -> duchy.setLandless(parseBoolean());
                case NO_AUTOMATIC_CLAIMS -> duchy.setNoAutomaticClaims(parseBoolean());
                case ALWAYS_FOLLOWS_PRIMARY_HEIR -> duchy.setAlwaysFollowsPrimaryHeir(parseBoolean());
                case DESTROY_IF_INVALID_HEIR -> duchy.setDestroyIfInvalidHeir(parseBoolean());
                case CAN_BE_NAMED_AFTER_DYNASTY -> duchy.setCanBeNamedAfterDynasty(parseBoolean());
                case AI_PRIMARY_PRIORITY -> duchy.setAiPrimaryPriority(parsePriority());
                case CAN_CREATE -> duchy.setCanCreate(parseCanCreate());
                case CAN_CREATE_ON_PARTITION -> duchy.setCanCreateOnPartition(parseCanCreateOnPartition());
                case DE_JURE_DRIFT_DISABLED -> duchy.setDejureDriftDisabled(parseBoolean());
                case CULTURAL_NAMES -> duchy.setCulturalNames(parseCulturalNames());
                case MALE_NAMES -> duchy.setMaleNames(parseMaleNames());
                default -> {
                    System.out.println("Unexpected token " + tokenizer.getToken().toString());
                    tokenizer.printContents();
                    var e = new RuntimeException();
                    e.printStackTrace();
                    System.exit(1);
                }
            }
        }
        tokenizer.nextToken();    // }

        return duchy;
    }

    private County parseCounty() {
        County county = new County();

        county.setName(tokenizer.getId());
        tokenizer.nextToken();
        tokenizer.nextToken();    // =
        tokenizer.nextToken();    // {

        while (tokenizer.getToken() != CKTitles.RBRACKET) {
            switch (tokenizer.getToken()) {
                case BARONY -> county.addBarony(parseBarony());
                case COLOR -> county.setColor(parseColor());
                case COLOR2 -> county.setColor2(parseColor());
                case DEFINITE_FORM -> county.setDefiniteForm(parseBoolean());
                case CAPITAL -> county.setCapital(parseString());
                case RULER_USES_TITLE_NAME -> county.setRulerUsesTitleName(parseBoolean());
                case LANDLESS -> county.setLandless(parseBoolean());
                case NO_AUTOMATIC_CLAIMS -> county.setNoAutomaticClaims(parseBoolean());
                case ALWAYS_FOLLOWS_PRIMARY_HEIR -> county.setAlwaysFollowsPrimaryHeir(parseBoolean());
                case DESTROY_IF_INVALID_HEIR -> county.setDestroyIfInvalidHeir(parseBoolean());
                case AI_PRIMARY_PRIORITY -> county.setAiPrimaryPriority(parsePriority());
                case CAN_CREATE -> county.setCanCreate(parseCanCreate());
                case CULTURAL_NAMES -> county.setCulturalNames(parseCulturalNames());
                case MALE_NAMES -> county.setMaleNames(parseMaleNames());
                default -> {
                    System.out.println("Unexpected token " + tokenizer.getToken().toString());
                    tokenizer.printContents();
                    var e = new RuntimeException();
                    e.printStackTrace();
                    System.exit(1);
                }
            }
        }
        tokenizer.nextToken();    // }

        return county;
    }

    private Barony parseBarony() {
        Barony barony = new Barony();

        barony.setName(tokenizer.getId());
        tokenizer.nextToken();
        tokenizer.nextToken();    // =
        tokenizer.nextToken();    // {

        while (tokenizer.getToken() != CKTitles.RBRACKET) {
            switch (tokenizer.getToken()) {
                case PROVINCE -> barony.setProvince(parseInt());
                case COLOR -> barony.setColor(parseColor());
                case COLOR2 -> barony.setColor2(parseColor());
                case DEFINITE_FORM -> barony.setDefiniteForm(parseBoolean());
                case CAPITAL -> barony.setCapital(parseString());
                case RULER_USES_TITLE_NAME -> barony.setRulerUsesTitleName(parseBoolean());
                case LANDLESS -> barony.setLandless(parseBoolean());
                case NO_AUTOMATIC_CLAIMS -> barony.setNoAutomaticClaims(parseBoolean());
                case ALWAYS_FOLLOWS_PRIMARY_HEIR -> barony.setAlwaysFollowsPrimaryHeir(parseBoolean());
                case DESTROY_IF_INVALID_HEIR -> barony.setDestroyIfInvalidHeir(parseBoolean());
                case AI_PRIMARY_PRIORITY -> barony.setAiPrimaryPriority(parsePriority());
                case CAN_CREATE -> barony.setCanCreate(parseCanCreate());
                case CULTURAL_NAMES -> barony.setCulturalNames(parseCulturalNames());
                case MALE_NAMES -> barony.setMaleNames(parseMaleNames());
                default -> {
                    System.out.println("Unexpected token " + tokenizer.getToken().toString());
                    tokenizer.printContents();
                    var e = new RuntimeException();
                    e.printStackTrace();
                    System.exit(1);
                }
            }
        }

        tokenizer.nextToken();    // }

        return barony;
    }

    private AIPrimaryPriority parsePriority() {
        AIPrimaryPriority priority = new AIPrimaryPriority();

        tokenizer.nextToken();    // ai_primary_priority
        tokenizer.nextToken();    // =
        tokenizer.nextToken();    // {

        while (tokenizer.getToken() != CKTitles.RBRACKET) {

            switch (tokenizer.getToken()) {
                case IF -> priority.addIf(parseIf());
                case ADD -> priority.setAdd((parseString()));
                default -> {
                    System.out.println("Unexpected token " + tokenizer.getToken().toString());
                    tokenizer.printContents();
                    var e = new RuntimeException();
                    e.printStackTrace();
                    System.exit(1);
                }
            }
        }
        tokenizer.nextToken();    // }

        return priority;
    }

    private If parseIf() {
        If ifStmt = new If();

        tokenizer.nextToken();    // if
        tokenizer.nextToken();    // =
        tokenizer.nextToken();    // {

        while (tokenizer.getToken() != CKTitles.RBRACKET) {

            switch (tokenizer.getToken()) {
                case LIMIT -> ifStmt.setLimit(parseLimit());
                case ADD -> ifStmt.addAdd(parseAdd());
                default -> {
                    System.out.println("Unexpected token " + tokenizer.getToken().toString());
                    tokenizer.printContents();
                    var e = new RuntimeException();
                    e.printStackTrace();
                    System.exit(1);
                }
            }

        }
        tokenizer.nextToken();    // }

        return ifStmt;
    }

    private Limit parseLimit() {
        Limit limit = new Limit();

        tokenizer.nextToken();    // limit
        tokenizer.nextToken();    // =
        tokenizer.nextToken();    // {

        while (tokenizer.getToken() != CKTitles.RBRACKET) {

            switch (tokenizer.getToken()) {
                case IS_AI -> limit.setAI(parseBoolean());
                case NOT -> limit.setNot(parseNot());
                case CULTURE_GROUP -> limit.setCultureGroup(parseString());
                case CULTURE -> limit.setCulture(parseString());
                case OR -> limit.setOr(parseOr());
                case FAITH -> limit.setFaith(parseString());
                default -> {
                    System.out.println("Unexpected token " + tokenizer.getToken().toString());
                    tokenizer.printContents();
                    var e = new RuntimeException();
                    e.printStackTrace();
                    System.exit(1);
                }
            }

        }
        tokenizer.nextToken();    // }

        return limit;

    }

    private Not parseNot() {
        Not not = new Not();

        tokenizer.nextToken();    // NOT
        tokenizer.nextToken();    // =
        tokenizer.nextToken();    // {

        while (tokenizer.getToken() != CKTitles.RBRACKET) {

            switch (tokenizer.getToken()) {
                case CULTURE -> not.setCulture(parseString());
                case HAS_TITLE -> not.setHasTitle(parseString());
                case EXISTS -> not.setExists(parseString());
                case FAITH -> not.setFaith(parseFaith());
                default -> {
                    System.out.println("Unexpected token " + tokenizer.getToken().toString());
                    tokenizer.printContents();
                    var e = new RuntimeException();
                    e.printStackTrace();
                    System.exit(1);
                }
            }

        }
        tokenizer.nextToken();    // }

        return not;
    }

    private Or parseOr() {
        Or or = new Or();

        tokenizer.nextToken();    // OR
        tokenizer.nextToken();    // =
        tokenizer.nextToken();    // {

        while (tokenizer.getToken() != CKTitles.RBRACKET) {

            switch (tokenizer.getToken()) {
                case CULTURE -> or.getCulture().add(parseString());
                case CULTURE_GROUP -> or.getCultureGroup().add(parseString());
                default -> {
                    System.out.println("Unexpected token " + tokenizer.getToken().toString());
                    tokenizer.printContents();
                    var e = new RuntimeException();
                    e.printStackTrace();
                    System.exit(1);
                }
            }

        }
        tokenizer.nextToken();    // }

        return or;
    }

    private CanCreate parseCanCreate() {
        CanCreate canCreate = new CanCreate();

        tokenizer.nextToken();    // can_create
        tokenizer.nextToken();    // =
        tokenizer.nextToken();    // {

        while (tokenizer.getToken() != CKTitles.RBRACKET) {
            switch (tokenizer.getToken()) {
                case ALWAYS -> canCreate.setAlways(parseBoolean());
                case TRIGGER_IF -> canCreate.setTriggerIf(parseTriggerIf());
                case NOT -> canCreate.setNot(parseNot());
                case FAITH -> canCreate.setFaith(parseFaith());
                default -> {
                    System.out.println("Unexpected token " + tokenizer.getToken().toString());
                    tokenizer.printContents();
                    var e = new RuntimeException();
                    e.printStackTrace();
                    System.exit(1);
                }
            }

        }
        tokenizer.nextToken();    // }

        return canCreate;
    }

    private CanCreateOnPartition parseCanCreateOnPartition() {
        CanCreateOnPartition partition = new CanCreateOnPartition();

        tokenizer.nextToken();      // can_create_on_partition
        tokenizer.nextToken();      // =
        tokenizer.nextToken();      // {

        partition.setFaith(parseFaith());

        tokenizer.nextToken();      // }

        return partition;
    }

    private TriggerIf parseTriggerIf() {
        TriggerIf triggerIf = new TriggerIf();

        tokenizer.nextToken();    // trigger_if
        tokenizer.nextToken();    // =
        tokenizer.nextToken();    // {

        while (tokenizer.getToken() != CKTitles.RBRACKET) {

            switch (tokenizer.getToken()) {
                case LIMIT -> triggerIf.setLimit(parseLimit());
                case FAITH -> triggerIf.setFaith(parseFaith());
                case HAS_CULTURE_GROUP -> triggerIf.setHasCultureGroup(parseString());
                case OR -> triggerIf.setOr(parseOr());
                case NOT -> triggerIf.setNot(parseNot());
                case CULTURE -> triggerIf.setCulture(parseString());
                default -> {
                    System.out.println("Unexpected token " + tokenizer.getToken().toString());
                    tokenizer.printContents();
                    var e = new RuntimeException();
                    e.printStackTrace();
                    System.exit(1);
                }
            }

        }
        tokenizer.nextToken();    // }

        return triggerIf;
    }

    private Faith parseFaith() {
        Faith faith = new Faith();

        tokenizer.nextToken();    // faith
        tokenizer.nextToken();    // =
        tokenizer.nextToken();    // {

        while (tokenizer.getToken() != CKTitles.RBRACKET) {
            switch (tokenizer.getToken()) {
                case RELIGION_TAG -> faith.setReligionTag(parseString());
                case HAS_DOCTRINE -> faith.setHasDoctrine(parseString());
            }
        }

        tokenizer.nextToken();    // }

        return faith;
    }

    private Color parseColor() {
        Color color;

        tokenizer.nextToken();    // color or color2
        tokenizer.nextToken();    // =

        // used for hsv color (only like 3 in base game)
        if (tokenizer.getToken() == CKTitles.HSV) {
            float h, s, v;

            tokenizer.nextToken();    // hsv
            tokenizer.nextToken();    // {

            h = tokenizer.getDecimalValue();
            tokenizer.nextToken();

            s = tokenizer.getDecimalValue();
            tokenizer.nextToken();

            v = tokenizer.getDecimalValue();
            tokenizer.nextToken();

            color = Color.getHSBColor(h, s, v);

            // this is used for literally every other color
        } else {
            int r, g, b;
            tokenizer.nextToken();    // {

            r = tokenizer.getInteger();
            tokenizer.nextToken();
            // g
            g = tokenizer.getInteger();
            tokenizer.nextToken();
            // b
            b = tokenizer.getInteger();
            tokenizer.nextToken();

            color = new Color(r, g, b);
        }

        // }
        tokenizer.nextToken();

        return color;
    }

    private HashMap<String, String> parseCulturalNames() {
        HashMap<String, String> culturalNames = new HashMap<>();

        tokenizer.nextToken();    // cultural_names
        tokenizer.nextToken();    // =
        tokenizer.nextToken();    // {

        while (tokenizer.getToken() != CKTitles.RBRACKET) {
            String culture = tokenizer.getId();
            tokenizer.nextToken();
            tokenizer.nextToken();    // =
            String name = tokenizer.getId();
            tokenizer.nextToken();

            culturalNames.put(culture, name);
        }
        tokenizer.nextToken();    // }

        return culturalNames;
    }

    private ArrayList<String> parseMaleNames() {
        ArrayList<String> maleNames = new ArrayList<>();

        tokenizer.nextToken();    // male_names
        tokenizer.nextToken();    // =
        tokenizer.nextToken();    // {

        while (tokenizer.getToken() != CKTitles.RBRACKET) {
            maleNames.add(tokenizer.getId());
            tokenizer.nextToken();
        }

        tokenizer.nextToken();    // }

        return maleNames;
    }

    // used to get value of attributes

    private boolean parseBoolean() {
        boolean output;

        tokenizer.nextToken();    // attribute
        tokenizer.nextToken();    // =
        output = tokenizer.getTruth();
        tokenizer.nextToken();

        return output;
    }

    private int parseInt() {
        int output;

        tokenizer.nextToken();    // attribute
        tokenizer.nextToken();    // =
        output = tokenizer.getInteger();
        tokenizer.nextToken();

        return output;
    }

    private String parseString() {
        String output;

        tokenizer.nextToken();    // attribute
        tokenizer.nextToken();    // =
        output = tokenizer.getId();
        tokenizer.nextToken();

        return output;
    }

    private String parseAdd() {
        String output;

        tokenizer.nextToken();    // add
        tokenizer.nextToken();    // =
        output = tokenizer.getId();
        tokenizer.nextToken();

        return output;
    }

}

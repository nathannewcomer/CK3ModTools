package titlesParser.tokenizer;

public enum CKTitles {
    // titles
    EMPIRE,
    KINGDOM,
    DUCHY,
    COUNTY,
    BARONY,

    // attributes
    PROVINCE,
    COLOR,
    COLOR2,
    DEFINITE_FORM,
    CAPITAL,
    RULER_USES_TITLE_NAME,
    LANDLESS,
    NO_AUTOMATIC_CLAIMS,
    ALWAYS_FOLLOWS_PRIMARY_HEIR,
    DESTROY_IF_INVALID_HEIR,
    AI_PRIMARY_PRIORITY,
    DE_JURE_DRIFT_DISABLED,
    CAN_BE_NAMED_AFTER_DYNASTY,
    CULTURAL_NAMES,
    MALE_NAMES,
    RELIGION_TAG,
    HAS_DOCTRINE,

    // symbols
    LBRACKET,
    RBRACKET,
    EQUAL,

    // logic
    IF,
    LIMIT,
    OR,
    NOT,
    TRIGGER_IF,
    CAN_CREATE,
    CAN_CREATE_ON_PARTITION,
    FAITH,
    IS_AI,
    CULTURE_GROUP,
    HAS_TITLE,
    EXISTS,
    ALWAYS,
    HAS_CULTURE_GROUP,

    // misc.
    CULTURE,
    HSV,
    ADD,
    TRUTH,
    VARIABLE,
    ID,
    DECIMAL,
    INTEGER,
    EOF

}

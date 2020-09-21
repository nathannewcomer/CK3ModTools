package CK3ModTools.parser;

public enum Token {
    // titles
    EMPIRE,
    KINGDOM,
    DUCHY,
    COUNTY,
    BARONY,

    // attributes
    PROVINCE {
        @Override
        public String toString() {
            return "province";
        }
    },
    COLOR {
        @Override
        public String toString() {
            return "color";
        }
    },
    COLOR2 {
        @Override
        public String toString() {
            return "color2";
        }
    },
    DEFINITE_FORM {
        @Override
        public String toString() {
            return "definite_form";
        }
    },
    CAPITAL {
        @Override
        public String toString() {
            return "capital";
        }
    },
    RULER_USES_TITLE_NAME {
        @Override
        public String toString() {
            return "ruler_uses_title_name";
        }
    },
    LANDLESS {
        @Override
        public String toString() {
            return "landless";
        }
    },
    NO_AUTOMATIC_CLAIMS {
        @Override
        public String toString() {
            return "no_automatic_claims";
        }
    },
    ALWAYS_FOLLOWS_PRIMARY_HEIR {
        @Override
        public String toString() {
            return "always_follows_primary_heir";
        }
    },
    DESTROY_IF_INVALID_HEIR {
        @Override
        public String toString() {
            return "destroy_if_invalid_heir";
        }
    },
    AI_PRIMARY_PRIORITY {
        @Override
        public String toString() {
            return "ai_primary_priority";
        }
    },
    CULTURAL_NAMES {
        @Override
        public String toString() {
            return "cultural_names";
        }
    },
    MALE_NAMES {
        @Override
        public String toString() { return "male_names"; }
    },


    // symbols
    LBRACKET,
    RBRACKET,
    EQUAL,

    // misc.
    TRUTH,
    VARIABLE,
    ID,
    CONSTANT,
    EOF

}

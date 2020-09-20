package CK3ModTools;

public enum Climate {
	NO_WINTER {
		public String toString() {
			return "no_winter";
		}
	},
    MILD_WINTER {
		public String toString() {
			return "mild_winter";
		}
	},
    NORMAL_WINTER {
		public String toString() {
			return "normal_winter";
		}
	},
    SEVERE_WINTER {
		public String toString() {
			return "severe_winter";
		}
	}
}

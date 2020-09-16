package CK3ModTools;

public enum Climate {
	NO_WINTER {
		public String toString() {
			return "No Winter";
		}
	},
    MILD_WINTER {
		public String toString() {
			return "Mild Winter";
		}
	},
    NORMAL_WINTER {
		public String toString() {
			return "Normal Winter";
		}
	},
    SEVERE_WINTER {
		public String toString() {
			return "Severe Winter";
		}
	}
}

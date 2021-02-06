package enums;

public enum Size {
	SMALL("S"), MEDIUM("M"), LARGE("L"), EXTRALARGE("XL");
	
	private String abbreviation;
	
	Size(String abbrev) {
		this.abbreviation = abbrev;
	}
	
	String getAbbrev() {
		return this.abbreviation;
	}
}

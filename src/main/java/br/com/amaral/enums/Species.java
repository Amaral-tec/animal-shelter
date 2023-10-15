package br.com.amaral.enums;

public enum Species {

	DOG("Dog"),
    CAT("Cat"),
    OTHER("Other");
	
	private String description;
	
	private Species(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public String toString() {
		return this.description;
	}
}

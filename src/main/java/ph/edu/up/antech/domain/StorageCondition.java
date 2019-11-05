package ph.edu.up.antech.domain;

public enum StorageCondition {

	FZ("-15 to 1 Degree"), CO("2 to 8 Degrees"),
	AC("Not more than 25 Degrees"), NA("Over 25 Degrees");

	private String description;

	private StorageCondition(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

}

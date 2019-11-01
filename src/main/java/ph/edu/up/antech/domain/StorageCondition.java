package ph.edu.up.antech.domain;

public enum StorageCondition {

	FZ("-15 to 1 Degree");

	private String description;

	private StorageCondition(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

}

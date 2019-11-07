package ph.edu.up.antech.domain;

public enum ProductLicenseCode {

	TYPE_3_2ND_LICENSE("Type 3: 2nd License"), TYPE_4_REGULATED ("Type 4: Regulated"),
	WITH_PDEA("With PDEA"), WITHOUT_PDEA("Without PDEA");

	private String description;

	private ProductLicenseCode(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

}

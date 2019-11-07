package ph.edu.up.antech.domain;

public enum MaterialGroup {

	ZAH("Animal Health Drug"), ZCT("Clinical  Trial"), ZCS("Cosmentic"),
	ZCH("Consumer Healthcare"), ZDN("Diagnostics"), ZGM("Gimmicks"),
	ZHS("Health Supplements / Vitamins"), ZHH("Household Hazardous"),
	ZHR("Household (Home) Remedies"), ZLS("Life Saving"),
	ZMD("Medical Devices"), ZNT("Nutritional"),
	ZOG("Oncology"), ZPM("Packaging Material"), ZPE("Pharma Ethical"),
	ZPG("Pharma Generics"), ZPO("Pharma OTC"), ZRM("Raw Material"),
	ZRD("Regulated Drugs"), ZSG("Surgical"), ZSP("Spare Part"),
	ZTM("Traditional Medicine"), ZVC("Vaccine"), ZVS("Vision Care");

	private String description;

	private MaterialGroup(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

}

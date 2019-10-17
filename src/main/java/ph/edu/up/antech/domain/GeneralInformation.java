package ph.edu.up.antech.domain;

public class GeneralInformation {

	private Integer plan;
	private Integer inMarketSales;
	private Integer averageInMarketSales;
	private Integer offTake;

	public Integer getPlan() {
		return plan;
	}

	public void setPlan(Integer plan) {
		this.plan = plan;
	}

	public Integer getInMarketSales() {
		return inMarketSales;
	}

	public void setInMarketSales(Integer inMarketSales) {
		this.inMarketSales = inMarketSales;
	}

	public Integer getAverageInMarketSales() {
		return averageInMarketSales;
	}

	public void setAverageInMarketSales(Integer averageInMarketSales) {
		this.averageInMarketSales = averageInMarketSales;
	}

	public Integer getOffTake() {
		return offTake;
	}

	public void setOffTake(Integer offTake) {
		this.offTake = offTake;
	}


	public static final class Builder {
		private Integer plan;
		private Integer inMarketSales;
		private Integer averageInMarketSales;
		private Integer offTake;

		private Builder() {
		}

		public static Builder buildGeneralInformation() {
			return new Builder();
		}

		public Builder plan(Integer plan) {
			this.plan = plan;
			return this;
		}

		public Builder inMarketSales(Integer inMarketSales) {
			this.inMarketSales = inMarketSales;
			return this;
		}

		public Builder averageInMarketSales(Integer averageInMarketSales) {
			this.averageInMarketSales = averageInMarketSales;
			return this;
		}

		public Builder offTake(Integer offTake) {
			this.offTake = offTake;
			return this;
		}

		public GeneralInformation build() {
			GeneralInformation generalInformation = new GeneralInformation();
			generalInformation.setPlan(plan);
			generalInformation.setInMarketSales(inMarketSales);
			generalInformation.setAverageInMarketSales(averageInMarketSales);
			generalInformation.setOffTake(offTake);
			return generalInformation;
		}
	}
}

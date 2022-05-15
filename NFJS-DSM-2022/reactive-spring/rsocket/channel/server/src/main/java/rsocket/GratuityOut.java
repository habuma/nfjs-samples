package rsocket;

import java.math.BigDecimal;

public class GratuityOut {

	private BigDecimal billTotal;
	private int percent;
	private BigDecimal gratuity;

	public GratuityOut() {}
	
	public GratuityOut(BigDecimal billTotal, int percent, 
			BigDecimal gratuity) {
		this.billTotal = billTotal;
		this.percent = percent;
		this.gratuity = gratuity;
	}
	
	public BigDecimal getBillTotal() {
		return billTotal;
	}
	public void setBillTotal(BigDecimal billTotal) {
		this.billTotal = billTotal;
	}
	public int getPercent() {
		return percent;
	}
	public void setPercent(int percent) {
		this.percent = percent;
	}
	public BigDecimal getGratuity() {
		return gratuity;
	}
	public void setGratuity(BigDecimal gratuity) {
		this.gratuity = gratuity;
	}
	
}

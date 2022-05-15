package rsocket;

import java.math.BigDecimal;

public class GratuityIn {

	private BigDecimal billTotal;
	private int percent;
	
	public GratuityIn() {}
	
	public GratuityIn(BigDecimal billTotal, int percent) {
		this.billTotal = billTotal;
		this.percent = percent;
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
	
}

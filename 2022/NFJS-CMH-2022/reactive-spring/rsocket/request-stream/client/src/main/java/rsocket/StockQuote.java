package rsocket;
import java.math.BigDecimal;
import java.time.Instant;

public class StockQuote {

	private String symbol;
	private BigDecimal price;
	private Instant timestamp;
	
	public StockQuote() {}
	
	public StockQuote(String symbol, BigDecimal price, Instant timestamp) {
		this.symbol = symbol;
		this.price = price;
		this.timestamp = timestamp;
	}
	
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Instant getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Instant timestamp) {
		this.timestamp = timestamp;
	}
	
	
}

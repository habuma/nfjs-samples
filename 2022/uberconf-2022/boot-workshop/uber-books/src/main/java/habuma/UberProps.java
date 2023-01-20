package habuma;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="uberconf")
public class UberProps {

	private String where = "Denver";
	
	public void setWhere(String where) {
		this.where = where;
	}
	
	public String getWhere() {
		return where;
	}
	
}

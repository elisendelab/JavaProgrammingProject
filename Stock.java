package term_project_22300245;

public class Stock {
	private String item;
	private int quant;
	
	public Stock(String item, int quant) {
		this.item=item;
		this.quant=quant;
	}
	
	public String getItem() {
		return item;
	}
	
	public void setItem(String item) {
		this.item=item;
	}
	
	public int getQuant() {
		return quant;
	}
	
	public void setQuant(int quant) {
		this.quant=quant;
	}
	
}

package product.search.vo;

public class Price {

	private Boolean sale;
	private String desc;
	public Boolean getSale() {
		return sale;
	}
	public void setSale(Boolean sale) {
		this.sale = sale;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Current getCurrent() {
		return current;
	}
	public void setCurrent(Current current) {
		this.current = current;
	}
	private Current current;
}

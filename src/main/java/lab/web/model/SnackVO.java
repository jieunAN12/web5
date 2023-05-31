package lab.web.model;

public class SnackVO {
	
	private String pid;
	private String pname;
	private int price;
	private int qty;
	private String pimg;
	
	public SnackVO() {
		super();
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public String getPimg() {
		return pimg;
	}

	public void setPimg(String pimg) {
		this.pimg = pimg;
	}

	@Override
	public String toString() {
		return "SnackVO [pid=" + pid + ", pname=" + pname + ", price=" + price + ", qty=" + qty + ", pimg=" + pimg
				+ "]";
	}

}

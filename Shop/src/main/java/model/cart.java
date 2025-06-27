package model;

public class cart {
	private int cart_id,cid,pid,qty,pprice,total_price,net_price;
	private String payment_status;
	public int getCart_id() {
		return cart_id;
	}
	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getPprice() {
		return pprice;
	}
	public void setPprice(int pprice) {
		this.pprice = pprice;
	}
	public int getTotal_price() {
		return total_price;
	}
	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}
	public int getNet_price() {
		return net_price;
	}
	public void setNet_price(int net_price) {
		this.net_price = net_price;
	}
	public String getPayment_status() {
		return payment_status;
	}
	public void setPayment_status(String payment_status) {
		this.payment_status = payment_status;
	}
	@Override
	public String toString() {
		return "cart [cart_id=" + cart_id + ", cid=" + cid + ", pid=" + pid + ", qty=" + qty + ", pprice=" + pprice
				+ ", total_price=" + total_price + ", net_price=" + net_price + ", payment_status=" + payment_status
				+ "]";
	}
}

package model;

public class transactionList {
	private String tranId;
	private String itemId;
	private String itemName;
	private String cName;
	private String email;
	private int qty;
	public transactionList(String tranId, String itemId, String itemName, String cName, String email, int qty) {
		super();
		this.tranId = tranId;
		this.itemId = itemId;
		this.itemName = itemName;
		this.cName = cName;
		this.email = email;
		this.qty = qty;
	}
	public String getTranId() {
		return tranId;
	}
	public void setTranId(String tranId) {
		this.tranId = tranId;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	
	public static void display(String tranId, String itemId, String itemName, String cName, String email, int qty) {
		
	}
	
//	belum selesai :(
}

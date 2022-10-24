package model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import main.Connect;

public class transaction {
	private int itemId;
	private String customer;
	private String email;
	private int qty;
	private String tranId;
	

	public transaction(int itemId, String customer, String email, int qty, String tranId) {
		super();
		this.itemId = itemId;
		this.customer = customer;
		this.email = email;
		this.qty = qty;
		this.tranId = tranId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
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
	
	public String getTranId() {
		return tranId;
	}

	public void setTranId(String tranId) {
		this.tranId = tranId;
	}

	public static void insert(String tranId, int itemId, String customer, String email, int qty) {
		Connect connect = Connect.getConnection();
		String q1 = "INSERT INTO transaction VALUE (?,?,?,?,?)";
		PreparedStatement ps = connect.prepareStatement(q1);
		
		try {
			ps.setString(1, tranId);
			ps.setInt(2, itemId);
			ps.setString(3, customer);
			ps.setString(4, email);
			ps.setInt(5, qty);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void delete(int noItem) {
		Connect connect = Connect.getConnection();
		String q1 = "DELETE transaction WHERE transactionID = ?";
		PreparedStatement ps = connect.prepareStatement(q1);
		
		try {
			ps.setInt(1, noItem);
			ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

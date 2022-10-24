package model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import main.Connect;

public class wing extends foodBev {
	private String sauceName;

	public wing(String itemId, String itemName, int itemPrice, String sauceName) {
		super(itemId, itemName, itemPrice);
		this.sauceName = sauceName;
	}

	public String getSauceName() {
		return sauceName;
	}

	public void setSauceName(String sauceName) {
		this.sauceName = sauceName;
	}

	@Override
	public void insert() {
		// TODO Auto-generated method stub
		Connect connect = Connect.getConnection();
		String q1 = "INSERT INTO wing VALUE (?,?,?,?)";
		
		PreparedStatement ps = connect.prepareStatement(q1);
		
		try {
			ps.setString(1, this.getItemId());
			ps.setString(2, this.getItemName());
			ps.setInt(3, this.getItemPrice());
			ps.setString(4, this.getSauceName());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void price() {
		// TODO Auto-generated method stub
		this.setItemPrice(this.getItemPrice());
	}
	
	
}

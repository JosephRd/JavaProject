package model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import main.Connect;

public class sodaDrink extends foodBev{
	
	private String withIce;
	
	

	public sodaDrink(String itemId, String itemName, int itemPrice, String withIce) {
		super(itemId, itemName, itemPrice);
		this.withIce = withIce;
	}

	public String getWithIce() {
		return withIce;
	}

	public void setWithIce(String withIce) {
		this.withIce = withIce;
	}

	@Override
	public void insert() {
		// TODO Auto-generated method stub
		Connect connect = Connect.getConnection();
		String q1 = "INSERT INTO sodadrink VALUE (?,?,?,?)";
		
		PreparedStatement ps = connect.prepareStatement(q1);
		
		try {
			ps.setString(1, this.getItemId());
			ps.setString(2, this.getItemName());
			ps.setInt(3, this.getItemPrice());
			ps.setString(4, this.getWithIce());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void price() {
		// TODO Auto-generated method stub
		
	}


	
	
}

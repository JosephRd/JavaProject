package main;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import model.foodBev;
import model.sodaDrink;
import model.transaction;
import model.transactionList;

public class Main {
	Connect connect = Connect.getConnection();
	Scanner scan = new Scanner(System.in);
	ArrayList<foodBev> fb = new ArrayList<>();
	ArrayList<transactionList> tl = new ArrayList<>();
	Random rand = new Random();

	public Main() {
		// TODO Auto-generated constructor stub
		initialize();
		int menu = 0;
		
		do {
			System.out.println("Welcome to WG Stop");
			System.out.println("=====================");
			System.out.println("1. Create Transaction");
			System.out.println("2. View Transaction");
			System.out.println("3. Delete Transaction");
			System.out.println("4. Exit");
			System.out.println("=====================");
			System.out.println(">>");
			
			menu  = scan.nextInt();
			scan.nextLine();
			
			switch(menu) {
			case 1:
				create();
				break;
			case 2:
				view();
				break;
			case 3:
				delete();
				break;
			case 4:
				scan.close();
				System.out.println("Goodbye!");
			}
		}while (menu != 4);
		
	}
	
	private void initialize() {
		String q1 = "(SELECT * FROM sodadrink) UNION (SELECT * FROM wing) ORDER BY itemID ASC";
		
		ResultSet rs = connect.executeQuery(q1);
		
		try {
			while(rs.next() == true) {
				fb.add(new sodaDrink(
						rs.getString("itemID"),
						rs.getString("itemName"),
						rs.getInt("itemPrice"),
						rs.getString("withIce")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void create() {
		String name, email, tranId;
		int qty, item;
	
		tranId = "TI" + rand.nextInt(10) +  rand.nextInt(10) +  rand.nextInt(10);
		
		for (foodBev foodBev : fb) {
			System.out.println(foodBev.getItemId() + " | " + foodBev.getItemName() + " | " + foodBev.getItemPrice() + " | " + ((sodaDrink)foodBev).getWithIce());
		}
		
		System.out.println("Input item: ");
		item = scan.nextInt();
		scan.nextLine();
		
		do {
			System.out.println("Input customer name [5-20] (invlucisve): ");
			name = scan.nextLine();
		}while (name.length() < 5 || name.length() > 20);
		
		System.out.println("Input customer email: ");
		email = scan.nextLine();
		
		do {
			System.out.println("Input quantity [must be more than zero]: ");
			qty = scan.nextInt();
			scan.nextLine();
		}while (qty <= 0);
		
		transaction.insert(tranId, item, name, email, qty);
		
		System.out.println("Detail Transaction");
		System.out.println("========================");
		System.out.println("Customer" + ": " + name);
		System.out.println("Email" + ": " + email);
		System.out.println("Item" + ": " + item);
		System.out.println("Sauce" + ": " + name);
		System.out.println("Qty" + ": " + name);
		System.out.println("Price" + ": " + name);
		System.out.println("Total Price" + ": " + name);
		 
	}
	
	private void view() {
		for (foodBev foodBev : fb) {
			System.out.println(foodBev.getItemId() + " | " + foodBev.getItemName() + " | " + foodBev.getItemPrice() + " | " + ((sodaDrink)foodBev).getWithIce());
		}
	}
	
	private void delete() {
		int target;
		
		view();
		System.out.println("Input number to delete: ");
		target = scan.nextInt();
		
		if(tl.isEmpty() == true) {
			System.out.println("There's No Transaction!");
			
		} else {
			transaction.delete(target);
			System.out.println("Transaction Successfuly Deleted");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

}

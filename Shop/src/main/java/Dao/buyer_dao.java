package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import db_connection.DBConnection;
import model.buyer;
import model.seller;

public class buyer_dao {
	public static void insertbuyer(buyer b) {
		try {
			Connection conn = DBConnection.createconnection();
			String sql = "insert into buyer(name,email,contact,password) values(?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, b.getName());
			pst.setString(2, b.getEmail());
			pst.setLong(3, b.getContact());
			pst.setString(4, b.getPassword());
			pst.executeUpdate();
			System.out.println("Registered Successfully!");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static boolean checkemail(String email) {
		boolean flag = false;
		try {
			Connection conn = DBConnection.createconnection();
			String sql = "select * from buyer where email = ?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, email);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				flag = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return flag;
	}
	
	public static buyer loginbuyer(buyer b) {
		buyer b1 = null;
		try {
			Connection conn = DBConnection.createconnection();
			String sql = "select * from buyer where email = ? and password = ?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, b.getEmail());
			pst.setString(2, b.getPassword());
			ResultSet rs = pst.executeQuery();
			System.out.println("Resultset data" + rs);
			if(rs.next()) {
				b1 = new buyer();
				b1.setId(rs.getInt("id"));
				b1.setName(rs.getString("name"));
				b1.setEmail(rs.getString("email"));
				b1.setContact(rs.getLong("contact"));
				b1.setPassword(rs.getString("password"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return b1;
	}
	
	public static void updatebuyer(buyer b) {
		try {
			Connection conn = DBConnection.createconnection();
			String sql = "update buyer set name = ?, email = ?, contact = ? where id = ?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, b.getName());
			pst.setString(2, b.getEmail());
			pst.setLong(3, b.getContact());
			pst.setInt(4, b.getId());
			pst.executeUpdate();
			System.out.println("Buyer Profile Updated");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static boolean checkpassword(String email, String op) {
		boolean flag = false;
		try {
			Connection conn = DBConnection.createconnection();
			String sql = "select * from buyer where email = ? and password = ?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, email);
			pst.setString(2, op);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				flag = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return flag;
	}
	
	public static void updatepassword(String email, String np) {
		try {
			Connection conn = DBConnection.createconnection();
			String sql = "update buyer set password = ? where email = ?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, np);
			pst.setString(2, email);
			pst.executeUpdate();
			System.out.println("Buyer Password Updated");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static void forgotpass(String email, String np) {
		try {
			Connection conn = DBConnection.createconnection();
			String sql = "update buyer set password = ? where email = ?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, np);
			pst.setString(2, email);
			pst.executeUpdate();
			System.out.println("Pass Updated");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}

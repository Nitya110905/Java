package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import db_connection.DBConnection;
import model.seller;

public class seller_dao {
	public static void insertseller(seller s) {
		try {
			Connection conn = DBConnection.createconnection();
			String sql = "insert into seller(name,email,contact,password) values(?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, s.getName());
			pst.setString(2, s.getEmail());
			pst.setLong(3, s.getContact());
			pst.setString(4, s.getPassword());
			pst.executeUpdate();
			System.out.println("Registered Successfully");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static boolean checkemail(String email) {
		boolean flag = false;
		try {
			Connection conn = DBConnection.createconnection();
			String sql = "select * from seller where email = ?";
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
	
	public static seller loginseller(seller s) {
		seller s1 = null;
		try {
			Connection conn = DBConnection.createconnection();
			String sql = "select * from seller where email = ? and password = ?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, s.getEmail());
			pst.setString(2, s.getPassword());
			ResultSet rs = pst.executeQuery();
			System.out.println("Resultset data" + rs);
			if(rs.next()) {
				s1 = new seller();
				s1.setId(rs.getInt("id"));
				s1.setName(rs.getString("name"));
				s1.setEmail(rs.getString("email"));
				s1.setContact(rs.getLong("contact"));
				s1.setPassword(rs.getString("password"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return s1;
	}
	
	public static void updateseller(seller s) {
		try {
			Connection conn = DBConnection.createconnection();
			String sql = "update seller set name = ?, email = ?, contact = ? where id = ?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, s.getName());
			pst.setString(2, s.getEmail());
			pst.setLong(3, s.getContact());
			pst.setInt(4, s.getId());
			pst.executeUpdate();
			System.out.println("Seller Profile Updated");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static boolean checkpassword(String email, String op) {
		boolean flag = false;
		try {
			Connection conn = DBConnection.createconnection();
			String sql = "select * from seller where email = ? and password = ?";
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
	
	public static void updatepassword(String email,String np) {
		try {
			Connection conn = DBConnection.createconnection();
			String sql = "update seller set password = ? where email = ?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, np);
			pst.setString(2, email);
			pst.executeUpdate();
			System.out.println("Seller Password updated");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static void forgotpass(String email, String np) {
		try {
			Connection conn = DBConnection.createconnection();
			String sql = "update seller set password = ? where email = ?";
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

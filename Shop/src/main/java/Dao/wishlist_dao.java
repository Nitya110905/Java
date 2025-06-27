package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db_connection.DBConnection;
import model.wishlist;

public class wishlist_dao {
	public static void addtowishlist(wishlist w) {
		try {
			Connection conn = DBConnection.createconnection();
			String sql = "insert into wishlist (cid,pid) values(?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, w.getCid());
			pst.setInt(2, w.getPid());
			pst.executeUpdate();
			System.out.println("Added to Wishlist");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public static List<wishlist> getWishLIstBycid(int cid){
		List<wishlist> list = new  ArrayList<wishlist>();
		try {
			Connection conn = DBConnection.createconnection();
			String sql = "select * from wishlist where cid=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, cid);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				wishlist w= new wishlist();
				w.setWid(rs.getInt("wid"));
				w.setCid(rs.getInt("cid"));
				w.setPid(rs.getInt("pid"));
				list.add(w);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public static void removerProduct(int wid) {
		try {
			Connection conn = DBConnection.createconnection();
			String sql = "delete from wishlist where wid=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, wid);
			pst.executeUpdate();
			System.out.println("deleted");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static boolean checkProductForWishList(int cid,int pid) {
		boolean flag = false;
		try {
			Connection conn = DBConnection.createconnection();
			String sql = "select * from wishlist where cid=? and pid=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1,cid);
			pst.setInt(2, pid);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
}

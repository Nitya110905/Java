package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db_connection.DBConnection;
import model.cart;

public class cart_dao {
	public static void insertINtoCart(cart c) {
		try {
			Connection conn = DBConnection.createconnection();
			String sql="insert into cart(cid,pid,qty,pprice,total_price,net_price,payment_status) values(?,?,?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, c.getCid());
			pst.setInt(2, c.getPid());
			pst.setInt(3, c.getQty());
			pst.setInt(4, c.getPprice());
			pst.setInt(5, c.getTotal_price());
			pst.setInt(6, c.getNet_price());
			pst.setString(7, c.getPayment_status());
			pst.executeUpdate();
			System.out.println("added into cart");
		} catch (Exception e) { 
			e.printStackTrace();
		}
	}
	public static List<cart> getCartByCusId(int cus_id){
		List<cart> list = new ArrayList<cart>();
		try {
			Connection conn = DBConnection.createconnection();
			String sql="select * from cart where cid=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, cus_id);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				cart c =new cart();
				c.setCart_id(rs.getInt("cart_id"));
				c.setCid(rs.getInt("cid"));
				c.setPid(rs.getInt("pid"));
				c.setQty(rs.getInt("qty"));
				c.setPprice(rs.getInt("pprice"));
				c.setTotal_price(rs.getInt("total_price"));
				c.setPayment_status(rs.getString("payment_status"));
				list.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public static void updatecart(cart c) {
		try {
			Connection conn = DBConnection.createconnection();
			String sql="update cart set qty=?,total_price=? where cart_id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, c.getQty());
			pst.setInt(2, c.getTotal_price());
			pst.setInt(3, c.getCart_id());
			pst.executeUpdate();
			System.out.println("cart updated");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void removerProduct(int cart_id) {
		try {
			Connection conn = DBConnection.createconnection();
			String sql = "delete from cart where cart_id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, cart_id);
			pst.executeUpdate();
			System.out.println("removed");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

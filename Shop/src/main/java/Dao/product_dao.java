package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db_connection.DBConnection;
import model.product;

public class product_dao {
	public static void uploadproduct(product p) {
		try {
			Connection conn = DBConnection.createconnection();
			String sql = "insert into product (sid,pname,pcompany,pdesc,pquant,pimage,pprice) values(?,?,?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, p.getSid());
			pst.setString(2, p.getPname());
			pst.setString(3, p.getPcompany());
			pst.setString(4, p.getPdesc());
			pst.setInt(5, p.getPquant());
			pst.setString(6, p.getPimage());
			pst.setInt(7, p.getPprice());
			pst.executeUpdate();
			System.out.println("Product Uploaded");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static List<product> getProductsBySid(int sid){
		List<product> list = new ArrayList<product>();
		try {
			Connection  conn = DBConnection.createconnection();
			String sql = "select * from product where sid = ?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, sid);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				product p = new product();
				p.setPid(rs.getInt("pid"));
				p.setSid(rs.getInt("sid"));
				p.setPname(rs.getString("pname"));
				p.setPcompany(rs.getString("pcompany"));
				p.setPdesc(rs.getString("pdesc"));
				p.setPquant(rs.getInt("pquant"));
				p.setPimage(rs.getString("pimage"));
				p.setPprice(rs.getInt("pprice"));
				list.add(p);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
	
	public static void deleteProductByPid(int pid) {
		try {
			Connection conn = DBConnection.createconnection();
			String sql = "delete from product where pid = ?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, pid);
			pst.executeUpdate();
			System.out.println("Product deleted!");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static product getProductByPid(int pid) {
		product p = null;
		try {
			Connection conn = DBConnection.createconnection();
			String sql="select * from product where pid=?";
			PreparedStatement pst= conn.prepareStatement(sql);
			pst.setInt(1, pid);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				p = new product();
				p.setPid(rs.getInt("pid"));
				p.setSid(rs.getInt("sid"));
				p.setPname(rs.getString("pname"));
				p.setPcompany(rs.getString("pcompany"));
				p.setPdesc(rs.getString("pdesc"));
				p.setPquant(rs.getInt("pquant"));
				p.setPimage(rs.getString("pimage"));
				p.setPprice(rs.getInt("pprice"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}
	
	public static void updateProduct(product p) {
		try {
			Connection conn = DBConnection.createconnection();
			String sql="update product set pname = ?, pcompany = ?, pdesc = ?, pquant = ?, pimage = ?, pprice = ? where pid=?";
			PreparedStatement pst= conn.prepareStatement(sql);
			pst.setString(1, p.getPname());
			pst.setString(2, p.getPcompany());
			pst.setString(3, p.getPdesc());
			pst.setInt(4, p.getPquant());
			pst.setString(5, p.getPimage());
			pst.setInt(6, p.getPprice());
			pst.setInt(7, p.getPid());
			pst.executeUpdate();
			System.out.println("product updated");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static List<product> getAllProducts(){
		List<product> list = new ArrayList<product>();
		try {
			Connection conn = DBConnection.createconnection();
			String sql="select * from product";
			PreparedStatement pst= conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				product p = new product();
				p.setPid(rs.getInt("pid"));
				p.setSid(rs.getInt("sid"));
				p.setPname(rs.getString("pname"));
				p.setPcompany(rs.getString("pcompany"));
				p.setPdesc(rs.getString("pdesc"));
				p.setPquant(rs.getInt("pquant"));
				p.setPimage(rs.getString("pimage"));
				p.setPprice(rs.getInt("pprice"));
				list.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}

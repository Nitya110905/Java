package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import db_connection.DBConnection;
import model.form;

public class form_dao {
	public static void submitform(form f) {
		try {
			Connection conn = DBConnection.createconnection();
			String sql = "insert into form (name,email,contact,password,address,hobby,course,gender) values(?,?,?,?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, f.getName());
			pst.setString(2, f.getEmail());
			pst.setLong(3, f.getContact());
			pst.setString(4, f.getPassword());
			pst.setString(5, f.getAddress());
			pst.setString(6, f.getHobby());
			pst.setString(7, f.getCourse());
			pst.setString(8, f.getGender());
			pst.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}

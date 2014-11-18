package com.talosdigital.safebuy.integration.test.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.talosdigital.safebuy.config.Properties;

public class BuyerUtil {
	static String JDBC_DRIVER = Properties.JDBC_DRIVER;
	static String DB_URL = Properties.DB_URL;
	static String USER = Properties.USER;
	static String PASS = Properties.PASS;

	/**
	 * Create a buyer, without store.
	 * The created buyer is created with id -1
	 */
	public static void createBuyer(String name, String lastName) {
		Connection con = null;
		Statement stm = null;

		try {
			Class.forName(JDBC_DRIVER);
			con = DriverManager.getConnection(DB_URL, USER, PASS);
			stm = con.createStatement();
			String sql = "INSERT INTO buyer(id, lastname, name) VALUES (?,?,?)";
			PreparedStatement statment = con.prepareStatement(sql);
			statment.setInt(1, -1);
			statment.setString(2, lastName);
			statment.setString(3, name);
			statment.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if (stm != null) {
					stm.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public static void deleteBuyer(int id){
		Connection conn = null;
		Statement stm = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL , USER , PASS) ;
			stm = conn.createStatement();
			String sql = "DELETE FROM buyer WHERE id = ?;" ;
			PreparedStatement statment = conn.prepareStatement(sql);
			statment.setInt(1, id);
			ResultSet rs = statment.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if (stm != null) {
					stm.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static boolean existBuyer(int id){
		Connection conn = null;
		Statement stm = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL , USER , PASS) ;
			stm = conn.createStatement();
			String sql = "SELECT * FROM buyer where id = ?" ;
			PreparedStatement statment = conn.prepareStatement(sql);
			statment.setInt(1, id);
			ResultSet rs = statment.executeQuery();
			while (rs.next()) {
				return true;
			}
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if (stm != null) {
					stm.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}
}

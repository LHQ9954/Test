package com.yc.Maven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Demo {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/film?useOldAliasMetadataBehavior=true&amp;\r\n" + 
					"     		useSSL=false&amp;useUnicode=true&amp;characterEncoding=utf8&amp;serverTimezone=GMT%2B8", "root", "1");
			pstmt = con.prepareStatement("select * from user ");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt("u_id") + "----" +  rs.getString("u_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
}


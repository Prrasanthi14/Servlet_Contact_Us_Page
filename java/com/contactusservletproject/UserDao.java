package com.contactusservletproject;
import java.sql.*;
public class UserDao {
	String adminName,adminPassword;
	public boolean setUserDao(User user) throws ClassNotFoundException, SQLException {
		String url="jdbc:postgresql://localhost:5432/postgres";
		String username= "postgres";
		String password="postgres";
		Class.forName("org.postgresql.Driver");
		Connection con= DriverManager.getConnection(url,username,password);
		String query="select username,password from users where username=? and password=?";	
		PreparedStatement prep = con.prepareStatement(query);
		prep.setString(1,user.getAdminname());
		prep.setString(1,user.getPassword());
		ResultSet resultSet = prep.executeQuery();
		while(resultSet.next()) {
			if(resultSet.getString(1)!=null&&resultSet.getString(2)!=null) {
				return true;
			}
		}
		return false;
	}
}

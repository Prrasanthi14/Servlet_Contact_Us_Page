package com.contactusservletproject;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class RequestDao {
	String url="jdbc:postgresql://localhost:5432/postgres";
	String username= "postgres";
	String password="postgres";
	public void requestDao(Request requestobj) throws ClassNotFoundException, SQLException {
		String name = requestobj.getName();
		String email = requestobj.getEmail();
		String message = requestobj.getMessage();
	String sql ="insert into requests (fullname,email,message,status) values ('"+name+"','"+email+"','"+message+"','active');";
		Class.forName("org.postgresql.Driver");
		Connection con= DriverManager.getConnection(url,username,password);
		Statement st=con.createStatement();
		 st.executeQuery(sql);
	}
	public List<Request>fetchRequests() throws ClassNotFoundException, SQLException {
		String query ="select * from requests order by id asc;";
		Class.forName("org.postgresql.Driver");
		Connection connection= DriverManager.getConnection(url,username,password);
		Statement statement=connection.createStatement();
		 ResultSet resultSet=statement.executeQuery(query);
		 List<Request> list=new ArrayList<Request>();
			while(resultSet.next()) {
				Request requestdata=new Request();
				requestdata.setId(resultSet.getString(1));
				requestdata.setName(resultSet.getString(2));
				requestdata.setEmail(resultSet.getString(3));
				requestdata.setMessage(resultSet.getString(4));
				requestdata.setTime(resultSet.getString(6));
				requestdata.setStatus(resultSet.getString(5));
				list.add(requestdata);
			}
			return list;
			}
	public void changeStatus(Request requestobj) throws ClassNotFoundException, SQLException {
		System.out.println(requestobj.getId());
		int id = Integer.parseInt(requestobj.getId());
		String status = requestobj.getStatus();
			if(status.equals("active")) {
			status="archive";
		}
		else {
			status="active";
		}
		String sql ="update requests set status='"+status+"' where id="+id+";";
		Class.forName("org.postgresql.Driver");
		Connection con= DriverManager.getConnection(url,username,password);
		Statement st=con.createStatement();
		 st.executeQuery(sql);
	}
}


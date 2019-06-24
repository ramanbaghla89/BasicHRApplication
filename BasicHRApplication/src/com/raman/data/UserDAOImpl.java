package com.raman.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.raman.model.User;

public class UserDAOImpl implements UserDAO{
	Connection con=null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	@Override
	public void addUser(User user) throws Exception {
		// TODO Auto-generated method stub
		try {
		con = ConnectionFactory.getCon();
		ps = con.prepareStatement("select * from users where user_id=?");
		ps.setString(1, user.getUserID());
		rs = ps.executeQuery();
		if(rs.next()) {
			throw new Exception("User Id alread exsit");
			
		}
		
		else {
			ps.close();
			ps= con.prepareStatement("insert users values(?,?,?,?,?,?,?)");
			ps.setString(1, user.getUserID());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getFirstName());
			ps.setString(4, user.getLastName());
			ps.setString(5, user.getAddress());
			ps.setString(6, user.getCity());
			ps.setString(7, user.getCountry());
			ps.executeUpdate();
		}
	}
	
		finally {
			con.close();
			
		}
}


	@Override
	public User getUser(String userID) throws Exception {
		// TODO Auto-generated method stub
		Connection con =null;
		PreparedStatement ps= null;
		ResultSet rs= null;
		User user= null;
		try {
			con = ConnectionFactory.getCon();
			ps=con.prepareStatement("select * from users where user_id=?");
			ps.setString(1, userID);
			rs=ps.executeQuery();
			
			if(rs.next()) {
				user = new User();
				user.setUserID(rs.getString("user_id"));
				user.setPassword(rs.getString("password"));
				user.setFirstName(rs.getString("firsy_name"));
				user.setLastName(rs.getString("last_name"));
				user.setAddress(rs.getString("address"));
				user.setCity(rs.getString("city"));
				user.setCountry(rs.getString("country"));
				
			}
			else {
				throw new Exception("Invalid user id");
			}
			
		}
		finally {
			con.close();
		}
		return user;
	}
	

}

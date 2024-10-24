package com.repositories;

import java.sql.*;

import com.models.User;

public class UserRepoImpl implements UserRepo {
	
	private Connection connection;
	
	public UserRepoImpl(Connection connection) {
		super();
		this.connection = connection;
	}
	
    public boolean register(User user) throws SQLException{
    	boolean success = false;
        String sql = "INSERT INTO user (username, password, email, address) VALUES (?, ?, ?, ?)";
        try {
        	PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());  
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getAddress());
            int rows = stmt.executeUpdate();
            if (rows == 1) {
            	success = true;
            }
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return success;
        
    }
    
    public User login(String email, String password) throws SQLException {
        String query = "SELECT * FROM user WHERE username = ? AND password = ?";
        User user = null;
        try {
        	PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, email);
            stmt.setString(2, password);  

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password")); 
                user.setEmail(rs.getString("email"));
                user.setAddress(rs.getString("address"));
//                user.setRole(rs.getString("role"));
            } 
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return user;
    }
    
    public boolean updateUser(User user) throws SQLException {
    	
        String query = "UPDATE user SET username = ?, password = ?, email = ?, address = ? WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());  
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getAddress());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;  
        }
    }
    
    
    public boolean setRole(int userId, String role) throws SQLException{
    	String query = "INSERT INTO user_role (user_id, role_id) VALUES (?, ?)";
    	String roleQ = "SELECT id FROM role WHERE role_name = ?";
    	
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
        	
        	PreparedStatement roleStmt = connection.prepareStatement(roleQ);
        	roleStmt.setString(1, role);
        	ResultSet rs = roleStmt.executeQuery();
        	int userRoleId = 2; 
        	
        	while (rs.next()) {
        		userRoleId = rs.getInt("id");
        	}
        	
            stmt.setInt(1, userId);
            stmt.setInt(2, userRoleId); 

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;  
        }
    }


	@Override
	public String getRole(int userId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}

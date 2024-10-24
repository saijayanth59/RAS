package com.repositories;

import java.sql.SQLException;
import com.models.User;

public interface UserRepo {

    User login(String email, String password) throws SQLException;

    boolean register(User user) throws SQLException;

    boolean updateUser(User user) throws SQLException;
    
    boolean setRole(int userId, String role) throws SQLException;
    
    String getRole(int userId) throws SQLException;
}

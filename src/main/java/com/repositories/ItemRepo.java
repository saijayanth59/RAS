package com.repositories;

import java.sql.SQLException;
import java.util.List;

import com.models.Item;

public interface ItemRepo {
    
    boolean addItem(Item item) throws SQLException;
    
    boolean updateItem(Item item) throws SQLException;
    
    boolean updateAvailability(int itemId, boolean availability) throws SQLException;
    
    Item getItemById(int itemId) throws SQLException;
    
    boolean deleteById(int itemId) throws SQLException;
    
    List<Item> getAllItems() throws SQLException;
    
    List<Item> getItemsByAvailability(boolean availability) throws SQLException;
}

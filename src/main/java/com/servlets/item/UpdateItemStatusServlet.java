package com.servlets.item;

import java.io.IOException;
import java.sql.Connection;

import com.db.DBConnect;
import com.models.Item;
import com.models.ItemIngredient;
import com.repositories.ItemRepoImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/updateItemStatus")
public class UpdateItemStatusServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		try {
			
			String id_ = req.getParameter("id");				
			ItemRepoImpl itemRepo = new ItemRepoImpl(DBConnect.connect());
			Item item = itemRepo.getItemById(Integer.parseInt(id_));
			Boolean status = item.isAvailability() ? false : true;
			
			if (itemRepo.updateAvailability(item.getId(), status)) {
				res.sendRedirect("all_items.jsp");
			}else {
				res.sendRedirect("index.jsp?message=Failed to update status");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnect.destroy();
		}
		
	}

}

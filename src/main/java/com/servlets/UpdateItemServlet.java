package com.servlets;

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


@WebServlet("/updateItem")
public class UpdateItemServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private static final String imageUrl = "https://plus.unsplash.com/premium_photo-1722686436015-bbba656b5381?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NXx8Zm9vZHxlbnwwfHwwfHx8MA%3D%3D";
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		try {
			
			String id_ = req.getParameter("id");			
			String name = req.getParameter("name");
			String description = req.getParameter("description");
			Double price = Double.parseDouble(req.getParameter("price"));
			String vegCheckBox = req.getParameter("veg");
			Boolean veg = false;

		    if (vegCheckBox != null && vegCheckBox.equals("on")) {
		        veg = true;
		      } 
		    
	
		    
			String[] ingredientIds = req.getParameterValues("ingredients");
			Item item = new Item();
			
			Connection conn = DBConnect.connect();
			if (ingredientIds != null) {
				for (String id: ingredientIds) {
	
					ItemIngredient itemIngredient = new ItemIngredient();
					itemIngredient.setIngredientId(Integer.parseInt(id));
					String quantity = req.getParameter(id);
					itemIngredient.setQuantity(Double.parseDouble(quantity));
					
					item.addItemIngredient(itemIngredient);
					
				}
			}
			
			item.setId(Integer.parseInt(id_));
			item.setName(name);
			item.setDescription(description);
			item.setPrice(price);
			item.setVeg(veg);
			item.setImage(imageUrl);
	
			
			ItemRepoImpl itemRepo = new ItemRepoImpl(DBConnect.connect());
			
			if (itemRepo.updateItem(item)) {
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

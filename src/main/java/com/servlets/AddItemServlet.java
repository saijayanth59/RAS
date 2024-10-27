package com.servlets;

import java.io.IOException;
import java.sql.Connection;

import com.db.DBConnect;
import com.models.Ingredient;
import com.models.Item;
import com.models.ItemIngredient;
import com.repositories.IngredientRepoImpl;
import com.repositories.ItemRepoImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/addItem")
public class AddItemServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private static final String imageUrl = "https://plus.unsplash.com/premium_photo-1722686436015-bbba656b5381?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NXx8Zm9vZHxlbnwwfHwwfHx8MA%3D%3D";
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		try {
			
			String name = req.getParameter("name");
			String description = req.getParameter("description");
			Double price = Double.parseDouble(req.getParameter("price"));
			String checkBox = req.getParameter("veg");
			Boolean veg = false;
			
		    if (checkBox != null && checkBox.equals("on")) {
		        veg = true;
		      } 
		    
			String[] ingredientIds = req.getParameterValues("ingredients");
			Item item = new Item();
			
			Connection conn = DBConnect.connect();
			
			for (String id: ingredientIds) {

				ItemIngredient itemIngredient = new ItemIngredient();
				itemIngredient.setIngredientId(Integer.parseInt(id));
				String quantity = req.getParameter(id);
				itemIngredient.setQuantity(Double.parseDouble(quantity));
				
				item.addItemIngredient(itemIngredient);
				
			}
			
			item.setName(name);
			item.setDescription(description);
			item.setPrice(price);
			item.setVeg(veg);
			item.setImage(imageUrl);
			
			ItemRepoImpl itemRepo = new ItemRepoImpl(DBConnect.connect());
			
			if (itemRepo.addItem(item)) {
				res.sendRedirect("index.jsp");
			}else {
				res.sendRedirect("add_item.jsp");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnect.destroy();
		}
		
	}

}

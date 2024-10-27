package com.servlets.ingredient;

import java.io.IOException;

import com.db.DBConnect;
import com.models.Ingredient;
import com.repositories.IngredientRepoImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addIngredient")
public class AddIngredientServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		try {
			
			String name = req.getParameter("name");
			Double price = Double.parseDouble(req.getParameter("price"));
			Double quantity = Double.parseDouble(req.getParameter("quantity"));
			
			Ingredient ingredient = new Ingredient(1, name, quantity, price);
			


			
			IngredientRepoImpl ingredientRepo = new IngredientRepoImpl(DBConnect.connect());
			
			if (ingredientRepo.addIngredient(ingredient)) {
				res.sendRedirect("view_ingredients.jsp");
			}else {
				res.sendRedirect("add_ingredient.jsp");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnect.destroy();
		}
		
	}

}

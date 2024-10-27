package com.servlets.ingredient;

import java.io.IOException;
import java.sql.Connection;

import com.db.DBConnect;
import com.repositories.IngredientRepoImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/deleteIngredient")
public class DeleteIngredientServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		try {
			
			int id_ = Integer.parseInt(req.getParameter("id"));
			System.out.println(id_);
			IngredientRepoImpl ingredientRepo = new IngredientRepoImpl(DBConnect.connect());
			
			if (ingredientRepo.deleteIngredient(id_)) {
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

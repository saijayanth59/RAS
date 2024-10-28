package com.servlets.customerorder;

import java.io.IOException;

import com.db.DBConnect;
import com.repositories.CustomerOrderRepoImpl;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deleteCustomerOrder")
public class DeleteCustomerOrderServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		try {
			
			int id_ = Integer.parseInt(req.getParameter("id"));
			
			
			CustomerOrderRepoImpl customerOrderRepo = new CustomerOrderRepoImpl(DBConnect.connect());
			
			if (customerOrderRepo.deleteCustomerOrder(id_)) {
				res.sendRedirect("customer_orders.jsp");
			}else {
				res.sendRedirect("customer_orders.jsp?message=Failed to update status");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnect.destroy();
		}
		
	}

}

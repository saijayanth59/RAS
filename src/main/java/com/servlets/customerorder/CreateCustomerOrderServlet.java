package com.servlets.customerorder;

import java.io.IOException;
import java.sql.Connection;

import com.db.DBConnect;
import com.models.CustomerOrder;
import com.models.Item;
import com.models.OrderItem;
import com.repositories.CustomerOrderRepoImpl;
import com.repositories.ItemRepoImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/createCustomerOrder")
public class CreateCustomerOrderServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		try {
		
			String[] itemIds = req.getParameterValues("items");
			
			CustomerOrder customerOrder = new CustomerOrder();
			Connection connection = DBConnect.connect();
			
			ItemRepoImpl itemRepo = new ItemRepoImpl(connection);
			
			Double totalPrice = (double) 0;
			
			for (String id_: itemIds) {
				
				Item item = itemRepo.getItemById(Integer.parseInt(id_));
				int quantity = Integer.parseInt(req.getParameter(id_));
				Double currPrice = quantity * item.getPrice();
				totalPrice += currPrice;
				OrderItem orderItem = new OrderItem();
				orderItem.setItemId(Integer.parseInt(id_));
				orderItem.setQuantity(quantity);
				orderItem.setPrice(item.getPrice());
				
				customerOrder.addItems(orderItem);
			}
			
//			customerOrder.setCustomerId(1);
			customerOrder.setNoOfItems(itemIds.length);
			customerOrder.setTotalPrice(totalPrice);

			
			CustomerOrderRepoImpl customerOrderRepo= new CustomerOrderRepoImpl(connection);
			
			if (customerOrderRepo.addCustomerOrder(customerOrder)) {
				res.sendRedirect("customer_orders.jsp");
			}else {
				res.sendRedirect("create_customer_order.jsp");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnect.destroy();
		}
		
	}

}

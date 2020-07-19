package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ItemDao;
import model.OrdersDao;
import vo.Item;
import vo.Orders;
@WebServlet("/mall/MyOrdersList")
public class MyOrdersList extends HttpServlet {
	
	private OrdersDao ordersDao;
	private Orders orders;
	private Item item;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request
	
		this.ordersDao = new OrdersDao();
		List<Orders> list = new ArrayList<Orders>();
		list = ordersDao.selectOrdersListAll();

		ItemDao i = new ItemDao();
		List<Item> item = new ArrayList<Item>();
		item = i.selectItemListAll();
		
		//view
		//response.sendRedirect(request.getContextPath()+"/WEB-INF/jsp/mall/myOrdersList.jsp");
		request.setAttribute("orders", list);
		request.setAttribute("item", item);
		request.getRequestDispatcher("/WEB-INF/jsp/mall/myOrdersList.jsp").forward(request, response);
	}
}

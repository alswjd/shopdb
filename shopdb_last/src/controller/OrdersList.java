package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.OrdersDao;
import vo.Orders;
@WebServlet("/admin/OrdersList")
public class OrdersList extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//session
		HttpSession s = request.getSession();
		
		if(s.getAttribute("SloginId")==null) {
			response.sendRedirect(request.getContextPath()+"/admin/AdminLogin");
			return;
		}
		
		//request 호출
		System.out.println(request.getRemoteAddr());
		
		//model 호출
		OrdersDao ordersDao = new OrdersDao();
		List<Orders> list = ordersDao.selectOrdersListAll();
		
		//view 연결
		request.setAttribute("orders", list);
		request.getRequestDispatcher("/WEB-INF/jsp/admin/ordersList.jsp").forward(request, response);
	}
}

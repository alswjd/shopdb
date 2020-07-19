package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.OrdersDao;
import vo.Orders;
@WebServlet("/admin/UpdateOrders")
public class UpdateOrders extends HttpServlet {
	
	private OrdersDao ordersDao;
	private Orders orders;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//session
		HttpSession s = request.getSession();
		
		if(s.getAttribute("SloginId")==null) {
			response.sendRedirect(request.getContextPath()+"/admin/AdminLogin");
			return;
		}
		
		//request 호출
		int ordersId = Integer.parseInt(request.getParameter("ordersId"));
		System.out.println(ordersId + "<--UpdateOrders.doGet()  ordersId");
		
		//model 호출
		this.ordersDao = new OrdersDao();
		Orders list = ordersDao.updateOrdersOne(ordersId);
		
		String[] str = {"주문완료","배송중","배송완료","주문취소"};
		request.setAttribute("str", str);
		
		//view 연결
		request.setAttribute("orders", list);
		request.getRequestDispatcher("/WEB-INF/jsp/admin/updateOrders.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//인코딩
		request.setCharacterEncoding("utf-8");
		
		//request 호출
		int ordersId = Integer.parseInt(request.getParameter("ordersId"));
		System.out.println(ordersId + "<--ordersId");
		String ordersState = request.getParameter("ordersState");
		System.out.println(ordersState + "<--ordersState");
		int itemCount = Integer.parseInt(request.getParameter("itemCount"));
		System.out.println(itemCount + "<--itemCount");
		
		//model 호출
		this.orders = new Orders();
		orders.setOrdersState(ordersState);
		orders.setItemCount(itemCount);
		
		this.ordersDao = new OrdersDao();
		ordersDao.updateOrdersState(ordersId, ordersState, itemCount);
		
		//view 연결
		response.sendRedirect(request.getContextPath()+"/admin/OrdersList");
	}
}

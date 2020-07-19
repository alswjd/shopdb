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

import model.CategoryDao;
import model.ItemDao;
import model.OrdersDao;
import vo.Category;
import vo.Item;
import vo.Orders;
@WebServlet("/mall/InsertOrders")
public class InsertOrders extends HttpServlet{
	
	private ItemDao itemDao;
	private OrdersDao ordersDao;
	
	@Override	//입력 폼
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int itemId = Integer.parseInt(request.getParameter("itemId"));
		this.itemDao = new ItemDao();
		Item item = itemDao.selectItemOne(itemId);
		
		List<Category> cate = new ArrayList<Category>();
		CategoryDao cateDao = new CategoryDao();
		cate = cateDao.selectCategoryListAll();
		
		request.setAttribute("item", item);
		request.setAttribute("cate", cate);
		request.getRequestDispatcher("/WEB-INF/jsp/mall/insertOrders.jsp").forward(request, response);
		
	}
	
	@Override	//입력 실행
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//인코딩
		request.setCharacterEncoding("utf-8");
		
		//request.get...으로 채우기
		int itemCount = Integer.parseInt(request.getParameter("itemCount"));
		System.out.println(itemCount+"doPost() itemCount");
		System.out.println(itemCount + "<--InsertOrders.doPost() itemCount");
		String userName = request.getParameter("userName");
		String userPhone = request.getParameter("userPhone");
		String userAddress = request.getParameter("userAddress");
		int itemId = Integer.parseInt(request.getParameter("itemId"));
		int itemPrice = Integer.parseInt(request.getParameter("itemPrice"));
		
		Orders orders = new Orders();
		orders.setItemCount(itemCount);
		orders.setUserName(userName);
		orders.setUserPhone(userPhone);
		orders.setUserAddress(userAddress);
		orders.setItemId(itemId);
		
		orders.setOrdersPrice(itemPrice*itemCount);
		
		this.ordersDao = new OrdersDao();
		ordersDao.myOrdersList(orders);
		
		//redirect
		response.sendRedirect(request.getContextPath()+"/mall/MyOrdersList");
	}
}

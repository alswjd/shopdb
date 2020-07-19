package controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CategoryDao;
import model.ItemDao;
import vo.Category;
import vo.Item;

@WebServlet("/admin/InsertItem")
public class InsertItem extends HttpServlet {
	
	private ItemDao itemDao;	//같은 클래스 안에서는 사용가능
	private CategoryDao categoryDao;
	
	//입력 폼(C-M-V)
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.categoryDao = new CategoryDao();
		List<Category> list = this.categoryDao.selectCategoryListAll();
		
		//session 값 가지고 옴
		HttpSession session = request.getSession();
		
		if(session.getAttribute("SloginId") == null) {
			response.sendRedirect(request.getContextPath()+"/admin/AdminLogin");
			return;
		}
		
		request.setAttribute("li",list);
		request.getRequestDispatcher("/WEB-INF/jsp/admin/insertItem.jsp").forward(request, response);
	}

	//입력 액션
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//인코딩
		request.setCharacterEncoding("utf-8");
		
		//request 호출
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		String itemName = request.getParameter("itemName");
		int itemPrice = Integer.parseInt(request.getParameter("itemPrice"));
		String itemContents = request.getParameter("itemContents");
		
		//model 호출
		Item i = new Item();
		i.setCategoryId(categoryId);
		i.setItemName(itemName);
		i.setItemPrice(itemPrice);
		i.setItemContents(itemContents);
		
		this.itemDao = new ItemDao();
		this.itemDao.insertItem(i);
		
		//view 연결
		response.sendRedirect(request.getContextPath()+"/admin/ItemList");
	}

}

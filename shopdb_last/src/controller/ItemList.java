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
import vo.Category;

import vo.Item;


@WebServlet("/admin/ItemList")
public class ItemList extends HttpServlet {
	
	private ItemDao itemDao;
	private CategoryDao categoryDao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.itemDao = new ItemDao();
		this.categoryDao = new CategoryDao();
		
		//session
		HttpSession session = request.getSession();
		
		if(session.getAttribute("SloginId") == null) {
			response.sendRedirect(request.getContextPath()+"/admin/AdminLogin");
			return;
		}
		
		List<Item> item = this.itemDao.selectItemListAll();
		List<Category> list = this.categoryDao.selectCategoryListAll();
		
		
		request.setAttribute("item", item);
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/WEB-INF/jsp/admin/itemList.jsp").forward(request, response);
	}
}

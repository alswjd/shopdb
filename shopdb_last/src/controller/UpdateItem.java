package controller;

import java.io.IOException;
import java.util.ArrayList;

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

@WebServlet("/admin/UpdateItem")
public class UpdateItem extends HttpServlet {
	
	private ItemDao itemDao;
	private Item item;
	
	//수정 폼
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//session
		HttpSession s = request.getSession();
		
		if(s.getAttribute("SloginId")==null) {
			response.sendRedirect(request.getContextPath()+"/admin/AdminLogin");
			return;
		}
		
		//request 호출
		int itemId = Integer.parseInt(request.getParameter("itemId"));
		System.out.println(itemId + "<--UpdateItem.doGet()  itemId");
		
		//model 호출 
		this.itemDao = new ItemDao();
		this.item = this.itemDao.selectItemOne(itemId);
		request.setAttribute("item", item);
		
		CategoryDao categoryDao = new CategoryDao();
		ArrayList<Category> list = categoryDao.selectCategoryListAll();
		request.setAttribute("list", list);
		
		//view 연결
		request.getRequestDispatcher("/WEB-INF/jsp/admin/updateItem.jsp").forward(request, response);
	}

	//수정 액션
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//
		request.setCharacterEncoding("utf-8");
		//request 호출
		int itemId = Integer.parseInt(request.getParameter("itemId"));
		System.out.println(itemId + "<--UpdateItem.doGet()  itemId");
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		System.out.println(categoryId + "<--categoryId");
		String itemName = request.getParameter("itemName");
		System.out.println(itemName + "<--itemName");
		int itemPrice = Integer.parseInt(request.getParameter("itemPrice"));
		System.out.println(itemPrice + "<--itemPrice");
		String itemContents = request.getParameter("itemContents");
		System.out.println(itemContents + "<--itemContents");
		
		
		//model 호출 
		this.item = new Item();
		item.setItemId(itemId);
		item.setCategoryId(categoryId);
		item.setItemName(itemName);
		item.setItemPrice(itemPrice);
		item.setItemContents(itemContents);
		
		
		this.itemDao = new ItemDao();
		itemDao.updateItem(item);
		
		//view연결
		response.sendRedirect(request.getContextPath()+"/admin/ItemList");
		
	}

}

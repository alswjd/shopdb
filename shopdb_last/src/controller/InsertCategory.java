package controller;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CategoryDao;
import vo.Category;

@WebServlet("/admin/InsertCategory")
public class InsertCategory extends HttpServlet{
	//InsertCategory 요청이 get방식일 경우 -> 입력폼으로 넘어감
	@Override	//C-V 를 가짐
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//처리할 요청도 없고, 호출할 모델도 없기 때문에 그냥 view만 호출
		
		//session값을 가지고옴
		HttpSession session = request.getSession();
		
		if(session.getAttribute("SloginId") == null) {
			response.sendRedirect(request.getContextPath()+"/admin/AdminLogin");
			return;
		}
		
		request.getRequestDispatcher("/WEB-INF/jsp/admin/insertCategory.jsp").forward(request, response);
	}
	
	//InsertCategory 요청이 post방식일 경우 -> 입력 진행
	@Override	//C-M을 가짐 ---> 또 다른 C를 호출("/CategoryList"):위에 Http부분에 있는 곳
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//인코딩을 맞춰줌
		request.setCharacterEncoding("utf-8");
		
		//1. 요청 분석(주소분석, request 분석)
		String categoryName = request.getParameter("categoryName");
		System.out.println(categoryName + "<-- InsertCategory.doPost() categoryName");
		Category category = new Category();
		category.setCategoryName(categoryName);
		
		//2. 모델 호출
		CategoryDao categoryDao = new CategoryDao();
		categoryDao.insertCategory(category);
		
		//3. 뷰 연결하거나 또는 다른 controller를 redirect해야 한다. ()
		response.sendRedirect(request.getContextPath() + "/admin/CategoryList");
	}
}

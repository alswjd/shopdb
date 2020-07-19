package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CategoryDao;
import vo.Category;


@WebServlet("/admin/UpdateCategory")
public class UpdateCategory extends HttpServlet {
	
	private CategoryDao categoryDao;
	
	//수정 폼을 보여줌  [ C-M-V ]
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//C
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		System.out.println(categoryId+"<--UpdateCategory.doGet()  categoryId");
		
		//session
		HttpSession s = request.getSession();
		
		if(s.getAttribute("SloginId")== null) {
			response.sendRedirect(request.getContextPath()+"/admin/AdminLogin");
			return;
		}
		
		//M
		this.categoryDao = new CategoryDao();
		Category category = this.categoryDao.selectCategoryOne(categoryId);
		
		//V (view forward): 뷰 연결
		request.setAttribute("ca", category);	//////jsp첫줄로 넘겨지는 값
		request.getRequestDispatcher("/WEB-INF/jsp/admin/updateCategory.jsp").forward(request, response);;
	}

	//수정 Action  [ C-M ] 하고 Redirect 발생 [ 또 다른 C 요청 ] 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//인코딩
		request.setCharacterEncoding("utf-8");
		
		//C
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		String categoryName = request.getParameter("categoryName");
		
		//M
		Category category = new Category();
		category.setCategoryId(categoryId);
		category.setCategoryName(categoryName);
		
		this.categoryDao = new CategoryDao();
		this.categoryDao.updateCategory(category);
		
		//또 다른 C
		response.sendRedirect(request.getContextPath()+"/admin/CategoryList");
	}

}

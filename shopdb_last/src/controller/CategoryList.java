package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import vo.*;
import model.CategoryDao;

@WebServlet("/admin/CategoryList")
public class CategoryList extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Model View Controll 모델2 (MVC) - 모델 1 과 차이점 알기

		//Controller 역할 
		//- request 분석
			System.out.println(request.getRemoteAddr()); //연결된 ip주소 가지고 옴
		
		//- model 호출
			CategoryDao categoryDao = new CategoryDao();
			ArrayList<Category> list = categoryDao.selectCategoryListAll();
			System.out.println(list.size());	//결과 값: 3
			request.setAttribute("list", list); //요청을 처리하고 모델을 불러와서 request 안에 저장한다
			
		//- view를 연결 (호출하는 거 아님)
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/admin/categoryList.jsp");
			rd.forward(request, response);
		
	}
}

package controller;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet({"/admin","/admin/Index"})	//두가지의 값으로 요청해도 둘 다 가능
public class Index extends HttpServlet {
	@Override
	//get방식으로 보낸 것은 Get으로 받아야 하고 post방식으로 보낸 것은 Post방식으로 받아야 됨
	//jsp에서 하이퍼링크로 보내줬기 때문에 doGet으로 받아옴
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getAttribute("RloginId") + "<--RloginId"); //null
		
		
		//session
		HttpSession session = request.getSession();
		System.out.println(session.getAttribute("SloginId") + "<--SloginId"); //admin
		
		//로그인 된 상태에서만 페이지를 볼 수 있게 모든 페이지에 이 코드가 필요함
		if(session.getAttribute("SloginId") == null) {
			response.sendRedirect(request.getContextPath()+"/admin/AdminLogin");
			return; //모든 코드를 중지
		}
		
		request.getRequestDispatcher("/WEB-INF/jsp/admin/index.jsp").forward(request, response);
	}
}

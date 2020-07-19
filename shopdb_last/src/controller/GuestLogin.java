package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.GuestDao;
import vo.Guest;

@WebServlet("/mall/GuestLogin")
public class GuestLogin extends HttpServlet{
	
	//login form
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/mall/guestLogin.jsp").forward(request, response);
	}
	
	//logout action (인증)
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String guestId = request.getParameter("guestId");
		String guestPw = request.getParameter("guestPw");
		
		Guest guest = new Guest();
		guest.setGuestId(guestId);
		guest.setGuestPw(guestPw);
		
		GuestDao guestDao = new GuestDao();
		Guest returnGuest = guestDao.login(guest);
		
		if(returnGuest != null) {
			System.out.println("로그인 성공");
			
			//session 이용
			HttpSession session = request.getSession();
			session.setAttribute("loginId", returnGuest.getGuestId());
			
			//2.관리자 index 요청 
			response.sendRedirect(request.getContextPath()+"/mall/MallIndex");
		}else {
			System.out.println("로그인 실패");
			response.sendRedirect(request.getContextPath()+"/mall/GuestLogin");
		}
	}
}

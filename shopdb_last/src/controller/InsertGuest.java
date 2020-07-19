package controller;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.*;
import vo.*;
@WebServlet("/mall/InsertGuest")
public class InsertGuest extends HttpServlet{
	
	private GuestDao guestDao;
	private Guest guest;
	
	//입력 폼
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request
		//model
		//view
		request.getRequestDispatcher("/WEB-INF/jsp/mall/insertGuest.jsp").forward(request, response);
	}
	
	//입력 액션
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//encoding
		request.setCharacterEncoding("utf-8");
		
		//request
		String guestId = request.getParameter("guestId");
		System.out.println(guestId+"<--Insertguest.doPost()  guestId");
		String guestPw = request.getParameter("guestPw");
		System.out.println(guestPw+"<--Insertguest.doPost()  guestPw");
		
		//model
		this.guestDao = new GuestDao();
		
		this.guest = new Guest();
		guest.setGuestId(guestId);
		guest.setGuestPw(guestPw);
		
		guestDao.insertGuest(guest);
		
		//view
		response.sendRedirect(request.getContextPath()+"/mall/GuestLogin");
	}
}

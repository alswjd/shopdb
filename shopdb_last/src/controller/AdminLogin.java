package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MemberDao;
import vo.Member;
@WebServlet("/admin/AdminLogin")
public class AdminLogin extends HttpServlet{
	
	
	
	//login form
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/admin/adminLogin.jsp").forward(request, response);
	}
	
	//login Action(인증)
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String adminId = request.getParameter("adminId");
		String adminPw = request.getParameter("adminPw");
		
		Member member = new Member();
		member.setMemberId(adminId);
		member.setMemberPw(adminPw);
		
		MemberDao memberDao = new MemberDao();
		Member returnMember = memberDao.login(member);
		
		
		if(returnMember != null) {
			System.out.println("로그인 성공");
			//1.로그인 했다는 정보를 톰켓(변수)안에 저장해야 한다 - request안에 저장 : 문제가 있음 -> session 사용
			// 저장공간 : request , session, application
			
			//session 이용
			HttpSession session = request.getSession();
			session.setAttribute("SloginId", returnMember.getMemberId());
			
			//2.관리자 index 요청 
			response.sendRedirect(request.getContextPath()+"/admin");
		}else {
			System.out.println("로그인 실패");
			response.sendRedirect(request.getContextPath()+"/admin/AdminLogin");
		}
		
		
		
	}
	
}

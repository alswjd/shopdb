package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDao;
import vo.Member;
@WebServlet("/admin/InsertMember")
public class InsertMember extends HttpServlet{
	
	private MemberDao memDao;
	private Member mem;
	
	//입력 폼
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request
		//model
		//view
		request.getRequestDispatcher("/WEB-INF/jsp/admin/insertMember.jsp").forward(request, response);
	}
	
	//입력 액션
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//encoding
		request.setCharacterEncoding("utf-8");
		
		//request
		String memberId = request.getParameter("memberId");
		System.out.println(memberId+"<--InsertMember.doPost()  memberId");
		String memberPw = request.getParameter("memberPw");
		System.out.println(memberPw+"<--InsertMember.doPost()  memberPw");
		
		//model
		this.memDao = new MemberDao();
		
		this.mem = new Member();
		mem.setMemberId(memberId);
		mem.setMemberPw(memberPw);
		
		memDao.insertMember(mem);
		
		//view
		response.sendRedirect(request.getContextPath()+"/admin/MemberList");
	}
}

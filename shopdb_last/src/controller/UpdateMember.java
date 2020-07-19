package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDao;
import vo.Member;
@WebServlet("/admin/UpdateMember")
public class UpdateMember extends HttpServlet{
	
	private MemberDao memDao;
	private Member mem;
	
	//수정 폼
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request
		String memberId = request.getParameter("memberId");
		System.out.println(memberId+"UpdateMember.doGet() memberId");
		
		//model
		this.memDao = new MemberDao();
		this.mem = memDao.selectMemberOne(memberId);
		
		//view
		request.setAttribute("mem", mem);
		request.getRequestDispatcher("/WEB-INF/jsp/admin/updateMember.jsp").forward(request, response);
	}
	
	//수정액션
	@Override	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//encoding
		request.setCharacterEncoding("utf-8");
		
		//request
		String memberId = request.getParameter("memberId");
		System.out.println(memberId+"<--UpdateMember.doPost()  memberId");
		String memberPw = request.getParameter("memberPw");
		System.out.println(memberPw+"<--UpdateMember.doPost()  memberPw");
		
		//model
		this.memDao = new MemberDao();
		
		this.mem = new Member();
		mem.setMemberId(memberId);
		mem.setMemberPw(memberPw);
		
		memDao.updateMember(mem);
		
		//view
		response.sendRedirect(request.getContextPath()+"/admin/MemberList");
	}
}

package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDao;
import vo.Member;
@WebServlet("/admin/MemberList")
public class MemberList extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request
		//model
		MemberDao memDao = new MemberDao();
		List<Member> mem = memDao.selectMemberAll();
		
		
		//view
		request.setAttribute("mem", mem);
		request.getRequestDispatcher("/WEB-INF/jsp/admin/memberList.jsp").forward(request, response);
	}
	
}

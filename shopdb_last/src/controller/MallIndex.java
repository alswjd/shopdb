package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ItemDao;
import vo.Item;

@WebServlet("/mall/MallIndex")
public class MallIndex extends HttpServlet {
	
	private ItemDao itemDao;	//1.추상화  : 클래스를 만드는 것, 인터페이스, 추상클래스 등.. 만드는 것 (데이터 타입을 만드는 것)
								//2.상속 : 
								//3.다형성 : 
								//4.캡슐화 : private으로 묶은 것과 같은 것 (?)
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.itemDao = new ItemDao();
		List<Item> list = itemDao.selectItemListAll();
		request.setAttribute("list", list);
		
		//session 이용해서 로그인 기능 만들기
		HttpSession session = request.getSession();
		System.out.println(session.getAttribute("loginId"));
		
		if(session.getAttribute("loginId")==null) {
			response.sendRedirect(request.getContextPath()+"/mall/GuestLogin");
			return;//모든 코드를 중지
		}
		
		request.getRequestDispatcher("/WEB-INF/jsp/mall/mallIndex.jsp").forward(request, response);
	}
}

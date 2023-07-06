package co.micol.prj.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.MainCommand;
import co.micol.prj.common.Command;
import co.micol.prj.member.command.AjaxIdCheck;
import co.micol.prj.member.command.AjaxMemberSearchList;
import co.micol.prj.member.command.MemberJoinForm;
import co.micol.prj.member.command.MemberList;
import co.micol.prj.member.command.MemberLogin;
import co.micol.prj.member.command.MemberLoginForm;
import co.micol.prj.member.command.MemberLogout;

@WebServlet("*.do")
public class FrontContorller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, Command> map = new HashMap<>();
	
    public FrontContorller() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		// 호출하는 이름들의 집합
		map.put("/main.do", new MainCommand()); // 처음 들어오는 페이지
		map.put("/memberLoginForm.do", new MemberLoginForm()); //로그인 폼 호출
		map.put("/memberLogin.do", new MemberLogin()); //로그인 처리
		map.put("/memberLogout.do", new MemberLogout()); //로그아웃 처리
		map.put("/memberJoinForm.do", new MemberJoinForm()); //회원가입 폼
		map.put("/ajaxIdCheck.do", new AjaxIdCheck()); //ajax 아이디 중복체크
		map.put("/memberList.do", new MemberList()); //멤버 목록보기
		map.put("/ajaxMemberSearchList.do", new AjaxMemberSearchList()); //멤버검색
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 어떤 요청이 들어왔는지 요청을 분석하고 적절한 Command를 선택하고 실행, 결과를 돌려줄 페이지를 정하는곳
		// view resolve
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String page = uri.substring(contextPath.length());
		
		Command command = map.get(page);
		String viewPage = command.exec(request, response);
		
		if(!viewPage.endsWith(".do")) {
			if(viewPage.startsWith("Ajax:")) {
				//Ajax 처리
				response.setContentType("text/html; charset=UTF-8");
				response.getWriter().append(viewPage.substring(5));
				return;
			}
			viewPage += ".tiles";
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect(viewPage);
		}
	}

}

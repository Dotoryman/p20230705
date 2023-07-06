package co.micol.prj.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.prj.common.Command;

public class MemberLogout implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 로그아웃처리
		HttpSession session = request.getSession();
		session.invalidate();
		request.setAttribute("message", "조심히 들어가쇼");
		return "member/errorMessage";
	}

}

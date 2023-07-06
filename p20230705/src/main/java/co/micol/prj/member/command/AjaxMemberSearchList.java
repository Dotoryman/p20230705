package co.micol.prj.member.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.micol.prj.common.Command;
import co.micol.prj.member.service.MemberService;
import co.micol.prj.member.service.MemberVO;
import co.micol.prj.member.serviceImpl.MemberServiceImpl;

public class AjaxMemberSearchList implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// ajax 멤버 검색
		MemberService memberService = new MemberServiceImpl();
		List<MemberVO> members =new ArrayList<>();
		ObjectMapper mapper = new ObjectMapper(); // json 객체로 돌려주기 위해서 쓴다
		
		String key = request.getParameter("key");
		String val = request.getParameter("val");
		System.out.println(key);
		System.out.println(val);
		members = memberService.memberSelectList(key, val);
		String str = "Ajax:"; 
		try {
			str += mapper.writeValueAsString(members); //검색된 결과를 json으로 바꾸기
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	
		return str;
	}

}

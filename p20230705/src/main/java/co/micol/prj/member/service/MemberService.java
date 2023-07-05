package co.micol.prj.member.service;

import java.util.List;

public interface MemberService {
	List<MemberVO> memberSelectList(); //R read 전체집합
	List<MemberVO> memberSelectList(String key, String val); //R read 전체집합
	
	MemberVO memberSelect(MemberVO vo); //R read 부분집합
	int memberInsert(MemberVO vo); //C create
	int memberUpdate(MemberVO vo); //U update
	int memberDelete(MemberVO vo); //D delete
	
	boolean isMemberIdCheck(String id); //boolean 타입은 앞에 is 붙여준다
}

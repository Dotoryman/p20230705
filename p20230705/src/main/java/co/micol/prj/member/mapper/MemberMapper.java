package co.micol.prj.member.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.micol.prj.member.service.MemberVO;

public interface MemberMapper {
	List<MemberVO> memberSelectList(); //R read 전체집합
	List<MemberVO> memberSelectList(@Param("key") String key, @Param("val") String val); //R read 전체집합 param은 매개변수가 2개 이상일때 무조건! 맵퍼에서 써준다
	
	MemberVO memberSelect(MemberVO vo); //R read 부분집합
	int memberInsert(MemberVO vo); //C create
	int memberUpdate(MemberVO vo); //U update
	int memberDelete(MemberVO vo); //D delete
	
	boolean isMemberIdCheck(String id); //boolean 타입은 앞에 is 붙여준다
}

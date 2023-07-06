<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
	<div><h1>회원가입</h1></div>
	<div>
		<form id="id" onsubmit="return formCheck()" action="memberJoin.do">
			<input type="text" id="memberId" name="memberId">
			<button type="button" id="btnChk" value="No" onclick="idCheck()">중복쳌</button>
			<br>
			<input type="submit" value="가입하기">
		</form>
	</div>
	<div id=""></div>
</div>
	<script type="text/javascript">
		function formCheck(){
			let chk = document.getElementById("btnChk").value;
			if(chk == 'No'){
				alert("아이디 중복체크 하고오쇼")
				return false;
			} else {
				return true;
			}
			let frm = document.getElementById("frm");
			frm.action="memberJoin.do";
			frm.submit
			
		}
	
		function idCheck() { //Ajax를 통한 아이디 중복 체크
			let id = document.getElementById("memberId").value;
			let url = "ajaxIdCheck.do?id=" + id;
			fetch(url)
				.then(response => response.text())
				.then(text => viewHtml(text))
		}
		
		function viewHtml(data){
			if(data == 1) {
				alert("이미 사용중인 아이디 입니다.");
			} else {
				alert("사용가능한 아이디 입니다.");
				document.getElementById("btnChk").value = "Yes";
			}
		}
		
		
		
	</script>
</body>
</html>
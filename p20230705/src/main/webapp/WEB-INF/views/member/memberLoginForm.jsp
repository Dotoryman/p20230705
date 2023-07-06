<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 폼 입니다</title>
</head>
<body>
<div align="center">
	<div><h1>로그인</h1></div>
	<div>
		<form id="frm" action="memberLogin.do" method="post">
			<div>
				<table border="1">
					<tr>
						<th width="150">아이디</th>
						<td width="200">
							<input type="text" id="memberId" name="memberId">
						</td>
					</tr>
					<tr>
						<th width="150">비밀번호</th>
						<td width="200">
							<input type="password" id="memberPassword" name="memberPassword">
						</td>
					</tr>
				</table>
			</div><br>
			<div>
				<input type="submit" value="로그인">
				<input type="reset" value="초기화">
			</div>
		
		</form>
	</div>
</div>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>표이슬 전화번호 수정화면</h1>
	
	<p>
		수정화면 입니다.<br>
		아래항목을 수정하고 "수정"버튼을 클릭하세요
	</p>
	
	<form action="${pageContext.request.contextPath}/phone/modify2" method="get">
		이름(name) : <input type="text" name="name" value="${requestScope.pMap.NAME}"> <br>
		핸드폰(hp) : <input type="text" name="hp" value="${requestScope.pMap.HP}"> <br>
		회사(company) : <input type="text" name="company" value="${requestScope.pMap.COMPANY}"> <br>
		
		 <input type="hidden" name="person_id" value="${requestScope.pMap.PERSON_ID }">
	<button type="submit" >수정</button>
		
	</form>
	
	<br>
	<a href="${pageContext.request.contextPath}/phone/list">리스트 바로가기</a>

</body>
</html>
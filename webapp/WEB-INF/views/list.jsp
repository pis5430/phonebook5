<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>phonebook 모델2</title>
</head>
<body>


	<h1>전화번호 리스트${pageContext.request.contextPath}</h1>

	<p>입력한 전화번호 내역입니다.</p>

	<c:forEach items="${requestScope.pList}" var="personVo" >
	<table border="1">
		<tr>
			<td>이름 (name)</td>
			<td>${personVo.name}</td>
		</tr>
		<tr>
			<td>핸드폰(hp)</td>
			<td>${personVo.hp}</td>
		</tr>
		<tr>
			<td>회사(company)</td>
			<td>${personVo.company}</td>
		</tr>
		<tr>
			<td>
				<a href="${pageContext.request.contextPath}/phone/modifyForm?id=${personVo.person_id}">[수정]</a>
				<a href="${pageContext.request.contextPath}/phone/modifyForm2?id=${personVo.person_id}">[수정2]</a>
			</td>
			
			<td>
				<a href="${pageContext.request.contextPath}/phone/delete/${personVo.person_id}">[삭제]</a>
				<a href="${pageContext.request.contextPath}/phone/delete2?id=${personVo.person_id}">[삭제2]</a>
			</td>
		</tr>
		
	</table>
	<br>
	</c:forEach>
	<br>
	
	
	<a href="${pageContext.request.contextPath}/phone/writeForm">추가번호 등록</a>


</body>
</html>
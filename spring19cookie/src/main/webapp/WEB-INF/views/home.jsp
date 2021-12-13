<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	쿠키테스트 
</h1>
<br>
<hr>
<h1> 쿠키 : ${cookie.test.name} / ${cookie.test.value }</h1>
<h2><a href="create">쿠키 생성</a></h2>
<h2><a href="drop">쿠키 삭제</a></h2>
<h2><a href="check">쿠키 검사</a></h2>
 
<c:if test="${cookie.test!=null}">
	<h1>쿠키가 있습니다.</h1>
</c:if>
</body>
</html>

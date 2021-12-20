<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<h1>결제 테스트</h1>
<form action="pay/confirm" method="get">
<c:forEach var="productDto" items="${list}" >
	<div>
	<input type="checkbox" name="no" value ="${productDto.no}">
		${productDto.no} / ${productDto.name} / ${productDto.price}
	</div>
</c:forEach>
<button type="submit">구매하기</button>
</form>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<script>
	$(function() {
		$("button").click(function() {
			$.ajax({
				url : "요청 주소",
				type : "전송방식",
				dataType : "기대하는결과",
				success : function(resp) {

				},
				error : function(e) {
					console.log(e);
				}
			});
		});
	});
</script>
<h1>View 1</h1>

<button>click</button>

<div id="result"></div>

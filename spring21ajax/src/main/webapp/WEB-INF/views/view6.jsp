<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script>
	$(function(){
		//#insert-form이 전송되면 전송 못하게 막고 ajax로 insert
		$("#insert-form").submit(function(e){
			//this == #insert-form
			e.preventDefault();
			
			var dataValue = $(this).serialize();
			
			$.ajax({
				url:"${pageContext.request.contextPath}/data/data7",
				type:"post",
				data : dataValue,
				//dataType 없음
				success:function(resp){
					console.log("성공", resp);
					
					//주의 : this 는 form이 아니다(this는 함수를 기준으로 계산)
					//jQuery는 reset() 명령이 없어서 get(0)으로 javascript 객체로 변경
					//$("#insert-form").get(0).reset();
					$("#insert-form")[0].reset();
				},
				error:function(e){
					console.log("실패", e);
				}
			});
		});
	});
</script>

<h1>성적 관리</h1>

<form id="insert-form">
	이름 : <input type="text" name="student"><br>
	과목 : <input type="text" name="subject"><br>
	유형 : <input type="text" name="type"><br>
	점수 : <input type="text" name="score"><br>
	<button type="submit">등록</button>
</form>
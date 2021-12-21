<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>대표 결제 정보</h1>

<ul>
	<li>고유번호 : ${buyDto.no}</li>
	<li>거래번호 : ${buyDto.tid}</li>
	<li>거래명 : ${buyDto.itemName}</li>
	<li>거래금액 : ${buyDto.totalAmount}</li>
	<li>거래시각 : ${buyDto.buyTime}</li>
</ul>

<hr>

<ul>
<c:forEach var="buyDetailDto" items="${buyDetailList}">
	<li>${buyDetailDto}</li>
</c:forEach>
</ul>

<hr>

<ul>
	<li>tid : ${responseVO.tid}</li>
	<li>cid : ${responseVO.cid}</li>
	<li>status : ${responseVO.status}</li>
	<li>partner_order_id : ${responseVO.partner_order_id}</li>
	<li>partner_user_id : ${responseVO.partner_user_id}</li>
	<li>payment_method_type : ${responseVO.payment_method_type}</li>
	<li>amount : ${responseVO.amount}</li>
	<li>canceled_amount : ${responseVO.canceled_amount}</li>
	<li>cancel_available_amount : ${responseVO.cancel_available_amount}</li>
	<li>item_name : ${responseVO.item_name}</li>
	<li>item_code : ${responseVO.item_code}</li>
	<li>quantity : ${responseVO.quantity}</li>
	<li>created_at : ${responseVO.created_at}</li>
	<li>approved_at : ${responseVO.approved_at}</li>
	<li>canceled_at : ${responseVO.canceled_at}</li>
	<li>selected_card_info : ${responseVO.selected_card_info}</li>
	<li>
		payment_action_detail : ${responseVO.payment_action_details}
		<ul>
			<c:forEach var="detail" items="${responseVO.payment_action_details}">
			<li>${detail}</li>
			</c:forEach>
		</ul>
	</li>
</ul>
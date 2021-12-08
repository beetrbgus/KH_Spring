<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<%-- 페이지에서 사용할 JSTL 변수 --%>
<c:set var="login" value="${ses != null}"></c:set>
<c:set var="admin" value="${grade == '관리자'}"></c:set>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" type="text/css" href="${root}/resources/css/reset.css">
    <link rel="stylesheet" type="text/css" href="${root}/resources/css/commons.css">
    <link rel="stylesheet" type="text/css" href="${root}/resources/css/layout.css">
<%--     <link rel="stylesheet" type="text/css" href="${root}/resources/css/test.css"> --%>
    <style>
        .logo-wrapper {
            width:130px;
        }
        .logo-wrapper > img {
            width:100%;
            height:100%;
        }
        .title-wrapper {
            flex-grow: 1;
        }

    </style>
</head>
<body>
    <!-- 홈페이지 전체 폭을 설정하는 테두리 영역 -->
    <main>

        <!-- 헤더(상단) 영역 -->
        <header>

            <div class="flex-container">
                <div class="logo-wrapper">
                    <img src="${root}/resources/image/kh_logo.jpg">
                </div>
                <div class="title-wrapper center">
                    <h1>과정평가형 정보처리산업기사 취득과정</h1>
                </div>
            </div>

        </header>

        <!-- 메뉴 영역 -->
        <nav>
            <ul class="slide-menu">
            	<c:choose>
            		<c:when test="${login}">
            			<li><a href="${root}">홈으로</a></li>
		            	<li><a href="${root}/board/list">게시판</a></li>
		            	<li class="flex-right">
		            		<a href="#">회원메뉴</a>
		            		<ul>
		            			<c:choose>
		            				<c:when test="${admin}">
		            					<li><a href="${root}/admin/home">관리메뉴</a></li>
		            				</c:when>
		            				<c:otherwise>
		            					<li><a href="${root}/point/charge">포인트 충전</a></li>
				            			<li><a href="${root}/member/mypage">내정보</a></li>
		            				</c:otherwise>
		            			</c:choose>
				            	<li><a href="${root}/member/logout">로그아웃</a></li>
		            		</ul>
		            	</li>
            		</c:when>
            		<c:otherwise>
	            		<li><a href="${root}">홈으로</a></li>
		            	<li><a href="${root}/board/list">게시판</a></li>
		            	<li class="flex-right">
		            		<a href="${root}/member/login">로그인</a>
		            		<ul>
		            			<li><a href="${root}/member/join">회원가입</a></li>
		            		</ul>
		            	</li>
            		</c:otherwise>
            	</c:choose>
            
            </ul>
        </nav>

        <!-- 섹션(컨텐츠) 영역 -->
        <section>
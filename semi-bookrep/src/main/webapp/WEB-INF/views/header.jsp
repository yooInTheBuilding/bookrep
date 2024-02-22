<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet" href="resources/css/header.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css">
</head>
<body>
<header>
    <div class="header">
        <div class="profile">
            <i class="fa fa-user-circle-o fa-2x" aria-hidden="true" onclick="return moveToFeed()"></i>
        </div>
        <div class="logo">
            <img src="resources/images/bookrepLogo.png" alt="로고">
        </div>
        <div class="buttons">
            <c:choose>
                <c:when test="${empty sessionScope.email}">
                    <div class="login-button">
                        <a href="/bookrep/sign-in"><button>로그인</button></a>
                    </div>
                </c:when>
                <c:otherwise>
                    <!-- 세션에 로그인 정보가 있는 경우 -->
                    <div class="search-box">
                        <form action="/search" method="GET">
                            <input type="text" name="query" placeholder="검색어를 입력하세요">
                            <button type="submit" class="search">search</button>
                        </form>
                    </div>
                    <div class="logout-button">
                        <a href="/bookrep/logout"><button>로그아웃</button></a>
                    </div>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</header>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>독후감 수정</title>
    <link rel="stylesheet" href="resources/css/page.css">
    <link rel="stylesheet" href="resources/css/reportUpdate.css">
</head>
<body>
    <c:choose>
        <c:when test="${not empty sessionScope.email}">
            <jsp:include page="loggedHeader.jsp"></jsp:include>
        </c:when>
        <c:otherwise>
            <jsp:include page="header.jsp"></jsp:include>
        </c:otherwise>
    </c:choose>
    <div id="total-body">
        <div id="update-form">
            <form action="/bookrep/apply-update" method="post">
                <div id="report-top">
                    <input type="hidden" name="id" value="${report.id}">
                    <input type="hidden" name="userEmail" value="${sessionScope.email}">
                    <input type="hidden" name="bookIsbn" value="${report.bookIsbn}">
                    <label for="title">제목:</label> 
                    <input type="text" id="title" name="title" value="${report.title}" required>
                </div>
                <div id="report-body">
                    <label for="content">내용:</label>
                    <textarea id="content" name="content" rows="5" required>${report.content}</textarea>
                    <input type="hidden" name="publicBool" value="${report.publicBool}">
                    <br>
                </div>
                <br>
                <button type="submit">수정완료</button>
            </form>
        </div>
    </div>
</body>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<script type="text/javascript">
    
</script>
</html>
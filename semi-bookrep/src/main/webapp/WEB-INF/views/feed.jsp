<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Feed</title>
</head>
<body>
	<h2>Report Summary</h2>

	<div>PageCnt : ${sessionItems.size()}</div>
	<div>UserEmail: ${userEmail}</div>
	<div>PostCnt: ${reportValue}</div>

	<c:if test="${isCurrentUser}">
		<p>Follower Count: ${followerCnt}</p>
		<p>Following Count: ${followingCnt}</p>
		<p>This is the current user's page.</p>
		<button>Modifying</button>
	</c:if>
	<c:if test="${not isCurrentUser}">
		<button>Follow</button>
	</c:if>

	<c:if test="${not empty sessionItems}">

		<c:forEach var="page" items="${sessionItems}">
			<li>Page ${page.pageNum}</li>
			<ul>
				<c:forEach var="report" items="${page.objectList}">
					<li>Title: ${report.report.title}</li>
					<li>Report_user: ${report.report.userEmail}</li>
					<li>Like: ${report.like}</li>
					<c:if test="${not empty report.image}">
						<li><img src="${report.image}" alt="Book Image" width="200"
							height="300"></li>
					</c:if>
				</c:forEach>
			</ul>
		</c:forEach>
	</c:if>
</body>

<script type="text/javascript">

</script>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Feed</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/feed.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css">
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
	<c:if test="${not empty sessionItems}">
		<div id="total-body">
			<!-- 
		 	세션 연결 후 확인해 볼것.
		 	유저정보들(팔로워 팔로잉, 북마크, 유저정보수정,
		   -->

			<div class="user-info">
				<div class="user-image-container">
					<img src="${userImage}" alt="UserImage">
				</div>
				<div class="user-text-container">
					<div class="top-line">
						<div class="user-name">${userEmail}</div>
						<c:choose>
							<c:when test="${isCurrentUser}">
								<button id="modifyBtn" onclick="showModify()"
									style="height: 50px;">Modifying</button>
							</c:when>
							<c:otherwise>
								<button id="followBtn" onclick="return isFollowing()"
									style="height: 50px;">Follow</button>
								<button id="unfollowBtn" class="top-line-margin"
									style="height: 50px; display: none;">Unfollow</button>
							</c:otherwise>
						</c:choose>
						<a href="/bookmark/${userEmail}"> <img class="bookmark-image"
							class="top-line-margin" alt="bookmark"
							src="../resources/images/bookmark_icon_black.png"
							style="width: 50px; height: 50px;"></a>
					</div>
					<br>
					<div class="bottom-line">
						<div class="bottom-line-margin">
							<span style="margin-right: 10%">Posts</span><span>${reportValue}</span>
						</div>
						<div class="bottom-line-margin">
							<a href="/follower/${userEmail}" style="margin-right: 10%">Follower</a><span>${followerCnt}</span>
						</div>
						<div class="bottom-line-margin">
							<a href="/following/${userEmail}" style="margin-right: 10%">Following</a><span>${followingCnt}</span>
						</div>
					</div>
				</div>
			</div>

			<hr class="separator">

			<br> <br>


			<!-- 현재 페이지 설정 -->
			<c:choose>
				<c:when test="${not empty param.pageNum}">
					<c:set var="currentPageNum" value="${param.pageNum}" />
				</c:when>
				<c:otherwise>
					<c:choose>
						<c:when test="${not empty sessionItems}">
							<c:set var="currentPageNum" value="${sessionItems[0].pageNum}" />
						</c:when>
					</c:choose>
				</c:otherwise>
			</c:choose>

			<!-- 현재 페이지 번호와 일치하는 독후감 등을 출력하는 부분 -->
			<c:if test="${not empty sessionItems}">
				<c:forEach var="page" items="${sessionItems}">
					<c:if test="${page.pageNum eq currentPageNum}">
						<div id="report-container">
							<c:forEach var="report" items="${page.objectList}">
								<div class="image-container">
									<img src="${report.image}" alt="Book Image">
									<div class="overlay">
										<p>${report.report.title}</p>
										<p>${report.report.userEmail}</p>
										<p>Like: ${report.like}</p>
										<a href="/bookrep/report-detail?id=${report.report.id}" target="_blank">독후감
											상세보기</a>
									</div>
								</div>
							</c:forEach>
						</div>
					</c:if>
				</c:forEach>
			</c:if>

			<div class="page">
				<!-- 처음 버튼 -->
				<a href="?pageNum=1" class="page-link">|◀</a>

				<!-- 이전 버튼 -->
				<c:if test="${currentPageNum > 3}">
					<a href="?pageNum=${currentPageNum - 5}" class="page-link">이전</a>
				</c:if>

				<!-- 페이지 번호 5개씩 표시 -->
				<c:forEach var="i"
					begin="${currentPageNum - 2 > 0 ? currentPageNum - 2 : 1}"
					end="${currentPageNum + 2 < sessionItems.size() ? currentPageNum + 2 : sessionItems.size()}">
					<c:choose>
						<c:when test="${i eq currentPageNum}">
							<span class="page-link">${i}</span>
						</c:when>
						<c:otherwise>
							<a href="?pageNum=${i}" class="page-link">${i}</a>
						</c:otherwise>
					</c:choose>
				</c:forEach>

				<!-- 다음 버튼 -->
				<c:if test="${currentPageNum + 2 < sessionItems.size()}">
					<a href="?pageNum=${currentPageNum + 3}" class="page-link">다음</a>
				</c:if>

				<!-- 마지막 버튼 -->
				<a href="?pageNum=${sessionItems.size()}" class="page-link">▶|</a>
			</div>
		</div>
	</c:if>
</body>

<script type="text/javascript">
	function showModify() {
		window.location.href = "/${userEmali}/update";
	}

	$(document).ready(function() {
		// Follow 버튼 클릭 시
		$("#followBtn").on("click", function() {
			var userEmail = $("#userEmail").val();
			follow(userEmail);
		});

		// Unfollow 버튼 클릭 시
		$("#unfollowBtn").on("click", function() {
			var userEmail = $("#userEmail").val();
			unfollow(userEmail);
		});

		function follow(userEmail) {
			$.ajax({
				type : "POST",
				url : "/follow",
				data : {
					email : userEmail
				},
				success : function() {
					// 팔로우 성공 시 버튼 업데이트
					updateButtons(true);
				},
				error : function() {
					console.error("팔로우 실패");
				}
			});
		}

		function unfollow(userEmail) {
			$.ajax({
				type : "POST",
				url : "/unfollow",
				data : {
					email : userEmail
				},
				success : function() {
					// 언팔로우 성공 시 버튼 업데이트
					updateButtons(false);
				},
				error : function() {
					console.error("언팔로우 실패");
				}
			});
		}

		function updateButtons(isFollowing) {
			if (isFollowing) {
				// 팔로우 상태일 때 버튼 업데이트
				$("#followBtn").hide();
				$("#unfollowBtn").show();
			} else {
				// 언팔로우 상태일 때 버튼 업데이트
				$("#followBtn").show();
				$("#unfollowBtn").hide();
			}
		}
	});
</script>
</html>

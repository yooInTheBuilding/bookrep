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
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/page.css">
</head>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"
	integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
	crossorigin="anonymous">
	</script>
<body>
	<c:choose>
		<c:when test="${not empty sessionScope.email}">
			<jsp:include page="loggedHeader.jsp"></jsp:include>
		</c:when>
		<c:otherwise>
			<jsp:include page="header.jsp"></jsp:include>
		</c:otherwise>
	</c:choose>
		<input type="hidden" value="${isFollowing}" id="isFollowing">
		<input type="hidden" value="${userEmail}" id="currentEmail">
		<div id="total-body">
			<!-- 
		 	세션 연결 후 확인해 볼것.
		 	유저정보들(팔로워 팔로잉, 북마크, 유저정보수정,
		   -->

			<div class="user-info">
				<div class="user-image-container">
					<img src="<%=request.getContextPath()%>/resources/images/${userImage}" alt="UserImage">
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
								<button id="followBtn"
									style="height: 50px;">
									<c:choose>
									<c:when test="${isFollowing}">Unfollow</c:when>
									<c:when test="${!isFollowing}">Follow</c:when>
									</c:choose>
									</button>
							</c:otherwise>
						</c:choose>
						<a href="/bookrep/bookmark/${userEmail}" target="_blank"> <img class="bookmark-image"
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
							<a href="/bookrep/follower/${userEmail}" style="margin-right: 10%" target="_blank">Follower</a><span id="follower">${followerCnt}</span>
						</div>
						<div class="bottom-line-margin">
							<a href="/bookrep/following/${userEmail}" style="margin-right: 10%" target="_blank">Following</a><span id="following">${followingCnt}</span>
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
</body>

<script type="text/javascript">
	function showModify() {
		window.location.href = "/bookrep/update";
	}
	var userEmail = document.getElementById("currentEmail").value;
	console.log(userEmail);
	var isFollowing = JSON.parse(document.getElementById("isFollowing").value);
	console.log(isFollowing);
	var button = document.getElementById("followBtn");
	console.log(button.innerText);
	var follower = document.getElementById("follower");
	var followerCount = parseInt(follower.innerText);
	console.log(typeof followerCount === 'number');

		$("#followBtn").on("click", function() {
		
			if(isFollowing){
				unfollow(userEmail);
				isFollowing = false;
				button.innerText = 'Follow';
				followerCount = followerCount - 1;
				follower.innerText = followerCount;
				
			}else{
				follow(userEmail);
				isFollowing = true;
				button.innerText = 'Unfollow';
				followerCount = followerCount + 1;
				follower.innerText = followerCount;
			}
		});

		function follow(userEmail) {
			$.ajax({
				type : 'post',
				url : '/bookrep/follow',
				data : {
					email : userEmail
				},
				success : function() {
					// 팔로우 성공 시 버튼 업데이트
				},
				error : function() {
					console.error("팔로우 실패");
				}
			});
		}

		function unfollow(userEmail) {
			$.ajax({
				type : 'post',
				url : '/bookrep/unfollow',
				data : {
					email : userEmail
				},
				success : function() {
					// 언팔로우 성공 시 버튼 업데이트
					
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
</script>
</html>

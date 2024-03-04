<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
String loginEmail = (String) session.getAttribute("loginEmail");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/page.css">
<link rel="stylesheet" href="resources/css/reportDetail.css">
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
		<div id="report-top">
			<div class="r_title">${report.title}</div>
			<div>
				<div class="r_user">${report.userEmail}</div>
				<div class="r_date">${report.time}</div>
			</div>
		</div>
		<br>
		<hr class="separator">
		<br>
		<div id="report-body">
			<div class="r_content">${report.content}</div>
			<!-- 수정 폼 시작 -->
			<div id="update-form-container" style="display: none;">
				<form action="apply-update" method="post">
					<input type="hidden" name="id" value="${report.id}">
					<div id="report-top">
						<div class="r_title">
							<input type="text" name="title" value="${report.title}">
						</div>
						<div>
							<div class="r_user">${report.userEmail}</div>
							<div class="r_date">${report.time}</div>
						</div>
					</div>
					<br>
					<hr class="separator">
					<br>
					<div id="report-body">
						<div class="r_content">
							<textarea name="content">${report.content}</textarea>
						</div>
					</div>
					<br>
					<hr class="separator">
					<br>
					<div id="report-bottom">
						<div id="report_bottom_left">
							<!-- 수정 완료 버튼 -->
							<button type="submit" class="update-btn">Update</button>
						</div>
					</div>
				</form>
			</div>
			<!-- 수정 폼 끝 -->
			<div class="comment">
				<!-- 댓글 입력 창 & 입력 버튼 -->
				<form action="comment" method="post">
					<input type="hidden" name="id" value="${report.id}">
					<textarea name="comment" placeholder="댓글을 입력하세요"></textarea>
					<button type="submit">등록</button>
				</form>
				<br>
				<hr>
				<br>
				<c:if test="${not empty commentList}">
					<!-- 현재 페이지 설정 -->
					<c:choose>
						<c:when test="${not empty param.pageNum}">
							<c:set var="currentPageNum" value="${param.pageNum}" />
						</c:when>
						<c:otherwise>
							<c:choose>
								<c:when test="${not empty commentList}">
									<c:set var="currentPageNum" value="${commentList[0].pageNum}" />
								</c:when>
							</c:choose>
						</c:otherwise>
					</c:choose>

					<!-- 현재 페이지 번호와 일치하는 댓글을 출력하는 부분 -->
					<c:if test="${not empty commentList}">
						<c:forEach var="page" items="${commentList}">
							<c:if test="${page.pageNum eq currentPageNum}">
								<div id="comment-container">
									<c:choose>
										<c:when test="${not empty page.objectList}">
											<c:forEach var="comment" items="${page.objectList}">
												<a href="feed/${comment.userEmail}" class="c_user">${comment.userEmail}</a>
												<p class="c_content">${comment.content}</p>
												<p class="c_time">${comment.time}</p>
												<br>
											</c:forEach>
										</c:when>
										<c:otherwise>
											<p class="no-comment">댓글이 없습니다.</p>
										</c:otherwise>
									</c:choose>
								</div>
							</c:if>
						</c:forEach>
					</c:if>
					<c:if test="${empty commentList}">
						<p class="no-comment">댓글이 없습니다.</p>
					</c:if>
				</c:if>
			</div>
		</div>
		<br>
		<hr class="separator">
		<br>
		<div id="report-bottom">
			<div id="report_bottom_left">
				<button class="delete-btn"
					onclick="confirmDelete(${report.id}, '${report.userEmail}')">Delete</button>
				<div class="r_like">
					<c:choose>
						<c:when
							test="${likeValue > 0 && likeValue != null && userEmail eq loginEmail}">
							<a href="javascript:void(0);" onclick="toggleLike(${report.id})">
								<img class="like-heart" alt="좋아요O"
								src="<%=request.getContextPath()%>/resources/images/heart_white.png">
							</a>
						</c:when>
						<c:otherwise>
							<a href="javascript:void(0);" onclick="toggleLike(${report.id})">
								<img class="like-heart" alt="좋아요X"
								src="<%=request.getContextPath()%>/resources/images/heart_blank.png">
							</a>
						</c:otherwise>
					</c:choose>
					<div>${likeValue}</div>
				</div>
				<button class="update-btn"
					onclick="location.href='report-update?id=${report.id}'">Update</button>
			</div>
			<div id="report_bottom_right">
				<div class="page">
					<c:if test="${not empty commentList}">
						<!-- 처음 버튼 -->
						<a href="?pageNum=1" class="page-link">|◀</a>

						<!-- 이전 버튼 -->
						<c:if test="${currentPageNum > 3}">
							<a href="?pageNum=${currentPageNum - 5}" class="page-link">이전</a>
						</c:if>

						<!-- 페이지 번호 5개씩 표시 -->
						<c:forEach var="i"
							begin="${currentPageNum - 2 > 0 ? currentPageNum - 2 : 1}"
							end="${currentPageNum + 2 < commentList.size() ? currentPageNum + 2 : commentList.size()}">
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
						<c:if test="${currentPageNum + 2 < commentList.size()}">
							<a href="?pageNum=${currentPageNum + 3}" class="page-link">다음</a>
						</c:if>

						<!-- 마지막 버튼 -->
						<a href="?pageNum=${commentList.size()}" class="page-link">▶|</a>
					</c:if>
				</div>
			</div>
		</div>
	</div>
</body>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<script type="text/javascript">
function confirmDelete(reportId, reportUserEmail) {
    if (confirm("게시글을 삭제하시겠습니까?")) {
        location.href = 'delete?id=' + reportId + '&reportUserEmail=' + reportUserEmail;
        var msg = "${msg}";
        if (msg) {
            alert(msg);
            return;
        }
    }
}

function toggleLike(reportId) {
    $.ajax({
        type: "POST",
        url: "like",
        data: { id: reportId },
        success: function(response) {
            if (response.like) {
                $(".like-heart").attr("src", "<%=request.getContextPath()%>/resources/images/heart_white.png");
            } else {
                $(".like-heart").attr("src", "<%=request.getContextPath()%>/resources/images/heart_blank.png");
            }
            $(".r_like div").text(response.likeValue);
        },
        error: function(error) {
            console.error("Error toggling like:", error);
        }
    });
}

function showUpdateForm() {
    document.getElementById('update-form-container').style.display = 'block';
    document.getElementById('report-detail-container').style.display = 'none';
}
</script>
</html>
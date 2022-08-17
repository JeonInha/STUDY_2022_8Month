<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="signUp.*"%>
<%@ page import="java.util.*"%>
<%@ page import="post.*"%>
<%@ page import="signUp.AccManagerDaoImpl"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/reset.css">
<link rel="stylesheet" href="./css/main.css">
<title>그린그린톡.com</title>
</head>
<%
	AccManagerDaoImpl adi = new AccManagerDaoImpl();
	postDaoImpl pd = new postDaoImpl();
	String userID = (String) session.getAttribute("loginid");
	Account user = adi.readAccountById(userID);
	List<Post> timeLine = pd.readPostbyFollower(user);

%>
<body>
	<div class="container">
		<header>
			<a href="/"><img src="./img/logo1.png" alt="그린그린톡 메인로고"></a>
		</header>
		<nav>
			<ul>
				<li><a href="./">톡톡하기</a></li>
				<li><a href="#!">탐색하기</a></li>
				<li><a href="#!">검색하기</a></li>
				<li><a href="#!">알림창</a></li>
				<li><a href="./mypage">마이페이지</a></li>
			</ul>
		</nav>
		<main>
			<div class="maintalk_wrap">

				<c:choose>
					<c:when test="${fn:length(timeline)==0}">
				        <p>표시할 톡이 없습니다. 활발한 톡활동을 해보세용!</p>
				    </c:when>
					<c:otherwise>
						<c:forEach var="post" items="${ timeline }">
							<div class="talktalk">
								<div class="talk_header">
									<div class="talk_id">
										<h2>닉네임닉네임</h2>
										<strong>@idid</strong>
									</div>
									<h3>${post.post_dateTime }</h3>
								</div>
								<div class="talk_liner">
									<i class="xi-user-o">누구에게 보내는지</i> <a href=""><i
										class="xi-comment-o">원톡보기</i></a> <i class="xi-speech-o">댓톡하기</i>
								</div>
								<p class="talk_post">
									${post.post_content } <a href="http://www.naver.com">이건
										주소주소</a>
								</p>
							</div>
						</c:forEach>
					</c:otherwise>
				</c:choose>



			</div>
		</main>
		<footer> </footer>
	</div>
</body>

</html>
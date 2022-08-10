<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 자바 태그 라이브러리를 사용하기 위해 설정해주는 부분. 저 라이브러리의 이름을 c라고 쓰겠다.-->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 반복문 -->
	<c:forEach var="i" begin="1" end="10">
		<!-- if문 (주의: else 가 없음!!) -->
		<c:if test="${i%2==0}">
			<p>${ i }</p>
		</c:if>
	</c:forEach>

	<!-- choose문은 스위치문과 비슷함: 자동으로 break 걸어줌 -->
	<c:choose>
		<c:when test="">
			<p>첫조건이 참일때</p>
		</c:when>
		<c:when test="두번째조건">
			<p>첫조건은 아니지만 둘째조건이 참일때</p>
		</c:when>
		<c:otherwise>
			<p>모든조건이 참이 아닐때</p>
		</c:otherwise>
	</c:choose>


</body>
</html>
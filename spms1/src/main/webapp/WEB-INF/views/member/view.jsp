<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<title>Java 41 SPMS</title>
<meta http-equiv="content-type" content="text/html;charset=utf-8" />
<meta name="author" content="fatma.hassan@gmail.com" />
<meta name="description" content="FTM" />


<link rel="stylesheet" href="${rootPath}/maincss/touching.css"
	type="text/css" />
<link href="${rootPath}/css/bootstrap.css" rel="stylesheet">
<link href="${rootPath}/css/bootstrap-theme.min.css" rel="stylesheet">
<link href="${rootPath}/css/carousel.css" rel="stylesheet">
</head>
<body>
	<!-- Generated at www.csscreator.com -->
	<div id="container">
		<jsp:include page="/header.do"></jsp:include>

		<div id="outer">
			<div id="inner">

				<jsp:include page="/sidebar.do"></jsp:include>

				<div id="content">
					<table class="table">
						<h1>멤버 정보</h1>
						이메일: ${memberInfo.email}
						<br> 이름: ${memberInfo.name }
						<br> 전화: ${memberInfo.tel }
						<br> 블로그: ${memberInfo.blog }
						<br> 상세주소: ${memberInfo.detailAddress }
						<br> 태그: ${memberInfo.tag }
						<br> 등록일: ${memberInfo.regDate }
						<br> 권한:
						<c:choose>
							<c:when test="${memberInfo.level == 0}">일반회원</c:when>
							<c:when test="${memberInfo.level == 1}">관리자</c:when>
							<c:when test="${memberInfo.level == 2}">PM</c:when>
							<c:otherwise>손님</c:otherwise>
						</c:choose>
						<br> 사진:
						<br>
						<c:choose>
							<c:when test="${memberInfo.photos!=null }">
								<img width="120" height="150" id="memberPhot"
									src="${rootPath }/file/${memberInfo.photos[0]}">
							</c:when>
							<c:otherwise>
								<img width="120" height="150" id="memberPhot"
									src="${rootPath}/images/test01.png">
							</c:otherwise>
						</c:choose>

						<p>
							<a href="list.do">[목록]</a>
							<!--  <a href="passwordChange.do?email=${memberInfo.email}">[암호변경]</a>-->
							<a href="update.do?email=${memberInfo.email}">[변경]</a> <a
								href="delete.do?email=${memberInfo.email}&level=${sessionScope.member.level}">[삭제]</a>
						</p>

					</table>
				</div>


				<!-- end content -->
			</div>
			<!-- end inner -->
		</div>
		<!-- end outer -->

	</div>
	<!-- end container -->




	<!-- /.carousel -->



</body>
</html>



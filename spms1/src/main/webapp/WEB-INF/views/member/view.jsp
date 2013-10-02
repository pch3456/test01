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
					<h1>멤버 정보</h1>
					<table cellpadding="20px">
						<tr>
							<th><c:choose>
									<c:when test="${memberInfo.photos!=null }">
										<img width="120" height="150" id="memberPhot"
											src="${rootPath }/file/${memberInfo.photos[0]}">
									</c:when>
									<c:otherwise>
										<img width="120" height="150" id="memberPhot"
											src="${rootPath}/images/test01.png">
									</c:otherwise>
								</c:choose></th>
							<th>
								<table class="table">
									<tr>
										<th>이메일</th>
										<td>${memberInfo.email}</td>
									</tr>
									<tr>
										<th>이름</th>
										<td>${memberInfo.name }</td>
									</tr>
									<tr>
										<th>전화</th>
										<td>${memberInfo.tel }</td>
									</tr>
									<tr>
										<th>블로그</th>
										<td>${memberInfo.blog }</td>
									</tr>
									<tr>
										<th>상세주소</th>
										<td>${memberInfo.detailAddress }</td>
									</tr>
									<tr>
										<th>태그</th>
										<td>${memberInfo.tag }</td>
									</tr>
									<tr>
										<th>등록일</th>
										<td>${memberInfo.regDate }</td>
									</tr>
									<tr>
										<th>권한</th>
										<td><c:choose>
												<c:when test="${memberInfo.level == 0}">일반회원</c:when>
												<c:when test="${memberInfo.level == 1}">관리자</c:when>
												<c:when test="${memberInfo.level == 2}">PM</c:when>
												<c:otherwise>손님</c:otherwise>
											</c:choose></td>
									</tr>
								</table>
					</table>

					<p>
						<a href="list.do">[목록]</a>
						<!--  <a href="passwordChange.do?email=${memberInfo.email}">[암호변경]</a>-->
						<a href="update.do?email=${memberInfo.email}">[변경]</a> <a
							href="delete.do?email=${memberInfo.email}&level=${sessionScope.member.level}">[삭제]</a>
					</p>


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



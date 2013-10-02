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
</head>
<body>
	<!-- Generated at www.csscreator.com -->
	<div id="container">
		<jsp:include page="/header.do"></jsp:include>

		<div id="outer">
			<div id="inner">

				<jsp:include page="/sidebar.do"></jsp:include>
				<div id="content">
					<div class="container">
						<h1>${projectInfo.title }'s Feeds</h1><br>


						<form action="add.do" method="post">
							<input type="hidden" name="pno" value="${projectInfo.no }">
							<textarea class="well" name="content" rows="3" cols="180"></textarea>
							<br>
							<div style="float: right">
								<input class="btn btn-primary" type="submit" value="등록"
									height="20">
							</div>

						</form>

						<br>
						<HR color="black" />
						<br>


						<c:forEach var="feed" items="${list}">
							<div class="panel panel-success">
								<div class="panel-heading">
									<h3 class="panel-title">${feed.email}</h3>
									${feed.regDate} 
									<c:if test="${loginInfo.email == feed.email}"><a href="delete.do?fno=${feed.fno}&pno=${projectInfo.no }">[삭제]</a></c:if>
								</div>
								<div class="panel-body">${feed.content}</div>
							</div>
						</c:forEach>
					</div>

				</div>
				<!-- end content -->
			</div>
			<!-- end inner -->
		</div>
		<!-- end outer -->

	</div>
	<!-- end container -->
</body>
</html>
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
					<h1>
						<a href="${rootPath}/project/list.do">프로젝트</a> > <a
							href="${rootPath}/project/view.do?no=${projectInfo.no}">${projectInfo.title }</a>
						> 피드
					</h1>
					<br>
					<div class="container">

						<div class="navbar navbar-default" style="max-height: 80px;">
							<div class="container">
								<div class="navbar-header" style="margin-left: -130px;">
									<button type="button" class="navbar-toggle"
										data-toggle="collapse" data-target=".navbar-collapse">
										<span class="icon-bar"></span> <span class="icon-bar"></span>
										<span class="icon-bar"></span>
									</button>
									<a class="navbar-brand" href="#"
										style="font-size: 20px; font-style: oblique; color: maroon;">Menu</a>

									<ul class="nav navbar-nav">
										<li><a
											href="${rootPath}/project/view.do?no=${projectInfo.no}">기본정보</a></li>

									</ul>
									<ul class="nav navbar-nav">
										<li><a
											href="${rootPath}/task/list.do?projectNo=${projectInfo.no}">작업목록</a></li>

									</ul>
									<ul class="nav navbar-nav">
										<li><a
											href="${rootPath}/feed/list.do?projectNo=${projectInfo.no}">피드</a></li>

									</ul>
									<!--/.nav-collapse -->
								</div>
							</div>
						</div>



						<form action="add.do" method="post">
							<input type="hidden" name="pno" value="${projectInfo.no }">
							<textarea class="well" name="content" rows="3" cols="135"
								placeholder="프로젝트에 대한 생각을 자유롭게 적어주세요."></textarea>
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
										<table cellpadding="10">
									<tr> 
									<th ><c:choose>
											<c:when test="${feed.memPhoto !=null }">
												<img src="${rootPath }/file/${feed.memPhoto}" width= "50px" height="70px" alt="picture" style="-webkit-box-shadow: 3px 3px 3px #7C7C7C;
    box-shadow: 3px 3px 3px #7C7C7C;">
											</c:when>
											<c:otherwise>
												<img src="${rootPath}/images/test01.png" width= "50px" height="70px" alt="picture" style="-webkit-box-shadow: 3px 3px 3px #7C7C7C;
    box-shadow: 3px 3px 3px #7C7C7C;">
											</c:otherwise>
										</c:choose></th>
										
										
									<td>

											<h3 class="panel-title">${feed.email} </h3><h6 align="left">${feed.regDate}
											
											<c:if test="${loginInfo.logEmail == feed.email}">
												<a href="delete.do?fno=${feed.fno}&pno=${projectInfo.no }">[삭제]</a>
											</c:if></h6>
											</td>
										</tr>
										</table>
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
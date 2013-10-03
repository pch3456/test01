
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
						> 작업목록
					</h1>
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
 						<!-- </div>
 						<div class="container"> -->
 
						<table class="table">
							<tr>
								<th>Task</th>
								<th>시작일자</th>
								<th>종료일자</th>
							</tr>
							<c:forEach var="task" items="${list}">
								<tr>
									<td><a href="view.do?no=${task.tno}&pno=${projectInfo.no}">${task.title}</a></td>
									<td>${task.startDate}</td>
									<td>${task.endDate}</td>
								</tr>
							</c:forEach>
						</table>
								<p align="right">
									<a href="${rootPath}/task/add.do?projectNo=${projectInfo.no}" class="btn btn-success">새 작업</a>
								</p>


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

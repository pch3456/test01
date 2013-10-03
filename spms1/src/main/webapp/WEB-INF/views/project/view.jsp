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
					
					<h1><a href="${rootPath}/project/list.do">프로젝트</a> > ${project.title}  </h1>
					
					<div class="container">
					
					<div class="navbar navbar-default" style="max-height: 80px">
							<div class="container">
								<div class="navbar-header" style="margin-left: -130px;">
									<button type="button" class="navbar-toggle"
										data-toggle="collapse" data-target=".navbar-collapse">
										<span class="icon-bar"></span> <span class="icon-bar"></span>
										<span class="icon-bar"></span>
									</button>
									<a class="navbar-brand" href="#" style="font-size: 20px;font-style: oblique;color: maroon;">Menu</a>
								
									<ul class="nav navbar-nav">
										<li><a href="view.do?no=${project.no}">기본정보</a></li>

									</ul>
									<ul class="nav navbar-nav">
										<li><a href="../task/list.do?projectNo=${project.no}">작업목록</a></li>

									</ul>
									<ul class="nav navbar-nav">
										<li><a href="../feed/list.do?projectNo=${project.no}">피드</a></li>

									</ul>
								<!--/.nav-collapse -->
							</div>
						</div>
					</div>
					
					<table class="table">
						<tr>
							<td>번호</td>
							<td>${project.no}</td>
						</tr>
						<tr>
							<td>프로젝트명</td>
							<td>${project.title}</td>
						</tr>
						<tr>
							<td>내용</td>
							<td>${project.content}</td>
						</tr>
						<tr>
							<td>시작일</td>
							<td>${project.startDate}</td>
						</tr>
						<tr>
							<td>종료일</td>
							<td>${project.endDate }</td>
						</tr>
						<tr>
							<td>태그</td>
							<td>${memberInfo.tag }</td>
						</tr>
						<tr>
							<td>태그</td>
							<td>${project.tag }</td>
						</tr>
					</table>
					
					
					<p align="right">
					<a href="list.do" class="btn btn-success">목록</a> 
					<a href="update.do?no=${project.no}" class="btn btn-primary">변경</a> 
<a href="delete.do?no=${project.no}&level=${sessionScope.member.level}" class="btn btn-danger">삭제</a>
</p>

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








<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html >
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<title>Java 41 SPMS</title>
<meta http-equiv="content-type" content="text/html;charset=utf-8" />
<meta name="author" content="fatma.hassan@gmail.com" />
<meta name="description" content="FTM" />


<link rel="stylesheet" href="${rootPath}/maincss/touching.css" type="text/css" />
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
<h1>프로젝트</h1>
<table class="table">
<tr>
	<th>번호</th>
	<th>프로젝트</th>
	<th>시작</th>
	<th>종료</th>
</tr>
<c:forEach var="project" items="${list}">
<tr>
	<td>${project.no}</td>
	<td><a href="view.do?no=${project.no}">${project.title}</a></td>
	<td>${project.startDate}</td>
	<td>${project.endDate}</td>
</tr>	
</c:forEach>
</table>


<c:choose>
	<c:when test="${loginInfo.level == 0}">
		<p><a href="${rootPath}/project/add.do">[신규 프로젝트]</a></p>
${project.pno }
	</c:when>
	<c:otherwise>
	</c:otherwise>
</c:choose>




	</div><!-- end content -->
		</div><!-- end inner -->
	</div><!-- end outer -->
 	
</div><!-- end container -->
</body></html>


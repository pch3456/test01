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
<div id="submenu">
<p>
<a href="view.do?no=${project.no}">[기본정보]</a> | 
<a href="../task/list.do?projectNo=${project.no}">[작업들]</a> | 
<a href="../feed/list.do?projectNo=${project.no}">[피드]</a>
</p>
</div>

<h1>프로젝트 정보</h1>
번호: ${project.no}<br>
프로젝트명: ${project.title }<br>
내용:<br> 
${project.content }<br>
시작일: ${project.startDate }<br>
종료일: ${project.endDate }<br>
태그: ${project.tag }<br>

<p>

<c:choose>
	<c:when test="${member.level == 0}">
		<a href="list.do">[목록]</a>
		<a href="update.do?no=${project.no}">[변경]</a>
		<a href="delete.do?no=${project.no}&level=${sessionScope.member.level}">[삭제]</a>

	</c:when>
	<c:otherwise>
	<a href="list.do">[목록]</a>
	</c:otherwise>
</c:choose>
</p>

	</div><!-- end content -->
		</div><!-- end inner -->
	</div><!-- end outer -->
 	
</div><!-- end container -->
</body></html>








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
</head>
<body>
 <!-- Generated at www.csscreator.com -->
<div id="container">
	<jsp:include page="/header.do"></jsp:include>
	
	<div id="outer">
 		<div id="inner">
 	
 		<jsp:include page="/sidebar.do"></jsp:include>
<div id="content">
<h1>${projectInfo.title }'s Task</h1>
<table>
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


<c:choose>
	<c:when test="${member.level == 0}">
		<p><a href="${rootPath}/task/add.do?projectNo=${projectInfo.no}">[New Task]</a></p>

	</c:when>
	<c:otherwise>
	</c:otherwise>
</c:choose>


	</div><!-- end content -->
		</div><!-- end inner -->
	</div><!-- end outer -->
 	<div id="footer"><h1>&nbsp;&nbsp;&nbsp;&nbsp;<a href="https://www.google.co.kr/" >구글형아</a></a>
 	</h1>
 	</div>
</div><!-- end container -->
</body></html>

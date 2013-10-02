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
<h1>${projectInfo.title }'s Feeds</h1>
<form action="add.do" method="post">
<input type = "hidden" name="pno"  value="${projectInfo.no }">
<textarea name="content" rows="5" cols="50" ></textarea>
<input type="submit" value="등록">
</form>
<table>
<tr>
	<th>피드번호</th>
	<th>작성자</th>
	<th>내용</th>
	<th>작성일</th>
	<th></th>
</tr>
<c:forEach var="feed" items="${list}">
	<tr>
		<td>${feed.fno}</td>
		<td>${feed.email } </td>
		<td>${feed.content}</td>
		<td>${feed.regDate}</td>
		<td><a href="delete.do?fno=${feed.fno}&pno=${projectInfo.no }">[삭제]</a></td>
	</tr>	
</c:forEach>
</table>





	</div><!-- end content -->
		</div><!-- end inner -->
	</div><!-- end outer -->
 	<div id="footer"><h1>&nbsp;&nbsp;&nbsp;&nbsp;<a href="https://www.google.co.kr/" >구글형아</a></a>
 	</h1>
 	</div>
</div><!-- end container -->
</body></html>
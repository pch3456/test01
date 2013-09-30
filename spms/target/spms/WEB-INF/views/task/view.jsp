
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
<div id="submenu">
</div>

<h1>테스크 정보</h1>
번호: ${task.tno}<br>
테스크명: ${task.title }<br>
내용:<br> 
${task.context }<br>
시작일: ${task.startDate }<br>
종료일: ${task.endDate }<br>
UI 프로토타입 : <br>
<c:choose>
	<c:when test="${task.UIProtoURL!=null }">
		<img id="UIProto" src="${rootPath }/file/${task.UIProtoURL}">
	</c:when>
</c:choose>


<p>

<c:choose>
	<c:when test="${member.level == 0}">
		<a href="list.do?projectNo=${task.pno }">[목록]</a>
		<a href="update.do?no=${task.tno}">[변경]</a>
		<a href="delete.do?no=${task.tno}&pno=${projectInfo.no}">[삭제]</a>
	</c:when>
	<c:otherwise>
	<a href="list.do?projectNo=${task.pno }">[목록]</a>
	</c:otherwise>
</c:choose>
</p>
<p>

</p>

	</div><!-- end content -->
		</div><!-- end inner -->
	</div><!-- end outer -->
 	<div id="footer"><h1>&nbsp;&nbsp;&nbsp;&nbsp;<a href="https://www.google.co.kr/" >구글형아</a></a>
 	</h1>
 	</div>
</div><!-- end container -->
</body></html>



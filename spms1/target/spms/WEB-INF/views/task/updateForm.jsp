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
<h1>테스크 정보변경</h1>
<form action="update.do" method="post" enctype="multipart/form-data">
*프로젝트 번호: <input type="text" name="pno" value="${taskInfo.pno}" readonly><br>
*테스크 번호: <input type="text" name="tno" value="${taskInfo.tno}" readonly><br>
*테스크명: <input type="text" name="title" value="${taskInfo.title}"><br>
*내용: <input type = "text" name="context"  value="${taskInfo.context }"><br>
시작일: <input type="text" name="startDate" value="${taskInfo.startDate}"><br>
종료일: <input type="text" name="endDate"value="${taskInfo.endDate}"><br>
UI Proto: <input type="file" name="URL"  value="${taskInfo.UIProtoURL}"><br>

<input type="submit" value="변경">
<input type="reset" value="취소">
</form>
<p>
<a href="view.do?no=${taskInfo.tno }&pno=${taskInfo.pno}">[이전]</a>
</p>

	</div><!-- end content -->
		</div><!-- end inner -->
	</div><!-- end outer -->
 	<div id="footer"><h1>&nbsp;&nbsp;&nbsp;&nbsp;<a href="https://www.google.co.kr/" >구글형아</a></a>
 	</h1>
 	</div>
</div><!-- end container -->
</body></html>



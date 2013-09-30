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
<h1>신규 테스크</h1>
<form action="add.do?projectNo=${projectInfo.no}" method="post" enctype="multipart/form-data">
프로젝트번호 : <input type="text" name = pno  value=${projectInfo.no } readonly="readonly">
프로젝트명: <input type="text"  value=${projectInfo.title } readonly="readonly"><br>
테스크명: <input type="text" name="title"><br>
내용:<br> 
<textarea name="context" rows="4" cols="50"></textarea><br>
UI 프로토타입: <input type="file" name="URL"><br>
시작일: <input type="text" name="startDate" placeholder="예)2013-4-5"><br>
종료일: <input type="text" name="endDate" placeholder="예)2013-6-5"><br>
<input type="submit" value="등록"><input type="reset" value="취소"><br>
</form>
<p><a href="list.do">[목록]</a></p>



	</div><!-- end content -->
		</div><!-- end inner -->
	</div><!-- end outer -->
 	<div id="footer"><h1>&nbsp;&nbsp;&nbsp;&nbsp;<a href="https://www.google.co.kr/" >구글형아</a></a>
 	</h1>
 	</div>
</div><!-- end container -->
</body></html>





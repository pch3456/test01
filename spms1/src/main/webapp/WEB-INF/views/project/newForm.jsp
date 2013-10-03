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
<h1><a href="${rootPath}/project/list.do">프로젝트</a> > 신규 프로젝트</h1>
<div class="container">
<form action="add.do" method="post">
<table class="table">
<tr>
<th>프로젝트명</th>
<td><input type="text" name="title"></td>
</tr>
<tr>
<th>내용</th>
<td><textarea name="content" rows="4" cols="22"></textarea></td>
</tr>
<tr>
<th>시작일</th>
<td><input type="text" name="startDate" placeholder="예)2013-4-5"></td>
</tr>
<tr>
<th>종료일</th>
<td><input type="text" name="endDate" placeholder="예)2013-6-5"></td>
</tr>
<tr>
<th>태그</th>
<td><input type="text" name="tag" placeholder="예)태그1 태그2 태그3 (공백으로 구분)"></td>
</tr>
</table>
<p align="right">
<input type="submit" value="등록" class="btn btn-success"> <input type="reset" value="취소" class="btn btn-warning"> <a href="list.do" class="btn btn-primary">목록</a>
</p>
</form>
</div>




	</div><!-- end content -->
		</div><!-- end inner -->
	</div><!-- end outer -->
 	
</div><!-- end container -->
</body></html>





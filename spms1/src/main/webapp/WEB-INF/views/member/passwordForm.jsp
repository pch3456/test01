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
<h1><a href="list.do">멤버관리</a> > <a href="view.do?email=${param.email}"> ${param.name}</a> > <a href="update.do?email=${param.email}"> 멤버 변경</a> > 암호변경</h1>
<div class="container">
<form action="passwordChange.do" method="post">
<table class="table">
<tr>
<th>이메일</th>
<td><input type="text" name="email" value="${param.email}" readonly></td>
</tr>
<tr>
<th>이전 암호</th>
<td><input type="password" name="password"></td>
</tr>
<tr>
<th>새 암호</th>
<td><input type="password" name="newPassword"></td>
</tr>
<tr>
<th>새 암호 확인</th>
<td><input type="password" name="newPassword2"></td>
</table>
<p align="right"><input type="submit" value="변경" class="btn btn-success">
<a href="view.do?email=${param.email}" class="btn btn-warning">이전</a>
<a href="list.do" class="btn btn-primary">목록</a>
</p>

</form>
<p>

</p>
</div>


	</div><!-- end content -->
		</div><!-- end inner -->
	</div><!-- end outer -->
 	
</div><!-- end container -->
</body></html>





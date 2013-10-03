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
<h1>멤버 등록</h1>

<div class="container">
<form action="add.do" method="post" enctype="multipart/form-data">
<table class = "table">
<tr>
<th>이메일</th>
<td><input type="text" name="email"></td>
</tr>
<tr>
<th>암호</th>
<td><input type="password" name="password"></td>
</tr>
<tr>
<th>암호 확인</th>
<td><input type="password" name="password2"></td>
</tr>
<tr>
<th>이름</th>
<td><input type="text" name="name"></td>
</tr>
<tr>
<th>전화</th>
<td><input type="text" name="tel"></td>
</tr>
<tr>
<th>사진</th>
<td><input type="file" name="photo" style="margin-left: 300px"></td>
</tr>
<tr>
<th>블로그</th>
<td><input type="text" name="blog"></td>
</tr>
<tr>
<th>우편번호</th>
<td><input type="text" name="postno"></td>
</tr>
<tr>
<th>기본주소</th>
<td><input type="text" name="basicAddr"></td>
</tr>
<tr>
<th>상세주소</th>
<td><input type="text" name="detailAddr" style="margin-left: 95px"><input type="button" value="우편번호찾기" class="btn btn-sm btn-success" style="margin-left: 10px"></td>

</tr>
<tr>
<th>태그</th>
<td><input type="text" name="tag"></td>
</tr>
<tr>
<th>권한</th>
<td><select name="level">
<option value="0" selected>일반회원</option>
<option value="1">관리자</option>
<option value="2">PM</option>
<option value="9">손님</option>
</select></td>
</tr>
</table>
<p align="right"><input type="submit" value="등록" class="btn btn-success"> 
<input type="reset" value="취소" class="btn btn-warning"> 
<a href="list.do" class="btn btn-primary">목록</a></p>
</form>


</div>
	</div><!-- end content -->
		</div><!-- end inner -->
	</div><!-- end outer -->
 	
</div><!-- end container -->
</body></html>





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
<h1><a href="${rootPath}/project/list.do">프로젝트</a> > <a href="${rootPath}/project/view.do?no=${projectInfo.no}">${projectInfo.title }</a> > <a href="${rootPath}/task/view.do?no=${taskInfo.tno}&pno=${taskInfo.pno}">${taskInfo.title}</a> > 변경</h1>

<div class="container">

<form action="update.do" method="post" enctype="multipart/form-data">
<table class="table">
<tr>
<th>프로젝트 번호</th>
<td><input type="text" name="pno" value="${taskInfo.pno}" readonly></td>
</tr>
<tr>
<th>테스크 번호</th>
<td><input type="text" name="tno" value="${taskInfo.tno}" readonly></td>
</tr>
<tr>
<th>테스크명</th>
<td><input type="text" name="title" value="${taskInfo.title}"></td>
</tr>
<tr>
<th>내용</th>
<td><input type = "text" name="context"  value="${taskInfo.context }"></td>
</tr>
<tr>
<th>시작일</th>
<td><input type="text" name="startDate" value="${taskInfo.startDate}"></td>
</tr>
<tr>
<th>종료일</th>
<td><input type="text" name="endDate"value="${taskInfo.endDate}"></td>
</tr>
<tr>
<th>UI Proto</th>
<td><input type="file" name="URL"  value="${taskInfo.UIProtoURL}" style="margin-left: 290px"></td>
</tr>
</table>
<p align="right">
<input type="submit" value="변경" class="btn btn-success">
<input type="reset" value="취소" class="btn btn-primary">
<a href="view.do?no=${taskInfo.tno }&pno=${taskInfo.pno}" class="btn btn-warning">이전</a>
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



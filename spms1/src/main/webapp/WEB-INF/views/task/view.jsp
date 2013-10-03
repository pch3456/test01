
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
</div>

<h1><a href="${rootPath}/project/list.do">프로젝트</a> > <a href="${rootPath}/project/view.do?no=${projectInfo.no}">${projectInfo.title }</a> > ${task.title}</h1>
<div class="container">

<table class="table">
<tr>
<th>번호</th>
<td>${task.tno}</td>
</tr>
<tr>
<th>테스크명</th>
<td>${task.title }</td>
</tr>
<tr>
<th>내용</th>
<td>${task.context }</td>
</tr>
<tr>
<th>시작일</th>
<td>${task.startDate }</td>
</tr>
<tr>
<th>종료일</th>
<td>${task.endDate }</td>
</tr>
<tr>
<th>UI 프로토타입</th>
<td><c:choose>
	<c:when test="${task.UIProtoURL!=null }">
		<img id="UIProto" src="${rootPath }/file/${task.UIProtoURL}">
	</c:when>
</c:choose></td>
</tr>

</table>

<p align="right">


		<a href="list.do?projectNo=${task.pno }">[목록]</a>
		<a href="update.do?no=${task.tno}">[변경]</a>
		<a href="delete.do?no=${task.tno}&pno=${projectInfo.no}">[삭제]</a>
</p>

</div>


	</div><!-- end content -->
		</div><!-- end inner -->
	</div><!-- end outer -->
 	
</div><!-- end container -->
</body></html>



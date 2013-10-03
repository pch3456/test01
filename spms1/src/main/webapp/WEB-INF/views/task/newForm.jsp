<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html >
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<title>Java 41 SPMS</title>
<meta http-equiv="content-type" content="text/html;charset=utf-8" />
<meta name="author" content="fatma.hassan@gmail.com" />
<meta name="description" content="FTM" />


<link rel="stylesheet" href="${rootPath}/maincss/touching.css"
	type="text/css" />
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
					<h1>
						<a href="${rootPath}/project/list.do">프로젝트</a> > <a
							href="${rootPath}/project/view.do?no=${projectInfo.no}">${projectInfo.title }</a>
						> 신규 작업
					</h1>
					<div class="container">
					

					<form action="add.do?projectNo=${projectInfo.no}" method="post"
						enctype="multipart/form-data">
						<table class="table">
						<tr>
						<th>프로젝트번호</th>
						<td><input type="text" name=pno value=${projectInfo.no }
							readonly="readonly"></td>
						</tr>
						<tr>
						<th>프로젝트명</th>
						<td><input type="text"	value=${projectInfo.title } readonly="readonly"></td>
						</tr>
						<tr>
						<th>테스크명</th>
						<td><input type="text" name="title"></td>
						</tr>
						<tr>
						<th>내용</th>
						<td><textarea name="context" rows="4" cols="23"></textarea></td>
						</tr>
						<tr>
						<th>UI 프로토타입</th>
						<td><input type="file" name="URL" style="margin-left: 290px"></td>
						</tr>
						<tr>
						<th>시작일</th>
						<td><input type="text" name="startDate" placeholder="예)2013-4-5"></td>
						</tr>
						<tr>
						<th>종료일</th>
						<td><input type="text" name="endDate" placeholder="예)2013-6-5"></td>
						</tr>
						</table>
						<p align="right">
						<input type="submit" value="등록"> <input type="reset" value="취소"> <a href="list.do">목록</a>
					</p>
							
					</form>
					


				</div>
				</div>
				<!-- end content -->
			</div>
			<!-- end inner -->
		</div>
		<!-- end outer -->

	</div>
	<!-- end container -->
</body>
</html>





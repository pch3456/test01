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
	
		<jsp:include page="/header.do"></jsp:include>

		<div id="outer">
			<div id="inner">

				<jsp:include page="/sidebar.do"></jsp:include>
				<div id="content">
					<h1><c:if test="${loginInfo.level == 1 }"><a href="list.do">멤버관리</a> > </c:if><a href="view.do?email=${memberInfo.email}"> ${memberInfo.name}</a> > 멤버 변경</h1>

					<div class="container">
						<form action="update.do" method="post" enctype="multipart/form-data">
							<table class="table">
								<tr>
									<td>
									<table style="text-align: center;vertical-align: middle;width: 100" >
									<tr><td>
									<c:choose>
											<c:when test="${memberInfo.photos!=null }">
												<img width="120" height="150" id="memberPhot"
													src="${rootPath }/file/${memberInfo.photos[0]}">
											</c:when>
											<c:otherwise>
												<img id="memberPhot" width="120" height="150"
													src="${rootPath}/images/test01.png">
											</c:otherwise>
										</c:choose></td></tr><tr>
										<td><input type="file" name="photo" style="margin-left: 100px"></td>
										</tr>
									</table>	
									</td>
										
									<td>
										<table class="table">
											<tr>
												<th>이메일</th>
												<td><input type="text" name="email"
													value="${memberInfo.email}" readonly></td>
													<td></td>
											</tr>
											<tr>
												<th>암호</th>
												<td><input type="password" name="password1"><input
													type="hidden" name="serverpwd"
													value="${memberInfo.password}"></td>
													<td><a href="passwordChange.do?email=${memberInfo.email}&name=${memberInfo.name}" class="btn btn-xs btn-success">암호변경</a></td>
													<td></td>
											</tr>
											<tr>
												<th>이름</th>
												<td><input type="text" name="name"
													value="${memberInfo.name}"></td>
													<td></td>
											</tr>
											<tr>
												<th>전화</th>
												<td><input type="text" name="tel"
													value="${memberInfo.tel}"></td>
													<td></td>
											</tr>
											<tr>
												<th>블로그</th>
												<td><input type="text" name="blog"
													value="${memberInfo.blog}"></td>
													<td></td>
											</tr>
											<tr>
												<th>우편번호</th>
												<td><input type="text" name="addressNo"
													value="${memberInfo.addressNo}"></td>
													<td></td>
											</tr>
											<tr>
												<th>상세주소</th>
												<td><input type="text" name="detailAddr"
													value="${memberInfo.detailAddress}"></td>
													<td></td>
											</tr>
											<tr>
												<th>태그</th>
												<td><input type="text" name="tag"
													value="${memberInfo.tag}"></td>
													<td></td>
											</tr>
											<tr>
												<th>권한</th>
												<td><select name="level">
														<option value="0"
															<c:if	test="${memberInfo.level == 0}">selected</c:if>>일반회원</option>
														<option value="1"
															<c:if	test="${memberInfo.level == 1}">selected</c:if>>관리자</option>
														<option value="2"
															<c:if	test="${memberInfo.level == 2}">selected</c:if>>PM</option>
														<option value="9"
															<c:if	test="${memberInfo.level == 9}">selected</c:if>>손님</option>
												</select></td>
												<td></td>
											</tr>
											
										</table>
										
								<tr>
									<th></th>
									<th></th>
									
								</tr>
							</table>

\
							<p align="right"><input type="submit" value="변경" class="btn btn-success"> <input type="reset"
								value="취소" class="btn btn-warning"> <a href="list.do" class="btn btn-primary">목록</a></p>
						</form>
						<p>
							
						</p>



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






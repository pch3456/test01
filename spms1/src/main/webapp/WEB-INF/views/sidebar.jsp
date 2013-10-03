<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="container">
	<div id="sidebar">
		<div id="member">
			<c:choose>
				<c:when test="${loginInfo.photoPath !=null }">
					<img id="memberPhoto"
						src="${rootPath }/file/${loginInfo.photoPath}" style="-webkit-box-shadow: 3px 3px 3px #7C7C7C;
    box-shadow: 3px 3px 3px #7C7C7C;">
				</c:when>
				<c:otherwise>
					<img id="memberPhoto" src="${rootPath}/images/test01.png" style="-webkit-box-shadow: 3px 3px 3px #7C7C7C;
    box-shadow: 3px 3px 3px #7C7C7C;">
				</c:otherwise>
			</c:choose>
		</div>
		<div id="memberInfo">
			
			<div class="list-group">
			
					<a href="${rootPath}/member/update.do?email=${loginInfo.logEmail}"
					class="list-group-item"
					style="font-size: medium;; width: 145px"> 
					<h2 class="list-group-item-heading">${loginInfo.name}</h2>
              <p class="list-group-item-text">${loginInfo.tel} <br> <h5>${loginInfo.logEmail}</h5></p></a>
					<!-- 
					</a> <a
					href="#" class="list-group-item" style="font-size: medium;"></a> <a href="#"
					class="list-group-item" style="font-size: medium;width: 145px"></a>
 -->				<!-- </div>




			<div class="verticalmenu"> -->

				<c:choose>
					<c:when test="${loginInfo.level == 0}">

						<a href="${rootPath}/project/list.do" class="list-group-item active" style="font-size: medium;">프로젝트
							전체</a>
						<c:forEach var="project" items="${myProjects}">
							<a href="${rootPath}/project/view.do?no=${project.no}" class="list-group-item" style="font-size: medium;">${project.title}<c:if
										test="${project.level == 0}">(PL)</c:if></a>
						</c:forEach>
						
					</c:when>
					<c:when test="${loginInfo.level == 1}">
						<a href="#"	class="list-group-item active" style="font-size: medium;">관리자모드</a>
						<a href="${rootPath}/member/list.do" class="list-group-item" style="font-size: medium;">멤버관리</a>
						<a href="${rootPath}/project/list.do" class="list-group-item" style="font-size: medium;">프로젝트관리</a>
					</c:when>
				</c:choose>
			</div>
		</div>
	</div>
</div>





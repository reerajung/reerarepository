<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- Spring MVC Pattern 에서 JSP 페이지 작성시 뷰 역할만 하기 때문에 액션 관련 코드는 모두 제거한다 --%>
<%-- 현재 페이지(*.jsp)를 직접 실행하지 않는다 --%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>직원 관리 v4.0</title>

<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<style>
div.panel {
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0
		rgba(0, 0, 0, 0.19);
}
</style>

</head>
<body>
	<div class="container">
		<div style="margin-bottom: 1%;">
			<div>
				<h1 style="font-size: x-large;">
					<img
						src="${pageContext.request.contextPath}/resources/img/sist_logo.png"
						alt="logo" style="vertical-align: bottom;"> 직원관리<small>v4.0
						(Spring MVC + MyBatis)</small>
				</h1>
			</div>
			<div>
				<ul class="nav nav-pills nav-justified ">
					<li class="active"><a
						href="${pageContext.request.contextPath}/employee/list">직원관리</a></li>
					<li><a href="${pageContext.request.contextPath}/region/list">지역관리</a></li>
					<li><a
						href="${pageContext.request.contextPath}/department/list">부서관리</a></li>
					<li><a href="${pageContext.request.contextPath}/position/list">직위관리</a></li>
					<li><a href="${pageContext.request.contextPath}/logout"
						style="color: red">홍길동 로그아웃</a></li>
				</ul>
			</div>

		</div>
		<div class="panel-group">
			<div class="panel panel-default">
				<div class="panel-heading">직원 출력</div>
				<div class="panel-body">
					<form class="form-inline" role="form" method="post">
						<select class="form-control" id="searchKey" name="searchKey">
							<option value="0">번호</option>
							<option value="1">이름</option>
							<option value="2">지역</option>
							<option value="3">부서</option>
							<option value="4">직위</option>
						</select> <label for="name"></label> <input type="text"
							class="form-control" id="searchValue" name="searchValue"
							required="required">
						<button type="submit" class="btn btn-default">
							<span class="glyphicon glyphicon-search"></span> Search
						</button>
					</form>


					<table class="table">
						<thead>
							<tr>
								<th>직원<br>번호
								</th>
								<th>이름<br>사진
								</th>
								<th>주민<br>번호
								</th>
								<th>생년<br>월일
								</th>
								<th>양음력</th>
								<th>전화번호</th>
								<th>입사일</th>
								<th>지역명</th>
								<th>부서명</th>
								<th>직위명</th>
								<th>아이디/등급</th>
								<th>사진<br>등록
								</th>
								<th>삭제<br>수정
								</th>
							</tr>
						</thead>
						<tbody>

							<c:forEach var="e" items="${list}">
					 
							<tr>
								<td>${e.emp_id }</td>
								<td>${e.name_ }<br>
									<button type="button" class="btn btn-default btn-xs"
										data-toggle="modal" data-target="#myModal">사진</button>
								</td>
 								<td>${fn:replace(e.ssn,"-","-<br>")}</td>
								<td>${e.birthdate }</td>
								<td>${(e.lunar==0)?"양력":"음력" }</td>
								<td>${e.phone }</td>
								<td>${e.hiredate }</td>
								<td>${e.reg_name }</td>
								<td>${e.dept_name }</td>
								<td>${e.job_title }</td>
								<td>${e.id_ }<br><button type="button" class="btn btn-default btn-xs">로그인 히스토리</button></td>
								<td>관리자</td>
								<td><button type="button" class="btn btn-default btn-xs">사진등록</button><br><button type="button" class="btn btn-default btn-xs">삭제</button></td> <td><button type="button" class="btn btn-default btn-xs  btnUpdateForm" >수정</button></td>
							</tr>
				 
							</c:forEach>
							 

						</tbody>
					</table>

					<form class="form-inline" role="form" method="post">
						<a href="${pageContext.request.contextPath}/employee/insertform"
							class="btn btn-default">Add</a>
						<button type="button" class="btn btn-default">
							Count <span class="badge">${count }</span>
						</button>
					</form>

				</div>
			</div>
		</div>

		<div id="myModal" class="modal fade" role="dialog">
			<div class="modal-dialog modal-sm">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">홍길동의 사진</h4>
					</div>
					<div class="modal-body">
						<div style="text-align: center;">
							<img
								src="${pageContext.request.contextPath}/resources/picture/hong.jpg"
								width="100%">
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>

			</div>
		</div>

	</div>

</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<%-- Spring MVC Pattern 에서 JSP 페이지 작성시 뷰 역할만 하기 때문에 액션 관련 코드는 모두 제거한다 --%>
<%-- 현재 페이지(*.jsp)를 직접 실행하지 않는다 --%>
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
					<img src="${pageContext.request.contextPath}/resources/img/sist_logo.png" alt="logo"
					style="vertical-align: bottom;"> 직원관리<small>v4.0 (Spring MVC + MyBatis)</small>
				</h1>
			</div>
			<div>
				<ul class="nav nav-pills nav-justified ">
					<li class="active"><a href="${pageContext.request.contextPath}/employee/list">직원관리</a></li>
					<li><a href="${pageContext.request.contextPath}/region/list">지역관리</a></li>
					<li><a href="${pageContext.request.contextPath}/department/list">부서관리</a></li>
					<li><a href="${pageContext.request.contextPath}/position/list">직위관리</a></li>
					<li><a href="${pageContext.request.contextPath}/logout" style="color: red">홍길동 로그아웃</a></li>
				</ul>
			</div>

		</div>
		<div class="panel panel-default">
			<div class="panel-heading">직위 입력</div>
			<div class="panel-body" id="demo">
				<form role="form" action="${pageContext.request.contextPath}/position/insert" method="post">
					<div class="form-group">
						<input type="text" class="form-control" id="positionName" name="positionName"
							placeholder="직위명 (30자 이내)" maxlength="30" required="required">
					</div>
					<div class="form-group">
						<input type="text" class="form-control" id="minBasicPay" name="minBasicPay"
							placeholder="최소기본급" required="required">
					</div>
					<button type="submit" class="btn btn-default">Submit</button>
				</form>

			</div>
		</div>
		<div class="panel panel-default">
			<div class="panel-heading">직위 출력</div>
			<div class="panel-body">
				<table class="table">
					<thead>
						<tr>
							<th>번호</th>
							<th>직위명</th>
							<th>최소기본급</th>
							<th></th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						
						<tr>
							<td>1</td>
							<td>사원</td>
							<td>1,000,000</td>
							<td><button type="button" class="btn btn-default btn-xs  btnDelete">삭제</button></td>
							<td><button type="button" class="btn btn-default btn-xs  btnUpdate">수정</button></td>
						</tr>
						
					</tbody>
				</table>

			</div>
		</div>
	</div>

</body>
</html>


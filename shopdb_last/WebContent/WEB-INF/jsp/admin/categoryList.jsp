<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>

<body>
	<div class="container">
	  <div class="jumbotron">
	    <h1>CATEGORY LIST</h1>      
	    <h5 class="text text-secondary">List</h5>
	    <br>
	    <a href="${pageContext.request.contextPath}/admin/InsertCategory"  class="btn btn-outline-secondary btn-sm"> 추가하기</a> &nbsp;&nbsp;&nbsp;
	     <a href="${pageContext.request.contextPath}/admin/Index"  class="btn btn-outline-secondary btn-sm"> 뒤로가기</a>
	  </div>     
  <br>
  <br>
  <br>
  <br>
  <br>
	
	<!--${list}-->	<!-- EL객체(=값), 뜻) request 안에 있는 list라는 이름을 가진 Attribute -->
	<!-- 자바에서는 직접적으로 불러올 수 없음 , jstl로 작성해여 함 //이걸 활용하면 위에 어트리뷰트로 불러오는 작업 안 해도 됨 (EL가지고 와서) -->
	
	<table class="table table-hover">
		<thead  class="thead-light">
			<tr>
				<th>category_id</th>
				<th>category_name</th>
				<th>update</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="c" items="${list}">	<!-- reuqest.getAttrubute("list")와 같음 -->
				<tr>
					<td>${c.categoryId}</td>
					<td>${c.categoryName}</td>
					<td><a href="${pageContext.request.contextPath}/admin/UpdateCategory?categoryId=${c.categoryId}"  class="btn btn-outline-secondary">수정</a></td>
				</tr>
			</c:forEach>
		<!-- 
			<c:if test="${3>2}">
				<div>출력 됨</div>
			</c:if>
			<c:if test="${2>2}">
				<div>출력 안됨</div>
			</c:if>
		 -->
		</tbody>
	</table>
</body>
</html>
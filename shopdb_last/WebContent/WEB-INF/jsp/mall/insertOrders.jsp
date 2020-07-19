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
	  <div class="jumbotron" style="background:#d1e2f0">
	    <h1>MIN SHOPING</h1>      
	    <h5 class="text text-secondary">My Orders Form</h5>
	  </div>     
  <br>
  <br>
  <br>
  <br>
  <br>
	<!-- item 상세화면 -->
	<h3>상품 정보</h3>
	<div class="row">
	<table class="table table-hover " style="width: 550px;">
		<tbody>
			<tr>
				<td>item_id</td>
				<td>${item.itemId}</td>
			</tr>
			<c:forEach items="${cate}" var="c">
				<c:if test="${c.categoryId == item.categoryId}">
					<tr>
						<td>category_name</td>
						<td>${c.categoryName}</td>
					</tr>
				</c:if>
			</c:forEach>
			<tr>
				<td>item_name</td>
				<td>${item.itemName}</td>
			</tr>
			<tr>
				<td>item_price</td>
				<td>${item.itemPrice}</td>
			</tr>
			<tr>
				<td>item_contents</td>
				<td>${item.itemContents}</td>
			</tr>
		</tbody>
	</table>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<table border="1">
		<tbody>
			<tr>
				<td>
					<img  width="300px" height="350px" src="${pageContext.request.contextPath}/imgs/${item.itemImg}">
				</td>
			</tr>
		</tbody>
	</table>
	</div>
	<br>
	<!-- 주문 폼 -->
	<h4>주문 정보 입력란</h4>
	<form method="post" action="${pageContext.request.contextPath}/mall/InsertOrders">
		<input type="hidden" name="itemId" value="${item.itemId}">
		<input type="hidden" name="itemPrice" value="${item.itemPrice}">
		<table class="table table-hover">
			<tr>
				<td>item_count</td>
				<td><input type="text" name="itemCount"></td>
			</tr>
			<tr>
				<td>user_name</td>
				<td><input type="text" name="userName"></td>
			</tr>
			<tr>
				<td>user_phone</td>
				<td><input type="text" name="userPhone"></td>
			</tr>
			<tr>
				<td>user_address</td>
				<td><input type="text" name="userAddress"></td>
			</tr>
		</table>
		<div>
			<button type="submit"  class="btn btn-outline-primary">주문하기</button>&nbsp;&nbsp;&nbsp;
			<a href="${pageContext.request.contextPath}/mall/MallIndex" class="btn btn-outline-primary">뒤로가기</a>
		</div>
	</form>
</body>
</html>
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
	   <h1>MANAGER Index</h1>      
	    <p><h6 class="text text-secondary">ID: &nbsp;<strong> " ${SloginId} "</strong></h6></p>
	    <p>Orders Update Form</p>
	     <br>
	     <a href="${pageContext.request.contextPath}/admin/OrdersList"  class="btn btn-outline-secondary btn-sm"> 목록 보기</a>
	  </div>     

  <br>
  <br>
  <br>
  <br>
  <br>
	<form method="post" action="${pageContext.request.contextPath}/admin/UpdateOrders">
		<table class="table table-hover">
		<!-- ordersId -->
			<tr>
				<td>orders_id :</td>
				<td><input type="text" name="ordersId" value="${orders.ordersId}" readonly="readonly"></td>
			</tr>
		<!-- itemId -->
			<tr>
				<td>item_id :</td>
				<td><input type="text" name="itemId" value="${orders.itemId}" readonly="readonly"></td>
			</tr>
		<!-- itemCount -->
			<tr>
				<td>item_count :</td>
				<td><input type="text" name="itemCount" value="${orders.itemCount}"></td>
			</tr>
		<!-- ordersDate -->
			<tr>
				<td>orders_date :</td>
				<td><input type="text" name="ordersDate" value="${orders.ordersDate}" readonly="readonly"></td>
			</tr>
		<!-- ordersPrice -->
			<tr>
				<td>orders_price :</td>
				<td><input type="text" name="ordersPrice" value="${orders.ordersPrice}" readonly="readonly"></td>
			</tr>
		<!-- ordersState -->
			<tr>
				<td>orders_state :</td>
				<td>
					<select name="ordersState">
						<c:forEach var="s" items="${str}">
							<c:if test="${str == s}">
								<option value="${s}" selected="selected">${s}</option>
							</c:if>
							<c:if test="${str != s}">
								<option value="${s}">${s}</option>
							</c:if>
						</c:forEach>
					</td>
				</select>
			</tr>
		<!-- userName -->
			<tr>
				<td>user_name :</td>
				<td><input type="text" name="userName" value="${orders.userName}" readonly="readonly"></td>
			</tr>
		<!-- userPhone -->
			<tr>
				<td>user_phone :</td>
				<td><input type="text" name="userPhone" value="${orders.userPhone}" readonly="readonly"></td>
			</tr>
		<!-- userAddress -->
			<tr>
				<td>user_address :</td>
				<td><input type="text" name="userAddress" value="${orders.userAddress}" readonly="readonly"></td>
			</tr>
		</table>
	<!-- button -->
		<div>
			<button type="submit" class="btn btn-secondary">수정하기</button>
		</div>
	</form>
	</div>
</body>
</html>
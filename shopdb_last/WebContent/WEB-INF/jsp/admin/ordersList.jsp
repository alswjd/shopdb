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
<title>OrdersList</title>
</head>

<body>
<div class="container">
	  <div class="jumbotron">
	    <h1>ORDERS LIST</h1>      
	    <h5 class="text text-secondary">List</h5>
	    <br>
	    <a href="${pageContext.request.contextPath}/admin/Index"  class="btn btn-outline-secondary btn-sm"> 뒤로가기</a>
	  </div>     
  <br>
  <br>
  <br>
  <br>
  <br>
	<table  class="table table-hover">
		<thead  class="thead-light">
			<tr>
				<th>orders_id</th>
				<th>item_id</th>
				<th>item_count</th>
				<th>orders_date</th>
				<th>orders_price</th>
				<th>orders_state</th>
				<th>user_name</th>
				<th>user_phone</th>
				<th>user_address</th>
				<th>UPDATE</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="o" items="${orders}">
				<tr>
					<td>${o.ordersId}</td>
					<td>${o.itemId}</td>
					<td>${o.itemCount}</td>
					<td>${o.ordersDate}</td>
					<td>${o.ordersPrice}</td>
					<td>${o.ordersState}</td>
					<td>${o.userName}</td>
					<td>${o.userPhone}</td>
					<td>${o.userAddress}</td>
					<td><a href="${pageContext.request.contextPath}/admin/UpdateOrders?ordersId=${o.ordersId}"  class="btn btn-outline-secondary">수정</a></td>
				</tr>
			</c:forEach>	
		</tbody>
	</table>
</body>
</html>
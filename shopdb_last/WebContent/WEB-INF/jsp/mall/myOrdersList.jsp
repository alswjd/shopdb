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
<title>my Orders List</title>
</head>

<body>
<div class="container">
	  <div class="jumbotron"  style="background:#d1e2f0">
	   <h1>MIN SHOPING</h1> 
	    <h5 class="text text-secondary">My Orders List</h5>
	  </div>     
  <br>
  <br>
  <br>
  <br>
  <br>
	
	<table  class="table table-hover">
		<thead  class="thead-light">
			<tr>
				<th>orders Id</th>
				<th>item Id</th>
				<th>item Count</th>
				<th>orders Date</th>
				<th>orders Price</th>
				<th>orders State</th>
				<th>user Name</th>
				<th>user Phone</th>
				<th>user Address</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="o" items="${orders}">	
				<tr>
					<td>${o.ordersId}</td>
					<c:forEach var="i" items="${item}">
						<c:if test="${i.itemId == o.itemId}">
							<td>${i.itemName}</td>
						</c:if>
					</c:forEach>
					<td>${o.itemCount}</td>
					<td>${o.ordersDate}</td>
					<td>${o.ordersPrice}</td>
					<td>${o.ordersState}</td>
					<td>${o.userName}</td>
					<td>${o.userPhone}</td>
					<td>${o.userAddress}</td>	
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div>
		<a href="${pageContext.request.contextPath}/mall/MallIndex" class="btn btn-outline-primary">쇼핑 계속하기</a>
	</div>
</body>
</html>
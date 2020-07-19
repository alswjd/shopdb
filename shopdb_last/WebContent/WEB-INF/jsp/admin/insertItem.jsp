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
<title>insertItem</title>
</head>
<body>
  <div class="container">
	  <div class="jumbotron">
	   <h1>MANAGER Index</h1>      
	    <p><h6 class="text text-secondary">ID: &nbsp;<strong> " ${SloginId} "</strong></h6></p>
	    <p>Item Insert Form</p>
	     <br>
	     <a href="${pageContext.request.contextPath}/admin/ItemList"  class="btn btn-outline-secondary btn-sm"> 목록 보기</a>
	  </div>     

  <br>
  <br>
  <br>
  <br>
  <br>
	<form method="post" action="${pageContext.request.contextPath}/admin/InsertItem">
		<table class="table table-hover">
		<!-- category_name -->
			<tr>
				<td>category_name :</td>
				<td>
					<select name="categoryId">
						<option value="">카테고리 선택</option>
						
						<c:forEach var="c" items="${li}">
							<option value="${c.categoryId}">${c.categoryName}</option>			
						</c:forEach>
					</select>
				</td>
			</tr>
		<!-- item_name -->
			<tr>
				<td>item_name :</td> 
				<td><input type="text" name="itemName"></td>
			</tr>
		<!-- item_price -->
			<tr>
				<td>item_price :</td> 
				<td><input type="text" name="itemPrice"></td>
			</tr>
		<!-- item_contents -->
			<tr>
				<td>item_contents :</td> 
				<td><input type="text" name="itemContents"></td>
			</tr>
		</table>
	<!-- button -->
		<div>
			<button type="submit" class="btn btn-secondary">입력하기</button>
		</div>
	</form>
</div>
</body>
</html>
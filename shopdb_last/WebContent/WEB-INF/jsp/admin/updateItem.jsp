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
<title>update Item</title>
</head>
<body>
  <div class="container">
	  <div class="jumbotron">
	   <h1>MANAGER Index</h1>      
	    <p><h6 class="text text-secondary">ID: &nbsp;<strong> " ${SloginId} "</strong></h6></p>
	    <p>Item Update Form</p>
	     <br>
	     <a href="${pageContext.request.contextPath}/admin/ItemList"  class="btn btn-outline-secondary btn-sm"> 목록 보기</a>
	  </div>     

  <br>
  <br>
  <br>
  <br>
  <br>
	
	<form method="post" action="${pageContext.request.contextPath}/admin/UpdateItem">
		<table class="table table-hover">
		<!-- itemId -->
			<tr>
				<td>item_id :</td> 
				<td><input type="text" name="itemId" value="${item.itemId}" readonly="readonly"></td>
			</tr>
		<!-- categoryId -->
			<tr>
				<td>category_name:</td>
				<td>
					<select name="categoryId"> 
						<c:forEach var="c" items="${list}">
							<c:if test="${c.categoryId == item.categoryId}">
								<option value="${c.categoryId}" selected="selected">${c.categoryName}</option>
							</c:if>
							<c:if test="${c.categoryId != item.categoryId}">
								<option value="${c.categoryId}">${c.categoryName}</option>
							</c:if>
						</c:forEach>
					</select>
				</td>
			</tr>
		<!-- itemName -->
			<tr>
				<td>item_name :</td> 
				<td><input type="text" name ="itemName" value="${item.itemName}"></td>
			</tr>
		<!-- itemPrice -->
			<tr>
				<td>item_price :</td> 
				<td><input type="text" name="itemPrice" value="${item.itemPrice}"></td>
			</tr>
		<!-- itemContents -->
			<tr>
				<td>item_contents :</td>
				<td><input type="text" name="itemContents" value="${item.itemContents}"></td>
	 		</tr>
	 	</table>
 	<!-- button -->
 		<div>
 			<button type="submit" class="btn bnt-secondary">수정하기</button>
 		</div>
	</form>
	</div>
</body>
</html>
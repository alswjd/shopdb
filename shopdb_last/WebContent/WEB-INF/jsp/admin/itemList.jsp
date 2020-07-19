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
<title>itemList</title>
</head>

<body>
	<div class="container">
	  <div class="jumbotron">
	    <h1>ITEM LIST</h1>      
	    <h5 class="text text-secondary">List</h5>
	    <br>
	    <a href="${pageContext.request.contextPath}/admin/InsertItem"  class="btn btn-outline-secondary btn-sm">추가하기</a>	<!-- get방식 --> &nbsp;&nbsp;&nbsp;
	    <a href="${pageContext.request.contextPath}/admin/Index"  class="btn btn-outline-secondary btn-sm"> 뒤로가기</a>
	  </div>     
  <br>
  <br>
  <br>
  <br>
  <br>
	
	<c:if test="${item == null}">
		<div>상품이 없습니다.</div>
	</c:if>
	<c:if test="${item != null}">
		<table  class="table table-hover">
		<thead  class="thead-light">
				<th>item_id</th>
				<th>category_id</th>
				<th>item_name</th>
				<th>item_price</th>
				<th>item_contents</th>
				<th>item_img</th>
				<th>update</th>
			</thead>
			<tbody>
				<c:forEach var="i" items="${item}">
				
						<tr>
							<td>${i.itemId}</td>  <!-- i.getItemId()와 같음 -->
					
							<c:forEach var="c" items="${list}">
								<c:if test="${i.categoryId == c.categoryId }">
									<td>ID ${i.categoryId}: ${c.categoryName}</td>
								</c:if>	
							</c:forEach>
					
							<td>${i.itemName}</td>
							<td>${i.itemPrice}</td>
							<td>${i.itemContents}</td>
							<!-- item 1 IMG -->
							<c:if test="${i.itemId == 1}">
								<td><img src="${pageContext.request.contextPath}/imgs/1.jpg" width="80px" height="80px"></td>
							</c:if>
							<!-- item 2 IMG -->
							<c:if test="${i.itemId == 2}">
								<td><img src="${pageContext.request.contextPath}/imgs/2.jpg" width="80px" height="80px"></td>
							</c:if>
							<!-- item 3 IMG -->
							<c:if test="${i.itemId == 3}">
								<td><img src="${pageContext.request.contextPath}/imgs/3.jpg" width="80px" height="80px"></td>
							</c:if>
							<!-- item 4 IMG -->
							<c:if test="${i.itemId == 4}">
								<td><img src="${pageContext.request.contextPath}/imgs/4.jpg" width="80px" height="80px"></td>
							</c:if>
							<!-- item 5 IMG -->
							<c:if test="${i.itemId == 5}">
								<td><img src="${pageContext.request.contextPath}/imgs/5.jpg" width="80px" height="80px"></td>
							</c:if>
							<!-- item 6 IMG -->
							<c:if test="${i.itemId == 6}">
								<td><img src="${pageContext.request.contextPath}/imgs/6.jpg" width="80px" height="80px"></td>
							</c:if>
							<!-- item 7 IMG -->
							<c:if test="${i.itemId == 7}">
								<td><img src="${pageContext.request.contextPath}/imgs/7.jpg" width="80px" height="80px"></td>
							</c:if>
							<!-- item 8 IMG -->
							<c:if test="${i.itemId == 8}">
								<td><img src="${pageContext.request.contextPath}/imgs/8.jpg" width="80px" height="80px"></td>
							</c:if>
							<!-- item 9 IMG -->
							<c:if test="${i.itemId == 9}">
								<td><img src="${pageContext.request.contextPath}/imgs/9.jpg" width="80px" height="80px"></td>
							</c:if>
							<!-- item 10 IMG -->
							<c:if test="${i.itemId == 10}">
								<td><img src="${pageContext.request.contextPath}/imgs/10.jpg" width="80px" height="80px"></td>
							</c:if>
							<!-- item 11 IMG -->
							<c:if test="${i.itemId == 11}">
								<td><img src="${pageContext.request.contextPath}/imgs/11.jpg" width="80px" height="80px"></td>
							</c:if>
							<!-- item 12 IMG -->
							<c:if test="${i.itemId == 12}">
								<td><img src="${pageContext.request.contextPath}/imgs/12.jpg" width="80px" height="80px"></td>
							</c:if>
							
							<td><a href="${pageContext.request.contextPath}/admin/UpdateItem?itemId=${i.itemId}"  class="btn btn-outline-secondary">수정</a></td>
						</tr>		
				</c:forEach>
			</tbody>
		</table>
	</c:if>
</body>
</html>
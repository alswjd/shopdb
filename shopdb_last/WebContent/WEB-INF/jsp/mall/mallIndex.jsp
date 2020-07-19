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
<title>mall Index</title>
</head>
<style>
	body{
	    background-color: #fff;
	}
</style>
<body>
	<!-- 
		상품 리스트 - (상품 상세+주문폼) - 주문액션 - 주문정보폼(이름+전화번호) - 나의 주문목록
	-->
	
	<div class="container">
	  <div class="jumbotron" style="background:#d1e2f0">
	    <h1>MIN SHOPING</h1>      
	    <h7 class="text text-secondary">@20,000원 이상 주문 시 500,000 원 쿠폰 증정!  @전 상품 교환, 반품 무료!  @이벤트 참여 시  랜덤박스 배송! </h7>
	  </div>     
  <br>
   <p><h6 class="text text-secondary"><strong> " ${loginId} "님 안녕하세요.</strong></h6></p>
   <a href="${pageContext.request.contextPath}/mall/GuestLogout" class="btn btn-outline-secondary btn-sm">로그아웃</a>
  <br>
  <br>
  <br>
  <br>
	<table class="table table-hover">
		<tr>
			<c:forEach var="item" items="${list}" varStatus="stats">	<!-- varStatus="stats": 이 안에서의 상태값 -->
				
				<c:if test="${stats.index != 0 && stats.index % 4 == 0}">	<!-- 줄바꿈 -->
					</tr><tr>
				</c:if>
				
				<td>	
					<div>
						<img  width="230px" height="330px" src="${pageContext.request.contextPath}/imgs/${item.itemImg}">
					</div>
					<br>
					<div>
						<!--${stats.index}-->
						<a href="${pageContext.request.contextPath}/mall/InsertOrders?itemId=${item.itemId}" class="btn btn-outline-secondary text text-secondary btn-sm">
							${item.itemName}
						</a>
						&nbsp;
						<button class="btn btn-warning btn-sm" disabled>
						    <span class="spinner-grow spinner-grow-sm"></span>
						    	best
						 </button>
					</div>
				</td>
			</c:forEach>
				
				<c:if test="${list.size() % 4 != 0}">	<!-- 경우에 따라 반복되는 td의 필요성 -->
					<c:forEach begin="${list.size() % 4}" end="3" step="1">	<!-- for 안에 있는 조건들과 동일한 역할 -->
						<td>&nbsp;</td>
					</c:forEach>
				</c:if>
		</tr>
	</table>
	</div>
</body>
</html>
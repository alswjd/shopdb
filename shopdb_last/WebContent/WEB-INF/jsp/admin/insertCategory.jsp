<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<title>insertCategoryForm</title>
</head>
<body>
  <div class="container">
	  <div class="jumbotron">
	   <h1>MANAGER Index</h1>      
	    <p><h6 class="text text-secondary">ID: &nbsp;<strong> " ${SloginId} "</strong></h6></p>
	    <p>Category Insert Form</p>
	    <br>
	     <a href="${pageContext.request.contextPath}/admin/CategoryList"  class="btn btn-outline-secondary btn-sm"> 목록 보기</a>
	  </div>     

  <br>
  <br>
  <br>
  <br>
  <br>
	
	<!-- 외부에서 요청하는 것 (브라우저에서 요청) -->
	<form method="post" action="<%=request.getContextPath()%>/admin/InsertCategory"><!-- post방식과 get방식으로 나눠서 작업하기 때문에 이름이 겹쳐도 됨 -->
		<table class="table table-hover">
			<tr>
				<td>카테고리 이름:</td>
				<td><input type="text" name="categoryName"></td>
			</tr>
		</table>
		<div>
			<button type="submit" class="btn btn-secondary">카테고리 추가</button>
		</div>
	</form>
	</div>
</body>
</html>
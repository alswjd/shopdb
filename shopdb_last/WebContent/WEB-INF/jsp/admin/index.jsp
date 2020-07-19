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
<title>Index</title>
</head>
<style>
	body{
	    background-color: #fff;
	}
</style>
<body>

  <div class="container">
	  <div class="jumbotron">
	   <h1>MANAGER Index</h1>      
	    <p><h6 class="text text-secondary">ID: &nbsp;<strong> " ${SloginId} "</strong></h6></p>
	    <a href="${pageContext.request.contextPath}/admin/AdminLogout" class="btn btn-outline-secondary btn-sm">로그아웃</a>
	  </div>     

  <br>
  <br>
  <br>
  <br>
  <br>
  <div class="card-deck" >
  <!-- category CRU -->
    <div class="card" style="background-color : #c2c9cb  ">
      <div class="card-body text-center">
        <p class="card-text">
        	<a href="${pageContext.request.contextPath}/admin/MemberList" class="btn btn-outline-light">
				ADMIN<!--(C,R,U,D)-->
			</a>
			<p class="text text-secondary">Admin_Id</p>
			<p class="text text-secondary">Admin_Pw</p>
        </p>
      </div>
    </div>
   <!-- category CRU -->
    <div class="card bg-" style="background-color : #c2c9cb">
      <div class="card-body text-center">
        <p class="card-text">
        	<a href="${pageContext.request.contextPath}/admin/CategoryList" class="btn btn-outline-light">
				CATEGORY<!--(C,R,U)-->
			</a>
			<p class="text text-secondary">Category_Id</p>
			<p class="text text-secondary">Category_Name</p>
        </p>
      </div>
    </div>
   <!-- item CRU --> 
    <div class="card bg-" style="background-color : #c2c9cb">
      <div class="card-body text-center">
        <p class="card-text">
			<a href="${pageContext.request.contextPath}/admin/ItemList" class="btn btn-outline-light">
				ITEM<!--(C,R,U)-->
			</a>
			<p class="text text-secondary">Item_Id</p>
			<p class="text text-secondary">Category_Id</p>
			<p class="text text-secondary">Item_Name</p>
			<p class="text text-secondary">Item_Price</p>
			<p class="text text-secondary">Item_Contents</p>
			<p class="text text-secondary">Item_Img</p>
		</p>
      </div>
    </div>
   <!-- orders RUD --> 
    <div class="card bg-" style="background-color : #c2c9cb">
      <div class="card-body text-center">
        <p class="card-text">
        	<a href="${pageContext.request.contextPath}/admin/OrdersList" class="btn btn-outline-light">
				ORDERS<!--(R,U-ordersState만 업데이트)--> 
			</a>
			<p class="text text-secondary">Orders_Id</p>
			<p class="text text-secondary">Item_Id</p>
			<p class="text text-secondary">Item_Count</p>
			<p class="text text-secondary">Orders_Date</p>
			<p class="text text-secondary">Orders_State</p>
			<p class="text text-secondary">User_Name</p>
			<p class="text text-secondary">User_Phone</p>
			<p class="text text-secondary">User_Address</p>
		</p>
      </div>
    </div>
      
  </div>
</div>
</body>
</html>
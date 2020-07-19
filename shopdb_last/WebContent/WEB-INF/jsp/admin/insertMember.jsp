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
<title>Insert Member</title>
</head>
<body>
  <div class="container">
	  <div class="jumbotron">
	   <h1>MANAGER Index</h1>      
	    <p><h6 class="text text-secondary"><strong> </strong></h6></p>
	   	<p>Manager Member Insert Form</p>
	     <br>
	     <a href="${pageContext.request.contextPath}/admin/MemberList"  class="btn btn-outline-secondary btn-sm"> 목록 보기</a>
	  </div>     

  <br>
  <br>
  <br>
  <br>
  <br>
	<form method="post" action="${pageContext.request.contextPath}/admin/InsertMember">
		<table class="table table-hover">
			<tbody>
				<tr>
					<td>member_id: </td>
					<td><input type="text" name="memberId"></td>
				</tr>
				<tr>
					<td>member_pw: </td>
					<td><input type="text" name="memberPw"></td>
				</tr>
			</tbody>
		</table>
		<div>
			<button type="submit" class="btn btn-secondary">추가하기</button>
		</div>
	</form>
	</div>
</body>
</html>
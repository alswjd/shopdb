<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- Popper JS -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {font-family: Arial, Helvetica, sans-serif;}
form {border: 3px solid #f1f1f1;}

input[type=text], input[type=password] {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}

button {
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
}

 a {
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
}

button:hover {
  opacity: 0.8;
}

.cancelbtn {
  width: auto;
  padding: 10px 18px;
  background-color: #f44336;
}

.imgcontainer {
  text-align: center;
  margin: 24px 0 12px 0;
}

img.guestId {
  width: 40%;
  border-radius: 50%;
}

.container {
  padding: 16px;
}

span.guestPw {
  float: right;
  padding-top: 16px;
}


@media screen and (max-width: 300px) {
  span.guestPw {
     display: block;
     float: none;
  }
  .cancelbtn {
     width: 100%;
  }
}
</style>
<title>Guest Login</title>
</head>

<body>
	<div class="container">
		<div class="jumbotron"  style="background:#d1e2f0">
			<h1>Guest Login page</h1>
			<p class="text text-secondary">회원 전용 페이지 입니다.</p>
		</div>

		<form action="${pageContext.request.contextPath}/mall/GuestLogin" method="post">
		  <div class="imgcontainer">
		    <img src="${pageContext.request.contextPath}/imgs/guest.png" >
		  </div>
		
		  <div class="container">
		    <label for="uname"><b>Username</b></label>
		    <input type="text" placeholder="Enter Username" name="guestId" required>
		
		    <label for="psw"><b>Password</b></label>
		    <input type="password" placeholder="Enter Password" name="guestPw" required>
		        
		    <button type="submit" class="btn btn-dark">Login</button>
		    <a href="${pageContext.request.contextPath}/mall/InsertGuest"  class="btn btn-dark">Sign up</a>
		    
		  </div>
		</form>
		<form action="${pageContext.request.contextPath}/admin/AdminLogin" method="post">
		   <div class="container">	
			<button type="submit" class="btn btn-secondary">Manager Login</button>
		   </div>
		</form>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" />
<title>Login Page</title>
</head>
<body>
  <div class="container">
    <h2>Welcome to the login page</h2>
    <!-- jewan의 로그인페이지 -->
    <pre>${errorMessage}</pre>
    <form method="post">
      Name : <input type="text" name="name" /> 
      Password : <input type="password" name="password" /> 
      <input type="submit" />
    </form>
  </div>
</body>
</html>

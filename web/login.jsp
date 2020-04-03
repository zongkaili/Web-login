<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<!--登陆框-->
<form action="UserServlet" method="post">
    用户名：<input type="text" class="inputName" name="username" placeholder="用户名"><br/>
    密 码：<input type="password" name="password" placeholder="密码"><br/>
    <button type="submit">登录</button>
</form>
</body>
</html>
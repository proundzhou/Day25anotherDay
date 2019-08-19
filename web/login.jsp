<%--
  Created by IntelliJ IDEA.
  User: Nirvana
  Date: 2019/8/17 0017
  Time: 9:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="AddressServlet?action=login" method="post">
    用户名： <input type="text" name="name"><br>
    密码： <input type="password" name="password"><br>
    记住我：<input type="checkbox" name="remember" value="remember"><br>
    <input type="submit" value="登陆">
</form>

</body>
</html>

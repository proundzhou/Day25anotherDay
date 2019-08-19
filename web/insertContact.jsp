<%--
  Created by IntelliJ IDEA.
  User: Nirvana
  Date: 2019/8/17 0017
  Time: 11:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="AddressServlet?action=insertContact" method="post">
    姓名： <input type="text" name="name"><br>
    电话： <input type="text" name="phone"><br>
    地址： <input type="text" name="address"><br>
    <input type="submit" value="添加">
</form>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Nirvana
  Date: 2019/8/17 0017
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="AddressServlet?action=editContact&name=${contact.name}" method="post">
    姓名：${contact.name}<br>
    密码(没有的账号自然没有密码)：<input type="text" name="password" value="${contact.password}"><br>
    电话：<input type="text" name="phone" value="${contact.phone}"><br>
    地址：<input type="text" name="address" value="${contact.address}"><br>
    <input type="submit" value="修改">
</form>

</body>
</html>

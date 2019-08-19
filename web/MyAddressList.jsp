<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Nirvana
  Date: 2019/8/17 0017
  Time: 10:56
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table cellpadding="0" border="1">
    <thead>
    <tr>
        <th>选中</th>
        <th>姓名</th>
        <th>电话</th>
        <th>地址</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody><form action="AddressServlet?action=deleteChoose" method="post" >
        <c:forEach items="${addressList}" var="contact">
            <tr>
                <td>${contact.name} <input type="checkbox" name="nameList" value="${contact.name}"></td>
                <td>${contact.name}</td>
                <td>${contact.phone}</td>
                <td>${contact.address}</td>
                <td><a href="AddressServlet?action=toEdit&name=${contact.name}">编辑</a>/
                    <a href="AddressServlet?action=deleteContact&name=${contact.name}">删除</a>
                </td>
            </tr>
        </c:forEach>
    <tr>
        <td><input type="submit" value="选中删除"></td>
    </tr>
    </form></tbody>
    <tfoot>
    <tr>
        <td colspan="3"><a href="AddressServlet?action=toInsert">添加</a>

        </td>
    </tr>
    </tfoot>
</table>
</body>
</html>

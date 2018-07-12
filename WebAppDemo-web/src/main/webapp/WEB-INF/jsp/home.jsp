<%--
  Created by IntelliJ IDEA.
  User: 涛
  Date: 2017/7/19
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Home</title>
</head>
<body style="background: url(/resources/images/background.jpg); background-size:100% 100%">
<div style="position: absolute; left:40%; top:30%" align="center">
<h1>
    欢迎，${sessionScope.get("username")}
</h1>
<form action="/user/logout" method="get">
    <table>
        <tr>
            <td><input type="submit" value="退出" /></td>
        </tr>
    </table>
</form>
<form action="/user/upload" method="post" enctype="multipart/form-data">
    <table>
        <tr>
            <td><input type="file" name="file" /></td>
            <td><input type="submit" value="上传" /></td>
        </tr>
    </table>
</form>
</div>
</body>
</html>

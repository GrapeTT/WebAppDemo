<%--
  Created by IntelliJ IDEA.
  User: 涛
  Date: 2017/7/18
  Time: 23:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>注册</title>
</head>
<body style="background: url(/resources/images/background.jpg); background-size:100% 100%">
<div style="position: absolute; left:40%; top:30%" align="center">
    <h1>用户注册</h1>
    <!-- 显示错误信息 -->
    <div>
        <c:if test="${allErrors != null }">
           <%--<c:forEach items="${allErrors }" var="error">--%>
                <%--<font color="red">--%>
                    <%--${ error.defaultMessage}<br/>--%>
                <%--</font>--%>
           <%--</c:forEach>--%>
            <font color="red">
                ${ allErrors[0].defaultMessage}<br/>
            </font>
        </c:if>
    </div>
    <form action="/user/register" method="post">
        <table border="0">
            <tr>
                <td>用户名</td>
                <td><input type="text" maxlength="20" name="username" value="${user.username}"></td>
            </tr>
            <tr>
                <td>密码</td>
                <td><input type="password" maxlength="20" name="password" value="${user.password}">
                </td>
            </tr>
            <tr>
                <td>姓名</td>
                <td><input type="text" maxlength="20" name="realname" value="${user.realname}"></td>
            </tr>
            <tr>
                <td>性别</td>
                <td><input type="text" maxlength="1" name="sex" value="${user.sex}"></td>
            </tr>
            <tr>
                <td>年级</td>
                <td><input type="number" maxlength="4" name="grade" value="${user.grade}"></td>
            </tr>
            <tr>
                <td>邮箱</td>
                <td><input type="email" maxlength="20" name="email" value="${user.email}"></td>
            </tr>
        </table>
        <br>
        <input type="submit" value="注册" style="color:#BC8F8F">
    </form>
</div>
</body>
</html>

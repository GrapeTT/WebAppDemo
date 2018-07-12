<%--
  Created by IntelliJ IDEA.
  User: 涛
  Date: 2017/7/15
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>
      <title>登录</title>
  </head>
  <body style="background: url(/resources/images/background.jpg); background-size:100% 100%">
  <div style="position: absolute; left:40%; top:30%" align="center">
     <h1>Login</h1>
     <form action="/user/login" method="post">
       <table border="0">
         <tr>
           <td>Username</td>
           <td><input type="text" maxlength="20" name="username" value="${user.username}"></td>
         </tr>
         <tr>
           <td>Password</td>
           <td><input type="password" maxlength="20" name="password" value="${user.password}">
           </td>
           <div>
             <c:if test="${error != null }">
               <font color="red">
                   ${error}
               </font>
             </c:if>
           </div>
         </tr>
       </table>
       <br>
       <input type="submit" value="登录" style="color:#BC8F8F">
     </form>
     <form action="/user/getRegister" method="get">
       <input type="submit" value="注册" style="color:#BC8F8F">
     </form>
    </div>
  </body>
</html>

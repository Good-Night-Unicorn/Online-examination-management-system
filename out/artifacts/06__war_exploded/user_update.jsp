<%@ page import="com.bjpowernode.ontity.Users" %><%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2021/8/29
  Time: 19:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
   Users users= (Users) request.getAttribute("key1");
%>
<center>
    <form action="/myweb/user/update" method="get">
        <table border="2">
            <tr>
                <td>用户编号</td>
                <td>用户姓名</td>
                <td>用户密码</td>
                <td>用户性别</td>
                <td>用户邮箱</td>

            </tr>
            <tr>
                <td><input type="text" name="userID" value="<%=users.getUserID()%>"  readonly></td>
                <td><input type="text" name="userName" value="<%=users.getUserName()%>"></td>
                <td><input type="text" name="password" value="<%=users.getPassword()%>"></td>
                <td><input type="text" name="sex" value="<%=users.getSex()%>"></td>
                <td><input type="text" name="Email" value="<%=users.getEmail()%>"></td>
            </tr>
            <tr  align="center">
                <td colspan="3"><input type="submit" value="更新用户信息"></td>
                <td colspan="4"><input type="reset" ></td>
            </tr>
        </table>


    </form>
</center>
</body>
</html>


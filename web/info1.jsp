<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2021/8/29
  Time: 22:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <%
        String result= (String) request.getAttribute("info");
    %>
    <font style="color:red;font-size: 45px">
        <%=result%>
    </font>
</center>
</body>
</html>

<%@ page import="java.util.List" %>
<%@ page import="com.bjpowernode.ontity.Question" %><%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2021/8/27
  Time: 23:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="2" align="center">
    <tr align="center">
        <td>题目编号</td>
        <td>题目信息</td>
        <td>A</td>
        <td>B</td>
        <td>C</td>
        <td>D</td>
        <td>正确答案</td>
        <td>操作</td>
        <td>操作</td>


    </tr>
    <%
     List list=(List)request.getAttribute("key1");
        for (int i = 0; i < list.size(); i++) {
            Question question= (Question) list.get(i);
    %>

    <%
       if(i%2==0){

    %>
    <tr style="background-color: cadetblue">
        <td><%=question.getQuestionID()%></td>
        <td><%=question.getTitle()%></td>
        <td><%=question.getOptionA()%></td>
        <td><%=question.getOptionB()%></td>
        <td><%=question.getOptionC()%></td>
        <td><%=question.getOptionD()%></td>
        <td><%=question.getAnswer()%></td>
        <td><a href="/myweb/question/delete?questionID=<%=question.getQuestionID()%> ">试题删除</a></td>
        <td><a href="/myweb/question/findByID?questionID=<%=question.getQuestionID()%> ">试题更新</a></td>
    </tr>

    <%
        }else {
    %>
    <tr style="background-color: yellow">
        <td><%=question.getQuestionID()%></td>
        <td><%=question.getTitle()%></td>
        <td><%=question.getOptionA()%></td>
        <td><%=question.getOptionB()%></td>
        <td><%=question.getOptionC()%></td>
        <td><%=question.getOptionD()%></td>
        <td><%=question.getAnswer()%></td>
        <td><a href="/myweb/question/delete?questionID=<%=question.getQuestionID()%> ">删除试题 </a></td>
        <td><a href="/myweb/question/findByID?questionID=<%=question.getQuestionID()%> ">详细信息</a></td>
    </tr>
    <%
        }


        }
    %>

</table>
</body>
</html>

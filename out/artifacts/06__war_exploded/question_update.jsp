<%@ page import="com.bjpowernode.ontity.Question" %><%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2021/8/28
  Time: 18:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Question question= (Question) request.getAttribute("key1");
%>
<center>
    <form action="/myweb/question/update" method="get">
        <table border="2">
            <tr>
                <td>题目编号：</td>
                <td><input type="text" name="questionID" value="<%=question.getQuestionID()%>"  readonly></td>
            </tr>
            <tr>
                <td>题目：</td>
                <td><input type="text" name="title" value="<%=question.getTitle()%>"></td>
            </tr>
            <tr>
                <td>A：</td>
                <td><input type="text" name="optionA" value="<%=question.getOptionA()%>"></td>
            </tr>
            <tr>
                <td>B:</td>
                <td><input type="text" name="optionB" value="<%=question.getOptionB()%>"></td>
            </tr>
            <tr>
                <td>C:</td>
                <td><input type="text" name="optionC" value="<%=question.getOptionC()%>"></td>
            </tr>
            <tr>
                <td>D:</td>
                <td><input type="text" name="optionD" value="<%=question.getOptionD()%>"></td>
            </tr>
            <tr>
                <td>正确答案:</td>
                <td>
                    <input type="radio" name="answer" value="A" <%="A".equals(question.getAnswer())?"checked":""%>>A
                    <input type="radio" name="answer" value="B" <%="B".equals(question.getAnswer())?"checked":""%>>B
                    <input type="radio" name="answer" value="C" <%="C".equals(question.getAnswer())?"checked":""%>>C
                    <input type="radio" name="answer" value="D" <%="D".equals(question.getAnswer())?"checked":""%>>D
                </td>
            </tr>
            <tr>
                <td><input type="submit" value="更新试题"></td>
                <td><input type="reset" ></td>
            </tr>
        </table>


    </form>
</center>
</body>
</html>

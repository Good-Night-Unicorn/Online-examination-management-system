<%@ page import="java.util.List" %>
<%@ page import="com.demo.ontity.Question" %><%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2021/8/30
  Time: 1:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
  <form action="/myweb/exam">
    <table border="2">
      <tr>
        <td>题目编号</td>
        <td>题目信息</td>
        <td>A</td>
        <td>B</td>
        <td>C</td>
        <td>D</td>
        <td>答案</td>
      </tr>
<%
  List<Question> questionList= (List<Question>) session.getAttribute("key");
  for(Question question:questionList){


%>
      <tr >
        <td><%=question.getQuestionID()%></td>
        <td><%=question.getTitle()%></td>
        <td><%=question.getOptionA()%></td>
        <td><%=question.getOptionB()%></td>
        <td><%=question.getOptionC()%></td>
        <td><%=question.getOptionD()%></td>
        <td>
          <input type="radio" name="answer_<%=question.getQuestionID()%>" value="A" />A
          <input type="radio" name="answer_<%=question.getQuestionID()%>" value="B" />B
          <input type="radio" name="answer_<%=question.getQuestionID()%>" value="C" />C
          <input type="radio" name="answer_<%=question.getQuestionID()%>" value="D" />D
        </td>
      </tr>
      <%
        }
      %>
      <tr align="center">
        <td colspan="3"><input type="submit" value="交卷"></td>
        <td colspan="4"><input type="reset" ></td>
      </tr>
    </table>
  </form>

</center>
</body>
</html>

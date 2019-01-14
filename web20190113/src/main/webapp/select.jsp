<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/14
  Time: 19:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href="/findStudent">查询所有</a><br>
    按id查询
    <form action="/findId">
        <input type="text" name="id">
        <input type="submit" value="查询">
    </form>
</body>
</html>

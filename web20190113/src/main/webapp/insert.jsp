<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/14
  Time: 15:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/insertStudent">
        请输入名字
        <input type="text" name="name">
        请输入生日（格式yyyy-MM-dd）
        <input type="text" name="birthday">
        请输入性别
        <input type="text" name="sex">
        <input type="submit" value="增加">
    </form>
</body>
</html>

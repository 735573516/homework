<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/14
  Time: 20:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1" width="100%">
    <thead>
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>生日</th>
        <th>性别</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="stu">
        <tr>
            <td>${stu.sid}</td>
            <td>${stu.sname}</td>
            <td><fmt:formatDate value="${stu.birthday}" pattern="yyyy-MM-dd"/></td>
            <td>${stu.sex}</td>
        </tr>
    </c:forEach>
    </tbody>
</table><br>
<form action="/update">
    修改编号=
    <input type="text" name="id">
    的数据<br>修改名字
    <input type="text" name="name" id="name" value="${stu.sname}">
    修改生日
    <input type="text" name="birthday" id="birthday" value="${stu.birthday}">
    修改性别
    <input type="text" name="sex" id="sex" value="${stu.sex}">
    <input type="submit" value="修改">
</form>
</body>
</html>

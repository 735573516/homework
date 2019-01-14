<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/13
  Time: 23:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎来到....</title>
    <script>
        var a1=0
        var a2=0;
        var a3=0;
        function fun1() {
            document.getElementById("1").src="/javaEE实用教程.jpg";
            a1++;
        }
        function func2() {
            document.getElementById("2").src="/javaWeb开发实战.jpg"
            a2++;
        }
        function func3() {
            document.getElementById("3").src="/java高级程序设计.jpg"
            a3++;
        }
        function func4() {
            document.getElementById("1").src=""
            document.getElementById("2").src=""
            document.getElementById("3").src=""
            a1=0;
            a2=0;
            a3=0;
        }
    </script>
</head>
<body>
    <center><b><h1>我的三本java书屋</h1></b></center>
    <table>
        <tr>
            <td><img src="/javaEE实用教程.jpg" border="10"></td>
            <td><img src="/javaWeb开发实战.jpg" border="10"></td>
            <td><img src="/java高级程序设计.jpg" border="10"></td>
        </tr>
        <tr>
            <td><center>价格399</center></td>
            <td><center>价格499</center></td>
            <td><center>价格599</center></td>
        </tr>
        <tr>
            <td>
                <center><input type="button" name="" onclick="fun1()" value="添加至购物车"></center>
            </td>
            <td>
                <center><input type="button" name="" onclick="func2()" value="添加至购物车"></center>
            </td>
            <td>
                <center><input type="button" name="" onclick="func3()" value="添加至购物车"></input></center>
            </td>
        </tr>
    </table>
    <br>
    <table>
        <thead>我的购物车</thead>
        <tbody>
            <tr>
                <td><img src="" id="1"></td>
                <td><img src="" id="2"></td>
                <td><img src="" id="3"></td>
            </tr>
            <tr>
                <td><center>${a1}<span value="数量：0"></span></center></td>
                <td><center><a value="数量：0"></a></center></td>
                <td><center><a value="数量：0"></a></center></td>
                <td><center><input type="button" onclick="func4()" value="清空购物车"></center></td>
            </tr>
        </tbody>
    </table>
</body>
</html>

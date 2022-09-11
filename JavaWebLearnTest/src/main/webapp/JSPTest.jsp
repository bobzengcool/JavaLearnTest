<%--
        Created by IntelliJ IDEA.
        User: Administrator
        Date: 2022/9/11
        Time: 10:42
        To change this template use File | Settings | File Templates.
        --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%! int fontSize = 0; %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>bob学习jsp</title>
    </head>
    <body>
        <h3>While 循环实例</h3>
        <%while (fontSize<= 10) { %>
        <span style="color: red;" >
            颜色字体
        </span>
        <br/>
        <%fontSize++;%>
        <%}%>
    </body>
</html>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/9/11
  Time: 11:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<form id="msg-form" method="post" action="${pageContext.request.contextPath}/ServletComment">
    <div>
        <div>
            <label>Your message here:</label>
            <textarea rows="3" name="comment" placeholder="Enter Your message:"
                      required></textarea>
        </div>
        <div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </div>
    </div>
</form>
</body>
</html>
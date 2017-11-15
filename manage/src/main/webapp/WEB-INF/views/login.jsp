<%--
  Created by IntelliJ IDEA.
  User: fxh
  Date: 2017/11/15
  Time: 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/loginHandler" method="post">
    <div>
        用户名：<input type="text" name="username">
    </div>
    <div>
        密码：<input type="text" name="password">
    </div>
    <button type="submit">提交</button>
</form>
</body>
</html>

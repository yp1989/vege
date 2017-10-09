<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
    <link rel="stylesheet" type="text/css" href="/static/admin/css/login.css">
</head>
<body class="no-skin">
<div class="errorBox">
    <div class="errorTip">
        <h1>出错啦！</h1>
        <p>亲，您访问的页面不存在！</p>
        <img src="/static/admin/img/error.png">
    </div>
    <p class="error_dec">这可能是因为您输入的网址不正确。如果您是通过收藏夹或者书签访问本页面，说明您收藏的网页已经过期。</p>
    <input type="button" onclick="window.location.href='/login'" class="btn" value="点击返回首页">
</div>
</body>
</html>
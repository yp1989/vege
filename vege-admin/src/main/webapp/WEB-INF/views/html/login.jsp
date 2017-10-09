<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en" class="member">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <meta charset="utf-8"/>
    <title>登录</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0"/>
    <link rel="stylesheet" href="/static/admin/css/login.css"/>
    <link rel="stylesheet" href="/static/admin/css/font-awesome.min.css"/>
</head>
<body class="no-skin">
<div class="m-main">
    <form action="/doLogin" method="post">
        <div class="m-form">
            <div class="m-icon circle"><i class="fa fa-user"></i></div>
            <div class="m-title">微客来销售管理系统</div>
            <div class="m-input-text m-input-join-u">
                <input name="adminName" class="input-focus radius-bl0 radius-br0" type="text" placeholder="请输入您的账号"/>
            </div>
            <div class="m-input-text m-input-join-d m-input-pass">
                <input name="adminPassword" class="input-focus radius-tl0 radius-tr0 xxxx sssss" name="xxx"
                       type="password" placeholder="请输入密码"/>
            </div>
            <div class="m-input-btn m-input-btn-ps">
                <input class="m-input-btn-s" type="submit" value="登录"/>
            </div>
        </div>
    </form>
</div>
</body>
</html>

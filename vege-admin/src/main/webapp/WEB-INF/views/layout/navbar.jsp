<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<div class="navbar-container" id="navbar-container">
    <!-- 小屏切换侧边栏按钮 -->
    <button type="button" class="navbar-toggle menu-toggler pull-left" id="menu-toggler">
        <span class="sr-only">切换侧边栏</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
    </button>
    <!-- 小屏切换侧边栏按钮 结束 -->
    <div class="navbar-header pull-left">
        <a href="#" class="navbar-brand">
            <small>
                <img src="/static/admin/avatars/logo.png" alt="">
                销售管理系统
            </small>
        </a>
    </div>
    <div class="navbar-buttons navbar-header pull-right" role="navigation">
        <ul class="nav ace-nav">
            <li class="light-blue">
                <a data-toggle="dropdown" href="#" class="dropdown-toggle">
                    <span>${sessionScope.admin.adminName}</span>
                    <i class="ace-icon fa fa-caret-down"></i>
                </a>
                <ul class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
                    <li>
                        <a href="/updatePasswordPage">
                            <i class="ace-icon fa fa-cog"></i>
                            修改密码
                        </a>
                    </li>
                    <li class="divider"></li>
                    <li>
                        <a href="/logout">
                            <i class="ace-icon fa fa-power-off"></i>
                            退出
                        </a>
                    </li>
                </ul>
            </li>
        </ul>
    </div>
</div>

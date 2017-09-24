<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<head>
<title>Hello</title>
</head>
<body>
 <h1>Hello, admin!</h1>
 <form action="auth/addForm" method="post">
 <table>
    <tr>
       <td>权限名称</td>
       <td><input type="text" name="authName"/></td>
    </tr>
    <tr>
       <td>权限code</td>
       <td><input type="text" name="authCode"/>
      <%--  <select name="authCode">
          <c:forEach var="a" begin="0" end="10" step="1">
             <option value="${2^a}">${2^a}</option>  
          </c:forEach>
       </select> --%>
    </tr>
    <tr>
       <td>权限类型</td>
       <td><select name="authType">
            <option value="1">菜单权限</option>
            <option value="2">按钮权限</option>
       </select> </td>
    </tr>
    <tr>
       <td>权限url</td>
       <td><input type="text" name="authUrl"/></td>
    </tr>
    <tr>
       <td>权限描述</td>
       <td><input type="text" name="authDesc"/></td>
    </tr>
    <tr>
       <td>权限排序</td>
       <td><input type="text" name="authSort"/></td>
    </tr>
    <tr>
       <td>权限父id</td>
       <td><input type="text" name="parentId"/></td>
    </tr>
    <tr>
       <td><input type="submit" value="提交表单"/></td>
       <td><input type="reset" name="取消提交"/></td>
    </tr>
 </table>
 </form>
 <form action="auth/addRoleForm" method="post">
    <table>
       <tr>
          <td>角色名称</td>
          <td><input type="text" name="roleName"/></td>
       </tr>
       <tr>
          <td>角色描述</td>
          <td><input type="text" name="roleDesc"/></td>
       </tr>
       <tr>
       <td><input type="submit" value="提交表单"/></td>
       <td><input type="reset" name="取消提交"/></td>
    </tr>
    </table>
 </form>
 <table>
    <c:forEach var="role" items="${roleList}" varStatus="status">
	    <tr>
	       <td></td>
	       <td>${role.id}</td>
	       <td>${role.roleName}</td>
	    </tr>
    </c:forEach>
    
 </table>
</body>
</html>
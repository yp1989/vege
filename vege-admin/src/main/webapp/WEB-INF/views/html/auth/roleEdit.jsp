<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body class="no-skin">
 			<div class="page-content">
			<!-- 页面内容全部放大这里 -->
			<div class="row">
				<div class="col-xs-12">
					<form id="editRoleForm" class="form-horizontal"  method="post">
					   <div class="form-group">
							<label class="col-md-1 control-label" style="width: 10%" for="form-field-1">角色名称<span class="required-star">*</span>：</label>
							<div class="col-md-9">
								<input type="text" name="roleName"  id="editRoleName" class="col-xs-10 col-sm-5">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-1 control-label" style="width: 10%" for="form-field-1">角色描述：</label>
							<div class="col-md-9">
								<input type="text" name="roleDesc" id="editRoleDesc"  class="col-xs-10 col-sm-5">
							</div>
						</div>
						<div>
						   <table border="1" style="height: 400px;width: 80%;border: 1px solid #BEBEBE;font-size: 14px">
						       <c:forEach var="auth" items="${authList}">
						          <tr style="background-color: #EAEAEA">
						             <td><input type="checkbox" name="authIdArray" value="${auth.id}" style="margin-left: 20px;">&nbsp;${auth.authName}</td>
						          </tr>
						          <c:if test="${fn:length(auth.children) > 0}">
						              <tr>
						                  <td>
						                     <c:forEach var="authChild" items="${auth.children}">
						                         <input type="checkbox" name="authIdArray" value="${authChild.id}" style="margin-left: 50px">&nbsp;${authChild.authName}&nbsp;
						                     </c:forEach>  
						                  </td>
						              </tr>
						          </c:if>
						           
						       </c:forEach>
						       
						   </table>
						</div>
						<div class="form-group" style="margin-top: 20px">
							<div class="col-md-5">
								<button type="button" id="savaBtn" class="btn btn-sm btn-primary" style="width: 100px;">保存</button>
								<button type="button" id="savaAddBtn" class="btn btn-sm btn-default"  style="width: 100px;">保存并新增</button>
							</div>
						</div>
						<input id="reset" type="reset" style="display:none;" />
					</form>
				</div>
			</div>					
			<!-- 页面内容全部放大这里 结束 -->
			<script type="text/javascript" src="/static/admin/js/crm/auth/auth.js" ></script>
		</div> 
</body>

</html>

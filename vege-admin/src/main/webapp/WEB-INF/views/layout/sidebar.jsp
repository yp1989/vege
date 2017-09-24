<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
         <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<ul class="nav nav-list">
<c:forEach var="auth" items="${sessionScope.authList}" varStatus="index" >
	<li class="${auth.authUrl}">
	    <a href="${pageContext.request.contextPath}${auth.authUrl}"  <c:if test="${auth.children != null}">class="dropdown-toggle"</c:if>>
	      <i class="menu-icon fa ${auth.authImg}" ></i>
	      <span class="menu-text"> ${auth.authName}</span>
	      
	      <c:if test="${auth.children != null}">
	         <b class="arrow fa fa-angle-down"></b>
	      </c:if>
	    </a> 
	    <ul class="submenu nav-show" >
		    <c:forEach var="authChild" items="${auth.children}">
		        <li class="${authChild.authUrl}">
			        <a href="${authChild.authUrl}">
						<i class="menu-icon fa fa-caret-right"></i>
						${authChild.authName}
					</a>
					<b class="arrow"></b>
				</li>
		    </c:forEach>
	    </ul>
	</li>
</c:forEach>

</ul>
<div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
  <i class="ace-icon fa fa-angle-double-left" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
</div>
<script>
   $(function(){
	   var url =window.location.href;
	   var li = $(".nav-list li");
	   $(".nav-list li").each(function() {
		   var className = $(this).attr("class");
		   
		   if(className != null){
			  className = $.trim(className.replace("hsub",""));
			  if(className != ""){
				 // alert(className+"===="+ url.indexOf(className));
				  if(url.indexOf(className) > -1 ){
						$(this).addClass("active");
						var s = $(this).parent().attr("class");
						
						if($(this).parent().attr("class").indexOf("submenu") > -1){
							$(this).parent().parent().addClass("open");
							$(this).parent().show();
						}
							
					} 
			  }
			  
		   }
			
	    });
   });
</script>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>合同管理</title>
</head>
<body>
	<div class="page-content">

		<!-- 页面内容全部放大这里 -->
		<div class="row">
		     <div class="col-md-12">
				<form class="form-horizontal" role="form" action="/contract/contractPage" method="post" id="findForm">
					<input type="hidden" id="pageNo" name="pageNo" value="${page.pageNo}"/>
					<div class="col-md-3 pb10 no-padding-left">
						<div class="input-group">
							<span class="input-group-addon">
								客户名称
							</span>
							<input type="text" name="cust" placeholder="请输入客户名称" value="${contract.cust}" class="input-sm form-control">
						</div>
					</div>
					<div class="col-md-3 pb10 no-padding-left">
						<div class="input-group">
							<span class="input-group-addon">
								日期
							</span>
							<div class="input-daterange input-group">
								<input type="text" class="input-sm form-control" name="createStartTime" value='<fmt:formatDate value="${contract.createStartTime}" pattern="yyyy-MM-dd"/>'>
								<span class="input-group-addon">
									<i class="fa fa-exchange"></i>
								</span>

								<input type="text" class="input-sm form-control" name="createEndTime" value='<fmt:formatDate value="${contract.createEndTime}" pattern="yyyy-MM-dd"/>'>
							</div>
						</div>
					</div>
					<div class="col-md-3 pb10 no-padding-left">
						<div class="input-group">
							<span class="input-group-addon">
								状态
							</span>
							<select class="input-sm form-control" name="contStatus">
								<option value="">全部</option>
								<c:forEach items="${statusEnum}" var="st" varStatus="index">
									<option value="${st.code}" <c:if test="${contract.contStatus == st.code}">selected</c:if>>${st.desc}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="col-md-3 pb10 no-padding-left">
						<div class="input-group">
							<span class="input-group-addon">
								归属人
							</span>
							<input type="text" name="ownerName" placeholder="请输入归属人姓名" value="${contract.ownerName}" class="input-sm form-control">
						</div>
					</div>
					<div class="col-md-3 pb10 no-padding-left">
						<div class="input-group">
							<span class="input-group-addon">
								预购套餐
							</span>
							<div class="selected_box">
								<input type="hidden" value="" id="myselect" />
								<input type="text" readonly="readonly" id="versShowName" class="pl5 package_btn" value="请选择" >
								<div class="select_ul">
									<ul>
									    <c:forEach items="${versions}" var="version" varStatus="index">
											<li>
												<div class="checkbox">
													<label>
														<input  name="versionIds" 
                                                            <c:forEach items="${contract.versionIds}" var="ids">
														         <c:if test="${version.id == ids}">
														             checked="checked"
														          </c:if>
													         </c:forEach>
                                                             type="checkbox" class="ace" value="${version.id}"> 
														<span class="lbl" id="lbl${version.id}"> ${version.versName}</span>
													</label>
												</div>
											</li>
									    </c:forEach>
									</ul>
									<div class="mb10 mt10 mr10 text-right">
										<button type="button" class="selectOk btn btn-primary btn-sm">保存</button>
									</div>
								</div>
							</div>
						</div>
					</div>
					
					<div class="col-md-3 pb10 no-padding-left">
						<div class="input-group">
							<span class="input-group-addon">
								未收款
							</span>
							<select class="input-sm form-control" name="uncollected">
								<option value="">全部</option>
								<c:forEach items="${unGatheringEnum}" var="unGathering" varStatus="index">
									<option value="${unGathering.code}" <c:if test="${contract.uncollected == unGathering.code}">selected</c:if>>${unGathering.desc}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="col-md-3 pb10 no-padding-left">
						<div class="input-group">
							<span class="input-group-addon">
								合同类型
							</span>
							<select class="input-sm form-control" name="contType">
								<option value="">全部</option>
								<c:forEach items="${typeEnum}" var="type" varStatus="index">
									<option value="${type.code}" <c:if test="${contract.contType == type.code}">selected</c:if>>${type.desc}</option>
								</c:forEach>
							</select>
						</div>
						
					</div>
					
					<button type="submit" class="btn btn-sm btn-primary btn_normal" data-fn="submit">查询</button>
				</form>
			</div>
			
			<div class="col-xs-12">
				<table id="sample-table-1" class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th class="center">
								<label class="position-relative">
									<input type="checkbox" class="ace">
									<span class="lbl"></span>
								</label>
							</th>
							<th>序号</th>
							<th>合同编号</th>
							<th>日期</th>
							<th>客户名称</th>
							<th>合同类型</th>
							<th>合同状态</th>
							<th>归属人</th>
							<th>来源</th>
							<th>购买套餐</th>
							<th>线索录入人</th>
							<th>应收款</th>
							<th>已收款</th>
							<th>未收款</th>
							<th>操作</th>
						</tr>
					</thead>

					<tbody>
					    <c:forEach var="contract"  items="${page.results}" varStatus="index">
							<tr class="selected">
								<td class="center">
									<label class="position-relative">
										<input type="checkbox" class="ace">
										<span class="lbl"></span>
									</label>
								</td>
								<td>${index.index+1}</td>
								<td>${contract.contNumber}</td>
								<td><fmt:formatDate value="${contract.createTime}" pattern="yyyy-MM-dd HH:mm:ss "/></td>
								<td><a href="/clue/toShowClue?clueId=${contract.clue_id}">${contract.cust}</a></td>
								<td>
								    <c:forEach items="${typeEnum}" var="type">
								       <c:if test="${contract.contType == type.code}">
								          ${type.desc}
								       </c:if>
									</c:forEach>
								</td>
								<td>
								    <c:forEach items="${statusEnum}" var="st">
										<c:if test="${contract.contStatus == st.code}">
								          ${st.desc}
								        </c:if>
									</c:forEach>
								</td>
								<td>${contract.ownerName}</td>
								<td>${contract.ownerName}</td>
								<td>
								    <c:forEach var="version" items="${contract.versionList}">
								        ${version.versName}&nbsp;
								    </c:forEach>
								</td>
								<td>${contract.adminName}</td>
								<td>${contract.contReceivable}</td>
								<td>${contract.contCollected}</td>
								<td>${contract.contUncollected}</td>
								<td>
								    <a class="mr20" onclick="checkContract('${contract.id}');" data-toggle="modal" data-target="#contractInfo">查看</a>
								    <!-- 合同审核中 -->
								    <c:if test="${contract.contStatus == 1}">
								          <a name="checkBtn" class="mr20" data-toggle="modal" data-target="#modal_checkClose" style="display: none;" onclick="audit('${contract.id}','${contract.busiId}');">审核</a>
								          <a name="cancelBtn" onclick="contractCancel('${contract.id}');" style="display: none;" class="mr20">作废</a>
								    </c:if>
								    <c:if test="${contract.contStatus == 2}">
								       <c:if test="${contract.accStatus == 0}">
								          <a href="/contract/contractAcc?id=${contract.id}&accStatus=2" class="mr20">开通账号</a>
								       </c:if>
								       <c:if test="${contract.accStatus == 1}">
								          已开通
								       </c:if>
								       <c:if test="${contract.accStatus == 2}">
								         开通中
								       </c:if>
								    </c:if> <!-- href="/contract/downLoad?fileName=easyui.css" -->
								    <a class="mr20" href="/contract/downLoad?id=${contract.id}" >下载</a>
									
								</td>
							</tr>
                                 </c:forEach>
						
					</tbody> 
				</table>
				<%@include file="/WEB-INF/views/common/pagination.jsp" %>
			</div>
		</div>	
		 				
		<!-- 页面内容全部放大这里 结束 -->
	</div>
	<!--查看合同弹窗-->
	<div class="modal fade" id="contractInfo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	   <div class="modal-dialog">
		    <div class="modal-content">
		      	<div class="modal-header">
				    <button type="button" class="close" data-dismiss="modal" onclick="cancelCheck();"
				       aria-hidden="true">×
				    </button>
				    <h4 class="modal-title" id="myModalLabel">
				        合同信息
				    </h4>
				</div>
				<div class="modal-body" id="contractInfoDiv">
				     <p class="form-control-static" >签约时间：<span id="contSigntime"></span></p>
				     <p class="form-control-static">客户名称：<span id="cust"></span></p>
				     <p class="form-control-static">归属人：<span id="ownerName"></span></p>
				     <p class="form-control-static">客户地址：<span id="addr"></span></p>
				     <p class="form-control-static">详细地址：<span id="custAddr"></span></p>
				     <div id="custDiv"></div>
				     <div id="versionDiv"></div>
				     <p class="form-control-static">备注：<span id="contRemark"></span></p>
				</div>
				<div class="modal-footer">
				    <button type="button" class="btn btn-default btn-sm" data-dismiss="modal" onclick="cancelCheck();">关闭</button>
				</div>
		    </div>
	   </div>
	</div>
	
	<!--审核-->
		<div class="modal fade" id="modal_checkClose" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		    <div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-body">
					    <p class="modal_closeTip text-center">是否审核通过？</p>
					</div>
					<form id="contractCheckForm" method="post">
					    <input type="hidden" id="cont_id" name="id">
					    <input type="hidden" id="cont_status" name="contStatus">
					    <input type="hidden" id="busi_id" name="busiId">
					    <div class="modal-footer">
						    <button type="button" class="btn btn-primary btn-sm" onclick="makeSurePass(2);">确认通过</button>
						    <button type="button" class="btn btn-default btn-sm back_edit">退回修改</button>
						</div>
						<div class="modal_more">
					    	<p class="form-control-static">请输入退回修改原因：</p>
					    	<textarea id="form-field-11" class="autosize-transition form-control" name="returnChangeRemark"></textarea>
					    	<div class="text-right">
					    		<button type="button" class="btn btn-primary btn-sm mt10" data-dismiss="modal" onclick="makeSurePass(4);">提交</button>
					    	</div>
					    </div>
					</form>
					
				</div><!-- /.modal-content -->
		    </div><!-- /.modal-dialog -->
		</div>
		<script src="/static/admin/js/crm/contract/contract.js"></script>
		<script>
		    /**
		     * 审核弹框按钮事件
		     */
			$(".modal_more").hide();
			$(".back_edit").on("click",function(){
				$(".modal_more").show();
			}) 
			
			
			$(function(){
				
				//下拉框
				var $ul = $(".selected_box .select_ul");
				var $thisinput = $(".selected_box .package_btn");
				$thisinput.on("click",function() {			
					$ul.show();
				});
				$(".selectOk").on("click",function() {
					var chk_value =[]; 
					$ul.find("input[type=checkbox]:checked").each(function(){ 
						chk_value.push($(this).next().text()); 
					});
					if(!chk_value.length){
						$thisinput.val("请选择");
						$("#myselect").val("请选择");
					}else{
						$thisinput.val(chk_value);
						$("#myselect").val(chk_value);
					}
					$ul.fadeOut("fast");
				});					
				var text = "";
				$ul.find("input[type=checkbox]:checked").each(function(){ 
					var spanText = $("#lbl"+$(this).val()).html();
					text += spanText; 
				});
				if(text != null && text != ""){
					$("#versShowName").val(text);
				}
				
				//按钮权限
				$sumCode =$("#sumCode").val();
				if($sumCode != null ){
					if(($sumCode&64) == 64){
						$("a[name='checkBtn']").show();
					}
					if(($sumCode&128) == 128){
						$("a[name='cancelBtn']").show();
					}
				}
			}) 
		</script>
</body>
</html>
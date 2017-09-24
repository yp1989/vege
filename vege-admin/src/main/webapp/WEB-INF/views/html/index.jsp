<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>线索管理</title>
		<meta name="description" content="overview &amp; stats" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
		<!-- css样式表异步加载 在/layout/stylesheets.html内 -->
	</head>

	<body class="no-skin">
			<div class="main-content">
				<div class="page-content">
					<!-- 页面内容全部放大这里 -->
					<div class="row">
						<div class="col-md-12">
							<form class="form-horizontal" role="form">
								<div class="col-md-3 pb10 no-padding-left">
									<div class="input-group">
										<span class="input-group-addon">
											客户名称
										</span>
										<input type="text" placeholder="请输入客户名称" class="input-sm form-control">
									</div>
								</div>
								<div class="col-md-3 pb10 no-padding-left">
									<div class="input-group">
										<span class="input-group-addon">
											线索状态
										</span>
										<select class="input-sm form-control" name="" id="">
											<option value="">全部</option>
											<option value="">未回访</option>
											<option value="">已回访</option>
										</select>
									</div>
								</div>
								<div class="col-md-3 pb10 no-padding-left">
									<div class="input-group">
										<span class="input-group-addon">
											创建时间
										</span>								
										<div class="input-daterange input-group">
											<input type="text" class="input-sm form-control" name="start">
											<span class="input-group-addon">
												<i class="fa fa-exchange"></i>
											</span>

											<input type="text" class="input-sm form-control" name="end">
										</div>
									</div>
								</div>
								<div class="col-md-3 pb10 no-padding-left">
									<div class="input-daterange input-group">
										<span class="input-group-addon">
											分配时间
										</span>
										<div class="input-daterange input-group">
											<input type="text" class="input-sm form-control" name="start">
											<span class="input-group-addon">
												<i class="fa fa-exchange"></i>
											</span>

											<input type="text" class="input-sm form-control" name="end">
										</div>
									</div>
								</div>						
								<div class="col-md-3 pb10 no-padding-left">
									<div class="input-group">
										<span class="input-group-addon">
											联系方式
										</span>
										<input type="text" placeholder="请输入联系方式"  class="input-sm form-control">
									</div>
								</div>
								<div class="col-md-3 pb10 no-padding-left">
									<div class="input-group">
										<span class="input-group-addon">
											省份
										</span>
										<select class="input-sm form-control" name="" id="">
											<option value="">全国</option>
											<option value="">上海</option>
											<option value="">北京</option>
										</select>
									</div>
								</div>
								<div class="col-md-3 pb10 no-padding-left">
									<div class="input-group">
										<span class="input-group-addon">
											城市
										</span>
										<select class="input-sm form-control" name="" id="">
											<option value="">上海</option>
											<option value="">北京</option>
										</select>
									</div>
								</div>
								<div class="col-md-3 pb10 no-padding-left">
									<div class="input-group">
										<span class="input-group-addon">
											线索类型
										</span>
										<select class="input-sm form-control" name="" id="">
											<option value="">咨询产品</option>
											<option value="">咨询代理</option>
										</select>
									</div>
								</div>
								<div class="col-md-3 pb10 no-padding-left">
									<div class="input-group">
										<span class="input-group-addon">
											线索来源
										</span>
										<select class="input-sm form-control" name="" id="">
											<option value="">系统分单</option>
											<option value="">咨询代理</option>
										</select>
									</div>
								</div>
								<div class="col-md-3 pb10 no-padding-left">
									<div class="input-group">
										<span class="input-group-addon">
											归属人
										</span>
										<select class="input-sm form-control" name="" id="">
											<option value="">咨询产品</option>
											<option value="">咨询代理</option>
										</select>
									</div>
								</div>
								<div class="col-md-3 pb10 no-padding-left">
									<div class="input-group">
										<span class="input-group-addon">
											预购产品
										</span>
										<select class="input-sm form-control" name="" id="">
											<option value="">咨询产品</option>
											<option value="">咨询代理</option>
										</select>
									</div>
								</div>
								<div class="col-md-3 pb10 no-padding-left">
									<div class="input-group">
										<span class="input-group-addon">
											成交意向
										</span>
										<select class="input-sm form-control" name="" id="">
											<option value="">咨询产品</option>
											<option value="">咨询代理</option>
										</select>
									</div>
								</div>
								<div class="col-md-3 pb10 no-padding-left">
									<div class="input-group">
										<span class="input-group-addon">
											了解方式
										</span>
										<select class="input-sm form-control" name="" id="">
											<option value="">咨询产品</option>
											<option value="">咨询代理</option>
										</select>
									</div>
								</div>
								<button type="button" class="btn btn-sm btn-primary" data-fn="submit">查询</button>
							</form>
						</div>
						<div class="col-md-12">
							<a href="callCenter_add.html" class="btn btn-primary btn-sm btn-filter">新增线索</a>
							<a href="#" class="btn btn-primary btn-sm btn-filter">线索分配</a>
						</div>
					</div>
					<div class="row">
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
										<th>编号</th>
										<th>创建时间</th>
										<th>分配时间</th>
										<th>客户名称</th>
										<th>联系人</th>
										<th>线索状态</th>
										<th>线索来源</th>
										<th>了解方式</th>
										<th>归属人</th>
										<th>线索类型</th>
										<th>录入人</th>
										<th>操作</th>
									</tr>
								</thead>

								<tbody>
									<tr class="selected">
										<td class="center">
											<label class="position-relative">
												<input type="checkbox" class="ace">
												<span class="lbl"></span>
											</label>
										</td>
										<td>10001</td>
										<td>2015-03-09</td>
										<td>2015-03-09</td>
										<td>邮政速递物流有限公司</td>
										<td>xxx</td>
										<td>未分配</td>
										<td>系统分单</td>
										<td>PC官网</td>
										<td>系统资源</td>
										<td>咨询代理</td>
										<td>蒋雪妮</td>
										<td>
											<a href="callCenter_look.html" class="mr20">查看</a>
											<a href="#" class="mr20">编辑</a>
											<a href="#" class="mr20">关闭</a>
										</td>
									</tr>

									
								</tbody>
							</table>
							<div class="form-inline">
								<div class="form-group">
									<ul class="pagination">
										<li><a href="#">首页</a></li>
										<li><a href="#">上一页</a></li>
										<li class="active"><a href="#">1<span class="sr-only">(current)</span></a></li>
										<li><a href="#">2</a></li>
										<li><a href="#">3</a></li>
										<li><a href="#">4</a></li>
										<li><a href="#">5</a></li>
										<li><a href="#">下一页</a></li>
										<li><a href="#">尾页</a></li>
									</ul>
								</div>
								<div class="form-group margin-left-10">共 10 页 第</div>
								<div class="form-group font-size-0">
									<div class="form-group has-error">
										<label for="pagination-input" class="sr-only">pagination-input</label>
										<input type="text" class="form-control vcard-input-page" id="pagination-input">
									</div>
									<div class="form-group">
										<button type="submit" class="btn btn-danger vcard-btn-page">GO</button>
									</div>
								</div>
								<div class="form-group">页</div>
							</div>
						</div>
					</div>					
					<!-- 页面内容全部放大这里 结束 -->
				</div>
			</div>
	</body>
</html>

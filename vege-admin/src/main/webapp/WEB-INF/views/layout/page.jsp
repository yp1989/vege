<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
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
			<button type="submit" class="btn btn-danger vcard-btn-page btn-sm">GO</button>
		</div>
	</div>
	<div class="form-group">页</div>
</div>
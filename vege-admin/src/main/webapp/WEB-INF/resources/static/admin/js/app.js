;$(function(){
	$('.dateRangePicker').daterangepicker({
		'applyClass' : 'btn-sm btn-success',
		'cancelClass' : 'btn-sm btn-default',
		locale: {
			applyLabel: '确定',
			cancelLabel: '取消'
		}
	}).on("apply.daterangepicker",function(ev,picker){
    var start = picker.startDate.format('YYYY-MM-DD');
    var end = picker.endDate.format('YYYY-MM-DD');
    $(this).attr("data-start",start);
    $(this).attr("data-end",end);
  });
  	//日期控件
	$('.date-picker').datepicker({
		autoclose: true,
		todayHighlight: true,
    format:'yyyy-mm-dd'
	});
	$('.input-daterange').datepicker({
    format:'yyyy-mm-dd',
    autoclose:true
  });
	//table全选
	$(document).on('click', 'th input:checkbox' , function(){
		var that = this;
		$(this).closest('table').find('tr > td:first-child input:checkbox')
		.each(function(){
			this.checked = that.checked;
			$(this).closest('tr').toggleClass('selected');
		});
	});
});

$.extend({
	confirm:function(options){
		var msg = options.msg;
		var callback = options.callback;
		var su = options.suretext?options.suretext:'确定';
		$('body').append('<div class="extendpop"><div class="popbox"><p class="text">'+msg+'</p><p class="extendbtn confirm"><a href="javascript:;" data-do="no">取消</a><a href="javascript:;" data-do="yes">'+su+'</a></p></div></div>');
		var pop = $('.extendpop');
		$('.extendpop a[data-do="no"]').click(function(){
			pop.remove();
			callback(0);
		});
		$('.extendpop a[data-do="yes"]').click(function(){
			pop.remove();
			callback(1);
		});
	},
	alert:function(options){
		var msg = options.msg;
		$('body').append('<div class="extendpop"><div class="popbox"><p class="text">'+msg+'</p><p class="extendbtn alert"><a href="javascript:;" data-do="yes">确定</a></p></div></div>');
		var pop = $('.extendpop');
		$('.extendpop a[data-do="yes"]').click(function(){
			pop.remove();
			if(options.callback){
				 options.callback();
			}
		});
	},
	tipshow:function(options){
		var msg = options.msg;
		var type = options.type?options.type:'info';
		var ico = options.ico?options.ico:'fa-info-circle';
		var str = '<div class="tippop"><div class="text '+type+'"><i class="fa '+ico+'"></i>'+msg+'</div></div>';
		$('body').append(str);
		var pop = $('.tippop');
		setTimeout(function(){
			pop.animate({'opacity':0},600,function(){
				pop.remove();
				if(options.callback){
					options.callback();
				}
			});
		},1200);
	},
	tiplist:function(options){
		$('.tiplistfixed').length<=0?$('body').append('<div class="tiplistfixed"></div>'):'';
		var box = $('.tiplistfixed');
		var len = $('.tiplistfixed').children().length+1;
		var msg = options.msg;
		var type = options.type?options.type:'info';
		var ico = options.ico?options.ico:'fa-info-circle';
		var close = options.close?'<i class="fa fa-times close"></i>':'';
		var str = '<div class="item item'+len+'"><div class="text '+type+'"><i class="fa '+ico+'"></i>'+msg+'</div>'+close+'</div>';
		box.append(str);
		var self = box.find('.item'+len);
		if(options.close){
			self.find('.close').click(function(){
				self.remove();
				if(options.callback){
					options.callback();
				}
				if(box.children().length==0){
					box.remove();
				}
			});
		}else{
			setTimeout(function(){
				self.slideUp(600,function(){
					self.remove();
					if(options.callback){
						options.callback();
					}
					if(box.children().length==0){
						box.remove();
					}
				});
			},3000);
		}
	},
	getWarnMessage:function(msg){
		$.tipshow({
			'msg':msg,
			'type':'waring'
		});
	},
	getNormalMessage:function(msg){
		$.tipshow({
			'msg':msg,
			'type':'info',
			'ico':'fa-check-circle-o'
		});
	}
})



$.fn.validate = function(){
    var inps = $(this).find('input[data-regex]');
    var out = "no";
    var checkstr = /\s/ig;
    inps.each(function(i,n){
        var val=$(this).val().replace(checkstr,'');
        var type = $(this).attr('data-regex');
        var text = $(this).attr('data-regstr');
        if(type=="text"){
            if(val==""){
                out = 'yes';
                $.tipshow({'msg':text+'不可为空','type':'waring'});
                $(this).focus();
                $(this).val('');
                return false;
            }
        }else if(type=="email"){
        	var regemail = /^[0-9a-z]+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*/ig;
            if(!(regemail.test(val))){
                $.tipshow({'msg':text+'格式不正确','type':'waring'});
                $(this).focus();
                $(this).val('');
                out = 'yes';
                return false;
            }
        }else if(type=="phone"){
        	var regphone = /^[1][0-9]{10}$/ig;
            if(!(regphone.test(val))){
                $.tipshow({'msg':text+'格式不正确','type':'waring'});
                $(this).focus();
                $(this).val('');
                out = 'yes';
                return false;
            }
        }else if(type=="number"){
        	var number = /^[0-9]{1,}$/ig;
            if(!(number.test(val))){
                $.tipshow({'msg':text+'格式不正确','type':'waring'});
                $(this).focus();
                $(this).val('');
                out = 'yes';
                return false;
            }
        }else if(type=="ch"){
        	var chiness = /^[\u4e00-\u9fa5]{1,}$/ig;
            if(!(chiness.test(val))){
                $.tipshow({'msg':text+'含有非中文字符','type':'waring'});
                $(this).focus();
                $(this).val('');
                out = 'yes';
                return false;
            }
        }else if(type=="eg"){
        	var chiness = /^[a-zA-Z]{1,}$/ig;
            if(!(chiness.test(val))){
                $.tipshow({'msg':text+'含有非英文字符','type':'waring'});
                $(this).focus();
                $(this).val('');
                out = 'yes';
                return false;
            }
        }
    });
    if(out=="yes"){return false;}
    return true;
}
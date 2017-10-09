/**
 * Created by xinbaojian on 15/8/3.
 */
var Business = function () {

    var bingClick = function () {
        $('body').on('click', '.back_edit', function () {//退回修改
            var hide = $('.modal_more').hasClass('hide');
            if (hide) {
                $('.modal_more').removeClass('hide');
                $('.modal_more').addClass('show');
                $('#audit_pass').val("0");
            } else {
                $('.modal_more').removeClass('show');
                $('.modal_more').addClass('hide');
                $('#audit_pass').val("1");
            }
        }).on('click', '.sure_confirm', function () {//审核通过
            $('#audit_pass').val("1");
            //$('#auditing_form').submit();
            var params = $('#auditing_form').serialize();
            $.ajax({
                url: '/business/auditing?' + params,
                type: 'POST',
                dataType: 'json',
                data: {},
                success: function (data) {
                    $.getNormalMessage(data.msg);
                    $('.btn_normal').click();
                }
            });

        }).on('click', '#auditing_shenhe', function () {//审核按钮
            var dataId = $(this).attr('data-id');
            $("#audit_busiId").val(dataId);
        }).on('click', '.auditing-mt10', function () {//退回提交
            //$('#auditing_form').submit();
            var params = $('#auditing_form').serialize();
            $.ajax({
                url: '/business/auditing?' + params,
                type: 'POST',
                dataType: 'json',
                data: {},
                success: function (data) {
                    if (data.code = 1) {
                        $.getNormalMessage(data.msg);
                    } else {
                        $.getWarnMessage(data.msg);
                    }
                    $('.btn_normal').click();
                }
            });
        }).on('click', '#businessClose', function () {
            var id = $(this).attr("data-id");
            $.confirm({
                'msg': '是否确定关闭该线索？', 'suretext': '确定', 'callback': function (data) {
                    if (data) {
                        window.location.href = '/business/close?busiId=' + id;
                    }
                }
            });
        }).on('click', '.busi_allot', function () {
            $('.close').click();
            var params = $('.busi_allot').parents('form').serialize();
            $.ajax({
                url: '/business/distribution?' + params,
                type: 'POST',
                dataType: 'json',
                data: {},
                success: function (data) {
                    if (data.code == 1) {
                        $.getNormalMessage(data.msg);
                    } else {
                        $.getWarnMessage(data.msg);
                    }
                    $('.btn_normal').click();
                }
            });

        });
    }

    return {
        init: function () {
            bingClick();
        }
    }

}();

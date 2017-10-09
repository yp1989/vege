/**
 * Created by xinbaojian on 15/8/4.
 */
var Package = function () {

    var calcTrs = function (tr) {
        var trs = {};
        var standAmount = parseFloat($(tr).find('.Standard_amount').text());
        trs.standAmount = standAmount;
        var actualAmount = $(tr).find('.Actual_amount input').val();
        trs.actualAmount = actualAmount == '' ? 0.0 : parseFloat(actualAmount);
        var countNum = $(tr).find('.count_num input').val();
        trs.countNum = countNum == '' ? 0.0 : parseFloat(countNum);
        //计算折扣
        var discount = actualAmount / standAmount * 10;
        discount = discount.toFixed(2);
        trs.discount = discount == '' ? 0.0 : parseFloat(discount);
        $(tr).find('.Discount input').val(trs.discount);
        var zongRenTian = $(tr).find('.zong_ren_tian input').val();
        trs.zongRenTian = zongRenTian == '' ? 0.0 : parseFloat(zongRenTian);
        var renTianDanJia = $(tr).find('.ren_tian_dan_jian input').val();
        trs.renTianDanJia = renTianDanJia == '' ? 0.0 : parseFloat(renTianDanJia);
    }

    var calcTotal = function () {
        var trsArray = new Array();
        $('.selected').each(function () {
            var trs = {};
            var standAmount = parseFloat($(this).find('.Standard_amount').text());
            trs.standAmount = standAmount;
            var actualAmount = $(this).find('.Actual_amount input').val();
            trs.actualAmount = actualAmount == '' ? 0.0 : parseFloat(actualAmount);
            var countNum = $(this).find('.count_num input').val();
            trs.countNum = countNum == '' ? 0.0 : parseFloat(countNum);
            var discount = $(this).find('.Discount input').val();
            trs.discount = discount == '' ? 0.0 : parseFloat(discount);
            var zongRenTian = $(this).find('.zong_ren_tian input').val();
            trs.zongRenTian = zongRenTian == '' ? 0.0 : parseFloat(zongRenTian);
            var renTianDanJia = $(this).find('.ren_tian_dan_jian input').val();
            trs.renTianDanJia = renTianDanJia == '' ? 0.0 : parseFloat(renTianDanJia);
            trsArray.push(trs);
        });
        var totals = {
            standAmount: 0.0,
            actualAmount: 0.0,
            countNum: 0.0,
            discount: 0.0,
            zongRenTian: 0.0,
            renTianDanJia: 0.0
        };
        for (var i = 0; i < trsArray.length; i++) {
            totals.standAmount = totals.standAmount + trsArray[i].standAmount * trsArray[i].countNum;
            totals.actualAmount = totals.actualAmount + trsArray[i].actualAmount * trsArray[i].countNum;
            totals.countNum = totals.countNum + trsArray[i].countNum;
            totals.discount = totals.discount + trsArray[i].discount;
            totals.zongRenTian = totals.zongRenTian + trsArray[i].zongRenTian;
            totals.renTianDanJia = totals.renTianDanJia + trsArray[i].renTianDanJia;
        }
        ;
        //设置合计的值
        $('.heji .Standard_amount').text(totals.standAmount);
        $('.heji .Actual_amount').text(totals.actualAmount);
        $('.heji .Actual_amount input').val(totals.actualAmount);
        $('.heji .count_num').text(totals.countNum);
        //$('.heji .Discount').text(totals.discount);
        //$('.heji .zong_ren_tian').text(totals.zongRenTian);
        //$('.heji .ren_tian_dan_jian').text(totals.renTianDanJia);
    }

    var getDisabled = function (prodType) {
        if (prodType == '1') {
            return 'disabled';
        } else if (prodType == '0') {
            return '';
        }
    }

    var changeTrs = function (obj) {
        var id = $(obj).val();
        var name = $(obj).attr('data-name');
        var versPrice = $(obj).attr('data-standardamount');
        var prodType = $(obj).attr('data-producttype');
        var prodId = $(obj).attr('data-pro-id');
        var checked = $(obj).is(':checked');
        var index = $('.selected').length;
        $('.selected').each(function () {
            var dataId = $(this).attr('data-v-id');
            if (id == dataId) {
                if (!checked) {
                    $(this).remove();
                    calcTotal();
                }
            }
        });
        if (checked) {
            var trhtml = '<tr class="selected" data-v-id="' + id + '">\
                        <td>' + name + '<input type="hidden" name="contProducts[' + (index + 1) + '].prodId" value="' + prodId + '"/></td>\
                        <td class="count_num"><input type="text"  name="contProducts[' + (index + 1) + '].buyCount" class="col-xs-10 col-sm-5" value=""></td>\
                        <td class="Standard_amount">' + versPrice + '<input type="hidden" name=""/></td>\
                        <td class="Actual_amount"><input type="text"  name="contProducts[' + (index + 1) + '].actualAmount" class="col-xs-10 col-sm-5" value=""></td>\
                        <td class="zong_ren_tian"><input type="text" ' + getDisabled(prodType) + ' name="contProducts[' + (index + 1) + '].sumMenday" class="col-xs-10 col-sm-5" value=""></td>\
                        <td class="ren_tian_dan_jian"><input type="text" ' + getDisabled(prodType) + ' name="contProducts[' + (index + 1) + '].priceMenday" class="col-xs-10 col-sm-5" value=""></td>\
                        <td class="Discount"><input type="text"  name="contProducts[' + (index + 1) + '].prodDiscount" class="col-xs-10 col-sm-5" value=""></td>\
                    </tr>';
            $('.heji').before(trhtml);
            calcTotal();
        }

    }

    var changeAgentTrs = function (obj) {
        var id = $(obj).val();
        var name = $(obj).attr('data-name');
        var prodId = $(obj).attr('data-pro-id');
        var checked = $(obj).is(':checked');
        var index = $('.selected').length;
        $('.selected').each(function () {
            var dataId = $(this).attr('data-v-id');
            if (id == dataId) {
                if (!checked) {
                    $(this).remove();
                    calcAgentTotal();
                }
            }
        });
        if (checked) {
            console.log(name + " " + prodId);
            var trhtml = '<tr class="selected" data-v-id="' + id + '">\
                        <td>' + name + '<input type="hidden" name="contProducts[' + (index + 1) + '].prodId" value="' + prodId + '"/>\
                        <input type="hidden" name="contProducts[' + (index + 1) + '].versId" value="' + prodId + '"/>\
                        </td>\
                        <td class="Actual_amount"><input type="text"  name="contProducts[' + (index + 1) + '].actualAmount" class="col-xs-10 col-sm-5 agentInput" value=""></td>\
                        </tr>';
            $('.heji').before(trhtml);
        }
    }

    var checkControct = function (contType) {
        var result = true;
        //检验邮箱
        $('.form-horizontal input[type="text"]').each(function () {
            var name = $(this).attr('name');
            if (name == undefined) {
                return true;
            }
            if (name.indexOf('custName') > 0) {
                if ($(this).val() == '') {
                    $.getWarnMessage("联系人不能为空!");
                    result = false;
                    return false;
                }
            }
            if (name.indexOf('custPhone') > 0) {
                if ($(this).val() == '') {
                    $.getWarnMessage("电话不能为空!");
                    result = false;
                    return false;
                }
            }
            if (name.indexOf('custEmail') > 0) {
                if ($(this).val() == '') {
                    $.getWarnMessage("邮箱不能为空!");
                    result = false;
                    return false;
                }
            }
            if (name.indexOf('actualAmount') > 0) {
                if ($(this).val() == '') {
                    $.getWarnMessage("实际金额不能为空!");
                    result = false;
                    return false;
                }
            }
            if (name.indexOf('buyCount') > 0) {
                if ($(this).val() == '') {
                    $.getWarnMessage("数量不能为空!");
                    result = false;
                    return false;
                }
            }

        });
        if (!result) {
            return false;
        }

        var index = 0;
        $('input[type="file"]').each(function (n, file) {
            if ($(file).val() != '') {
                index = index + 1;
            }

        });
        if (index == 0) {
            $.tipshow({
                'msg': '请选择上传文件!',
                'type': 'waring'
            });
            return false;
        }

        $('.form-horizontal select').each(function () {
            var name = $(this).attr('name');
            console.log(name);
            if (name == 'contract.contServiceLevel') {
                if ($(this).val() == '') {
                    $.getWarnMessage("请选择服务级别!");
                    result = false;
                    return false;
                }
            }
            if (name == 'contract.contCategory') {
                if ($(this).val() == '') {
                    $.getWarnMessage("请选择类别!");
                    result = false;
                    return false;
                }
            }
            if (name == 'contract.agentLevel') {
                if ($(this).val() == '') {
                    $.getWarnMessage("请选择代理商级别!");
                    result = false;
                    return false;
                }
            }
        });
        if (!result) {
            return false;
        }
        if ($('input[type="checkbox"]:checked').length <= 0) {
            $.getWarnMessage("请选择购买产品!");
            result = false;
            return false;
        }

        return result;
    }

    var bindClick = function () {
        $('body').on('change', '.selected input', function () {
            calcTrs($(this).parents('tr'));
            calcTotal();

        }).on('change', '.selectedagent input', function () {
            //计算合计
            var numTotal = 0;
            $('.selectedagent').each(function () {
                $(this).attr("data-v-price", $(this).find('.Standard_amount input').val());
                numTotal += parseInt($(this).attr("data-v-price"));

            });
            $('.heji .Standard_amount').text(numTotal)
        }).on('click', '.checkbox-inline input[type="checkbox"].products', function () {
            changeTrs(this);
        }).on('click', '.checkbox-inline input[type="checkbox"].agentCheckbox', function () {
            var $this = $(this);
            var productPrice = $this.attr("data-price");
            var prodId = $this.val();
            var productName = $this.next().html();
            var checked = $this.is(':checked');
            var index = $('#sample-table-1 tbody tr').length - 1;
            if (checked) {
                var html = '<tr class="selectedagent" data-v-id="' + prodId + '" data-v-price="' + productPrice + '">\
                <td>' + productName + '<input type="hidden" name="contProducts[' + index + '].prodId" value="' + prodId + '"/>\
                </td>\
                <td class="Standard_amount"><input type="text" name="contProducts[' + index + '].actualAmount" value="' + productPrice + '"/></td>\
                </tr>';
                $('#sample-table-1 tbody tr.heji').before(html);
            } else {
                //删除该选择的产品
                $('#sample-table-1 tbody tr').each(function () {
                    var data_v_id = $(this).attr('data-v-id');
                    if (data_v_id == prodId) {
                        $(this).remove();
                    }
                });
            }
            //计算合计
            var numTotal = 0;
            $('.selectedagent').each(function () {
                numTotal += parseInt($(this).attr("data-v-price"));

            });
            $('.heji .Standard_amount').text(numTotal)
        }).on('click', '#product_contract_submit', function () {
            if (checkControct(2)) {
                $(this).parents('form').submit();
            }
            ;

        }).on('click', '#add_new_contract_file', function () {
            var html = '<div class="form-group">\
                <label class="col-md-1 control-label"></label>\
                <div class="col-md-2">\
                <div class="file-btn">\
                <input type="file" name="file" value="">\
                </div>\
                </div>\
                </div>';
            $("#add_new_contract_file").parents('.form-group').before(html);
        });
    }

    var calcAgentTotal = function () {
        var trsArray = new Array();
        $('.selected').each(function () {
            var trs = {};

            var standAmount = parseFloat($(this).find('.Standard_amount').text());
            trs.standAmount = standAmount;
            trsArray.push(trs);
        });
        var totals = {standAmount: 0.0};
        for (var i = 0; i < trsArray.length; i++) {
            totals.standAmount = totals.standAmount + trsArray[i].standAmount;
        }
        ;
        //设置合计的值
        $('.heji .Standard_amount').text(totals.standAmount);
    }

    return {
        init: function () {
            bindClick();
        },
        calculationTotal: function () {
            calcTotal();
        },
        calculationAgentTotal: function () {
            calcAgentTotal();
        }
    }
}();
var ss = {}
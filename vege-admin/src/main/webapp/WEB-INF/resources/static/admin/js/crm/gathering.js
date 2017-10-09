/**
 * Created by xinbaojian on 15/8/5.
 */

var Gathering = function () {

    var dateCompare = function (a, b) {
        var arr = a.split("-");
        var starttime = new Date(arr[0], arr[1], arr[2]);
        var starttimes = starttime.getTime();

        var arrs = b.split("-");
        var lktime = new Date(arrs[0], arrs[1], arrs[2]);
        var lktimes = lktime.getTime();

        if (starttimes >= lktimes) {
            return false;
        } else {
            return true;
        }

    }

    var addCheck = function (form) {
        var formId = $(form).attr("id");
        console.log("this form's id = " + formId);
        var contNumer = $(form).find('.typeahead.tt-input').val();
        var gathMoney = $(form).find('input[name="gathMoney"]').val();
        var gathDate = $(form).find('input[name="gathDate"]').val();

        if (formId == 'gatherAddForm') {
            var contStatus = $("#Contract_contNumber").attr('cont-status');
            if (contStatus != undefined && contStatus != '2') {
                $.getWarnMessage("该合同已作废！");
                return false;
            }
        }

        if (formId == 'gatherAddFormEdit') {
            var contStatus = $("#Contract_contNumberEdit").attr('cont-status');
            if (contStatus != undefined && contStatus != '2') {
                $.getWarnMessage("该合同已作废！");
                return false;
            }
        }


        if (contNumer = undefined || contNumer == "") {
            $.tipshow({
                'msg': '合同编号不能为空!',
                'type': 'waring'
            });
            return false;
        }
        if (gathMoney == undefined || gathMoney == "") {
            $.tipshow({
                'msg': '本次收款金额不能为空!',
                'type': 'waring'
            });
            return false;
        }
        var pattern = /^[0-9]\d*$/;
        if (!pattern.test(gathMoney)) {
            $.tipshow({
                'msg': '请输入正确的金额!',
                'type': 'waring'
            });
            return false;
        }
        if (formId == 'gatherAddForm') {
            var reci = $('#cont_receivable').text();
            var coll = $('#cont_collected').text();
            var receivable = parseInt(reci) - parseInt(coll);
            if (parseInt(gathMoney) > receivable) {
                $.getWarnMessage("合同收款不能大于应收款!");
                return false;
            }
        }

        if (formId == 'gatherAddFormEdit') {
            var reci = $('#cont_receivable_edit').text();
            var coll = $('#cont_collected_edit').text();
            var oldGetMoney = $('#cont_gathMoney_edit').attr("data-old-val");
            var receivable = parseInt(reci) - (parseInt(coll) - parseInt(oldGetMoney));
            if (parseInt(gathMoney) > receivable) {
                $.getWarnMessage("合同收款不能大于应收款!");
                return false;
            }
        }

        if (gathDate == undefined || gathDate == "") {
            $.tipshow({
                'msg': '收款时间不能为空!',
                'type': 'waring'
            });
            return false;
        }
        ;


        return true;
    }

    var bindClick = function () {
        $('body').on('blur', '#Contract_contNumber', function () {
            var contNumer = $(this).val();
            $.ajax({
                url: '/contract/getContract',
                type: 'POST',
                dataType: 'json',
                data: {contractNumber: contNumer},
                success: function (data) {
                    console.log(JSON.stringify(data));
                    if (data.contStatus == 2) {
                        $("#cont_receivable").html(data.contReceivable);
                        $("#cont_collected").html(data.contCollected == null ? 0 : data.contCollected);
                        $("#cont_id").val(data.id);
                        $("#Contract_contNumber").attr('cont-status', '2');
                    } else {
                        $("#Contract_contNumber").attr('cont-status', data.contStatus);
                        $.getWarnMessage("该合同已作废！");
                    }

                }
            })
            ;

        }).on('click', '#gatherAddBtn', function () {
            if (addCheck($("#gatherAddForm"))) {
                $("#gatherAddForm").submit();
            }
        }).on('click', '#gatherAddBtn_edit', function () {
            if (addCheck($("#gatherAddFormEdit"))) {
                $("#gatherAddFormEdit").submit();
            }
        }).on('change', '.date-picker', function () {
            var datePicker = $('.date-picker').val();
            if (datePicker != undefined && datePicker != "") {
                var date = new Date(datePicker);
                var currentDate = new Date();
                if (!dateCompare(datePicker, currentDate.GetCurrentDate())) {
                    $('.date-picker').val(currentDate.GetCurrentDate());
                }
                ;
            }
            ;
        }).on('click', '#edit_gather', function () {
            var id = $(this).attr('data-id');
            var contNumber = $(this).attr('data-contNumber');
            $.ajax({
                url: '/gather/toEdit',
                type: 'POST',
                dataType: 'json',
                data: {id: id, contNumber: contNumber},
                success: function (data) {
                    $("#Contract_contNumberEdit").val(data.contract.contNumber);
                    $("#Contract_contNumberEdit").attr("cont-status", data.contract.contStatus);
                    $("#cont_receivable_edit").html(data.contract.contReceivable);
                    $("#cont_collected_edit").html(data.contract.contCollected);
                    $("#cont_gathMoney_edit").val(data.gathering.gathMoney);
                    $("#cont_gathMoney_edit").attr("data-old-val", data.gathering.gathMoney);
                    $("#gathDate_edit").val(data.gathering.gathDate.substring(0, 10));
                    $("#id_edit").val(data.gathering.id);
                }
            });

        }).on('click', '#confirm_open', function () {
            $.confirm({
                'msg': '该账号是否已确定开通?', 'suretext': '确定', 'callback': function (data) {
                    if (data) {
                        var contId = $("#confirm_open").attr("data-contid");
                        window.location.href = '/gather/confirm?contId=' + contId;
                    }
                }
            });
        });
    }

    return {
        init: function () {
            bindClick();
            var currentDate = new Date();
            $('.date-picker').val(currentDate.GetCurrentDate());
        }
    }
}();

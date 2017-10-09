/**
 * Created by xinbaojian on 15/7/20.
 */
var Clue = function () {
    var custRoleJson = "";
    var provinceId = "";
    var cityId = "";

    //判断是否具有联系人，如果没有，默认显示一个联系人空表单
    var checkCust = function () {
        var obj = $("#vweddingTable tbody").children("tr");
        if (obj.length <= 0) {
            addNewCust(obj.length);
        }
    }
    //新增联系人
    var addNewCust = function (obj) {
        var obj = $("#vweddingTable tbody").children("tr");
        var index = 0;
        if (obj.length > 0) {
            index = obj.length;
        }
        var cust = " <tr>\
			<td>" + (index + 1) + "</td>\
			<td>\
			<select class=\"form-control\" name=\"customerList[" + index + "].custRole\">";
        cust += getCustRoleOption(index);
        cust += "</select>\
			</td>\
			<td><input type=\"text\" class=\"form-control\" name=\"customerList[" + index + "].custName\" placeholder=\"请输入姓名\"></td>\
			<td><input type=\"text\" class=\"form-control\" name=\"customerList[" + index + "].custJob\" placeholder=\"请输入职务\"></td>\
			<td><input type=\"text\" class=\"form-control\" name=\"customerList[" + index + "].custPhone\" placeholder=\"请输入联系方式\"></td>\
			<td><input type=\"text\" class=\"form-control\" name=\"customerList[" + index + "].custQq\" placeholder=\"请输入QQ\"></td>\
			<td><input type=\"text\" class=\"form-control\" name=\"customerList[" + index + "].custEmail\" placeholder=\"请输入邮箱\"></td>\
			</tr>";
        $("#vweddingTable tbody").append(cust)
    }

    //往弹出层中插入数据
    var addNewCustByDataModel = function (json) {
        var obj = $("#vweddingTableModel tbody").children("tr").remove();
        var index = 0;
        for (var i = 0; i < json.length; i++) {
            var cust = " <tr>\
			<td>" + json[i].clueNumber + "</td>\
			<td>" + json[i].clueStatusOnlineStr + "</td>\
			<td>" + json[i].ownerName + "</td>\
			<td>";
            for (var j = 0; j < json[i].productList.length; j++) {
                cust += json[i].productList[j].productName + " ";
            }
            ;
            cust += "</td>\
			<td>" + json[i].createTime + "</td>\
			</tr>";
            $("#vweddingTableModel tbody").append(cust)
            index = index + 1;
        }
        ;

    }
    //表单验证
    var validate = function () {
        var result = true;
        var custName = $('#form-field-1').val();
        if (custName == undefined || custName == '') {
            $.tipshow({
                'msg': '请填写客户名称!',
                'type': 'waring'
            });
            result = false;
            return false;
        }
        ;
        var shengfen = $("#sheng").val();
        if (shengfen == '') {
            $.tipshow({
                'msg': '请选择省份!',
                'type': 'waring'
            });
            result = false;
            return false;
        }
        ;
        var shi = $("#shi").val();
        if (shi == '') {
            $.tipshow({
                'msg': '请选择城市!',
                'type': 'waring'
            });
            result = false;
            return false;
        }
        ;
        var qu = $("#qu").val();
        if (qu == '') {
            $.tipshow({
                'msg': '请选择地区!',
                'type': 'waring'
            });
            result = false;
            return false;
        }
        ;
        //验证线索信息
        var clueSource = $('#clueSource').val();
        if (clueSource == undefined || clueSource == '') {
            $.tipshow({
                'msg': '请选择线索来源!',
                'type': 'waring'
            });
            result = false;
            return false;
        }
        ;
        //验证线索类型
        var clueType = $('#clueType').val();
        if (clueType == undefined || clueType == '') {
            $.tipshow({
                'msg': '请选择线索类型!',
                'type': 'waring'
            });
            result = false;
            return false;
        }
        ;
        //验证预购产品
        var productIds = $('.checkbox-inline input[type="checkbox"]:checked').length;
        if (productIds == undefined || productIds <= 0) {
            $.tipshow({
                'msg': '请选择预购产品!',
                'type': 'waring'
            });
            result = false;
            return false;
        }
        ;
        //验证联系人信息
        if ($('#vweddingTable tbody tr td input').length <= 0) {
            $.getWarnMessage("请新增联系人!")
            result = false;
            return false;
        }
        var custResult = true;
        $('#vweddingTable tbody tr td input').each(function () {
            var name = $(this).attr('name');

            if (name.indexOf('custName') > 0 && $(this).val() === '') {
                $.getWarnMessage("姓名不能为空！");
                result = false;
                return false;
            }
            if (name.indexOf('custPhone') > 0 && $(this).val() === '') {
                $.getWarnMessage('联系方式不能为空！');
                result = false;
                return false;
            } else if (name.indexOf('custPhone') > 0 && $(this).val() != '') {
                var tel = $(this).val(); //获取手机号
                var telReg = !!tel.match(/^(0|86|17951)?(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$/);
                var telRegZuo = !!tel.match(/^((0\d{2,3}-?)?\d{7,8})|1\d{10}$/);
                if (!(telReg || telRegZuo )) {
                    custResult = false;
                    $.getWarnMessage('请输入正确的号码');
                }
                ;
                return custResult;
            }
        });
        if (!custResult) {
            return false;
        }
        //验证了解方式
        var clueKnow = $('#clueKnow').val();
        if (clueKnow == undefined || clueKnow == '') {
            $.tipshow({
                'msg': '请选择了解方式!',
                'type': 'waring'
            });
            result = false;
            return false;
        }
        ;
        if (clueKnow == "-1" && result) {
            $('#clueKnow').val("");
        }
        ;
        //验证咨询方式
        var clueConsult = $('#clueConsult').val();
        if (clueConsult == undefined || clueConsult == '') {
            $.tipshow({
                'msg': '请选择咨询方式!',
                'type': 'waring'
            });
            result = false;
            return false;
        }
        ;
        if (clueConsult == "-1" && result) {
            $('#clueConsult').val("");
        }
        ;
        return result;
    }
    var getCustRoleOption = function (val) {
        var str = "";
        for (var i = 0; i < custRoleJson.length; i++) {
            str += "<option ";
            str += "value=\"" + custRoleJson[i].code + "\"";
            if (val == custRoleJson[i].code) {
                str += "checked";
            }
            str += ">" + custRoleJson[i].desc + "</option>";
        }
        return str;

    }

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

    var addProductVersion = function (json) {
        var html = '';
        var index = 0;
        for (var i = 0; i < json.length; i++) {
            html += '<div class="form_group pb10">';
            html += '<p class="form-control-static">' + json[i].productName + '</p>';
            for (var j = 0; j < json[i].versionList.length; j++) {
                html += '<label class="checkbox-inline no-padding-left">';
                html += '<input name="busiProducts[' + index + '].prodId" type="hidden" value="' + json[i].id + '"/>';
                html += '<input name="busiProducts[' + index + '].prodVersionId" type="checkbox" class="ace" value="' + json[i].versionList[j].id + '">';

                html += '<span class="lbl">' + json[i].versionList[j].versName + '</span>';
                html += '</label>';
                index = index + 1;
            }
            ;
            html += '</div>';
        }
        ;
        // console.log(html);
        $('#modal_generate .modal-body').html(html);
    }

    var getPageHtml = function (pageNo, totalPage) {
        var pageLen = 10;
        var pageIndex = ((pageNo - 1) - (pageNo - 1) % pageLen) / pageLen;
        var lastPageNo = pageLen * (pageIndex + 1);
        // var totalPage = 100;
        pagehtml = '<div class="modal-body" id="page_html">\
	        <div class="form-group">\
	            <ul class="pagination">';
        if (totalPage > 1) {
            if (pageNo != 1) {
                pagehtml += '<li><a href="javascript:" onclick="goPaging(1)">首页</a></li>\
	                         <li><a href="javascript:" onclick="goPaging(' + (pageNo - 1) + ')">上一页</a></li>';
            }
            ;
            var begin = pageLen * pageIndex + 1;
            var end = lastPageNo > totalPage ? totalPage : lastPageNo;
            for (var i = begin; i <= end; i++) {
                if (i == pageNo) {
                    pagehtml += '<li class="active"><a href="javascript:">' + i + '<span class="sr-only">(current)</span></a></li>';
                } else {
                    pagehtml += '<li><a href="javascript:" onclick="goPaging(' + i + ')">' + i + '</a></li>';
                }
            }
            ;
            if (pageNo != totalPage) {
                pagehtml += '<li><a href="javascript:" onclick="goPaging(' + (pageNo + 1) + ')">下一页</a></li>\
	                            <li><a href="javascript:" onclick="goPaging(' + totalPage + ')">尾页</a></li>';
            }
            ;
        } else {
            pagehtml += '<li class="active"><a href="#">1<span class="sr-only">(current)</span></a></li>';
        }
        pagehtml += '</ul>\
	        </div>';
        return pagehtml;
    }

    var queryAgentForPage = function (query, page, page_size) {
        $.ajax({
            url: '/callcenter/getAgent',
            type: 'POST',
            dataType: 'json',
            data: {'query': query, 'page': page, 'pageSize': page_size},
            success: function (data) {
                var htmlagent = '';
                for (var i = 0; i < data.agents.length; i++) {
                    htmlagent += '<tr class="selected">\
									<td class="center">\
										<label class="position-relative">\
											<input type="radio" name="checkRadio" class="ace acechild" value="' + data.agents[i].id + '" data-name="' + data.agents[i].name + '">\
											<span class="lbl"></span>\
										</label>\
									</td>\
									<td>' + data.agents[i].name + '</td>\
									<td>' + data.agents[i].company_nname + '</td>\
								</tr>';
                }
                ;
                $(".tbody_agent").html(htmlagent);
                if ($('#page_html').length > 0) {
                    $('#page_html').remove();
                }
                ;
                $('#myModalAgent .modal-footer').before(getPageHtml(page, data.total_count));
            }
        });
    }


    var bingClick = function () {
        $('body').on('click', '#addNewCust', function () {
            addNewCust();
        }).on('click', '#submitBtn', function () {
            $("#submitBtn").attr('disabled', true);
            if (validate()) {
                $("#addNewCustForm").submit();
            } else {
                $("#submitBtn").attr('disabled', false);
            }
        }).on('click', '#allotClue_id', function () {
            var checkeds = $('.acechild:checked').length;
            if (checkeds <= 0) {
                $.tipshow({
                    'msg': '请先选中要分配的线索!',
                    'type': 'waring'
                });
                return false;
            }
            ;
            var clueIds = '';
            var boolresult = true;
            $('.acechild:checked').each(function () {
                var status = $(this).attr("data-status");
                if (status == '2') {
                    $.tipshow({
                        'msg': '已关闭线索不能再分配!',
                        'type': 'waring'
                    });
                    boolresult = false;
                }
                ;
                if ($(this).val() != '') {
                    clueIds += $(this).val() + ',';
                }
                ;
            })
            if (!boolresult) {
                return false;
            }
            ;
            $('input[name="cluds"]').val(clueIds)
            $.ajax({
                url: '/clue/allot',
                type: 'POST',
                dataType: 'json',
                data: {adminStatus: 1},
                success: function (data) {
                    var optionhtml = '<option value="">请选择归属人</option>';
                    for (var i = 0; i < data.length; i++) {
                        optionhtml += '<option value="' + data[i].id + '">' + data[i].adminRealName + '</option>';
                    }
                    ;
                    $("#form-field-1").html(optionhtml);
                    $('#myModal').modal();
                }
            });
        }).on('change', '#form-field-1', function () {
            var val = $("#form-field-1").val();
            var value = $('#form-field-1 option[value="' + val + '"]').text();
            $("#id_ownerName").val(value);
        }).on('change', '#id-date-picker-1', function () {
            var datePicker = $('#id-date-picker-1').val();
            if (datePicker != undefined && datePicker != "") {
                var date = new Date(datePicker);
                var currentDate = new Date();
                if (dateCompare(datePicker, currentDate.GetCurrentDate())) {
                    $('#id-date-picker-1').val(currentDate.GetCurrentDate());
                }
                ;
            }
            ;
        }).on('click', '#searchPhoneBtn', function () {
            var phone = $('#searchPhone').val();
            if (phone.length <= 0) {
                $.tipshow({
                    'msg': '请输入手机号!',
                    'type': 'waring'
                });
                return false;
            }
            ;
            $.ajax({
                url: '/clue/queryByPhone',
                type: 'POST',
                dataType: 'json',
                data: {"phone": phone},
                success: function (data) {
                    addNewCustByDataModel(data);
                }
            });
        }).on('click', '#modal_generate_id', function () {
            //bug 修改 ---增加线索类型，判断类型为代理合同
            var clueType = $(this).attr("data-clue-type");
            var clueId = $(this).attr("data-id");
            $("#modal_generate_clueId").val(clueId);

            //代理咨询类型code为2
            if (clueType == "2") {
                $.confirm({
                    'msg': '是否确定将该线索生成商机？', 'suretext': '确定', 'callback': function (data) {
                        if (data) {
                            $("#clue_submit").parents('form').submit();
                        }
                    }
                });
                return false;
            }

            $.ajax({
                url: '/clue/queryProdVers',
                type: 'POST',
                dataType: 'json',
                data: {},
                success: function (data) {
                    addProductVersion(data);
                    $("#modal_generate").show();
                }
            });
        }).on('click', '#return_clue_detail', function () {
            var remark = $(this).attr("data-remark");
            $("#return_change_remark").html(remark);
        }).on('click', '#checkClose', function () {
            var $this = $(this);
            var id = $(this).attr("data-id");
            $.confirm({
                'msg': '是否确定关闭该线索？', 'suretext': '确定', 'callback': function (data) {
                    if (data) {
                        //window.location.href = '/clue/close?clueId='+id;
                        $.ajax({
                            url: '/clue/close',
                            type: 'POST',
                            dataType: 'json',
                            data: {"clueId": id},
                            success: function (data) {
                                $.tipshow({
                                    'msg': data.msg,
                                    'type': 'info',
                                    'ico': 'fa-check-circle-o'
                                });
                                if (data.msg = '关闭成功') {
                                    $this.parent().find('a').each(function () {
                                        console.log();
                                        var href = $(this).attr('href');
                                        if (href.indexOf('toShowClue') < 0) {
                                            $(this).remove();
                                        }
                                    });
                                }

                            }
                        });

                    }
                }
            });
        }).on('click', '.centerCloseClue', function () {
            var $this = $(this);
            var id = $(this).attr("data-id");
            $this.prev().remove();
            $.confirm({
                'msg': '是否确定关闭该线索？', 'suretext': '确定', 'callback': function (data) {
                    if (data) {
                        $.ajax({
                            url: '/callcenter/close',
                            type: 'POST',
                            dataType: 'json',
                            data: {"clueId": id},
                            success: function (data) {
                                if (data.code == 1) {
                                    $.tipshow({
                                        'msg': data.msg,
                                        'type': 'info',
                                        'ico': 'fa-check-circle-o',
                                        'callback': function () {
                                            $this.remove();
                                            $this.prev().remove();
                                        }
                                    });
                                } else {
                                    $.tipshow({
                                        'msg': data.msg,
                                        'type': 'waring'
                                    });
                                }
                            }
                        })
                        ;

                    }
                }
            });
        }).on('click', '#clue_submit', function () {
            var len = $("#clue_submit").parents('form').find('input[type="checkbox"]:checked').length;
            if (len > 0) {
                $.confirm({
                    'msg': '是否确定将该线索生成商机？', 'suretext': '确定', 'callback': function (data) {
                        if (data) {
                            //判断是否选择了商机
                            $("#clue_submit").parents('form').submit();
                        }
                    }
                });
            } else {
                $.getWarnMessage("请选择至少一个套餐!");
            }
        }).on('click', '#allotClue_id_toAgent', function (event) {//分配线索给代理商
            var checkeds = $('.acechild:checked').length;
            if (checkeds <= 0) {
                $.tipshow({
                    'msg': '请先选中要分配的线索!',
                    'type': 'waring'
                });
                return false;
            }
            ;
            var clueIds = '';
            var boolresult = true;
            $('.acechild:checked').each(function () {
                var status = $(this).attr("data-status");
                if (status == '2') {
                    $.tipshow({
                        'msg': '已关闭线索不能再分配!',
                        'type': 'waring'
                    });
                    boolresult = false;
                }
                ;
                if ($(this).val() != '') {
                    var ownerType = $(this).attr('data-owner-type');
                    clueIds += $(this).val() + '!' + ownerType + ',';
                }
                ;
            })
            if (!boolresult) {
                return false;
            }
            ;

            $("#query_agent_clueIds").val(clueIds);
            queryAgentForPage('', 1, 10);
            $('#myModalAgent').modal();
        }).on('click', '#query_agent_submit', function () {
            var query = $("#query_agent_companyName").val();
            queryAgentForPage(query, 1, 10)
        }).on('click', '#query_agent_sure', function () {
            var agentId = $('input[type="radio"]:checked').val();
            $("#query_agent_id").val(agentId);
            var agentName = $('input[type="radio"]:checked').attr('data-name');
            $("#query_agent_name").val(agentName);
            $("#lead_distribute_agent").submit();
        }).on('click', '#fenpei_xiansuo_button', function () {//分配线索，改为异步。2015-11-11 11:57:45
            var ownerName = $("#id_ownerName").val();
            var cluds = $('input[name="cluds"]').val();
            var owner = $("#form-field-1").val();
            var params = "ownerName=" + ownerName + "&cluds=" + cluds + "&owner=" + owner;
            var search = $('.btn_normal').parents('form').serialize();
            //params = params+"&"+search
            console.log(params);
            $.ajax({
                url: '/callcenter/distribution?' + params,
                type: 'POST',
                dataType: 'json',
                data: {},
                success: function (data) {
                    console.log(JSON.stringify(data));
                    if (data == "1") {
                        $('.btn_normal').click();
                    }
                }
            });
        }).on('click', '#query_agent_sure', function () {//分配线索给代理商，改为异步。2015-11-11 12:09:45
            var params = $("#query_agent_sure").parents("form").serialize();
            $.ajax({
                url: '/callcenter/addClueToAgent?' + params,
                type: 'GET',
                dataType: 'json',
                data: {},
                success: function (data) {
                    if (data.msg != undefined && data.msg != "") {
                        if (data.code == '1') {
                            $.tipshow({
                                'msg': data.msg,
                                'type': 'info',
                                'ico': 'fa-check-circle-o'
                            });
                            $('.btn_normal').click();
                        } else {
                            $.getWarnMessage(data.msg);
                        }

                    }
                }
            });

        });
    }
    return {
        init: function () {
            //新增联系人
            bingClick();
            //checkCust();
        },
        setCustRoleJson: function (str) {
            custRoleJson = str;
        },
        validateCustomer: function () {

        },
        queryAgent: function (query, page, page_size) {
            queryAgentForPage(query, page, page_size);
        }
    }
}();
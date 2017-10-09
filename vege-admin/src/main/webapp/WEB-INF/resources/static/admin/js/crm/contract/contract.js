/**
 * 查看合同信息
 * @param id
 */
function checkContract(id) {
    $.ajax({
        type: 'post',
        url: '/contract/selectContractInfoById?id=' + id,
        dataType: 'json',
        success: function (data) {
            if (data != null) {
                setValueInfo(data);
            }
        },
        error: function () {
        }
    });
}


/**
 * 查看合同信息弹窗赋值
 */
function setValueInfo(contract) {
    var loc = new Location();
    var addr = loc.find('0')[contract.custProvince] + " " + loc.find('0,' + contract.custProvince)[contract.custCity]
        + " " + loc.find('0,' + contract.custProvince + ',' + contract.custCity)[contract.custArea];
    $("#contSigntime").html(contract.contSigntime);
    $("#cust").html(contract.cust);
    $("#ownerName").html(contract.ownerName);
    $("#contRemark").html(contract.contRemark);
    $("#addr").html(addr);
    $("#custAddr").html(contract.custAddr);
    if (contract.customerList != null) {
        var custHtml = "";
        $.each(contract.customerList, function (i, cust) {
            custHtml += "<p class='form-control-static'>联系人：" + cust.custName + "  电话：" + cust.custPhone + "  邮箱：" + cust.custEmail + "</p>";
        })
        $("#custDiv").html(custHtml);
    }
    if (contract.versionList != null && contract.versionList.length > 0) {
        var versionHtml = "<table border = 1 style='width:90%;'><tr><th>购买套餐</th><th>数量</th><th>标准单价</th><th>实际金额</th><th>总人天</th><th>人天单价</th><th>折扣</th></tr>";
        $.each(contract.versionList, function (i, version) {
            versionHtml += "<tr><td>" + version.versName + "</td><td>" + version.buyCount + "</td><td>" + version.versPrice + "</td><td>" + version.actualAmount + "</td><td>"
                + (version.sumMenday == null ? "" : version.sumMenday) + "</td><td>" + (version.priceMenday == null ? "" : version.priceMenday) + "</td><td>" + version.prodDiscount + "</td></tr>";
        })
        versionHtml += "</table>";
        $("#versionDiv").html(versionHtml);
    }

    if (contract.contType == 1 && contract.contProductList != null && contract.contProductList.length > 0) {
        var prodHtml = "<table border = 1 style='width:90%;'><tr><th>代理产品</th><th>金额</th></tr>";
        $.each(contract.contProductList, function (i, prod) {
            prodHtml += "<tr><td>" + prod.productName + "</td><td>" + prod.productPrice + "</td></tr>";
        })
        prodHtml += "</table>";
        $("#versionDiv").html(prodHtml);
    }
}

/**
 * 审核按钮
 * @param id
 */
function audit(id, busi_id) {
    $("#cont_id").val(id);
    $("#busi_id").val(busi_id);
}

/**
 * 审核通过按钮点击
 * @param status
 */
function makeSurePass(status) {
    $('#cont_status').val(status);
    var action = "/contract/contractAudit";
    $('#contractCheckForm').attr("action", action).submit();
}

/**
 * 合同作废按钮
 * @param id
 */
function contractCancel(id) {
    $.confirm({
        'msg': '是否确定将该合同作废?', 'suretext': '<span>确定</span>', 'callback': function (data) {
            if (data) {
                $.ajax({
                    type: 'post',
                    url: '/contract/contractCancel',
                    data: {id: id, contStatus: 3},
                    dataType: 'json',
                    success: function (data) {
                        if (data != null && data == "1") {
                            $.tipshow({
                                'msg': '操作成功',
                                'type': 'info',
                                'ico': 'fa-check-circle-o',
                                'callback': function () {
                                    $('#findForm').submit();
                                }
                            });
                        }
                    },
                    error: function () {
                    }
                });
            }
        }
    });


}

function cancelCheck() {
    $('#contractInfoDiv span').html("");
    $('#contractInfoDiv div').html("");
}
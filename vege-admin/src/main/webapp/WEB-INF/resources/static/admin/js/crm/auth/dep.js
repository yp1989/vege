
/**
 *  部门管理
 */
var selectId,selectName = null;
//右击时获取的节点
var rightClickNode = null;
$(document).ready(function(){
	$('#tree_test').tree({   
	    url: "/auth/getTreeDepList",
	    checkbox : false,
	    cascadeCheck : false
	   
	});
	$('#tree_test').tree({  
		onContextMenu: function(e,node){
			e.preventDefault();
			// 选择节点
			$('#tree_test').tree('select', node.target);
			selectId = node.id;
			selectName = node.text;
			rightClickNode = node;
			// 显示上下文菜单
			$('#mm').menu('show', {
				left: e.pageX,
				top: e.pageY
			});
		},
		onDblClick: function(node){
			loadAdminByDep(node.id);
		}

		
	});
});

/** 初始化部门树 */
function loadTree(depListJson) {
	var json =new DataSourceTree({data: depListJson});
	 $('#tree').ace_tree({
		dataSource: json ,
		multiSelect:false,
		loadingHTML:'<div class="tree-loading"><i class="ace-icon fa fa-refresh fa-spin blue"></i></div>',
		'open-icon' : 'ace-icon tree-minus',
		'close-icon' : 'ace-icon tree-plus',
		'selectable' : true,
		'selected-icon' : null,
		'unselected-icon' : null
	});
	 
	$("#tree").on("click",".action-buttons a",function(event){
		var $this = $(this),
			target = $this.attr("href");
		$(target).modal(); 
	});
	
	$("#tree").on("selected",function(e,result){ 
		setParametersDepId(result.info[0].id,result.info[0].name);
		loadAdminByDep(result.info[0].id);
	}).on('opened closed', function(e,result) {
		if(result != null){
			setParametersDepId(result.id,result.name);
			//loadAdminByDep(result.id);
		}
		var items = result;
	});
	
}

/**
 * 添加和修改部门时给parentId、depId赋值
 */
function setParametersDepId(val,name) {
	
	$("#editDepName").val("");
	if(name != null){
		name = name.substring(0, name.indexOf('<'));
	}  
	
	$("#parentId").val(val);
	$("#depId").val(val);
	$("#editDepName").attr('placeholder',name)
	$("#editDepName").val(name); 
}

/**
 * 根据选中的部门加载管理员列表
 */
function loadAdminByDep(depId) {
	$.ajax({     
        type:'post',         
        url:'/auth/getAdminByDep?adminDep='+depId,  
        dataType:'json',     
        success:function(data){ 
        	if(data != null){
        		if(data.results != null){
        			initAdminTable(data.results);
        		}
        	}
        }     
    });   
}

function initAdminTable(adminList) {
	var html = "";
	$.each(adminList,function(i,admin){
		if(admin.isDepManager == 1){
			html+="<tr><td>"+(i+1)+"</td><td>"+admin.adminName+"</td><td>"+admin.depName+"</td><td>"
			+"<label><input name='switch-field-1' checked='checked' onchange='setIsDepManager(0,"+admin.id+","+admin.adminDep+");' class='ace ace-switch ace-switch-6' type='checkbox'><span class='lbl'></span>"
			+"</label></td><td>"+"<a  data-toggle='modal' data-target='#move' class='mr20' onclick='moveAdmin("+admin.id+");'>移动</a></td></tr>";
		}else{
			html+="<tr><td>"+(i+1)+"</td><td>"+admin.adminName+"</td><td>"+admin.depName+"</td><td>"
			+"<label><input name='switch-field-1'  onchange='setIsDepManager(1,"+admin.id+","+admin.adminDep+");' class='ace ace-switch ace-switch-6' type='checkbox'><span class='lbl'></span>"
			+"</label></td><td>"+"<a  data-toggle='modal' data-target='#move' class='mr20' onclick='moveAdmin("+admin.id+");'>移动</a></td></tr>"
		}
		
	});
	$('#tableBody').html(html);
	$('#total').html("全部成员（"+adminList.length+"）");
} 

/**
 * 管理员移动保存按钮 
 */
function savaMoveAdmin() {
	var action="/auth/moveAdmin";
	$('#moveAdminForm').attr("action", action).submit(); 
}

/**
 * 管理员移动按钮
 * @param adminId
 */
function moveAdmin(adminId) {
	$('#adminId').val(adminId);
}

function append() {
	$("#parentId").val(selectId);
}

function edit() {
	$("#depId").val(selectId);
	$("#editDepName").val(selectName); 
}

function deleteNode() {
	var selected = $('#tree_test').tree('getSelected');
	$.ajax({     
        type:'post',         
        url:'/auth/deleteDep?id='+selected.id,
        dataType:'text',
        success:function(data){ 
        	if(data != null){
        		if(data == "0"){
        			$('#tree_test').tree('remove', selected.target);
        		}
        	}
        }     
    });    
}
/**
 * 添加部门保存按钮
 */
function savaAddDep() {
	var selected = $('#tree_test').tree('getSelected');
	$.ajax({     
        type:'post',         
        url:'/auth/savaAddDep', 
        data:$('#addDepForm').serialize(),// 你的formid 
        success:function(data){ 
        	if(data != null){
        		if(data.id != null){
        			$('#tree_test').tree('append', {
        				parent: selected.target,
        				data: [{
        					id: data.id,
        					text: data.depName,
        					"state":"closed" 
        				}]
        			});
        		}
        	}
        }     
    });   
	/*var action="/auth/savaAddDep";
	$('#addDepForm').attr("action", action).submit();*/
	
}

/**
 * 修改部门保存按钮
 */
function savaUpdateDep() {
	var selected = $('#tree_test').tree('getSelected');
	$.ajax({     
        type:'post',         
        url:'/auth/savaUpdateDep', 
        data:$('#editDepForm').serialize(),// 你的formid 
        success:function(data){ 
        	if(data != null){
        		if(data == "0"){
        			$('#tree_test').tree('update', {
        				target: selected.target,
        				text: $('#editDepName').val()
        			});

        		}
        	}
        }     
    });   
	/*var action="/auth/savaUpdateDep";
	$('#editDepForm').attr("action", action).submit(); */
}

/**
 * @param 设置为部门管理员
 */
function setIsDepManager(isDepManager,id,adminDep) {
	$.ajax({     
        type:'post',         
        url:'/auth/setIsDepManager',  
        data:{isDepManager:isDepManager,id:id,adminDep:adminDep},
        dataType:'json',     
        success:function(data){ 
        	if(data != null){
        		if(data == "0"){
        			$.tipshow({
        				'msg':'设置完成',
        				'type':'info',
        				'ico':'fa-check-circle-o',
        				'callback':function(){
        					loadAdminByDep(adminDep);
        				}
        			});
        		}
        	}
        }     
    });   
	/*var url="/auth/setIsDepManager?isDepManager="+isDepManager+"&id="+id+"&adminDep="+adminDep;
	window.location.href = url;*/
}

/**
 * 取消移动按钮和x
 */
function cancelMove() {
	$("#adminId").val("");
	$("input:radio[name='adminDep']").attr("checked",false);
}
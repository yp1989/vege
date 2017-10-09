package com.vcooline.crm.common.util;

import com.vcooline.crm.common.model.CrmAuth;
import com.vcooline.crm.common.model.CrmDep;

import java.util.ArrayList;
import java.util.List;

public class TreeUtil {

    /**
     * @param @param menuList    设定文件
     * @return void    返回类型
     * @throws
     * @Description:这里用一句话描述这个方法的作用
     * @author caohuan
     * @date 2015年7月17日 下午5:04:16
     * 上海微客来软件技术有限公司
     */
    public static List<CrmAuth> createTree(List<CrmAuth> menuList) {

        List<CrmAuth> nodeList = new ArrayList<CrmAuth>();
        for (CrmAuth node1 : menuList) {
            boolean mark = false;
            for (CrmAuth node2 : menuList) {
                if (node1.getParentId() != null && node1.getParentId().equals(node2.getId())) {
                    mark = true;
                    if (node2.getChildren() == null)
                        node2.setChildren(new ArrayList<CrmAuth>());
                    node2.getChildren().add(node1);
                    break;
                }
            }
            if (!mark) {
                nodeList.add(node1);
            }
        }

        return nodeList;
    }

    public List<CrmDep> initDepTree(Long id) {

        List<CrmDep> depList = new ArrayList<CrmDep>();
        List<CrmDep> tree = new ArrayList<CrmDep>();
        for (CrmDep dep : depList) {
            dep.setChildren(initDepTree(dep.getId()));
            /*if(dep.getParentId() == null){
				nodeList.add(dep);
			}*/
            tree.add(dep);
        }
        return tree;
    }
}

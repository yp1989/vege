/**
 * cwise-plat[com.thrfid.cwise.tree.TreeNodeAttribute.java]
 * com.thrfid.cwise.yangguang
 * 2013年11月28日-下午8:02:25
 */
package com.vcooline.crm.common.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * 功能描述：标记添加至node中的属性
 *
 * @author yangguang
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TreeNodeAttribute {


    /**
     * 功能描述：树上节点的属性名称
     * 创建时间：2013年12月1日 上午11:18:49
     *
     * @return
     */
    String attributeName();
}

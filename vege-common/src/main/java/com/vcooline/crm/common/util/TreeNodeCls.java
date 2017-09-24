/**
 * cwise-plat[com.thrfid.cwise.tree.TreeNodeCls.java]
 * com.thrfid.cwise.yangguang
 * 2013年11月27日-下午6:51:59
 */
package com.vcooline.crm.common.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 功能描述：标注为可以转换成树节点
 * 
 * @author yangguang
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface TreeNodeCls {
	
	
	/**
	 * 功能描述：id指定属性名称
	 * 创建时间：2013年11月27日 下午6:58:17
	 * @return
	 */
	String id();

	
	/**
	 * 功能描述：text指定属性名称
	 * 创建时间：2013年11月27日 下午6:58:34
	 * @return
	 */
	String text();
}

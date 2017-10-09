/**
 * cwise-plat[com.thrfid.cwise.tree.LeafFlag.java]
 * com.thrfid.cwise.yangguang
 * 2013年11月28日-下午8:38:51
 */
package com.vcooline.crm.common.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * 功能描述：是否为叶子节点判断参考属性
 *
 * @author yangguang
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LeafFlag {

}

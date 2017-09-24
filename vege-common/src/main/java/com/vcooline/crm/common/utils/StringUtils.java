package com.vcooline.crm.common.utils;

import java.util.Date;

import com.alibaba.fastjson.JSONObject;
import com.vcooline.crm.common.model.CrmClue;

/**
 * String辅助处理类
 * Created by xinbaojian on 15/7/17.
 */
public class StringUtils extends org.springframework.util.StringUtils{

    public static boolean isNotEmpty(Object str){
        return !StringUtils.isEmpty(str);
    }

    /**
     * 根据自增码
     * 生成线索编号
     * @return
     */
    public static String generateClueNumber(Integer numCode){
        return generateNumber(numCode,"CL",8,"yyyy");
    }

    public static String generateNumber(Integer numCode,String prefix,Integer numLenth,String format){
        if (numCode == null)
            numCode = 0;
        StringBuffer sb = new StringBuffer();
        sb.append(prefix);
        sb.append(DateUtil.dateToStr(new Date(), format));
        StringBuffer code = new StringBuffer(Integer.toString(numCode));
        int length = numLenth - code.length();
        if (code.length() < numLenth){
            for(int i = 0;i < length;i++){
                code.insert(0,"0");
            }
        }
        sb.append(code.toString());
        return sb.toString();
    }

    public static String generateBusiNumber(Integer numCode){
        return generateNumber(numCode, "BO", 3,"yyyyMM");
    }

    public static String generateContactNumber(Integer numCode){
        return generateNumber(numCode,"CN",3,"yyyyMMdd");
    }

    public static void main(String[] args) {
     CrmClue clue = new CrmClue();
     System.out.println(JSONObject.toJSON(clue));
        System.out.println(generateClueNumber(99999));
    }
}

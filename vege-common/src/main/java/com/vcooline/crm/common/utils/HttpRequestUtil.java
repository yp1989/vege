package com.vcooline.crm.common.utils;

import com.google.gson.Gson;
import com.vcooline.crm.common.util.ConstantUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class HttpRequestUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(HttpRequestUtil.class);

    /**
     * 向指定URL发送GET方法的请求
     *
     * @param url   发送请求的URL
     * @param param 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return URL 所代表远程资源的响应结果
     */
    public static String sendGet(String url, String param) {
        String result = "";
        if (param == null) {
            param = "";
        }
        StringBuilder jsonStr = new StringBuilder();
        BufferedReader in = null;
        try {
            String urlNameString = url + param;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                LOGGER.info(key + "--->" + map.get(key));
            }

            //ConstantUtil.UTF_CODE 编码格式
            InputStreamReader reader = new InputStreamReader(connection.getInputStream(), ConstantUtil.UTF_CODE);
            char[] buff = new char[1024];
            int length = 0;
            while ((length = reader.read(buff)) != -1) {
                result = new String(buff, 0, length);
                jsonStr.append(result);
            }


            Gson gson = new Gson();
            Map temp = gson.fromJson("", Map.class);

        } catch (Exception e) {
            LOGGER.error("发送GET请求出现异常！", e);
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return jsonStr.toString();
    }

    /**
     * 向指定 URL 发送POST方法的请求
     *
     * @param url   发送请求的 URL
     * @param param 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return 所代表远程资源的响应结果
     */
    public static String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        URLConnection conn = null;
        StringBuilder jsonStr = new StringBuilder();
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            conn = realUrl.openConnection();
            conn.setConnectTimeout(20000);
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应

            InputStreamReader reader = new InputStreamReader(conn.getInputStream(), ConstantUtil.UTF_CODE);
            char[] buff = new char[1024];
            int length = 0;
            while ((length = reader.read(buff)) != -1) {
                String result = new String(buff, 0, length);
                jsonStr.append(result);
            }
        } catch (Exception e) {
            LOGGER.error("发送 POST 请求出现异常！", e);
        }
        //使用finally块来关闭输出流、输入流
        finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                LOGGER.error(ex.getMessage(), ex);
            }
        }
        return jsonStr.toString();
    }

    public static void main(String[] args) {
        String url = "http://at.itsmore.com/goods/";
        System.out.println(HttpRequestUtil.sendGet(url, null));
    }
}

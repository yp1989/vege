package com.vcooline.crm.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * 文件辅助类
 * Created by xinbaojian on 15/11/12.
 */
public class FileUtils {

    protected static Logger logger = LoggerFactory.getLogger(FileUtils.class);

    public static void main(String[] args) throws IOException {
//        List<String> pathList = new ArrayList<>();
//        pathList.add("/Users/xinbaojian/Downloads/test/辛保健-简历.doc");
//        pathList.add("/Users/xinbaojian/Downloads/test/系统详细设计报告-CRM.doc");
////        pathList.add("/Users/xinbaojian/Downloads/test/招募系统.xlsx");
//
//        ZipFiles(pathList, "/Users/xinbaojian/Desktop/xinbaojian.zip");

    }

    public static boolean ZipFiles(List<String> filePaths, String zipFileName) {
        try {
            File zipFile = new File(zipFileName);
            if (!zipFile.getParentFile().exists()) {
                zipFile.getParentFile().mkdirs();
            }
            InputStream input = null;
            ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipFile));
            // zip的名称为
            zipOut.setComment(zipFile.getName());

            File[] files = new File[filePaths.size()];
            for (int i = 0; i < filePaths.size(); i++) {
                files[i] = new File(filePaths.get(i));
            }
            for (int i = 0; i < files.length; ++i) {
                input = new FileInputStream(files[i]);
                zipOut.putNextEntry(new ZipEntry(files[i].getName()));
                int temp;
                byte[] buf = new byte[1024];
                while ((temp = input.read(buf)) != -1) {
                    zipOut.write(buf, 0, temp);
                }
                input.close();
            }
            zipOut.close();
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("压缩文件失败了", e);
            return false;
        }
        return true;
    }

}

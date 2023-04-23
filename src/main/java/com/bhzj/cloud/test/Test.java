package com.bhzj.cloud.test;


import org.apache.commons.io.FileUtils;

import java.io.File;

public class Test {
    public static void main(String[] args) throws Exception {
//        long size = FileUtils.sizeOfDirectory(new File("C:/test"));
//        System.out.println("Size: " + size + " bytes");


        String basePath="C:/驱动程序/WIN10驱动/";
        File baseFile = new File(basePath);
        String[] list = baseFile.list();

        for(String dirName : list){
            File fileItem = new File(basePath+dirName);
            if(fileItem.isFile()){
                long mb = MB(fileItem.length());
                if(mb>500){
                    System.out.println(dirName + "-文件: " + mb);
                }
            }else{
                long size = FileUtils.sizeOfDirectory(new File(basePath+dirName));
                long mb = MB(size);
                if(mb>500){
                    System.out.println(dirName + "-目录: " + mb  );
                }
            }

        }

        System.out.println("\n\n执行完成");
    }

    public static long MB(long b){
        long mb = b / (1024 * 1024);
        return mb;
    }

}

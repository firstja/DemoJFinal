package com.baidu.commons.kit;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

/**
 * 作者:shaoQW
 * 创建日期:2019-03-29 22:13
 * 修改日期:
 * description:实现文件的替换
 **/
public class FileService {

    public static void fileChannel(File s, File m){

        FileInputStream fis =  null;
        FileOutputStream fos = null;
        FileChannel in = null;
        FileChannel out = null;
        try{
            fis = new FileInputStream(s);
            fos = new FileOutputStream(m);

            //获取通道
            in = fis.getChannel();
            out = fos.getChannel();
            in.transferTo(0,in.size(),out); //连接传输通道
        }catch (Exception e){

        }finally {
            try {
                fis.close();
                in.close();
                fos.close();
                out.close();
            }catch (Exception e){

            }
        }
    }
}

package com.baidu.controller;

import com.baidu.commons.kit.FileService;
import com.baidu.commons.kit.PageHelper;
import com.baidu.model.Dog;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.upload.UploadFile;

import java.io.File;

/**
 * 作者:shaoQW
 * 创建日期:2019-03-28 22:11
 * 修改日期:
 * description:
 **/
public class DogController extends Controller {

    //获取所有的dog数据
    public void findAllDogs(){
        //获取url携带的页码和每页显示记录数
        int pageSize=getInt("limit"),pageNumber=getInt("page");
        //执行分页查询 获取page对象
        Page<Dog> page = Dog.dao.paginate(pageNumber,pageSize,"select id,d_name","from dog");
        //page帮助类,实现table表格的渲染
        PageHelper<Dog> pageHelper = new PageHelper<>(page.getList(),page.getTotalRow());
        renderJson(pageHelper);
    }



    //新增dog信息
    public void saveDog(){
        System.out.println("访问到此方法");
        boolean falg = false; //标志位
        try{
            System.out.println("执行");
            falg = new Dog().setDName(get("d_name")).save(); //新增dog

        }catch (Exception e){
            renderJson("msg",e.getMessage());//返回错误信息
        }
        renderJson("code",falg);
    }


    //实现文件上传
    public void fileUplaod(){
        //注意:如果是文件上传,只有先获取文件,才能获取到别的参数哦
        UploadFile uploadFile = getFile();
        //获取提交的文件
        File file = uploadFile.getFile();

        //获取文件名
        String fileName = uploadFile.getOriginalFileName();
        //获取文件存储路径
        String path = getRequest().getSession().getServletContext().getRealPath("upload");//默认存放在upload文件
        //创建一个新文件
        File file1 = new File(path+File.separator+fileName);
        //判断文件是否存在
        if(!file1.exists()){//如果文件不存在
            try{
                file1.createNewFile();

            }catch (Exception e){
                renderJson("msg","上传失败");
            }

        }
        //替换文件
        FileService.fileChannel(file,file1);
        //删除旧文件
        file.delete();
        renderJson("code","1");
    }


    //根据编号删除dog信息
    public void removeDogById(){
        int id = getInt("id");//获取url的参数值
        boolean falg=false;
        try{
            falg = Dog.dao.deleteById(id);//删除操作(根据dog编号)

        }catch (Exception e){
            renderJson("msg",e.getMessage()); //发生异常
        }
        renderJson("code",falg); //执行成功

    }

    //根据dog编号,修改dog姓名
    public void editDNameById(){
        //获取url中携带的参数值
        int id = getInt("id");
        String dName = get("d_name");
        boolean falg = false;
        try{
            //执行修改操作
            falg = Dog.dao.findById(id).setDName(dName).update();

        }catch (Exception e){
            renderJson("msg",e.getMessage());
        }
        renderJson("code",falg);
    }



}

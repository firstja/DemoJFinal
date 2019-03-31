package com.baidu.controller.handler;

import com.jfinal.handler.Handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 作者:shaoQW
 * 创建日期:2019-03-30 20:35
 * 修改日期:
 * description:
 **/
public class ResourceHandler extends Handler {
    @Override
    public void handle(String target, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, boolean[] booleans) {
        //target:
        System.out.println(target);

        //接收所有的web请求

        //conr4j的具体应用场景
        //数据表的统计,定时更新

        //继续往下执行
        handle(target,httpServletRequest,httpServletResponse,booleans);
    }

}

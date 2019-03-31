package com.baidu.aop.interceptor;

import com.alibaba.druid.pool.vendor.SybaseExceptionSorter;
import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

/**
 * 作者:shaoQW
 * 创建日期:2019-03-28 22:06
 * 修改日期:
 * description:
 **/
public class LoginInterceptor implements Interceptor {
    @Override
    public void intercept(Invocation invocation) {
        System.out.println("----------------->之前执行");
        invocation.invoke();
        System.out.println("----------------->之后执行");
    }

}

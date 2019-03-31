package com.baidu.config;

import com.baidu.aop.interceptor.LoginInterceptor;
import com.baidu.controller.DogController;
import com.baidu.model._MappingKit;
import com.jfinal.config.*;
import com.jfinal.kit.Prop;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.template.Engine;

/**
 * 作者:shaoQW
 * 创建日期:2019-03-28 22:04
 * 修改日期:
 * description:核心配置类
 **/
public class SystemConfig extends JFinalConfig {

    //常量配置
    @Override
    public void configConstant(Constants constants) {
        //设置开发者模式
        constants.setDevMode(PropKit.use("ds.properties").getBoolean("devmode"));
        //设置依赖注入
        constants.setInjectDependency(true);

    }

    //路由配置
    @Override
    public void configRoute(Routes routes) {
        routes.add("/dog", DogController.class);

    }
    //引擎配置
    @Override
    public void configEngine(Engine engine) {

    }
    //插件配置
    @Override
    public void configPlugin(Plugins plugins) {
        //读取配置文件
        Prop prop = PropKit.use("ds.properties");
        DruidPlugin dp = new DruidPlugin(prop.get("url"),prop.get("username"),prop.get("password"));
        plugins.add(dp);
        //数据库访问插件
        ActiveRecordPlugin arp = new ActiveRecordPlugin(dp);
        //设置是否显示执行的sql
        arp.setShowSql(true);
        _MappingKit.mapping(arp); //添加model到数据表的映射
        plugins.add(arp);

    }
    //拦截器配置
    @Override
    public void configInterceptor(Interceptors interceptors) {
        //添加全局拦截器
        interceptors.add(new LoginInterceptor());

    }
    //处理器配置
    @Override
    public void configHandler(Handlers handlers) {

    }
}

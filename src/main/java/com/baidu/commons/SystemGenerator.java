package com.baidu.commons;

import com.jfinal.kit.PathKit;
import com.jfinal.kit.Prop;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.dialect.MysqlDialect;
import com.jfinal.plugin.activerecord.generator.Generator;
import com.jfinal.plugin.druid.DruidPlugin;

import javax.sql.DataSource;

/**
 * 作者:shaoQW
 * 创建日期:2019-03-28 21:48
 * 修改日期:
 * description:
 **/
public class SystemGenerator {

    //准备数据源
    public static DataSource getDataSource(){
        Prop prop  = PropKit.use("ds.properties");
        DruidPlugin dp  = new DruidPlugin(prop.get("url"),prop.get("username"),prop.get("password"));
        dp.start();
        return dp.getDataSource();
    }

    //实现model的自动生成
    public static void main(String[] args) {
        //baseModel存放的包名
        String baseModelPackageName="com.baidu.model.base";
        //baseModel所在的位置
        String baseModelOutPutDir = PathKit.getWebRootPath()+"/src/main/java/com/baidu/model/base";
        //model存放的包名
        String modelPackageName= "com.baidu.model";
        //model存放的位置
        String modelOutPutDir=baseModelOutPutDir+"/..";
        Generator generator = new Generator(getDataSource(),baseModelPackageName,baseModelOutPutDir,modelPackageName,modelOutPutDir);
        //设置是否生成setter方法链
        generator.setGenerateChainSetter(true);
        //设置是否生成model文件中的dao
        generator.setGenerateDaoInModel(true);
        //设置是否生成数据字典
        generator.setGenerateDataDictionary(false);
        //设置数据库方言
        generator.setDialect(new MysqlDialect());
        generator.generate();
    }


}

import com.alibaba.druid.pool.vendor.SybaseExceptionSorter;
import com.jfinal.kit.Prop;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import org.junit.Test;

/**
 * 作者:shaoQW
 * 创建日期:2019-03-28 21:50
 * 修改日期:
 * description:测试数据源
 **/
public class DbTest {
    private DruidPlugin dp = null;
    private ActiveRecordPlugin arp = null;


    @Test
    public void testDb(){
        Prop prop = PropKit.use("ds.properties");
        dp = new DruidPlugin(prop.get("url"),prop.get("username"),prop.get("password"));
        dp.start();
        arp = new ActiveRecordPlugin(dp.getDataSource());
        arp.start();
        System.out.println(dp.getDataSource());
    }


}

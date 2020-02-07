package com.zhuguang.jack.dynamicDataSource;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * 往期视频加瑶瑶老师QQ：2483034688
 * Jack老师QQ： 2943489129
 * 时间   ：     2018年6月14日 下午9:05:57
 * 作者   ：   烛光学院【Jack老师】
 * <p>
 * 如果要用到spring中的动态数据源切换功能，那么必须要继承 AbstractRoutingDataSource
 * <p>
 * 如何才能让这个类实例化并且交给spring管理
 * <p>
 * <p>
 * 1、在类上面加注解@Service@Component@Resource
 * 2、创建beanDifinition对象，然后设置BeanClass属性
 */

public class DynamicDataSource extends AbstractRoutingDataSource {

    /**
     * 往期视频加瑶瑶老师QQ：2483034688
     * Jack老师QQ： 2943489129
     * 时间   ：     2018年6月14日 下午9:08:27
     * 作者   ：   烛光学院【Jack老师】
     * <p>
     * 在这个方法里面要返回一个数据源的标识比如 ： ds1，ds2
     */
    @Override
    protected Object determineCurrentLookupKey() {
        try {
            Field targetF = this.getClass().getSuperclass().getDeclaredField("targetDataSources");
            targetF.setAccessible(true);
            Map<Object, Object> targetV = (Map<Object, Object>) targetF.get(this);

            String ds = DynamicDataSourceContextHolder.getDataSourceType();

            if (ds != null)
                System.out.println("操作的数据源是： "
                        + ds + "->url:" + ((DruidDataSource) targetV.get(ds)).getUrl());
            return DynamicDataSourceContextHolder.getDataSourceType();

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return "ds1";
    }

}

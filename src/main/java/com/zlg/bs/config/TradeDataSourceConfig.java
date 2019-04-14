package com.zlg.bs.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.logging.slf4j.Slf4jImpl;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = {"com.zlg.bs.mapper.trade"},sqlSessionFactoryRef = "tradeSqlSessionFactory")
public class TradeDataSourceConfig {
    @Bean(name = "tradedatasource",destroyMethod = "close")
    public DruidDataSource dataSource() throws Exception{
        //String config = ConfigService.getConfig("yundt.smartsales.mall.appmgmt.datasourcevo", "zlg", 3000);

        //DataSourceVo dataSourceVo = JSONObject.parseObject(config, DataSourceVo.class);

        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://127.0.0.1/bs_trade?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull&allowMultiQueries=true");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        dataSource.setMaxActive(5);
        dataSource.setValidationQuery("SELECT 1");
        dataSource.setInitialSize(1);
        dataSource.setMinIdle(0);
        dataSource.setMaxWait(6000);
        return dataSource;
    }
    @Bean(name = "tradeSqlSessionFactory")
    public SqlSessionFactory sqlsessionFactoryBean(@Qualifier("tradedatasource") DruidDataSource dataSource) throws Exception{
        org.apache.ibatis.session.Configuration config = new org.apache.ibatis.session.Configuration();
        config.setMapUnderscoreToCamelCase(true);
        config.setLogImpl(Slf4jImpl.class);
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setConfiguration(config);

        return sqlSessionFactoryBean.getObject();
    }

}

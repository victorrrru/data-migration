package com.muyuan.skip.dbmanger;

import com.muyuan.skip.configs.MysqlDataSource;
import com.mysql.cj.jdbc.MysqlXADataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by Administrator on 2017/8/1.
 */
//@Configuration
@MapperScan(basePackages = {"com.muyuan.skip.mapper.mysql"}, sqlSessionTemplateRef = "mysqlSqlSessionTemplate")
public class MysqlDataConfig {
    // 配置数据源
    @Bean(name = "mysqlDataSource")
    public DataSource mysqlDataSource(MysqlDataSource dataSource) throws SQLException {
        MysqlXADataSource mysqlXaDataSource = new MysqlXADataSource();
        mysqlXaDataSource.setUrl(dataSource.getUrl());
        mysqlXaDataSource.setUser(dataSource.getUsername());
        mysqlXaDataSource.setPassword(dataSource.getPassword());
        mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);
        AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
        xaDataSource.setXaDataSource(mysqlXaDataSource);
        xaDataSource.setUniqueResourceName("mysqlDataSource");
        return xaDataSource;
    }

    @Bean(name = "mysqlDataSqlSessionFactory")
    public SqlSessionFactory mysqlSqlSessionFactory(@Qualifier("mysqlDataSource") DataSource dataSource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/mysql/**/*Mapper.xml"));
        return bean.getObject();
    }

    @Bean(name = "mysqlDataSqlSessionTemplate")
    public SqlSessionTemplate mysqlSqlSessionTemplate(
            @Qualifier("mysqlDataSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
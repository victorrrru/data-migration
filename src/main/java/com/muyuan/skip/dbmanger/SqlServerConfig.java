package com.muyuan.skip.dbmanger;


import com.atomikos.jdbc.AtomikosDataSourceBean;
import com.muyuan.skip.configs.SqlServerDataSource;
import com.mysql.cj.jdbc.MysqlXADataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created By victorrrr on 2017/8/22
 */

//@Configuration
@MapperScan(basePackages = {"com.muyuan.skip.mapper.sqlserver"}, sqlSessionTemplateRef = "sqlserverSqlSessionTemplate")
public class SqlServerConfig {

  // 配置数据源
  @Bean(name = "sqlserverSource")
  public DataSource sqlserverDataSource(SqlServerDataSource dataSource) throws SQLException {
      MysqlXADataSource mysqlXaDataSource = new MysqlXADataSource();
      mysqlXaDataSource.setUrl(dataSource.getUrl());
      mysqlXaDataSource.setUser(dataSource.getUsername());
      mysqlXaDataSource.setPassword(dataSource.getPassword());
      mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);
      AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
      xaDataSource.setXaDataSource(mysqlXaDataSource);
      xaDataSource.setUniqueResourceName("sqlserverSource");
      return xaDataSource;
  }

  @Bean(name = "sqlserverSqlSessionFactory")
  public SqlSessionFactory sqlserverSqlSessionFactory(@Qualifier("sqlserverSource") DataSource dataSource)
          throws Exception {
      SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
      bean.setDataSource(dataSource);
      bean.setMapperLocations(
              new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/sqlserver/**/*Mapper.xml"));
      return bean.getObject();
  }

  @Bean(name = "sqlserverSqlSessionTemplate")
  public SqlSessionTemplate sqlserverSqlSessionTemplate(
          @Qualifier("sqlserverSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
      return new SqlSessionTemplate(sqlSessionFactory);
  }

}

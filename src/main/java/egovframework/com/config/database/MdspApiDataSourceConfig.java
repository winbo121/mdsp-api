package egovframework.com.config.database;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.atomikos.jdbc.AtomikosDataSourceBean;
import com.tmax.tibero.jdbc.ext.TbXADataSource;

/**
 * 
 * MDSP Tibero DB DataSourceConfig 
 * 멀티,이기종 트랜젝션 처리를 위한 JTA 설정
 *
 * @author 임명호
 * @version 1.0
 * @since 2024.07.08
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *     수정일        수정자           수정내용
 *  ----------    --------    ---------------------------
 *  2024.07.08    임명호        최초 생성
 * </pre>
 */ 

@Configuration
@PropertySource(value = {"classpath:egovframework/config/mdsp-api-datasource.properties"
		}, ignoreResourceNotFound = true)

@MapperScan(
				basePackages="egovframework.mdsp.**.dao", 
				sqlSessionFactoryRef="mdspApiTiberoSqlSessionFactory"
			)
public class MdspApiDataSourceConfig {

    @Autowired
    private Environment env;
    
    @Primary
    @Bean(name = "mdspApiTiberoDataSource", destroyMethod = "close")
    public DataSource mdspApiTiberoDataSource() throws Exception{
    	
    	TbXADataSource xaDataSource = new TbXADataSource();
    	xaDataSource.setURL(env.getProperty("app.mdsp.api.datasource.url"));
    	xaDataSource.setUser(env.getProperty("app.mdsp.api.datasource.username"));
    	xaDataSource.setPassword(env.getProperty("app.mdsp.api.datasource.password"));
    	
        AtomikosDataSourceBean dataSource = new AtomikosDataSourceBean();
        
        dataSource.setUniqueResourceName("mdspApiTiberoDataSource");
        //dataSource.setXaDataSourceClassName(env.getProperty("app.mdsp.datasource.driverClassName"));
        dataSource.setUniqueResourceName(env.getProperty("app.mdsp.api.datasource.uniqueResourceName"));
        //dataSource.setMaxPoolSize(env.getProperty("app.mdsp.datasource.maxPoolSize", Integer.class));
        //dataSource.setMinPoolSize(env.getProperty("app.mdsp.datasource.minPoolSize", Integer.class));
        dataSource.setXaDataSource(xaDataSource);

        return dataSource;
        
    }

    @Primary
    @Bean(name = "mdspApiTiberoSqlSessionFactory")
    public SqlSessionFactory mdspApiTiberoSqlSessionFactory(@Qualifier("mdspApiTiberoDataSource")DataSource mdspApiTiberoDataSource) throws Exception {
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setFailFast(true);
        sessionFactoryBean.setDataSource(mdspApiTiberoDataSource);
        sessionFactoryBean.setConfigLocation(resolver.getResource("classpath:egovframework/config/mybatis.xml"));

        // Type Aliases
        String typeAliasesPackage = "egovframework.**.dto";
        typeAliasesPackage += ",egovframework.**.entity";
        sessionFactoryBean.setTypeAliasesPackage(typeAliasesPackage);
        sessionFactoryBean.setVfs(CustomMyBatisVfs.class);

        // XML Mapper
        Resource[] mapperXmls = resolver.getResources("classpath:egovframework/mapper/mdsp/api/**/*.xml");
        sessionFactoryBean.setMapperLocations(mapperXmls);
        sessionFactoryBean.afterPropertiesSet();

        return sessionFactoryBean.getObject();
    }

}
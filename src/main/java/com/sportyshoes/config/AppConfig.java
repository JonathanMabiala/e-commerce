package com.sportyshoes.config;

import java.beans.PropertyVetoException;
import java.util.Properties;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.sportyshoes")
@PropertySource("classPath:persistence-mysql.properties")
@EnableTransactionManagement
public class AppConfig implements WebMvcConfigurer {
	
	// Set up a variable to hold the properties
	
	@Autowired
	private Environment env;

	//Set up a logger
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	//Define a Encrytion
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}
	
	//Define a bean for ViewResolver
	
	@Bean
	public ViewResolver viewResolver() {
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}
	
	 @Override
	  public void addResourceHandlers(ResourceHandlerRegistry registry) {
	        registry
	          .addResourceHandler("/resource/**")
	          .addResourceLocations("/static/");	
	    }
	
	
	
	
	//Define a bean for our security datasource
	
	@Bean
	public DataSource securityDataSource() {
		
		//Create connection
		
		ComboPooledDataSource securityDataSource = new ComboPooledDataSource();
		
		
		//set the jdbc
		
		try {
			securityDataSource.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (PropertyVetoException exc) {
			
			throw new RuntimeException(exc);
		}
		
		//log the connection
		
		logger.info(">>> jdbc.url=" + env.getProperty("jdbc.url"));
		logger.info(">>> jdbc.user=" + env.getProperty("jdbc.user"));
		
		
		//set database connection props
		
		securityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		securityDataSource.setUser(env.getProperty("jdbc.user"));
		securityDataSource.setPassword(env.getProperty("jdbc.password"));
		
		//set connection pool props
		
		securityDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
		securityDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
		securityDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
		securityDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));
		return securityDataSource;
	}
	
	//Read env property and convert to int
	
	private int getIntProperty(String propName) {
		String propVal = env.getProperty(propName);
		
		//Now convert to int 
		
		int intPropVal = Integer.parseInt(propVal);
		
		return intPropVal;
	}
	
	
	
	 private Properties hibernateProperties() {
	        Properties properties = new Properties();
	        properties.put("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
	        properties.put("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));
	        properties.put("hibernate.format_sql", env.getRequiredProperty("hibernate.format_sql"));
	        properties.put("hibernate.hbm2ddl.auto", env.getRequiredProperty("hibernate.hbm2ddl.auto"));
	        return properties;
	    }
	  
	 @Bean
	 public LocalSessionFactoryBean sessionFactory() {
	        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
	        sessionFactory.setDataSource(securityDataSource());
	        sessionFactory.setPackagesToScan(new String[] {
	            "com.sportyshoes.entity"
	        });
	        sessionFactory.setHibernateProperties(hibernateProperties());
	        return sessionFactory;
	    }

	    @Bean
	    public HibernateTransactionManager getTransactionManager() {
	        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
	        transactionManager.setSessionFactory(sessionFactory().getObject());
	        return transactionManager;
	    }
	
}

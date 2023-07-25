package com.example.demo;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@SpringBootConfiguration
public class AppConfiguration {
	@Autowired
	private Environment env;
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource source = new DriverManagerDataSource();
		source.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
		source.setUrl(env.getProperty("spring.datasource.url"));
		source.setUsername(env.getProperty("spring.datasource.name"));
		source.setPassword(env.getProperty("spring.datasource.password"));
		return source;
	}
	
	@Bean(name = "entityManagerFactory")
	public SessionFactory getSessionDactory() {
		LocalSessionFactoryBean sf = new LocalSessionFactoryBean();
		sf.setDataSource(getDataSource());
		sf.setPackagesToScan("com.example.demo.entites");
		Properties props = new Properties();
		props.put("hibernate.show_sql", env.getProperty("spring.jpa.show-sql"));
		props.put("hibernate.dialect", env.getProperty("spring.jpa.properties.hibernate.dialect"));
		sf.setHibernateProperties(props);
		try {
			sf.afterPropertiesSet();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sf.getObject();
	}
	
	
}

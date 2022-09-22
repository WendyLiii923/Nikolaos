package com.java18.nikolaos.config;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "com.java18.nikolaos")
public class SpringConfig {

    @Bean
	public DataSource dataSource() {
		DriverManagerDataSource dmds = new DriverManagerDataSource();

		// set properties
		dmds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dmds.setUrl("jdbc:mysql://localhost:3306/18_project_db");
		dmds.setUsername("root");
		dmds.setPassword("lwl220420");

		return dmds;
	}

//    @Bean
//    public DataSource dataSource() {
//        JndiObjectFactoryBean factory = new JndiObjectFactoryBean();
//        factory.setJndiName("java:comp/env/jdbc/18_project_db");
//        factory.setProxyInterface(DataSource.class);
//
//        try {
//
//            // look up
//            factory.afterPropertiesSet();
//        } catch (IllegalArgumentException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (NamingException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//
//        return (DataSource) factory.getObject();
//
//    }

    @Bean
    public SessionFactory sessionFactory() {
        return new LocalSessionFactoryBuilder(dataSource())
                .configure("hibernate.cfg.xml").buildSessionFactory();
    }

    @Bean
    public PlatformTransactionManager transactionManagement() {
        return new HibernateTransactionManager(sessionFactory());

    }
}

package com.niit.choco.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.niit.choco.model.AnswerForum;
import com.niit.choco.model.Blog;
import com.niit.choco.model.BlogComment;
import com.niit.choco.model.Forum;
import com.niit.choco.model.Friend;
import com.niit.choco.model.Jobs;
import com.niit.choco.model.Users;



@Configuration
@ComponentScan("com")
@EnableTransactionManagement
public class ApplicationConfiguration {

	@Bean(name = "dataSource")
	public DataSource getDatasource(){
		DriverManagerDataSource dmd=new DriverManagerDataSource();
		dmd.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dmd.setUrl("jdbc:oracle:thin:@//localhost:1521/XE ");
		dmd.setUsername("chatting");
        dmd.setPassword("chatting");
        System.out.println("datasource");
		return dmd;		
		
		
	}
	
	public Properties getHibernateProperties(){
		
		Properties p=new Properties();
     p.setProperty("hibernate.hbm2ddl.auto", "update"); 
		

		p.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");

		
		
        System.out.println("properties choco");

		return p;
	}
	@Autowired
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource)
	{
		LocalSessionFactoryBuilder localSessionFactoryBuilder=new LocalSessionFactoryBuilder(dataSource);
		localSessionFactoryBuilder.addProperties(getHibernateProperties());
		localSessionFactoryBuilder.addAnnotatedClass(Users.class);
		localSessionFactoryBuilder.addAnnotatedClass(Blog.class);
		localSessionFactoryBuilder.addAnnotatedClass(Forum.class);
		localSessionFactoryBuilder.addAnnotatedClass(Jobs.class);
		localSessionFactoryBuilder.addAnnotatedClass(Friend.class);
		localSessionFactoryBuilder.addAnnotatedClass(BlogComment.class);
		localSessionFactoryBuilder.addAnnotatedClass(AnswerForum.class);
		
		return localSessionFactoryBuilder.buildSessionFactory();
	}
	@Autowired
	@Bean(name="transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{
		HibernateTransactionManager hibernateTransactionManager=new HibernateTransactionManager(sessionFactory);
		return hibernateTransactionManager;
		
	}
	@Bean
	public CommonsMultipartResolver multipartResolver() {
	    CommonsMultipartResolver resolver=new CommonsMultipartResolver();
	    resolver.setDefaultEncoding("utf-8");
	    return resolver;
	}

}

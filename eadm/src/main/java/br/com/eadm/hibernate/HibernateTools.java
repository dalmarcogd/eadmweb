package br.com.eadm.hibernate;

import java.util.Iterator;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.persistence.Entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.mapping.PersistentClass;
import org.hibernate.tool.hbm2ddl.SchemaUpdate;
import org.reflections.Reflections;

import br.com.eadm.dao.BasicDAO;

public class HibernateTools {
	
	private static final SessionFactory sessionFactory = buildSessionFactory();
	private static Configuration configuration;
	
	private static final String dialect = "org.hibernate.dialect.MySQLDialect";
	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/eadm";
	private static final String username = "root";
	private static final String password = "1";
	private static final String showSQL = "true";
	private static final String formatSQL = "true";
	private static final String hbm2ddl = "true"; 
	
	//@PostConstruct
	private static SessionFactory buildSessionFactory() {
		
		configuration = new Configuration();
		
		//configuration.configure("/hibernate.cfg.xml");
		
		//configuração das property
		configuration.setProperty("hibernate.dialect",dialect);
		configuration.setProperty("hibernate.connection.url",url);
		configuration.setProperty("hibernate.connection.username",username);
		configuration.setProperty("hibernate.connection.driver_class",driver);
		configuration.setProperty("hibernate.connection.password",password);
		configuration.setProperty("hibernate.show_sql",showSQL);
		configuration.setProperty("hibernate.format_sql",formatSQL);
		configuration.setProperty("hibernate.hbm2ddl.auto",hbm2ddl);
		
		//classes a serem mapeadas
		
		Reflections reflections = new Reflections("br.com.eadm.model");
		Set<Class<?>> typesAnnotatedWith = reflections.getTypesAnnotatedWith(Entity.class);
		
		for (Class<?> class1 : typesAnnotatedWith) {
			configuration.addAnnotatedClass(class1.getClass());
		}
		
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		
		return configuration.buildSessionFactory(builder.build());	 
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public static void updateSchemma(){
		try {
			SchemaUpdate seUpdate = new SchemaUpdate(configuration,configuration.getProperties());
			seUpdate.execute(true, true);
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	
	public void saveOrUpdate(BasicDAO basicDAO){
		Transaction transaction = null;
		Session session = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			session.saveOrUpdate(basicDAO);
			transaction.commit();
			
			session.close();
		} catch (Exception e) {
			transaction.rollback();
			session.close();
		}
	}
	
	public void delete(BasicDAO basicDAO){
		Transaction transaction = null;
		Session session = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			session.delete(basicDAO);
			transaction.commit();
			
			session.close();
		} catch (Exception e) {
			transaction.rollback();
			session.close();
		}
	}
	
}

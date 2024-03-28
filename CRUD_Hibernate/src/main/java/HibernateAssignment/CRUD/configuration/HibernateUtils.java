package HibernateAssignment.CRUD.configuration;


import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import HibernateAssignment.CRUD.entity.Employee;

import java.util.Properties;

public class HibernateUtils {
	
	public static SessionFactory getSessionFactory() {
		
		Configuration configuration = new Configuration();
		SessionFactory sessionFactory = null;
		Properties settings = new Properties();
		  settings.put(Environment.DRIVER, "org.hsqldb.jdbc.JDBCDriver");
	        settings.put(Environment.URL, "jdbc:hsqldb:mem:myDb");
	        settings.put(Environment.USER, "root");
	        settings.put(Environment.PASS, "1234");
	        settings.put(Environment.SHOW_SQL, "true");
	        settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
	        settings.put(Environment.HBM2DDL_AUTO, "create-drop");

	        configuration.setProperties(settings);
	        configuration.addAnnotatedClass(Employee.class);

	        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
	                .applySettings(configuration.getProperties()).build();

	        sessionFactory = configuration.buildSessionFactory(serviceRegistry);

	        return sessionFactory;
		
	}

}

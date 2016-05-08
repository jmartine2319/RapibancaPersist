package com.rapibanca.session;

import javassist.util.proxy.ProxyFactory;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.rapibanca.tool.EnumProperties;

public class SessionFactoryHibernate extends ProxyFactory {
	private static final SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;
	static EnumProperties enumProperties = EnumProperties.INSTANCE;
	
	static {
		try {
			
			Configuration configuration = new Configuration();
			configuration.setProperty("hibernate.connection.driver_class", enumProperties.getProperty("driver"));
			configuration.setProperty("hibernate.connection.url", enumProperties.getProperty("url"));
			configuration.setProperty("hibernate.connection.username", enumProperties.getProperty("user"));
			configuration.setProperty("hibernate.connection.password", enumProperties.getProperty("password"));
			configuration.setProperty("hibernate.default_schema", enumProperties.getProperty("schema"));
			configuration.setProperty("hibernate.dialect", enumProperties.getProperty("dialect"));
		    configuration.configure();
			serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		} catch (Throwable ex) {

			System.err.println("Initial SessionFactory creation failed." + ex);

			throw new ExceptionInInitializerError(ex);

		}

	}

	public static SessionFactory getSessionFactory() {

		return sessionFactory;

	}
	
	@Override
    protected ClassLoader getClassLoader() {
        ClassLoader classLoader = getSuperclass().getClassLoader();
        if (classLoader == null) {
            return SessionFactoryHibernate.class.getClassLoader();
        } else {
            return classLoader;
        }
    }
}

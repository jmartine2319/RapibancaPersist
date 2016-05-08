package com.rapibanca.dao;
// default package
// Generated 16/04/2016 01:23:11 PM by Hibernate Tools 3.4.0.CR1

import com.rapibanca.entities.ClienteRapibanca;
import com.rapibanca.entities.ProductosRapibanca;
import com.rapibanca.session.SessionFactoryHibernate;
import java.math.BigDecimal;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.Session;

/**
 * Home object for domain model class ProductosRapibanca.
 * @see .ProductosRapibanca
 * @author Hibernate Tools
 */
@Stateless
public class ProductosRapibancaDAO {


	@PersistenceContext
        
        private Session session = SessionFactoryHibernate.getSessionFactory().openSession();
	public void persist(ProductosRapibanca transientInstance) {
	
		try {
			session.getTransaction().begin();
			session.persist(transientInstance);
			session.getTransaction().commit();
			session.clear();
                        System.out.println("succed");
			
		} catch (Exception re) {
			session.getTransaction().rollback();
			
			System.out.println("hubo un error ProductoRapibancaDAO.persist "+re);
			throw re;
		}
	}
	

	/*public void remove(ProductosRapibanca persistentInstance) {
		
		try {
			entityManager.remove(persistentInstance);
			
		} catch (RuntimeException re) {
			
			throw re;
		}

	}

	public ProductosRapibanca merge(ProductosRapibanca detachedInstance) {
		
		try {
			ProductosRapibanca result = entityManager.merge(detachedInstance);
			
			return result;
		} catch (RuntimeException re) {
			
			throw re;
		}
	}

	public ProductosRapibanca findById(BigDecimal id) {
		
		try {
			ProductosRapibanca instance = entityManager.find(
					ProductosRapibanca.class, id);
			
			return instance;
		} catch (RuntimeException re) {
			
			throw re;
		}
	}¨*/
}

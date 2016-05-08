package com.rapibanca.dao;
// default package
// Generated 16/04/2016 01:23:11 PM by Hibernate Tools 3.4.0.CR1

import com.rapibanca.entities.ClienteRapibanca;
import java.math.BigDecimal;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.Session;
import com.rapibanca.session.SessionFactoryHibernate;
import javax.persistence.Query;

/**
 * Home object for domain model class ClienteRapibanca.
 * @see .ClienteRapibanca
 * @author Hibernate Tools
 */
@Stateless
public class ClienteRapibancaDAO {

	@PersistenceContext
	private Session session = SessionFactoryHibernate.getSessionFactory().openSession();

	public void persist(ClienteRapibanca transientInstance) {
		try {
			session.getTransaction().begin();
			session.persist(transientInstance);
			session.getTransaction().commit();
			session.clear();
                        System.out.println("succed");
			
		} catch (Exception re) {
			session.getTransaction().rollback();
			
			System.out.println("hubo un error ClienteRapibancaDAO.persist "+re);
			throw re;
		}
	}

	public void remove(ClienteRapibanca persistentInstance) {
		
		try {
			session.getTransaction().begin();
			session.delete(persistentInstance);
			session.getTransaction().commit();
			session.clear();
			
		} catch (Exception re) {
			session.getTransaction().rollback();
			
			throw re;
		}
	}

	/*public ClienteRapibanca merge(ClienteRapibanca detachedInstance) {
		log.debug("merging ClienteRapibanca instance");
		try {
			ClienteRapibanca result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}*/

	public ClienteRapibanca findById(BigDecimal id) {
		
		try {
			session.getTransaction().begin();
			//Query query = (Query) session.getNamedQuery("findStockByStockCode").setBigDecimal(id);
			session.getTransaction().commit();
			session.clear();
			
			return null;
		} catch (RuntimeException re) {
			
			throw re;
		}
	}
}

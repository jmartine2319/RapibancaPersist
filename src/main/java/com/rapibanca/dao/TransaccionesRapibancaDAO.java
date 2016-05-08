package com.rapibanca.dao;
// default package
// Generated 16/04/2016 01:23:11 PM by Hibernate Tools 3.4.0.CR1

import com.rapibanca.entities.TransaccionesRapibanca;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 * Home object for domain model class TransaccionesRapibanca.
 * @see .TransaccionesRapibanca
 * @author Hibernate Tools
 */
@Stateless
public class TransaccionesRapibancaDAO {


	@PersistenceContext
	private EntityManager entityManager;

	public void persist(TransaccionesRapibanca transientInstance) {
		
		try {
			entityManager.persist(transientInstance);
			
		} catch (RuntimeException re) {
			
			throw re;
		}
	}

	public void remove(TransaccionesRapibanca persistentInstance) {
		try {
			entityManager.remove(persistentInstance);
			
		} catch (RuntimeException re) {
			
			throw re;
		}
	}

	public TransaccionesRapibanca merge(TransaccionesRapibanca detachedInstance) {
		
		try {
			TransaccionesRapibanca result = entityManager
					.merge(detachedInstance);
			
			return result;
		} catch (RuntimeException re) {
			
			throw re;
		}
	}

	public TransaccionesRapibanca findById(String id) {
		
		try {
			TransaccionesRapibanca instance = entityManager.find(
					TransaccionesRapibanca.class, id);
			
			return instance;
		} catch (RuntimeException re) {
			
			throw re;
		}
	}
}

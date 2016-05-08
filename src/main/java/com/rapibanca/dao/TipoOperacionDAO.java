package com.rapibanca.dao;
// default package
// Generated 16/04/2016 01:23:11 PM by Hibernate Tools 3.4.0.CR1

import com.rapibanca.entities.TipoOperacion;
import java.math.BigDecimal;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;



/**
 * Home object for domain model class TipoOperacion.
 * @see .TipoOperacion
 * @author Hibernate Tools
 */
@Stateless
public class TipoOperacionDAO {


	@PersistenceContext
	private EntityManager entityManager;

	public void persist(TipoOperacion transientInstance) {
		
		try {
			entityManager.persist(transientInstance);
			
		} catch (RuntimeException re) {
                    
			throw re;
		}
	}

	public void remove(TipoOperacion persistentInstance) {
		
		try {
			entityManager.remove(persistentInstance);
			
		} catch (RuntimeException re) {
			
			throw re;
		}
	}

	public TipoOperacion merge(TipoOperacion detachedInstance) {
		
		try {
			TipoOperacion result = entityManager.merge(detachedInstance);
			
			return result;
		} catch (RuntimeException re) {
			
			throw re;
		}
	}

	public TipoOperacion findById(BigDecimal id) {
		
		try {
			TipoOperacion instance = entityManager
					.find(TipoOperacion.class, id);
			
			return instance;
		} catch (RuntimeException re) {
			
			throw re;
		}
	}
}

package com.rapibanca.dao;
// default package
// Generated 16/04/2016 01:23:11 PM by Hibernate Tools 3.4.0.CR1

import com.rapibanca.entities.PromocionesRapibanca;
import java.math.BigDecimal;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;



/**
 * Home object for domain model class PromocionesRapibanca.
 * @see .PromocionesRapibanca
 * @author Hibernate Tools
 */
@Stateless
public class PromocionesRapibancaDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(PromocionesRapibanca transientInstance) {
		
		try {
			entityManager.persist(transientInstance);
			
		} catch (RuntimeException re) {
			
			throw re;
		}
	}

	public void remove(PromocionesRapibanca persistentInstance) {
		
		try {
			entityManager.remove(persistentInstance);
			
		} catch (RuntimeException re) {
			
			throw re;
		}
	}

	public PromocionesRapibanca merge(PromocionesRapibanca detachedInstance) {
		
		try {
			PromocionesRapibanca result = entityManager.merge(detachedInstance);
			
			return result;
		} catch (RuntimeException re) {
			
			throw re;
		}
	}

	public PromocionesRapibanca findById(BigDecimal id) {
		
		try {
			PromocionesRapibanca instance = entityManager.find(
					PromocionesRapibanca.class, id);
			
			return instance;
		} catch (RuntimeException re) {
			
			throw re;
		}
	}
}

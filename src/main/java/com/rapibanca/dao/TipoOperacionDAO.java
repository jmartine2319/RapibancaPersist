package com.rapibanca.dao;
// default package
// Generated 16/04/2016 01:23:11 PM by Hibernate Tools 3.4.0.CR1

import com.rapibanca.entities.TipoOperacion;
import com.rapibanca.session.SessionFactoryHibernate;
import java.math.BigDecimal;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.Query;
import org.hibernate.Session;



/**
 * Home object for domain model class TipoOperacion.
 * @see .TipoOperacion
 * @author Hibernate Tools
 */
@Stateless
public class TipoOperacionDAO {


	@PersistenceContext
    private Session session = SessionFactoryHibernate.getSessionFactory().openSession();

	public void persist(TipoOperacion transientInstance) {
		
            try {
                session.getTransaction().begin();
                session.persist(transientInstance);
                session.getTransaction().commit();
                session.clear();
                System.out.println("succed");
                
            } catch (RuntimeException re) {

                throw re;
            }
	}

	public TipoOperacion findById(BigDecimal id) {

            try {
                session.getTransaction().begin();
                Query query = (Query) session.getNamedQuery("TipoOperacion.findByIdOperacion");
                query.setParameter("idOperacion", id);
                TipoOperacion tipoOperacion = (TipoOperacion) query.uniqueResult();
                session.clear();

                return tipoOperacion;
            } catch (RuntimeException re) {

                throw re;
            }

	}
}

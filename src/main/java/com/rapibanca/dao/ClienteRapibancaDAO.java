package com.rapibanca.dao;
// default package
// Generated 16/04/2016 01:23:11 PM by Hibernate Tools 3.4.0.CR1

import com.rapibanca.entities.ClienteRapibanca;
import com.rapibanca.session.SessionFactoryHibernate;
import java.math.BigDecimal;
import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * Home object for domain model class ClienteRapibanca.
 *
 * @see .ClienteRapibanca
 * @author Hibernate Tools
 */
@Stateless
public class ClienteRapibancaDAO {

    @PersistenceContext
    private Session session = SessionFactoryHibernate.getSessionFactory().openSession();

    /**
     * Metodo para insertar un nuevo cliente
     * @param transientInstance 
     */
    public void persist(ClienteRapibanca transientInstance) {
        try {
            session.getTransaction().begin();
            session.persist(transientInstance);
            session.getTransaction().commit();
            session.clear();
            System.out.println("succed");

        } catch (Exception re) {
            session.getTransaction().rollback();

            System.out.println("hubo un error ClienteRapibancaDAO.persist " + re);
            throw re;
        }
    }

    /**
     * Metodo para eliminar un cliente
     * @param persistentInstance 
     */
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

    /**
     * Metodo que permite buscar por el idUsuario para loguearse
     * @param idUsuario
     * @return 
     */
    public ClienteRapibanca findByIdUsuario(String idUsuario) {

        try {
            session.getTransaction().begin();
            Query query = (Query) session.getNamedQuery("ClienteRapibanca.findByIdUsuario");
            query.setParameter("numeroDocumento", idUsuario);
            ClienteRapibanca clienteRapibanca = (ClienteRapibanca) query.uniqueResult();
            session.clear();

            return clienteRapibanca;
        } catch (RuntimeException re) {

            throw re;
        }
    }

    /**
     * Metodo para buscar el usuario por el numero de documento
     * @param id
     * @return 
     */
    public ClienteRapibanca findById(BigDecimal id) {

        try {
            session.getTransaction().begin();
            Query query = (Query) session.getNamedQuery("ClienteRapibanca.findByNumeroDocumento");
            query.setParameter("numeroDocumento", id);
            ClienteRapibanca clienteRapibanca = (ClienteRapibanca) query.uniqueResult();
            session.getTransaction().commit();
            session.clear();

            return clienteRapibanca;
        } catch (RuntimeException re) {

            throw re;
        }
    }
}

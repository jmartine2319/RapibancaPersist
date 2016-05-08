/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rapibanca.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MaríaCamila
 */
@Entity
@Table(name = "TRANSACCIONES_RAPIBANCA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TransaccionesRapibanca.findAll", query = "SELECT t FROM TransaccionesRapibanca t"),
    @NamedQuery(name = "TransaccionesRapibanca.findByIdTransaccion", query = "SELECT t FROM TransaccionesRapibanca t WHERE t.idTransaccion = :idTransaccion"),
    @NamedQuery(name = "TransaccionesRapibanca.findByFechaTransaccion", query = "SELECT t FROM TransaccionesRapibanca t WHERE t.fechaTransaccion = :fechaTransaccion"),
    @NamedQuery(name = "TransaccionesRapibanca.findByMedioElectronico", query = "SELECT t FROM TransaccionesRapibanca t WHERE t.medioElectronico = :medioElectronico"),
    @NamedQuery(name = "TransaccionesRapibanca.findByValorOperacion", query = "SELECT t FROM TransaccionesRapibanca t WHERE t.valorOperacion = :valorOperacion")})
public class TransaccionesRapibanca implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_TRANSACCION")
    private String idTransaccion;
    @Basic(optional = false)
    @Column(name = "FECHA_TRANSACCION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaTransaccion;
    @Basic(optional = false)
    @Column(name = "MEDIO_ELECTRONICO")
    private BigInteger medioElectronico;
    @Basic(optional = false)
    @Column(name = "VALOR_OPERACION")
    private BigInteger valorOperacion;
    @JoinColumn(name = "TIPO_OPERACION", referencedColumnName = "ID_OPERACION")
    @ManyToOne(optional = false)
    private TipoOperacion tipoOperacion;
    @JoinColumn(name = "ID_PRODUCTO", referencedColumnName = "ID_PRODUCTO")
    @ManyToOne(optional = false)
    private ProductosRapibanca idProducto;

    public TransaccionesRapibanca() {
    }

    public TransaccionesRapibanca(String idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public TransaccionesRapibanca(String idTransaccion, Date fechaTransaccion, BigInteger medioElectronico, BigInteger valorOperacion) {
        this.idTransaccion = idTransaccion;
        this.fechaTransaccion = fechaTransaccion;
        this.medioElectronico = medioElectronico;
        this.valorOperacion = valorOperacion;
    }

    public String getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(String idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public Date getFechaTransaccion() {
        return fechaTransaccion;
    }

    public void setFechaTransaccion(Date fechaTransaccion) {
        this.fechaTransaccion = fechaTransaccion;
    }

    public BigInteger getMedioElectronico() {
        return medioElectronico;
    }

    public void setMedioElectronico(BigInteger medioElectronico) {
        this.medioElectronico = medioElectronico;
    }

    public BigInteger getValorOperacion() {
        return valorOperacion;
    }

    public void setValorOperacion(BigInteger valorOperacion) {
        this.valorOperacion = valorOperacion;
    }

    public TipoOperacion getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(TipoOperacion tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public ProductosRapibanca getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(ProductosRapibanca idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTransaccion != null ? idTransaccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TransaccionesRapibanca)) {
            return false;
        }
        TransaccionesRapibanca other = (TransaccionesRapibanca) object;
        if ((this.idTransaccion == null && other.idTransaccion != null) || (this.idTransaccion != null && !this.idTransaccion.equals(other.idTransaccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.rapibanca.entities.TransaccionesRapibanca[ idTransaccion=" + idTransaccion + " ]";
    }
    
}

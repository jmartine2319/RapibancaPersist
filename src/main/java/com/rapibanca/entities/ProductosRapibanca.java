/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rapibanca.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author MaríaCamila
 */
@Entity
@Table(name = "PRODUCTOS_RAPIBANCA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductosRapibanca.findAll", query = "SELECT p FROM ProductosRapibanca p"),
    @NamedQuery(name = "ProductosRapibanca.findByNumDocumento", query = "SELECT p FROM ProductosRapibanca p where p.numDocumentoClienteFk = :numDocumentoClienteFk"),
    @NamedQuery(name = "ProductosRapibanca.findByIdProducto", query = "SELECT p FROM ProductosRapibanca p WHERE p.idProducto = :idProducto"),
    @NamedQuery(name = "ProductosRapibanca.findByDescripcionProducto", query = "SELECT p FROM ProductosRapibanca p WHERE p.descripcionProducto = :descripcionProducto"),
    @NamedQuery(name = "ProductosRapibanca.findByFechaCreacion", query = "SELECT p FROM ProductosRapibanca p WHERE p.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "ProductosRapibanca.findByFechaCancelacion", query = "SELECT p FROM ProductosRapibanca p WHERE p.fechaCancelacion = :fechaCancelacion"),
    @NamedQuery(name = "ProductosRapibanca.findByPenalizacion", query = "SELECT p FROM ProductosRapibanca p WHERE p.penalizacion = :penalizacion"),
    @NamedQuery(name = "ProductosRapibanca.findBySaldoProducto", query = "SELECT p FROM ProductosRapibanca p WHERE p.saldoProducto = :saldoProducto")})
public class ProductosRapibanca implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_PRODUCTO")
    private BigDecimal idProducto;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION_PRODUCTO")
    private String descripcionProducto;
    @Basic(optional = false)
    @Column(name = "FECHA_CREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Basic(optional = false)
    @Column(name = "FECHA_CANCELACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCancelacion;
    @Column(name = "PENALIZACION")
    private Short penalizacion;
    @Basic(optional = false)
    @Column(name = "SALDO_PRODUCTO")
    private BigInteger saldoProducto;
    @JoinColumn(name = "ID_PROMOCION_FK", referencedColumnName = "ID_PROMOCION")
    @ManyToOne
    private PromocionesRapibanca idPromocionFk;
    @JoinColumn(name = "NUM_DOCUMENTO_CLIENTE_FK", referencedColumnName = "NUMERO_DOCUMENTO")
    @ManyToOne(optional = false)
    private ClienteRapibanca numDocumentoClienteFk;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProducto")
    private Collection<TransaccionesRapibanca> transaccionesRapibancaCollection;

    public ProductosRapibanca() {
    }

    public ProductosRapibanca(BigDecimal idProducto) {
        this.idProducto = idProducto;
    }

    public ProductosRapibanca(BigDecimal idProducto, String descripcionProducto, Date fechaCreacion, Date fechaCancelacion, BigInteger saldoProducto) {
        this.idProducto = idProducto;
        this.descripcionProducto = descripcionProducto;
        this.fechaCreacion = fechaCreacion;
        this.fechaCancelacion = fechaCancelacion;
        this.saldoProducto = saldoProducto;
    }

    public BigDecimal getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(BigDecimal idProducto) {
        this.idProducto = idProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaCancelacion() {
        return fechaCancelacion;
    }

    public void setFechaCancelacion(Date fechaCancelacion) {
        this.fechaCancelacion = fechaCancelacion;
    }

    public Short getPenalizacion() {
        return penalizacion;
    }

    public void setPenalizacion(Short penalizacion) {
        this.penalizacion = penalizacion;
    }

    public BigInteger getSaldoProducto() {
        return saldoProducto;
    }

    public void setSaldoProducto(BigInteger saldoProducto) {
        this.saldoProducto = saldoProducto;
    }

    public PromocionesRapibanca getIdPromocionFk() {
        return idPromocionFk;
    }

    public void setIdPromocionFk(PromocionesRapibanca idPromocionFk) {
        this.idPromocionFk = idPromocionFk;
    }

    public ClienteRapibanca getNumDocumentoClienteFk() {
        return numDocumentoClienteFk;
    }

    public void setNumDocumentoClienteFk(ClienteRapibanca numDocumentoClienteFk) {
        this.numDocumentoClienteFk = numDocumentoClienteFk;
    }

    @XmlTransient
    public Collection<TransaccionesRapibanca> getTransaccionesRapibancaCollection() {
        return transaccionesRapibancaCollection;
    }

    public void setTransaccionesRapibancaCollection(Collection<TransaccionesRapibanca> transaccionesRapibancaCollection) {
        this.transaccionesRapibancaCollection = transaccionesRapibancaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProducto != null ? idProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductosRapibanca)) {
            return false;
        }
        ProductosRapibanca other = (ProductosRapibanca) object;
        if ((this.idProducto == null && other.idProducto != null) || (this.idProducto != null && !this.idProducto.equals(other.idProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.rapibanca.entities.ProductosRapibanca[ idProducto=" + idProducto + " ]";
    }
    
}

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
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author MaríaCamila
 */
@Entity
@Table(name = "PROMOCIONES_RAPIBANCA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PromocionesRapibanca.findAll", query = "SELECT p FROM PromocionesRapibanca p"),
    @NamedQuery(name = "PromocionesRapibanca.findByIdPromocion", query = "SELECT p FROM PromocionesRapibanca p WHERE p.idPromocion = :idPromocion"),
    @NamedQuery(name = "PromocionesRapibanca.findByDescripcionPromocion", query = "SELECT p FROM PromocionesRapibanca p WHERE p.descripcionPromocion = :descripcionPromocion"),
    @NamedQuery(name = "PromocionesRapibanca.findByVigencia", query = "SELECT p FROM PromocionesRapibanca p WHERE p.vigencia = :vigencia"),
    @NamedQuery(name = "PromocionesRapibanca.findByValorPromocion", query = "SELECT p FROM PromocionesRapibanca p WHERE p.valorPromocion = :valorPromocion")})
public class PromocionesRapibanca implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_PROMOCION")
    private BigDecimal idPromocion;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION_PROMOCION")
    private String descripcionPromocion;
    @Basic(optional = false)
    @Column(name = "VIGENCIA")
    private BigInteger vigencia;
    @Basic(optional = false)
    @Column(name = "VALOR_PROMOCION")
    private BigInteger valorPromocion;
    @OneToMany(mappedBy = "idPromocionFk")
    private Collection<ProductosRapibanca> productosRapibancaCollection;

    public PromocionesRapibanca() {
    }

    public PromocionesRapibanca(BigDecimal idPromocion) {
        this.idPromocion = idPromocion;
    }

    public PromocionesRapibanca(BigDecimal idPromocion, String descripcionPromocion, BigInteger vigencia, BigInteger valorPromocion) {
        this.idPromocion = idPromocion;
        this.descripcionPromocion = descripcionPromocion;
        this.vigencia = vigencia;
        this.valorPromocion = valorPromocion;
    }

    public BigDecimal getIdPromocion() {
        return idPromocion;
    }

    public void setIdPromocion(BigDecimal idPromocion) {
        this.idPromocion = idPromocion;
    }

    public String getDescripcionPromocion() {
        return descripcionPromocion;
    }

    public void setDescripcionPromocion(String descripcionPromocion) {
        this.descripcionPromocion = descripcionPromocion;
    }

    public BigInteger getVigencia() {
        return vigencia;
    }

    public void setVigencia(BigInteger vigencia) {
        this.vigencia = vigencia;
    }

    public BigInteger getValorPromocion() {
        return valorPromocion;
    }

    public void setValorPromocion(BigInteger valorPromocion) {
        this.valorPromocion = valorPromocion;
    }

    @XmlTransient
    public Collection<ProductosRapibanca> getProductosRapibancaCollection() {
        return productosRapibancaCollection;
    }

    public void setProductosRapibancaCollection(Collection<ProductosRapibanca> productosRapibancaCollection) {
        this.productosRapibancaCollection = productosRapibancaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPromocion != null ? idPromocion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PromocionesRapibanca)) {
            return false;
        }
        PromocionesRapibanca other = (PromocionesRapibanca) object;
        if ((this.idPromocion == null && other.idPromocion != null) || (this.idPromocion != null && !this.idPromocion.equals(other.idPromocion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.rapibanca.entities.PromocionesRapibanca[ idPromocion=" + idPromocion + " ]";
    }
    
}

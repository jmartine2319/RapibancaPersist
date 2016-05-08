/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rapibanca.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MaríaCamila
 */
@Entity
@Table(name = "MEDIO_ELECTRONICO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MedioElectronico.findAll", query = "SELECT m FROM MedioElectronico m"),
    @NamedQuery(name = "MedioElectronico.findByIdMedio", query = "SELECT m FROM MedioElectronico m WHERE m.idMedio = :idMedio"),
    @NamedQuery(name = "MedioElectronico.findByDescripcionMedio", query = "SELECT m FROM MedioElectronico m WHERE m.descripcionMedio = :descripcionMedio"),
    @NamedQuery(name = "MedioElectronico.findByValorServicio", query = "SELECT m FROM MedioElectronico m WHERE m.valorServicio = :valorServicio")})
public class MedioElectronico implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_MEDIO")
    private BigDecimal idMedio;
    @Column(name = "DESCRIPCION_MEDIO")
    private String descripcionMedio;
    @Column(name = "VALOR_SERVICIO")
    private BigInteger valorServicio;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "medioElectronico")
    private TipoOperacion tipoOperacion;

    public MedioElectronico() {
    }

    public MedioElectronico(BigDecimal idMedio) {
        this.idMedio = idMedio;
    }

    public BigDecimal getIdMedio() {
        return idMedio;
    }

    public void setIdMedio(BigDecimal idMedio) {
        this.idMedio = idMedio;
    }

    public String getDescripcionMedio() {
        return descripcionMedio;
    }

    public void setDescripcionMedio(String descripcionMedio) {
        this.descripcionMedio = descripcionMedio;
    }

    public BigInteger getValorServicio() {
        return valorServicio;
    }

    public void setValorServicio(BigInteger valorServicio) {
        this.valorServicio = valorServicio;
    }

    public TipoOperacion getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(TipoOperacion tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMedio != null ? idMedio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MedioElectronico)) {
            return false;
        }
        MedioElectronico other = (MedioElectronico) object;
        if ((this.idMedio == null && other.idMedio != null) || (this.idMedio != null && !this.idMedio.equals(other.idMedio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.rapibanca.entities.MedioElectronico[ idMedio=" + idMedio + " ]";
    }
    
}

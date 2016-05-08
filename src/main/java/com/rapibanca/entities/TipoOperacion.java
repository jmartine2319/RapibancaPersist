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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author MaríaCamila
 */
@Entity
@Table(name = "TIPO_OPERACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoOperacion.findAll", query = "SELECT t FROM TipoOperacion t"),
    @NamedQuery(name = "TipoOperacion.findByIdOperacion", query = "SELECT t FROM TipoOperacion t WHERE t.idOperacion = :idOperacion"),
    @NamedQuery(name = "TipoOperacion.findByDescripcionOperacion", query = "SELECT t FROM TipoOperacion t WHERE t.descripcionOperacion = :descripcionOperacion"),
    @NamedQuery(name = "TipoOperacion.findByValorOperacion", query = "SELECT t FROM TipoOperacion t WHERE t.valorOperacion = :valorOperacion")})
public class TipoOperacion implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_OPERACION")
    private BigDecimal idOperacion;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION_OPERACION")
    private String descripcionOperacion;
    @Basic(optional = false)
    @Column(name = "VALOR_OPERACION")
    private BigInteger valorOperacion;
    @JoinColumn(name = "ID_OPERACION", referencedColumnName = "ID_MEDIO", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private MedioElectronico medioElectronico;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoOperacion")
    private Collection<TransaccionesRapibanca> transaccionesRapibancaCollection;

    public TipoOperacion() {
    }

    public TipoOperacion(BigDecimal idOperacion) {
        this.idOperacion = idOperacion;
    }

    public TipoOperacion(BigDecimal idOperacion, String descripcionOperacion, BigInteger valorOperacion) {
        this.idOperacion = idOperacion;
        this.descripcionOperacion = descripcionOperacion;
        this.valorOperacion = valorOperacion;
    }

    public BigDecimal getIdOperacion() {
        return idOperacion;
    }

    public void setIdOperacion(BigDecimal idOperacion) {
        this.idOperacion = idOperacion;
    }

    public String getDescripcionOperacion() {
        return descripcionOperacion;
    }

    public void setDescripcionOperacion(String descripcionOperacion) {
        this.descripcionOperacion = descripcionOperacion;
    }

    public BigInteger getValorOperacion() {
        return valorOperacion;
    }

    public void setValorOperacion(BigInteger valorOperacion) {
        this.valorOperacion = valorOperacion;
    }

    public MedioElectronico getMedioElectronico() {
        return medioElectronico;
    }

    public void setMedioElectronico(MedioElectronico medioElectronico) {
        this.medioElectronico = medioElectronico;
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
        hash += (idOperacion != null ? idOperacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoOperacion)) {
            return false;
        }
        TipoOperacion other = (TipoOperacion) object;
        if ((this.idOperacion == null && other.idOperacion != null) || (this.idOperacion != null && !this.idOperacion.equals(other.idOperacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.rapibanca.entities.TipoOperacion[ idOperacion=" + idOperacion + " ]";
    }
    
}

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
 * @author Ccuella,Jmartine2319
 */
@Entity
@Table(name = "CLIENTE_RAPIBANCA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClienteRapibanca.findAll", query = "SELECT c FROM ClienteRapibanca c"),
    @NamedQuery(name = "ClienteRapibanca.findByTipoDocumento", query = "SELECT c FROM ClienteRapibanca c WHERE c.tipoDocumento = :tipoDocumento"),
    @NamedQuery(name = "ClienteRapibanca.findByNumeroDocumento", query = "SELECT c FROM ClienteRapibanca c WHERE c.numeroDocumento = :numeroDocumento"),
    @NamedQuery(name = "ClienteRapibanca.findByNombreCliente", query = "SELECT c FROM ClienteRapibanca c WHERE c.nombreCliente = :nombreCliente"),
    @NamedQuery(name = "ClienteRapibanca.findByTelefono", query = "SELECT c FROM ClienteRapibanca c WHERE c.telefono = :telefono"),
    @NamedQuery(name = "ClienteRapibanca.findByEmail", query = "SELECT c FROM ClienteRapibanca c WHERE c.email = :email"),
    @NamedQuery(name = "ClienteRapibanca.findByDireccionResidencia", query = "SELECT c FROM ClienteRapibanca c WHERE c.direccionResidencia = :direccionResidencia"),
    @NamedQuery(name = "ClienteRapibanca.findByFechaVinculacion", query = "SELECT c FROM ClienteRapibanca c WHERE c.fechaVinculacion = :fechaVinculacion"),
    @NamedQuery(name = "ClienteRapibanca.findByIdUsuario", query = "SELECT c FROM ClienteRapibanca c WHERE c.idUsuario = :idUsuario"),
    @NamedQuery(name = "ClienteRapibanca.findByPassword", query = "SELECT c FROM ClienteRapibanca c WHERE c.password = :password")})
public class ClienteRapibanca implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "TIPO_DOCUMENTO")
    private BigInteger tipoDocumento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "NUMERO_DOCUMENTO")
    private BigDecimal numeroDocumento;
    @Basic(optional = false)
    @Column(name = "NOMBRE_CLIENTE")
    private String nombreCliente;
    @Basic(optional = false)
    @Column(name = "TELEFONO")
    private BigInteger telefono;
    @Basic(optional = false)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @Column(name = "DIRECCION_RESIDENCIA")
    private String direccionResidencia;
    @Basic(optional = false)
    @Column(name = "FECHA_VINCULACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaVinculacion;
    @Basic(optional = false)
    @Column(name = "ID_USUARIO")
    private String idUsuario;
    @Basic(optional = false)
    @Column(name = "PASSWORD")
    private String password;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numDocumentoClienteFk")
    private Collection<ProductosRapibanca> productosRapibancaCollection;

    public ClienteRapibanca() {
    }

    public ClienteRapibanca(BigDecimal numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public ClienteRapibanca(BigDecimal numeroDocumento, BigInteger tipoDocumento, String nombreCliente, BigInteger telefono, String email, String direccionResidencia, Date fechaVinculacion, String idUsuario, String password) {
        this.numeroDocumento = numeroDocumento;
        this.tipoDocumento = tipoDocumento;
        this.nombreCliente = nombreCliente;
        this.telefono = telefono;
        this.email = email;
        this.direccionResidencia = direccionResidencia;
        this.fechaVinculacion = fechaVinculacion;
        this.idUsuario = idUsuario;
        this.password = password;
    }

    public BigInteger getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(BigInteger tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public BigDecimal getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(BigDecimal numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public BigInteger getTelefono() {
        return telefono;
    }

    public void setTelefono(BigInteger telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccionResidencia() {
        return direccionResidencia;
    }

    public void setDireccionResidencia(String direccionResidencia) {
        this.direccionResidencia = direccionResidencia;
    }

    public Date getFechaVinculacion() {
        return fechaVinculacion;
    }

    public void setFechaVinculacion(Date fechaVinculacion) {
        this.fechaVinculacion = fechaVinculacion;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        hash += (numeroDocumento != null ? numeroDocumento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClienteRapibanca)) {
            return false;
        }
        ClienteRapibanca other = (ClienteRapibanca) object;
        if ((this.numeroDocumento == null && other.numeroDocumento != null) || (this.numeroDocumento != null && !this.numeroDocumento.equals(other.numeroDocumento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.rapibanca.entities.ClienteRapibanca[ numeroDocumento=" + numeroDocumento + " ]";
    }

    public void persist(ClienteRapibanca clienteRapibanca) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

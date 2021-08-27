/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pc1
 */
@Entity
@Table(name = "factura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Factura.findAll", query = "SELECT f FROM Factura f"),
    @NamedQuery(name = "Factura.findByIdFacatura", query = "SELECT f FROM Factura f WHERE f.idFacatura = :idFacatura"),
    @NamedQuery(name = "Factura.findByFecha", query = "SELECT f FROM Factura f WHERE f.fecha = :fecha"),
    @NamedQuery(name = "Factura.findByTotal", query = "SELECT f FROM Factura f WHERE f.total = :total"),
    @NamedQuery(name = "Factura.findByCiudad", query = "SELECT f FROM Factura f WHERE f.ciudad = :ciudad"),
    @NamedQuery(name = "Factura.findByDireccion", query = "SELECT f FROM Factura f WHERE f.direccion = :direccion"),
    @NamedQuery(name = "Factura.findByEnvio", query = "SELECT f FROM Factura f WHERE f.envio = :envio"),
    @NamedQuery(name = "Factura.findByDescuento", query = "SELECT f FROM Factura f WHERE f.descuento = :descuento")})
public class Factura implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "id_facatura")
    private String idFacatura;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "total")
    private Integer total;
    @Size(max = 20)
    @Column(name = "ciudad")
    private String ciudad;
    @Size(max = 20)
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "envio")
    private Integer envio;
    @Column(name = "descuento")
    private Integer descuento;
    @JoinColumn(name = "id_presona", referencedColumnName = "id_persona")
    @ManyToOne(optional = false)
    private Persona idPresona;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "factura")
    private Collection<CarroProducto> carroProductoCollection;

    public Factura() {
    }

    public Factura(String idFacatura) {
        this.idFacatura = idFacatura;
    }

    public String getIdFacatura() {
        return idFacatura;
    }

    public void setIdFacatura(String idFacatura) {
        this.idFacatura = idFacatura;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getEnvio() {
        return envio;
    }

    public void setEnvio(Integer envio) {
        this.envio = envio;
    }

    public Integer getDescuento() {
        return descuento;
    }

    public void setDescuento(Integer descuento) {
        this.descuento = descuento;
    }

    public Persona getIdPresona() {
        return idPresona;
    }

    public void setIdPresona(Persona idPresona) {
        this.idPresona = idPresona;
    }

    @XmlTransient
    public Collection<CarroProducto> getCarroProductoCollection() {
        return carroProductoCollection;
    }

    public void setCarroProductoCollection(Collection<CarroProducto> carroProductoCollection) {
        this.carroProductoCollection = carroProductoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFacatura != null ? idFacatura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Factura)) {
            return false;
        }
        Factura other = (Factura) object;
        if ((this.idFacatura == null && other.idFacatura != null) || (this.idFacatura != null && !this.idFacatura.equals(other.idFacatura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Factura[ idFacatura=" + idFacatura + " ]";
    }
    
}

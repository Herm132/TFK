/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pc1
 */
@Entity
@Table(name = "carro_producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CarroProducto.findAll", query = "SELECT c FROM CarroProducto c"),
    @NamedQuery(name = "CarroProducto.findByIdcarroProducto", query = "SELECT c FROM CarroProducto c WHERE c.carroProductoPK.idcarroProducto = :idcarroProducto"),
    @NamedQuery(name = "CarroProducto.findByCantidad", query = "SELECT c FROM CarroProducto c WHERE c.cantidad = :cantidad"),
    @NamedQuery(name = "CarroProducto.findByEstado", query = "SELECT c FROM CarroProducto c WHERE c.estado = :estado"),
    @NamedQuery(name = "CarroProducto.findByIdPresona", query = "SELECT c FROM CarroProducto c WHERE c.carroProductoPK.idPresona = :idPresona"),
    @NamedQuery(name = "CarroProducto.findByIdFacatura", query = "SELECT c FROM CarroProducto c WHERE c.carroProductoPK.idFacatura = :idFacatura")})
public class CarroProducto implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CarroProductoPK carroProductoPK;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Size(max = 20)
    @Column(name = "estado")
    private String estado;
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto")
    @ManyToOne
    private Producto idProducto;
    @JoinColumn(name = "id_presona", referencedColumnName = "id_persona", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Persona persona;
    @JoinColumn(name = "id_facatura", referencedColumnName = "id_facatura", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Factura factura;

    public CarroProducto() {
    }

    public CarroProducto(CarroProductoPK carroProductoPK) {
        this.carroProductoPK = carroProductoPK;
    }

    public CarroProducto(String idcarroProducto, String idPresona, String idFacatura) {
        this.carroProductoPK = new CarroProductoPK(idcarroProducto, idPresona, idFacatura);
    }

    public CarroProductoPK getCarroProductoPK() {
        return carroProductoPK;
    }

    public void setCarroProductoPK(CarroProductoPK carroProductoPK) {
        this.carroProductoPK = carroProductoPK;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (carroProductoPK != null ? carroProductoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CarroProducto)) {
            return false;
        }
        CarroProducto other = (CarroProducto) object;
        if ((this.carroProductoPK == null && other.carroProductoPK != null) || (this.carroProductoPK != null && !this.carroProductoPK.equals(other.carroProductoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.CarroProducto[ carroProductoPK=" + carroProductoPK + " ]";
    }
    
}

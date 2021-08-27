/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author pc1
 */
@Embeddable
public class CarroProductoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "idcarro_producto")
    private String idcarroProducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "id_presona")
    private String idPresona;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "id_facatura")
    private String idFacatura;

    public CarroProductoPK() {
    }

    public CarroProductoPK(String idcarroProducto, String idPresona, String idFacatura) {
        this.idcarroProducto = idcarroProducto;
        this.idPresona = idPresona;
        this.idFacatura = idFacatura;
    }

    public String getIdcarroProducto() {
        return idcarroProducto;
    }

    public void setIdcarroProducto(String idcarroProducto) {
        this.idcarroProducto = idcarroProducto;
    }

    public String getIdPresona() {
        return idPresona;
    }

    public void setIdPresona(String idPresona) {
        this.idPresona = idPresona;
    }

    public String getIdFacatura() {
        return idFacatura;
    }

    public void setIdFacatura(String idFacatura) {
        this.idFacatura = idFacatura;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcarroProducto != null ? idcarroProducto.hashCode() : 0);
        hash += (idPresona != null ? idPresona.hashCode() : 0);
        hash += (idFacatura != null ? idFacatura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CarroProductoPK)) {
            return false;
        }
        CarroProductoPK other = (CarroProductoPK) object;
        if ((this.idcarroProducto == null && other.idcarroProducto != null) || (this.idcarroProducto != null && !this.idcarroProducto.equals(other.idcarroProducto))) {
            return false;
        }
        if ((this.idPresona == null && other.idPresona != null) || (this.idPresona != null && !this.idPresona.equals(other.idPresona))) {
            return false;
        }
        if ((this.idFacatura == null && other.idFacatura != null) || (this.idFacatura != null && !this.idFacatura.equals(other.idFacatura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.CarroProductoPK[ idcarroProducto=" + idcarroProducto + ", idPresona=" + idPresona + ", idFacatura=" + idFacatura + " ]";
    }
    
}

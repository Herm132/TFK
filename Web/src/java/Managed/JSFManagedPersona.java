/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Managed;

import Entidades.Persona;
import Sesiones.PersonaFacadeLocal;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author pc1
 */
@ManagedBean(name = "JSFManagedPersona")
@RequestScoped
public class JSFManagedPersona implements Serializable {

    public JSFManagedPersona() {
    }
   
    private String usuario;
    private String clave;
    @EJB
    private PersonaFacadeLocal manejadorPersona;

    @PostConstruct
    public String iniciarSesion() {

        Persona per;
        String redireccion = null;

        try {
            per = manejadorPersona.validarPersona(this.getUsuario(), this.getClave());
            if (per != null) {
                redireccion = "/index.xhtml";
            } else {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Credenciales Incorrectas"));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error ..." + e));
        }
        return redireccion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }


}

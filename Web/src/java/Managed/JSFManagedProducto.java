/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Managed;

import Entidades.Producto;
import Sesiones.ProductoFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author pc1
 */
@ManagedBean(name = "JSFManagedProducto")
@RequestScoped
public class JSFManagedProducto implements Serializable {

    public JSFManagedProducto() {
    }
    
    @EJB
private ProductoFacadeLocal managedProducto;
private List<Producto> listaProducto;
private Producto producto;
@PostConstruct
private void inicio(){
    producto = new Producto();
    listarProductos();
}


    public void listarProductos(){
        setListaProducto(managedProducto.findAll());
    }

    public void crearProducto(){
        managedProducto.create(producto);
    }

    public List<Producto> getListaProducto() {
        this.listaProducto=this.managedProducto.findAll();
        return listaProducto;
    }

    public void setListaProducto(List<Producto> listaProducto) {
        this.listaProducto = listaProducto;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
   
   

}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sesiones;

import Entidades.Producto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author pc1
 */
@Local
public interface ProductoFacadeLocal {

    void create(Producto producto);

    void edit(Producto producto);

    void remove(Producto producto);

    Producto find(Object id);

    List<Producto> findAll();

    List<Producto> findRange(int[] range);

    int count();
    
}

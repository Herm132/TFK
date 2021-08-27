/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sesiones;

import Entidades.CarroProducto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author pc1
 */
@Local
public interface CarroProductoFacadeLocal {

    void create(CarroProducto carroProducto);

    void edit(CarroProducto carroProducto);

    void remove(CarroProducto carroProducto);

    CarroProducto find(Object id);

    List<CarroProducto> findAll();

    List<CarroProducto> findRange(int[] range);

    int count();
    
}

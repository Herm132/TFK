/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sesiones;

import Entidades.CarroProducto;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author pc1
 */
@Stateless
public class CarroProductoFacade extends AbstractFacade<CarroProducto> implements CarroProductoFacadeLocal {
    @PersistenceContext(unitName = "EJBPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CarroProductoFacade() {
        super(CarroProducto.class);
    }
    
}

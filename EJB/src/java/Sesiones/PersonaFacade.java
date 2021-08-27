package Sesiones;

import Entidades.Persona;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class PersonaFacade extends AbstractFacade<Persona> implements PersonaFacadeLocal {
    @PersistenceContext(unitName = "EJBPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonaFacade() {
        super(Persona.class);
    }
    
        @Override
        public Persona validarPersona(String usuario, String clave){
                Persona per = null;
        try {
            Query sql = em.createNamedQuery("Persona.validarUsuario")
                    .setParameter("usuario", usuario)  
                    .setParameter("clave", clave);
            
            List<Persona> listaPersona = sql.getResultList();

            if (!listaPersona.isEmpty()) {
                per = listaPersona.get(0);
            }
        } catch (Exception e) {
            throw e;
        }
        return per;
        }   
}

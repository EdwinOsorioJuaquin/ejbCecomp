
package ejbCecomp.ejb.dao;

import jakarta.persistence.*;
import java.lang.reflect.ParameterizedType;

public abstract class ejbCcoGenericoDAO<T> implements ejbCcoGenericoDAOLocal<T> {
    static private final String PERSISTENCE_UNIT_NAME="ejbCecompPU";
    @PersistenceContext (unitName=PERSISTENCE_UNIT_NAME)
    protected EntityManager em;
    
    @Override
    public T crear(T entidad){
        em.persist(entidad);
        return entidad;
    }
    
    @Override
    public T actualizar(T entidad){
        entidad=em.merge(entidad);
        return entidad;
    }
    
    @Override
    public T buscarPorId(Object id){
        Class<T> claseEntidad=(Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        return em.find(claseEntidad,id);
    }
}

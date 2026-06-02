
package ejbCecomp.ejb.dao;

import ejbCecomp.entidades.ejbCcoCepNivelModalidad;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;
import java.util.List;

/**
 * Implementación del DAO para la entidad Nivel Modalidad.
 * 
 * Contiene las consultas JPQL hacia la base de datos.
 */
@Stateless
public class ejbCcoCepNivelModalidadDAO extends ejbCcoGenericoDAO<ejbCcoCepNivelModalidad> implements ejbCcoCepNivelModalidadDAOLocal {

    @Override
    public List<ejbCcoCepNivelModalidad> listarNivelesModalidad() {
        TypedQuery<ejbCcoCepNivelModalidad> query = 
            em.createQuery("SELECT n FROM CepNivelModalidad n WHERE n.habilitado = true", 
                           ejbCcoCepNivelModalidad.class);
        return query.getResultList();
    }
}

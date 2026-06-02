
package ejbCecomp.ejb.dao;

import ejbCecomp.entidades.ejbCcoCepNivelModalidad;
import jakarta.ejb.Local;
import java.util.List;

/**
 * Implementación del DAO para la entidad Nivel Modalidad.
 * 
 * Contiene las consultas JPQL hacia la base de datos.
 */
@Local
public interface ejbCcoCepNivelModalidadDAOLocal extends ejbCcoGenericoDAOLocal<ejbCcoCepNivelModalidad>{
    public List<ejbCcoCepNivelModalidad> listarNivelesModalidad();
}

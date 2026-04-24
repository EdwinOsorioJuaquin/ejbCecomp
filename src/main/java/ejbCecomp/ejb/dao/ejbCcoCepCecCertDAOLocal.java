
package ejbCecomp.ejb.dao;

import ejbCecomp.entidades.ejbCcoCepCecCert;
import jakarta.ejb.Local;
import java.util.List;

/**
 * DAO Local para certificados.
 */
@Local
public interface ejbCcoCepCecCertDAOLocal extends ejbCcoGenericoDAOLocal<ejbCcoCepCecCert>{
    /**
     * Función para listar todos los certificados
     * @return Lista de certificados
     */
    List<ejbCcoCepCecCert> listarTodos();

    /**
     * Función para listar certificados por alumno
     * @param idAlumno Identificador del alumno
     * @return Lista de certificados del alumno
     */
    List<ejbCcoCepCecCert> listarPorAlumno(Integer idAlumno);
}

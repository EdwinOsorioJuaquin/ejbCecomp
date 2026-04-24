
package ejbCecomp.ejb.dao;

import ejbCecomp.entidades.ejbCcoCepCursoDocente;
import jakarta.ejb.Local;
import java.util.List;

/**
 * DAO para la gestión de grupos (curso docente).
 */
@Local
public interface ejbCcoCepCursoDocenteDAOLocal extends ejbCcoGenericoDAOLocal<ejbCcoCepCursoDocente>{
    /**
     * Función para listar todos los grupos
     * @return Lista de grupos
     */
    List<ejbCcoCepCursoDocente> listarTodos();

    /**
     * Función para listar grupos por curso
     * @param idCurso Identificador del curso
     * @return Lista de grupos asociados al curso
     */
    List<ejbCcoCepCursoDocente> listarPorCurso(Integer idCurso);
    
    
}

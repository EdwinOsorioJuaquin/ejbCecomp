
package ejbCecomp.ejb.dao;

import ejbCecomp.entidades.ejbCcoCepCurso;
import jakarta.ejb.Local;
import java.util.List;

/**
 * DAO Local para la entidad Curso.
 * 
 * Define las operaciones de acceso a datos para la tabla cep_curso.
 */
@Local
public interface ejbCcoCursoDAOLocal extends ejbCcoGenericoDAOLocal<ejbCcoCepCurso>{
    /**
     * Función para obtener todos los cursos registrados
     * @return Lista de cursos
     */
    List<ejbCcoCepCurso> listarTodos();

    /**
     * Función para buscar cursos por nombre
     * @param nombre Nombre o parte del nombre del curso
     * @return Lista de cursos que coinciden con la búsqueda
     */
    List<ejbCcoCepCurso> buscarPorNombre(String nombre);
}

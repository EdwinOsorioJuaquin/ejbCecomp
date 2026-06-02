
package ejbCecomp.ejb.negocio;

import ejbCecomp.entidades.ejbCcoCepCurso;
import jakarta.ejb.Local;
import java.util.List;

/**
 * Interfaz de negocio para la gestión de cursos.
 */
@Local
public interface ejbCcoCepCursoServiceLocal {
    /**
     * Función para crear un nuevo curso
     * @param curso Objeto con los datos del curso
     * @return Curso creado
     */
    ejbCcoCepCurso crear(ejbCcoCepCurso curso);

    /**
     * Función para actualizar un curso existente
     * @param curso Objeto con los datos actualizados
     * @return Curso actualizado
     */
    ejbCcoCepCurso actualizar(ejbCcoCepCurso curso);

    /**
     * Función para buscar un curso por su ID
     * @param id Identificador del curso
     * @return Curso encontrado o null si no existe
     */
    ejbCcoCepCurso buscarPorId(Integer id);

    /**
     * Función para listar todos los cursos
     * @return Lista de cursos
     */
    List<ejbCcoCepCurso> listarTodos();

    /**
     * Función para buscar cursos por nombre
     * @param nombre Texto de búsqueda
     * @return Lista de cursos encontrados
     */
    List<ejbCcoCepCurso> buscarPorNombre(String nombre);
    
    /**
     * Función para listar todos los cursos activos
     * @return Lista de cursos activos
     */
    List<ejbCcoCepCurso> listarActivos();

}

package ejbCecomp.ejb.negocio;

import ejbCecomp.entidades.ejbCcoCepCursoDocente;
import jakarta.ejb.Local;
import java.util.List;

/**
 * Servicio de negocio para grupos (curso docente).
 */
@Local
public interface ejbCcoCepCursoDocenteServiceLocal {

    /**
     * Función para crear un grupo
     * @param grupo Datos del grupo
     * @return Grupo creado
     */
    ejbCcoCepCursoDocente crear(ejbCcoCepCursoDocente grupo);

    /**
     * Función para actualizar un grupo
     * @param grupo Datos actualizados
     * @return Grupo actualizado
     */
    ejbCcoCepCursoDocente actualizar(ejbCcoCepCursoDocente grupo);

    /**
     * Función para buscar un grupo por ID
     * @param id Identificador del grupo
     * @return Grupo encontrado o null
     */
    ejbCcoCepCursoDocente buscarPorId(Integer id);

    /**
     * Función para listar todos los grupos
     * @return Lista de grupos
     */
    List<ejbCcoCepCursoDocente> listarTodos();

    /**
     * Función para listar grupos por curso
     * @param idCurso Identificador del curso
     * @return Lista de grupos
     */
    List<ejbCcoCepCursoDocente> listarPorCurso(Integer idCurso);

    /**
     * Función para contar preregistros de un grupo
     * @param idGrupo Identificador del grupo
     * @return Cantidad de preregistros
     */
    Long contarPreregistros(Integer idGrupo);

    /**
     * Función para listar alumnos matriculados en un grupo
     * @param idGrupo Identificador del grupo
     * @return Lista de alumnos matriculados
     */
    List<Object> listarMatriculados(Integer idGrupo);
}
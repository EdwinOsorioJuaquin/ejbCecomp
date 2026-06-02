
package ejbCecomp.ejb.negocio;

import ejbCecomp.entidades.ejbCcoCepNivelModalidad;
import jakarta.ejb.Local;
import java.util.List;

/**
 * Servicio de negocio para Niveles Modalidad.
 */
@Local
public interface ejbCcoCepNivelModalidadServiceLocal {
    /**
     * Función para crear un nivel modalidad
     * @param nivel Datos del nivel modalidad
     * @return Nivel modalidad creado
     */
    ejbCcoCepNivelModalidad crear(ejbCcoCepNivelModalidad nivel);

    /**
     * Función para actualizar un nivel modalidad
     * @param nivel Datos actualizados
     * @return Nivel modalidad actualizado
     */
    ejbCcoCepNivelModalidad actualizar(ejbCcoCepNivelModalidad nivel);

    /**
     * Función para buscar por ID
     * @param id Identificador del nivel modalidad
     * @return Nivel modalidad encontrado o null
     */
    ejbCcoCepNivelModalidad buscarPorId(Integer id);

    /**
     * Función para listar nivel modalidad ACTIVOS
     * @return Lista de nivel modalidad ACTIVOSs
     */
    public List<ejbCcoCepNivelModalidad> listarNivelesModalidad();
}

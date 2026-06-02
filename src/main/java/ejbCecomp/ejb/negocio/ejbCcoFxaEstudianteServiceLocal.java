
package ejbCecomp.ejb.negocio;

import ejbCecomp.entidades.*;
import jakarta.ejb.Local;

/**
 *
 * @author Jael
 */
@Local
public interface ejbCcoFxaEstudianteServiceLocal {
    /**
     * Función para buscar un alumno por su código de estudiante
     * @param codigoEstudiante  Número de 9 dogítos que identifica al estudiante
     * @return Retorna la clase ejbCcoFxaEstudiante
     */
    ejbCcoFxaEstudiante buscarPorCodigo(String codigoEstudiante);
    
    /**
     * Función para crear un nuevo estudiante
     * @param objEstudiante Clase con los datos del nuevo estudiante
     * @return Reporta la nueva clase creada
     */
    ejbCcoFxaEstudiante crear(ejbCcoFxaEstudiante objEstudiante);
}

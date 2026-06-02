
package ejbCecomp.ejb.dao;

import ejbCecomp.entidades.ejbCcoCcoPrecios;
import jakarta.ejb.Local;
import java.util.List;

/**
 * DAO Local para la entidad Precios.
 * 
 * Define las operaciones de acceso a datos para la tabla cco_precios.
 */
@Local
public interface ejbCcoCcoPreciosDAOLocal extends ejbCcoGenericoDAOLocal<ejbCcoCcoPrecios>{
    /**
     * Función para obtener todos los precios registrados
     * @return Lista de cursos
     */
    List<ejbCcoCcoPrecios> listarTodos();
    
    /**
     * Función para obtener todos los cursos registrados
     * @return Lista de precios actuvos
     */
    List<ejbCcoCcoPrecios> listarActivos();


    /**
     * Función para buscar cursos por nombre
     * @param concepto Nombre o parte del concepto
     * @return Lista de precios que coinciden con la búsqueda
     */
    List<ejbCcoCcoPrecios> buscarPorConcepto(String concepto);
    
}

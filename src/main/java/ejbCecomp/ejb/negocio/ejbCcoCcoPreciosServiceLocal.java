
package ejbCecomp.ejb.negocio;

import ejbCecomp.entidades.ejbCcoCcoPrecios;
import jakarta.ejb.Local;
import java.util.List;

/**
 *
 * Servicio de negocio para los precios
 */
@Local
public interface ejbCcoCcoPreciosServiceLocal {
        /**
     * Función para crear un precio
     * @param precio Datos del precio y concepto
     * @return Precio creado
     */
    ejbCcoCcoPrecios crear(ejbCcoCcoPrecios cert);

    /**
     * Función para actualizar un certificado
     * @param precio Datos actualizados
     * @return Precio actualizado
     */
    ejbCcoCcoPrecios actualizar(ejbCcoCcoPrecios precio);

    /**
     * Función para buscar por ID
     * @param id Identificador del precio
     * @return Precio encontrado o null
     */
    ejbCcoCcoPrecios buscarPorId(Integer id);

    /**
     * Función para listar todos los precios
     * @return Lista de precios
     */
    List<ejbCcoCcoPrecios> listarTodos();

    /**
     * Función para listar precios por concepto
     * @param concepto Identificador del alumno
     * @return Lista de Precios
     */
    List<ejbCcoCcoPrecios> buscarPorConcepto(String concepto);
}

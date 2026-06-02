
package ejbCecomp.ejb.negocio;

import ejbCecomp.entidades.ejbCcoCepCecCert;
import jakarta.ejb.Local;
import java.util.List;

/**
 * Servicio de negocio para certificados.
 */
@Local
public interface ejbCcoCepCecCertServiceLocal {
    /**
     * Función para crear un certificado
     * @param cert Datos del certificado
     * @return Certificado creado
     */
    ejbCcoCepCecCert crear(ejbCcoCepCecCert cert);

    /**
     * Función para actualizar un certificado
     * @param cert Datos actualizados
     * @return Certificado actualizado
     */
    ejbCcoCepCecCert actualizar(ejbCcoCepCecCert cert);

    /**
     * Función para buscar por ID
     * @param id Identificador del certificado
     * @return Certificado encontrado o null
     */
    ejbCcoCepCecCert buscarPorId(Integer id);

    /**
     * Función para listar todos los certificados
     * @return Lista de certificados
     */
    List<ejbCcoCepCecCert> listarTodos();

    /**
     * Función para listar certificados por alumno
     * @param idAlumno Identificador del alumno
     * @return Lista de certificados
     */
    List<ejbCcoCepCecCert> listarPorAlumno(Integer idAlumno);
}


package ejbCecomp.ejb.dao;

import ejbCecomp.clases.ejbCcoAlumnoExternoDTO;
import ejbCecomp.entidades.*;
import jakarta.ejb.Local;
import java.util.List;

/**
 * DAO Local para la entidad Alumno Externo.
 * 
 * Contiene métodos de acceso a datos específicos
 * utilizados principalmente para autenticación.
 * 
 */
@Local
public interface ejbCcoCcoAlumnoExternoDAOLocal extends ejbCcoGenericoDAOLocal<ejbCcoCcoAlumnoExterno>{
    /**
     * Busca un alumno externo por su correo de login.
     * 
     * @param correo Correo del alumno
     * @return Objeto ejbCcoCcoAlumnoExterno si existe, null si no existe
     */
    public ejbCcoCcoAlumnoExterno buscarPorCorreo(String correo);
    
    
    /**
    * Lista alumnos externos con datos de persona
     * @return 
    */
    public List<ejbCcoCcoAlumnoExterno> listarAlumnosExternos();
    
    /**
    * Guarda persona natural
     * @param persona
     * @return 
    */
    public ejbCcoDrtPersonanatural  guardarPersona(ejbCcoDrtPersonanatural persona);

    
    /**
    * Guarda alumno externo
     * @param alumno
    */
    public void guardarAlumnoExterno(ejbCcoCcoAlumnoExterno alumno);

    /**
    * Actualiza datos de persona
        * @param persona
        * @return 
    */
    public ejbCcoDrtPersonanatural actualizarPersona(ejbCcoDrtPersonanatural persona);
    
    
    public void actualizarAlumnoExterno(ejbCcoCcoAlumnoExterno alumno);

    /**
     * Cambia estado del alumno externo
     * @param idAlumno
     * @param estado
     */

    public void cambiarEstado(Integer idAlumno, short estado);
    
    public List<ejbCcoAlumnoExternoDTO> listarAlumnosExternosDTO();
    
    public Integer obtenerUltimoIdPersona();
     
    public Integer obtenerUltimoIdAlumno();
     
    ejbCcoCcoAlumnoExterno buscarPorIdDir(Integer idDir);
}

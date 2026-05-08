package ejbCecomp.ejb.negocio;

import ejbCecomp.clases.ejbCcoAlumnoExternoDTO;
import ejbCecomp.entidades.ejbCcoCcoAlumnoExterno;
import ejbCecomp.entidades.ejbCcoDrtPersonanatural;
import jakarta.ejb.Local;
import java.util.List;

@Local
public interface ejbCcoCcoAlumnoExternoServiceLocal {

    public int autentificar(String correo, String clave);

    public ejbCcoCcoAlumnoExterno buscarPorCorreo(String correo);

    public List<ejbCcoCcoAlumnoExterno> listarAlumnosExternos();

    public ejbCcoDrtPersonanatural  guardarPersona(ejbCcoDrtPersonanatural persona);

    public ejbCcoDrtPersonanatural actualizarPersona(ejbCcoDrtPersonanatural persona);

    public void guardarAlumnoExterno(ejbCcoCcoAlumnoExterno alumno);

    public void actualizarAlumnoExterno(ejbCcoCcoAlumnoExterno alumno);

    public void cambiarEstado(Integer idAlumno, short estado);
    
    public List<ejbCcoAlumnoExternoDTO> listarAlumnosExternosDTO();
    
    public Integer obtenerUltimoIdPersona();
    
    public Integer obtenerUltimoIdAlumno();
    
    ejbCcoCcoAlumnoExterno buscarPorId(Integer id);
}
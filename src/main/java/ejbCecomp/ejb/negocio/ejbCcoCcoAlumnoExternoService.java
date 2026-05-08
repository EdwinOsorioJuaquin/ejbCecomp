package ejbCecomp.ejb.negocio;

import ejbCecomp.entidades.ejbCcoCcoAlumnoExterno;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import ejbCecomp.ejb.dao.ejbCcoCcoAlumnoExternoDAOLocal;
import ejbCecomp.entidades.ejbCcoDrtPersonanatural;
import ejbCecomp.clases.ejbCcoAlumnoExternoDTO;
import java.util.List;

@Stateless
public class ejbCcoCcoAlumnoExternoService implements ejbCcoCcoAlumnoExternoServiceLocal {

    @Inject
    ejbCcoCcoAlumnoExternoDAOLocal dao;

    @Override
    public int autentificar(String correo, String clave) {
        try {
            ejbCcoCcoAlumnoExterno alumno = dao.buscarPorCorreo(correo);
            if (alumno == null) return 1;
            if (!alumno.getPassword().equals(clave)) return 2;
        } catch (Exception e) {
            return 3;
        }
        return 0;
    }

    @Override
    public ejbCcoCcoAlumnoExterno buscarPorCorreo(String correo) {
        return dao.buscarPorCorreo(correo);
    }

    @Override
    public List<ejbCcoCcoAlumnoExterno> listarAlumnosExternos() {
        return dao.listarAlumnosExternos();
    }

    @Override
    public List<ejbCcoAlumnoExternoDTO> listarAlumnosExternosDTO() {
        return dao.listarAlumnosExternosDTO();
    }

    @Override
    public ejbCcoDrtPersonanatural guardarPersona(ejbCcoDrtPersonanatural persona) {
        return dao.guardarPersona(persona);
    }

    @Override
    public ejbCcoDrtPersonanatural actualizarPersona(ejbCcoDrtPersonanatural persona) {
        return dao.actualizarPersona(persona);
    }

    @Override
    public void guardarAlumnoExterno(ejbCcoCcoAlumnoExterno alumno) {
        dao.guardarAlumnoExterno(alumno);
    }

    @Override
    public void actualizarAlumnoExterno(ejbCcoCcoAlumnoExterno alumno) {
        dao.actualizarAlumnoExterno(alumno);
    }

    @Override
    public void cambiarEstado(Integer idAlumno, short estado) {
        dao.cambiarEstado(idAlumno, estado);
    }
    
    @Override
    public Integer obtenerUltimoIdPersona() {
        return dao.obtenerUltimoIdPersona();
    }
    
    @Override
    public Integer obtenerUltimoIdAlumno() {
        return dao.obtenerUltimoIdAlumno();
    }
    
    @Override
    public ejbCcoCcoAlumnoExterno buscarPorId(Integer id) {
        return dao.buscarPorId(id);
    }
}
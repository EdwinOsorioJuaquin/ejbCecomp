package ejbCecomp.ejb.negocio;

import ejbCecomp.entidades.ejbCcoCcoAlumnoExterno;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import ejbCecomp.ejb.dao.ejbCcoCcoAlumnoExternoDAOLocal;
import ejbCecomp.entidades.ejbCcoDrtPersonanatural;
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
    public ejbCcoDrtPersonanatural  guardarPersona(ejbCcoDrtPersonanatural persona) {
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
}
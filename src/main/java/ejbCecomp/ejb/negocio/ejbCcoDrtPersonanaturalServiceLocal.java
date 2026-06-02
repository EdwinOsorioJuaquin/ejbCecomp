package ejbCecomp.ejb.negocio;

import ejbCecomp.entidades.ejbCcoDrtPersonanatural;
import jakarta.ejb.Local;
import java.util.List;

@Local
public interface ejbCcoDrtPersonanaturalServiceLocal {
    ejbCcoDrtPersonanatural crear(ejbCcoDrtPersonanatural persona);
    ejbCcoDrtPersonanatural actualizar(ejbCcoDrtPersonanatural persona);
    ejbCcoDrtPersonanatural buscarPorId(Integer id);
    ejbCcoDrtPersonanatural buscarPorDni(String dni);
    List<ejbCcoDrtPersonanatural> listarTodos();
    List<ejbCcoDrtPersonanatural> listarActivos();
    Integer obtenerUltimoIdPersona();
}
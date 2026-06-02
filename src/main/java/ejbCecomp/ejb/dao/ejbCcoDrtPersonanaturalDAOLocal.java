package ejbCecomp.ejb.dao;

import ejbCecomp.entidades.ejbCcoDrtPersonanatural;
import jakarta.ejb.Local;
import java.util.List;

@Local
public interface ejbCcoDrtPersonanaturalDAOLocal extends ejbCcoGenericoDAOLocal<ejbCcoDrtPersonanatural> {
    List<ejbCcoDrtPersonanatural> listarTodos();
    List<ejbCcoDrtPersonanatural> listarActivos();
    ejbCcoDrtPersonanatural buscarPorDni(String dni);
    Integer obtenerUltimoIdPersona();
    ejbCcoDrtPersonanatural guardarPersona(ejbCcoDrtPersonanatural persona);
    ejbCcoDrtPersonanatural actualizarPersona(ejbCcoDrtPersonanatural persona);
}
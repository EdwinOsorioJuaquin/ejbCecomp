package ejbCecomp.ejb.negocio;

import ejbCecomp.entidades.ejbCcoEscPersonal;
import jakarta.ejb.Local;
import java.util.List;

@Local
public interface ejbCcoEscPersonalServiceLocal {
    List<ejbCcoEscPersonal> listarTodos();
    List<ejbCcoEscPersonal> listarActivos();
}
package ejbCecomp.ejb.dao;

import ejbCecomp.entidades.ejbCcoEscPersonal;
import jakarta.ejb.Local;
import java.util.List;

@Local
public interface ejbCcoEscPersonalDAOLocal extends ejbCcoGenericoDAOLocal<ejbCcoEscPersonal> {
    List<ejbCcoEscPersonal> listarTodos();
    List<ejbCcoEscPersonal> listarActivos();
}
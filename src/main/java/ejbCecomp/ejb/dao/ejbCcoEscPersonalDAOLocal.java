package ejbCecomp.ejb.dao;

import ejbCecomp.entidades.ejbCcoEscPersonal;
import jakarta.ejb.Local;
import java.util.List;

@Local
public interface ejbCcoEscPersonalDAOLocal extends ejbCcoGenericoDAOLocal<ejbCcoEscPersonal> {
    List<ejbCcoEscPersonal> listarTodos();
    List<ejbCcoEscPersonal> listarActivos();
    ejbCcoEscPersonal buscarPorId(Integer id);
    ejbCcoEscPersonal buscarPorIdDir(Integer idDir);
    Integer obtenerUltimoIdEsc();
    List<ejbCcoEscPersonal> listarNoDocentesCecomp();
    ejbCcoEscPersonal guardarEscPersonal(ejbCcoEscPersonal escPersonal);
    ejbCcoEscPersonal actualizarEscPersonal(ejbCcoEscPersonal escPersonal);
}
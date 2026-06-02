package ejbCecomp.ejb.negocio;

import ejbCecomp.entidades.ejbCcoEscPersonal;
import jakarta.ejb.Local;
import java.util.List;

@Local
public interface ejbCcoEscPersonalServiceLocal {
    List<ejbCcoEscPersonal> listarTodos();
    List<ejbCcoEscPersonal> listarActivos();
    ejbCcoEscPersonal crear(ejbCcoEscPersonal escPersonal);
    ejbCcoEscPersonal actualizar(ejbCcoEscPersonal escPersonal);
    ejbCcoEscPersonal buscarPorId(Integer id);
    ejbCcoEscPersonal buscarPorIdDir(Integer idDir);
    Integer obtenerUltimoIdEsc();
    List<ejbCcoEscPersonal> listarNoDocentesCecomp();
}
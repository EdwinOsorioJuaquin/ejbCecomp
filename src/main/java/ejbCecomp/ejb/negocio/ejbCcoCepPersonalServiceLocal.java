package ejbCecomp.ejb.negocio;

import ejbCecomp.entidades.ejbCcoCepPersonal;
import jakarta.ejb.Local;
import java.util.List;

@Local
public interface ejbCcoCepPersonalServiceLocal {
    ejbCcoCepPersonal crear(ejbCcoCepPersonal cepPersonal);
    ejbCcoCepPersonal actualizar(ejbCcoCepPersonal cepPersonal);
    ejbCcoCepPersonal buscarPorId(Integer id);
    List<ejbCcoCepPersonal> listarTodos();
    List<ejbCcoCepPersonal> listarActivos();
    Integer obtenerUltimoIdPersonal();
}
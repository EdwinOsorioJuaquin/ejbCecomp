package ejbCecomp.ejb.dao;

import ejbCecomp.entidades.ejbCcoCepPersonal;
import ejbCecomp.entidades.ejbCcoEscPersonal;
import jakarta.ejb.Local;
import java.util.List;

@Local
public interface ejbCcoCepPersonalDAOLocal extends ejbCcoGenericoDAOLocal<ejbCcoCepPersonal> {
    List<ejbCcoCepPersonal> listarTodos();
    List<ejbCcoCepPersonal> listarActivos();
    ejbCcoCepPersonal buscarPorId(Integer id);
    Integer obtenerUltimoIdPersonal();
    ejbCcoCepPersonal guardarCepPersonal(ejbCcoCepPersonal cepPersonal);
    ejbCcoCepPersonal actualizarCepPersonal(ejbCcoCepPersonal cepPersonal);
}
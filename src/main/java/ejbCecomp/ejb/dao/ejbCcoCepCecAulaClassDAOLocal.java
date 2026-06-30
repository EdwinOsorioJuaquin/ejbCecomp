package ejbCecomp.ejb.dao;

import ejbCecomp.entidades.ejbCcoCepCecAulaClass;
import jakarta.ejb.Local;
import java.util.List;

@Local
public interface ejbCcoCepCecAulaClassDAOLocal extends ejbCcoGenericoDAOLocal<ejbCcoCepCecAulaClass> {
    List<ejbCcoCepCecAulaClass> listarTodos();
    ejbCcoCepCecAulaClass buscarPorId(Integer id);
}
package ejbCecomp.ejb.negocio;

import ejbCecomp.entidades.ejbCcoCepCecAulaClass;
import jakarta.ejb.Local;
import java.util.List;

@Local
public interface ejbCcoCepCecAulaClassServiceLocal {
    List<ejbCcoCepCecAulaClass> listarTodos();
    ejbCcoCepCecAulaClass buscarPorId(Integer id);
}
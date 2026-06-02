
package ejbCecomp.ejb.negocio;

import ejbCecomp.entidades.ejbCcoCepCecNivel;
import jakarta.ejb.Local;
import java.util.List;

/**
 *
 * @author Jael
 */
@Local
public interface ejbCcoCepCecNivelServiceLocal {
    public List<ejbCcoCepCecNivel> listarTodos();
    public ejbCcoCepCecNivel buscarPorId(Integer id);
}

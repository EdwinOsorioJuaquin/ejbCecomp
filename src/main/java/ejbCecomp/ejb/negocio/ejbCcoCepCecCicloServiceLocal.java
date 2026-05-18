
package ejbCecomp.ejb.negocio;

import ejbCecomp.entidades.ejbCcoCepCecCiclo;
import jakarta.ejb.Local;
import java.util.List;

/**
 *
 * @author Jael
 */
@Local
public interface ejbCcoCepCecCicloServiceLocal {
    public List<ejbCcoCepCecCiclo> listarTodos();
    public ejbCcoCepCecCiclo buscarPorId(Integer id);
}

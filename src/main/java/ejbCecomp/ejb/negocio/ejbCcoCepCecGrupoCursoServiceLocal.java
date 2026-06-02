
package ejbCecomp.ejb.negocio;

import ejbCecomp.entidades.ejbCcoCepCecGrupoCurso;
import jakarta.ejb.Local;
import java.util.List;

/**
 *
 * @author Jael
 */
@Local
public interface ejbCcoCepCecGrupoCursoServiceLocal {
    public List<ejbCcoCepCecGrupoCurso> listarTodos();
    public ejbCcoCepCecGrupoCurso buscarPorId(Integer id);
    
}

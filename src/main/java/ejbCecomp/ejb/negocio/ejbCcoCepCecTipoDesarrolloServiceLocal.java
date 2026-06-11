package ejbCecomp.ejb.negocio;

import ejbCecomp.entidades.ejbCcoCepCecTipoDesarrollo;
import jakarta.ejb.Local;
import java.util.List;

@Local
public interface ejbCcoCepCecTipoDesarrolloServiceLocal {
    List<ejbCcoCepCecTipoDesarrollo> listarTodos();
    ejbCcoCepCecTipoDesarrollo buscarPorId(Integer idCiclo);
    List<ejbCcoCepCecTipoDesarrollo> listarActivos();
}
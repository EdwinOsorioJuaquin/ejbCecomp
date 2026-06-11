package ejbCecomp.ejb.dao;

import ejbCecomp.entidades.ejbCcoCepCecTipoDesarrollo;
import jakarta.ejb.Local;
import java.util.List;

@Local
public interface ejbCcoCepCecTipoDesarrolloDAOLocal extends ejbCcoGenericoDAOLocal<ejbCcoCepCecTipoDesarrollo> {
    List<ejbCcoCepCecTipoDesarrollo> listarTodos();
    ejbCcoCepCecTipoDesarrollo buscarPorId(Integer idCiclo);
    List<ejbCcoCepCecTipoDesarrollo> listarActivos();
}
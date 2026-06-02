package ejbCecomp.ejb.dao;

import ejbCecomp.entidades.ejbCcoCepCecTema;
import jakarta.ejb.Local;
import java.util.List;

@Local
public interface ejbCcoCepCecTemaDAOLocal extends ejbCcoGenericoDAOLocal<ejbCcoCepCecTema> {
    List<ejbCcoCepCecTema> listarPorSesion(Integer idPland, Integer idSesio);
    List<ejbCcoCepCecTema> listarTodos();
}
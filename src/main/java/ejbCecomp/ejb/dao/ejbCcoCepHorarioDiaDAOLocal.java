package ejbCecomp.ejb.dao;

import ejbCecomp.entidades.ejbCcoCepHorarioDia;
import jakarta.ejb.Local;
import java.util.List;

@Local
public interface ejbCcoCepHorarioDiaDAOLocal extends ejbCcoGenericoDAOLocal<ejbCcoCepHorarioDia> {
    List<ejbCcoCepHorarioDia> listarPorGrupo(Integer idAd);
    void eliminar(ejbCcoCepHorarioDia horario);
}
package ejbCecomp.ejb.negocio;

import ejbCecomp.entidades.ejbCcoCepHorarioDia;
import jakarta.ejb.Local;
import java.util.List;

@Local
public interface ejbCcoCepHorarioDiaServiceLocal {
    ejbCcoCepHorarioDia crear(ejbCcoCepHorarioDia horario);
    ejbCcoCepHorarioDia actualizar(ejbCcoCepHorarioDia horario);
    ejbCcoCepHorarioDia buscarPorId(Integer id);
    List<ejbCcoCepHorarioDia> listarPorGrupo(Integer idAd);
    void eliminarTodosPorGrupo(Integer idAd);
}
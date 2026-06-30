package ejbCecomp.ejb.negocio;

import ejbCecomp.entidades.ejbCcoCepHorarioHora;
import jakarta.ejb.Local;
import java.util.List;

@Local
public interface ejbCcoCepHorarioHoraServiceLocal {
    List<ejbCcoCepHorarioHora> listarActivos();
    ejbCcoCepHorarioHora buscarPorId(Integer id);
}
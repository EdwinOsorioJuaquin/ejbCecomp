package ejbCecomp.ejb.dao;

import ejbCecomp.entidades.ejbCcoCepHorarioHora;
import jakarta.ejb.Local;
import java.util.List;

@Local
public interface ejbCcoCepHorarioHoraDAOLocal extends ejbCcoGenericoDAOLocal<ejbCcoCepHorarioHora> {
    List<ejbCcoCepHorarioHora> listarActivos();
    ejbCcoCepHorarioHora buscarPorId(Integer id);
}
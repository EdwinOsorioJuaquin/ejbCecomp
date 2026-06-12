package ejbCecomp.ejb.dao;

import ejbCecomp.entidades.ejbCcoCepCecNotas;
import jakarta.ejb.Local;
import java.util.List;

@Local
public interface ejbCcoCepCecNotasDAOLocal extends ejbCcoGenericoDAOLocal<ejbCcoCepCecNotas> {
    public List<ejbCcoCepCecNotas> listarPorMatricula(Integer idMtaAlu);
}
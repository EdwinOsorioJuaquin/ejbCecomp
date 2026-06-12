package ejbCecomp.ejb.negocio;

import ejbCecomp.entidades.ejbCcoCepCecNotas;
import jakarta.ejb.Local;
import java.util.List;

@Local
public interface ejbCcoCepCecNotasServiceLocal {
    List<ejbCcoCepCecNotas> listarPorMatricula(Integer idMtaAlu);
}
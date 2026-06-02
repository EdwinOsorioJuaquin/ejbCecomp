package ejbCecomp.ejb.dao;

import ejbCecomp.entidades.ejbCcoCepCecSesion;
import jakarta.ejb.Local;
import java.util.List;

@Local
public interface ejbCcoCepCecSesionDAOLocal extends ejbCcoGenericoDAOLocal<ejbCcoCepCecSesion> {
    List<ejbCcoCepCecSesion> listarPorPlan(Integer idPlan);
}
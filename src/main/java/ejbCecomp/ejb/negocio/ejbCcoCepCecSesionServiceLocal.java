package ejbCecomp.ejb.negocio;

import ejbCecomp.entidades.ejbCcoCepCecSesion;
import jakarta.ejb.Local;
import java.util.List;

@Local
public interface ejbCcoCepCecSesionServiceLocal {
    ejbCcoCepCecSesion crear(ejbCcoCepCecSesion sesion);
    ejbCcoCepCecSesion actualizar(ejbCcoCepCecSesion sesion);
    ejbCcoCepCecSesion buscarPorId(Integer idPland, Integer idSesio);
    List<ejbCcoCepCecSesion> listarPorPlan(Integer idPlan);
}
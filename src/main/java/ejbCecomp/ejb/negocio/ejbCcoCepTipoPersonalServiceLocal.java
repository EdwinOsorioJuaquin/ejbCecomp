package ejbCecomp.ejb.negocio;

import ejbCecomp.entidades.ejbCcoCepTipoPersonal;
import jakarta.ejb.Local;
import java.util.List;

@Local
public interface ejbCcoCepTipoPersonalServiceLocal {
    List<ejbCcoCepTipoPersonal> listarActivos();
    ejbCcoCepTipoPersonal buscarPorId(Short id);
}
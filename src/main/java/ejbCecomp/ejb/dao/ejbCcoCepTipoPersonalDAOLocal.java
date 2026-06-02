package ejbCecomp.ejb.dao;

import ejbCecomp.entidades.ejbCcoCepTipoPersonal;
import jakarta.ejb.Local;
import java.util.List;

@Local
public interface ejbCcoCepTipoPersonalDAOLocal extends ejbCcoGenericoDAOLocal<ejbCcoCepTipoPersonal> {
    List<ejbCcoCepTipoPersonal> listarActivos();
    ejbCcoCepTipoPersonal buscarPorId(Short id);
}
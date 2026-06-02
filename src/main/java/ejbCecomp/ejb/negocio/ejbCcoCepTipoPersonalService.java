package ejbCecomp.ejb.negocio;

import ejbCecomp.ejb.dao.ejbCcoCepTipoPersonalDAOLocal;
import ejbCecomp.entidades.ejbCcoCepTipoPersonal;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.util.List;

@Stateless
public class ejbCcoCepTipoPersonalService implements ejbCcoCepTipoPersonalServiceLocal {

    @Inject
    private ejbCcoCepTipoPersonalDAOLocal dao;

    @Override
    public List<ejbCcoCepTipoPersonal> listarActivos() {
        return dao.listarActivos();
    }
    
    @Override
    public ejbCcoCepTipoPersonal buscarPorId(Short id) {
        return dao.buscarPorId(id);
    }
}
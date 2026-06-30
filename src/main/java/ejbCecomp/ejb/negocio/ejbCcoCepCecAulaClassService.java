package ejbCecomp.ejb.negocio;

import ejbCecomp.ejb.dao.ejbCcoCepCecAulaClassDAOLocal;
import ejbCecomp.entidades.ejbCcoCepCecAulaClass;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.util.List;

@Stateless
public class ejbCcoCepCecAulaClassService implements ejbCcoCepCecAulaClassServiceLocal {

    @Inject
    private ejbCcoCepCecAulaClassDAOLocal dao;

    @Override
    public List<ejbCcoCepCecAulaClass> listarTodos() {
        return dao.listarTodos();
    }

    @Override
    public ejbCcoCepCecAulaClass buscarPorId(Integer id) {
        return dao.buscarPorId(id);
    }
}
package ejbCecomp.ejb.negocio;

import ejbCecomp.ejb.dao.ejbCcoCepCecNotasDAOLocal;
import ejbCecomp.entidades.ejbCcoCepCecNotas;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.util.List;

@Stateless
public class ejbCcoCepCecNotasService implements ejbCcoCepCecNotasServiceLocal {

    @Inject
    private ejbCcoCepCecNotasDAOLocal dao;

    @Override
    public List<ejbCcoCepCecNotas> listarPorMatricula(Integer idMtaAlu) {
        return dao.listarPorMatricula(idMtaAlu);
    }
}
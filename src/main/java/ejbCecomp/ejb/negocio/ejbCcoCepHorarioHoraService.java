package ejbCecomp.ejb.negocio;

import ejbCecomp.ejb.dao.ejbCcoCepHorarioHoraDAOLocal;
import ejbCecomp.entidades.ejbCcoCepHorarioHora;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.util.List;

@Stateless
public class ejbCcoCepHorarioHoraService implements ejbCcoCepHorarioHoraServiceLocal {

    @Inject
    private ejbCcoCepHorarioHoraDAOLocal dao;

    @Override
    public List<ejbCcoCepHorarioHora> listarActivos() {
        return dao.listarActivos();
    }

    @Override
    public ejbCcoCepHorarioHora buscarPorId(Integer id) {
        return dao.buscarPorId(id);
    }
}
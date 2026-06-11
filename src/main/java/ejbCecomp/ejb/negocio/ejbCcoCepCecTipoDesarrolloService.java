package ejbCecomp.ejb.negocio;

import ejbCecomp.ejb.dao.ejbCcoCepCecTipoDesarrolloDAOLocal;
import ejbCecomp.entidades.ejbCcoCepCecTipoDesarrollo;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import java.util.List;

@Stateless
public class ejbCcoCepCecTipoDesarrolloService implements ejbCcoCepCecTipoDesarrolloServiceLocal {

    @EJB
    private ejbCcoCepCecTipoDesarrolloDAOLocal dao;

    @Override
    public List<ejbCcoCepCecTipoDesarrollo> listarTodos() {
        return dao.listarTodos();
    }

    @Override
    public ejbCcoCepCecTipoDesarrollo buscarPorId(Integer idCiclo) {
        return dao.buscarPorId(idCiclo);
    }

    @Override
    public List<ejbCcoCepCecTipoDesarrollo> listarActivos() {
        return dao.listarActivos();
    }
}
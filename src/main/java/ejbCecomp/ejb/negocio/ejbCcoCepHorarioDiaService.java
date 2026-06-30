package ejbCecomp.ejb.negocio;

import ejbCecomp.ejb.dao.ejbCcoCepHorarioDiaDAOLocal;
import ejbCecomp.entidades.ejbCcoCepHorarioDia;
import jakarta.annotation.Resource;
import jakarta.ejb.Stateless;
import jakarta.ejb.TransactionManagement;
import jakarta.ejb.TransactionManagementType;
import jakarta.inject.Inject;
import jakarta.transaction.UserTransaction;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class ejbCcoCepHorarioDiaService implements ejbCcoCepHorarioDiaServiceLocal {

    @Resource
    private UserTransaction ut;

    @Inject
    private ejbCcoCepHorarioDiaDAOLocal dao;

    @Override
    public ejbCcoCepHorarioDia crear(ejbCcoCepHorarioDia horario) {
        try {
            ut.begin();
            horario = dao.crear(horario);
            ut.commit();
            return horario;
        } catch (Exception e) {
            try {
                ut.rollback();
            } catch (Exception ex) {
                Logger.getLogger(ejbCcoCepHorarioDiaService.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        }
    }

    @Override
    public ejbCcoCepHorarioDia actualizar(ejbCcoCepHorarioDia horario) {
        try {
            ut.begin();
            horario = dao.actualizar(horario);
            ut.commit();
            return horario;
        } catch (Exception e) {
            try {
                ut.rollback();
            } catch (Exception ex) {
                Logger.getLogger(ejbCcoCepHorarioDiaService.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        }
    }

    @Override
    public ejbCcoCepHorarioDia buscarPorId(Integer id) {
        return dao.buscarPorId(id);
    }

    @Override
    public List<ejbCcoCepHorarioDia> listarPorGrupo(Integer idAd) {
        return dao.listarPorGrupo(idAd);
    }

    @Override
    public void eliminarTodosPorGrupo(Integer idAd) {
        try {
            ut.begin();
            List<ejbCcoCepHorarioDia> horarios = dao.listarPorGrupo(idAd);
            for (ejbCcoCepHorarioDia horario : horarios) {
                dao.eliminar(horario);
            }
            ut.commit();
        } catch (Exception e) {
            try {
                ut.rollback();
            } catch (Exception ex) {
                Logger.getLogger(ejbCcoCepHorarioDiaService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
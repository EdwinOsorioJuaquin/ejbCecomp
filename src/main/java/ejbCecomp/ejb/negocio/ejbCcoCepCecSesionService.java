package ejbCecomp.ejb.negocio;

import ejbCecomp.ejb.dao.ejbCcoCepCecSesionDAOLocal;
import ejbCecomp.entidades.ejbCcoCepCecSesion;
import ejbCecomp.entidades.ejbCcoCepCecSesionPK;
import jakarta.annotation.Resource;
import jakarta.ejb.Stateless;
import jakarta.ejb.TransactionManagement;
import jakarta.ejb.TransactionManagementType;
import jakarta.inject.Inject;
import jakarta.transaction.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class ejbCcoCepCecSesionService implements ejbCcoCepCecSesionServiceLocal {

    @Resource
    private UserTransaction ut;

    @Inject
    private ejbCcoCepCecSesionDAOLocal dao;

    @Override
    public ejbCcoCepCecSesion crear(ejbCcoCepCecSesion sesion) {
        try {
            ut.begin();
            sesion = dao.crear(sesion);
            ut.commit();
            return sesion;
        } catch (NotSupportedException | SystemException | RollbackException |
                 HeuristicMixedException | HeuristicRollbackException |
                 SecurityException | IllegalStateException ex) {
            try {
                ut.rollback();
            } catch (IllegalStateException | SecurityException | SystemException ex1) {
                Logger.getLogger(ejbCcoCepCecSesionService.class.getName())
                      .log(Level.SEVERE, null, ex1);
            }
            return null;
        }
    }

    @Override
    public ejbCcoCepCecSesion actualizar(ejbCcoCepCecSesion sesion) {
        try {
            ut.begin();
            sesion = dao.actualizar(sesion);
            ut.commit();
            return sesion;
        } catch (Exception e) {
            try {
                ut.rollback();
            } catch (Exception ex) {
                Logger.getLogger(ejbCcoCepCecSesionService.class.getName())
                      .log(Level.SEVERE, null, ex);
            }
            return null;
        }
    }

    @Override
    public ejbCcoCepCecSesion buscarPorId(Integer idPland, Integer idSesio) {
        ejbCcoCepCecSesionPK pk = new ejbCcoCepCecSesionPK();
        pk.setIdPland(idPland);
        pk.setIdSesio(idSesio);
        return dao.buscarPorId(pk);
    }

    @Override
    public List<ejbCcoCepCecSesion> listarPorPlan(Integer idPlan) {
        return dao.listarPorPlan(idPlan);
    }
    
    @Override
    public List<ejbCcoCepCecSesion> listarPorCurso(Integer idCurso) {
        return dao.listarPorCurso(idCurso);
    }
}
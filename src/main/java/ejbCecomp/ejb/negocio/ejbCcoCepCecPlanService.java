package ejbCecomp.ejb.negocio;

import ejbCecomp.ejb.dao.ejbCcoCepCecPlanDAOLocal;
import ejbCecomp.entidades.ejbCcoCepCecPlan;
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
public class ejbCcoCepCecPlanService implements ejbCcoCepCecPlanServiceLocal {

    @Resource
    private UserTransaction ut;

    @Inject
    private ejbCcoCepCecPlanDAOLocal dao;

    @Override
    public ejbCcoCepCecPlan crear(ejbCcoCepCecPlan plan) {
        try {
            ut.begin();
            plan = dao.crear(plan);
            ut.commit();
            return plan;
        } catch (NotSupportedException | SystemException | RollbackException |
                 HeuristicMixedException | HeuristicRollbackException |
                 SecurityException | IllegalStateException ex) {
            try {
                ut.rollback();
            } catch (IllegalStateException | SecurityException | SystemException ex1) {
                Logger.getLogger(ejbCcoCepCecPlanService.class.getName())
                      .log(Level.SEVERE, null, ex1);
            }
            return null;
        }
    }

    @Override
    public ejbCcoCepCecPlan actualizar(ejbCcoCepCecPlan plan) {
        try {
            ut.begin();
            plan = dao.actualizar(plan);
            ut.commit();
            return plan;
        } catch (NotSupportedException | SystemException | RollbackException |
                 HeuristicMixedException | HeuristicRollbackException |
                 SecurityException | IllegalStateException ex) {
            try {
                ut.rollback();
            } catch (IllegalStateException | SecurityException | SystemException ex1) {
                Logger.getLogger(ejbCcoCepCecPlanService.class.getName())
                      .log(Level.SEVERE, null, ex1);
            }
            return null;
        }
    }

    @Override
    public ejbCcoCepCecPlan buscarPorId(Integer id) {
        return dao.buscarPorId(id);
    }

    @Override
    public List<ejbCcoCepCecPlan> listarTodos() {
        return dao.listarTodos();
    }

    @Override
    public List<ejbCcoCepCecPlan> listarActivos() {
        return dao.listarActivos();
    }

    @Override
    public ejbCcoCepCecPlan buscarPorNombre(String nombre) {
        return dao.buscarPorNombre(nombre);
    }
}
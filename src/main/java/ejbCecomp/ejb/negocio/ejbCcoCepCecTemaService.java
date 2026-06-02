package ejbCecomp.ejb.negocio;

import ejbCecomp.ejb.dao.ejbCcoCepCecTemaDAOLocal;
import ejbCecomp.entidades.ejbCcoCepCecTema;
import ejbCecomp.entidades.ejbCcoCepCecTemaPK;
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
public class ejbCcoCepCecTemaService implements ejbCcoCepCecTemaServiceLocal {

    @Resource
    private UserTransaction ut;

    @Inject
    private ejbCcoCepCecTemaDAOLocal dao;

    @Override
    public ejbCcoCepCecTema crear(ejbCcoCepCecTema tema) {
        try {
            ut.begin();
            tema = dao.crear(tema);
            ut.commit();
            return tema;
        } catch (NotSupportedException | SystemException | RollbackException |
                 HeuristicMixedException | HeuristicRollbackException |
                 SecurityException | IllegalStateException ex) {
            try {
                ut.rollback();
            } catch (IllegalStateException | SecurityException | SystemException ex1) {
                Logger.getLogger(ejbCcoCepCecTemaService.class.getName())
                      .log(Level.SEVERE, null, ex1);
            }
            return null;
        }
    }

    @Override
    public ejbCcoCepCecTema actualizar(ejbCcoCepCecTema tema) {
        try {
            ut.begin();
            tema = dao.actualizar(tema);
            ut.commit();
            return tema;
        } catch (Exception e) {
            try {
                ut.rollback();
            } catch (Exception ex) {
                Logger.getLogger(ejbCcoCepCecTemaService.class.getName())
                      .log(Level.SEVERE, null, ex);
            }
            return null;
        }
    }

    @Override
    public ejbCcoCepCecTema buscarPorId(Integer idPland, Integer idSesio, Integer idTem) {
        ejbCcoCepCecTemaPK pk = new ejbCcoCepCecTemaPK();
        pk.setIdPland(idPland);
        pk.setIdSesio(idSesio);
        pk.setIdTem(idTem);
        return dao.buscarPorId(pk);
    }

    @Override
    public List<ejbCcoCepCecTema> listarPorSesion(Integer idPland, Integer idSesio) {
        return dao.listarPorSesion(idPland, idSesio);
    }
    
    @Override
    public List<ejbCcoCepCecTema> listarTodos() {
        return dao.listarTodos();
    }
}
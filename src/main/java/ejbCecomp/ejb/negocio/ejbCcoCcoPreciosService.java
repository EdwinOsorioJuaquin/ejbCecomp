package ejbCecomp.ejb.negocio;

import ejbCecomp.ejb.dao.ejbCcoCcoPreciosDAOLocal;
import ejbCecomp.entidades.ejbCcoCcoPrecios;
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
public class ejbCcoCcoPreciosService implements ejbCcoCcoPreciosServiceLocal {

    @Resource
    private UserTransaction ut;

    @Inject
    private ejbCcoCcoPreciosDAOLocal dao;

    @Override
    public ejbCcoCcoPrecios crear(ejbCcoCcoPrecios precio) {
        try {
            ut.begin();
            precio = dao.crear(precio);
            ut.commit();
            return precio;
        } catch (NotSupportedException | SystemException | RollbackException | 
                 HeuristicMixedException | HeuristicRollbackException | 
                 SecurityException | IllegalStateException ex) {
            try {
                ut.rollback();
            } catch (IllegalStateException | SecurityException | SystemException ex1) {
                Logger.getLogger(ejbCcoCcoPreciosService.class.getName())
                      .log(Level.SEVERE, null, ex1);
            }
            return null;
        }
    }

    @Override
    public ejbCcoCcoPrecios actualizar(ejbCcoCcoPrecios precio) {
        try {
            ut.begin();
            precio = dao.actualizar(precio);
            ut.commit();
            return precio;
        } catch (NotSupportedException | SystemException | RollbackException | 
                 HeuristicMixedException | HeuristicRollbackException | 
                 SecurityException | IllegalStateException ex) {
            try {
                ut.rollback();
            } catch (IllegalStateException | SecurityException | SystemException ex1) {
                Logger.getLogger(ejbCcoCcoPreciosService.class.getName())
                      .log(Level.SEVERE, null, ex1);
            }
            return null;
        }
    }

    @Override
    public ejbCcoCcoPrecios buscarPorId(Integer id) {
        return dao.buscarPorId(id);
    }

    @Override
    public List<ejbCcoCcoPrecios> listarTodos() {
        return dao.listarTodos();
    }

    @Override
    public List<ejbCcoCcoPrecios> listarActivos() {
        return dao.listarActivos();
    }

    @Override
    public List<ejbCcoCcoPrecios> buscarPorConcepto(String concepto) {
        return dao.buscarPorConcepto(concepto);
    }
}
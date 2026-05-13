package ejbCecomp.ejb.negocio;

import ejbCecomp.ejb.dao.ejbCcoCepPersonalDAOLocal;
import ejbCecomp.entidades.ejbCcoCepPersonal;
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
public class ejbCcoCepPersonalService implements ejbCcoCepPersonalServiceLocal {

    @Resource
    private UserTransaction ut;

    @Inject
    private ejbCcoCepPersonalDAOLocal dao;

    @Override
    public ejbCcoCepPersonal crear(ejbCcoCepPersonal cepPersonal) {
        try {
            ut.begin();
            cepPersonal = dao.guardarCepPersonal(cepPersonal);
            ut.commit();
            return cepPersonal;
        } catch (Exception e) {
            try {
                ut.rollback();
            } catch (Exception ex) {
                Logger.getLogger(ejbCcoCepPersonalService.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        }
    }

    @Override
    public ejbCcoCepPersonal actualizar(ejbCcoCepPersonal cepPersonal) {
        try {
            ut.begin();
            cepPersonal = dao.actualizar(cepPersonal);
            ut.commit();
            return cepPersonal;
        } catch (Exception e) {
            try {
                ut.rollback();
            } catch (Exception ex) {
                Logger.getLogger(ejbCcoCepPersonalService.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        }
    }

    @Override
    public ejbCcoCepPersonal buscarPorId(Integer id) {
        return dao.buscarPorId(id);
    }

    @Override
    public List<ejbCcoCepPersonal> listarTodos() {
        return dao.listarTodos();
    }

    @Override
    public List<ejbCcoCepPersonal> listarActivos() {
        return dao.listarActivos();
    }
    
    @Override
    public Integer obtenerUltimoIdPersonal() {
        return dao.obtenerUltimoIdPersonal();
    }
}
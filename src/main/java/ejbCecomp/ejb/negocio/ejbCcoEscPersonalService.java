package ejbCecomp.ejb.negocio;

import ejbCecomp.ejb.dao.ejbCcoEscPersonalDAOLocal;
import ejbCecomp.entidades.ejbCcoEscPersonal;
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
public class ejbCcoEscPersonalService implements ejbCcoEscPersonalServiceLocal {

    @Resource
    private UserTransaction ut;

    @Inject
    private ejbCcoEscPersonalDAOLocal dao;

    @Override
    public List<ejbCcoEscPersonal> listarTodos() {
        return dao.listarTodos();
    }

    @Override
    public List<ejbCcoEscPersonal> listarActivos() {
        return dao.listarActivos();
    }
    
        @Override
    public ejbCcoEscPersonal crear(ejbCcoEscPersonal escPersonal) {
        try {
            ut.begin();
            escPersonal = dao.guardarEscPersonal(escPersonal);
            ut.commit();
            return escPersonal;
        } catch (Exception e) {
            try {
                ut.rollback();
            } catch (Exception ex) {
                Logger.getLogger(ejbCcoEscPersonalService.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        }
    }

    @Override
    public ejbCcoEscPersonal actualizar(ejbCcoEscPersonal escPersonal) {
        try {
            ut.begin();
            escPersonal = dao.actualizar(escPersonal);
            ut.commit();
            return escPersonal;
        } catch (Exception e) {
            try {
                ut.rollback();
            } catch (Exception ex) {
                Logger.getLogger(ejbCcoEscPersonalService.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        }
    }

    @Override
    public ejbCcoEscPersonal buscarPorId(Integer id) {
        return dao.buscarPorId(id);
    }
    
    @Override
    public ejbCcoEscPersonal buscarPorIdDir(Integer idDir) {
        return dao.buscarPorIdDir(idDir);
    }
  
    @Override
    public Integer obtenerUltimoIdEsc() {
        return dao.obtenerUltimoIdEsc();
    }
    
    @Override
    public List<ejbCcoEscPersonal> listarNoDocentesCecomp() {
        return dao.listarNoDocentesCecomp();
    }
}
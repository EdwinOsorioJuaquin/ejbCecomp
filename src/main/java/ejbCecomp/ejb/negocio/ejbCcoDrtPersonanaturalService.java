package ejbCecomp.ejb.negocio;

import ejbCecomp.ejb.dao.ejbCcoDrtPersonanaturalDAOLocal;
import ejbCecomp.entidades.ejbCcoDrtPersonanatural;
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
public class ejbCcoDrtPersonanaturalService implements ejbCcoDrtPersonanaturalServiceLocal {

    @Resource
    private UserTransaction ut;

    @Inject
    private ejbCcoDrtPersonanaturalDAOLocal dao;

    @Override
    public ejbCcoDrtPersonanatural crear(ejbCcoDrtPersonanatural persona) {
        try {
            ut.begin();
            persona = dao.guardarPersona(persona);  // ← Cambiar a guardarPersona
            ut.commit();
            return persona;
        } catch (Exception e) {
            try {
                ut.rollback();
            } catch (Exception ex) {
                Logger.getLogger(ejbCcoDrtPersonanaturalService.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        }
    }

    @Override
    public ejbCcoDrtPersonanatural actualizar(ejbCcoDrtPersonanatural persona) {
        try {
            ut.begin();
            persona = dao.actualizar(persona);
            ut.commit();
            return persona;
        } catch (Exception e) {
            try {
                ut.rollback();
            } catch (Exception ex) {
                Logger.getLogger(ejbCcoDrtPersonanaturalService.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        }
    }

    @Override
    public ejbCcoDrtPersonanatural buscarPorId(Integer id) {
        return dao.buscarPorId(id);
    }

    @Override
    public ejbCcoDrtPersonanatural buscarPorDni(String dni) {
        return dao.buscarPorDni(dni);
    }

    @Override
    public List<ejbCcoDrtPersonanatural> listarTodos() {
        return dao.listarTodos();
    }

    @Override
    public List<ejbCcoDrtPersonanatural> listarActivos() {
        return dao.listarActivos();
    }
    
    @Override
    public Integer obtenerUltimoIdPersona() {
        return dao.obtenerUltimoIdPersona();
    }
}
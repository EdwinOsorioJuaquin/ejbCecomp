package ejbCecomp.ejb.negocio;

import ejbCecomp.ejb.dao.ejbCcoCepNivelModalidadDAOLocal;
import ejbCecomp.entidades.ejbCcoCepNivelModalidad;
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
public class ejbCcoCepNivelModalidadService implements ejbCcoCepNivelModalidadServiceLocal {

    @Resource
    UserTransaction ut;

    @Inject
    ejbCcoCepNivelModalidadDAOLocal dao;

    @Override
    public ejbCcoCepNivelModalidad crear(ejbCcoCepNivelModalidad nivel) {
        try {
            ut.begin();
            nivel = dao.crear(nivel);
            ut.commit();
            return nivel;
        } catch (Exception e) {
            try {
                ut.rollback();
            } catch (Exception ex) {
                Logger.getLogger(ejbCcoCepNivelModalidadService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    @Override
    public ejbCcoCepNivelModalidad actualizar(ejbCcoCepNivelModalidad nivel) {
        try {
            ut.begin();
            nivel = dao.actualizar(nivel);
            ut.commit();
            return nivel;
        } catch (Exception e) {
            try {
                ut.rollback();
            } catch (Exception ex) {
                Logger.getLogger(ejbCcoCepNivelModalidadService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    @Override
    public ejbCcoCepNivelModalidad buscarPorId(Integer id) {
        return dao.buscarPorId(id);
    }

    @Override
    public List<ejbCcoCepNivelModalidad> listarNivelesModalidad() {
        return dao.listarNivelesModalidad();
    }

}

package ejbCecomp.ejb.negocio;

import ejbCecomp.entidades.ejbCcoCepCecCert;
import jakarta.ejb.Stateless;
import java.util.List;
import jakarta.ejb.TransactionManagement;
import jakarta.ejb.TransactionManagementType;
import jakarta.transaction.*;
import jakarta.inject.Inject;
import jakarta.annotation.Resource;
import ejbCecomp.ejb.dao.ejbCcoCepCecCertDAOLocal;


/**
 * Servicio de negocio para la gestión de certificados.
 */
@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class ejbCcoCepCecCertService implements ejbCcoCepCecCertServiceLocal {
    @Resource
    UserTransaction ut;

    @Inject
    ejbCcoCepCecCertDAOLocal dao;

    @Override
    public ejbCcoCepCecCert crear(ejbCcoCepCecCert cert) {
        try {
            ut.begin();
            cert = dao.crear(cert);
            ut.commit();
            return cert;
        } catch (Exception e) {
            rollback();
        }
        return null;
    }

    @Override
    public ejbCcoCepCecCert actualizar(ejbCcoCepCecCert cert) {
        try {
            ut.begin();
            cert = dao.actualizar(cert);
            ut.commit();
            return cert;
        } catch (Exception e) {
            rollback();
        }
        return null;
    }

    @Override
    public ejbCcoCepCecCert buscarPorId(Integer id) {
        return dao.buscarPorId(id);
    }

    @Override
    public List<ejbCcoCepCecCert> listarTodos() {
        return dao.listarTodos();
    }

    @Override
    public List<ejbCcoCepCecCert> listarPorAlumno(Integer idAlumno) {
        return dao.listarPorAlumno(idAlumno);
    }

    /**
     * Manejo de rollback en caso de error
     */
    private void rollback() {
        try {
            ut.rollback();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
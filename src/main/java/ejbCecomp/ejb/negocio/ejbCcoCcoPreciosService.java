
package ejbCecomp.ejb.negocio;

import ejbCecomp.ejb.dao.ejbCcoCcoPreciosDAOLocal;
import ejbCecomp.ejb.dao.ejbCcoCursoDAOLocal;
import ejbCecomp.entidades.ejbCcoCcoPrecios;
import ejbCecomp.entidades.ejbCcoCepCurso;
import jakarta.annotation.Resource;
import jakarta.ejb.Stateless;
import jakarta.ejb.TransactionManagement;
import jakarta.ejb.TransactionManagementType;
import jakarta.inject.Inject;
import jakarta.transaction.UserTransaction;
import java.util.List;

/**
 *
 * Servicio de negocio para la gestión de precios
 */
@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class ejbCcoCcoPreciosService implements ejbCcoCcoPreciosServiceLocal {

    @Resource
    UserTransaction ut;

    @Inject
    ejbCcoCcoPreciosDAOLocal dao;

    @Override
    public ejbCcoCcoPrecios crear(ejbCcoCcoPrecios precio) {
        try {
            ut.begin();
            precio = dao.crear(precio);
            ut.commit();
            return precio;
        } catch (Exception e) {
            rollback();
        }
        return null;
    }

    @Override
    public ejbCcoCcoPrecios actualizar(ejbCcoCcoPrecios precio) {
        try {
            ut.begin();
            precio = dao.actualizar(precio);
            ut.commit();
            return precio;
        } catch (Exception e) {
            rollback();
        }
        return null;
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
    public List<ejbCcoCcoPrecios> buscarPorConcepto(String concepto) {
        return dao.buscarPorConcepto(concepto);
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

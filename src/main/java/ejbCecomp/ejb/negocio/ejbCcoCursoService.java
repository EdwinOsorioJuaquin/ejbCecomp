
package ejbCecomp.ejb.negocio;

import ejbCecomp.ejb.dao.ejbCcoCursoDAOLocal;
import ejbCecomp.entidades.ejbCcoCepCurso;
import jakarta.annotation.Resource;
import jakarta.ejb.Stateless;
import jakarta.ejb.TransactionManagement;
import jakarta.ejb.TransactionManagementType;
import jakarta.inject.Inject;
import jakarta.transaction.UserTransaction;
import java.util.List;

/**
 * Servicio de negocio para la gestión de cursos.
 */
@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class ejbCcoCursoService implements ejbCcoCursoServiceLocal {
    @Resource
    UserTransaction ut;

    @Inject
    ejbCcoCursoDAOLocal dao;

    @Override
    public ejbCcoCepCurso crear(ejbCcoCepCurso curso) {
        try {
            ut.begin();
            curso = dao.crear(curso);
            ut.commit();
            return curso;
        } catch (Exception e) {
            rollback();
        }
        return null;
    }

    @Override
    public ejbCcoCepCurso actualizar(ejbCcoCepCurso curso) {
        try {
            ut.begin();
            curso = dao.actualizar(curso);
            ut.commit();
            return curso;
        } catch (Exception e) {
            rollback();
        }
        return null;
    }

    @Override
    public ejbCcoCepCurso buscarPorId(Integer id) {
        return dao.buscarPorId(id);
    }

    @Override
    public List<ejbCcoCepCurso> listarTodos() {
        return dao.listarTodos();
    }

    @Override
    public List<ejbCcoCepCurso> buscarPorNombre(String nombre) {
        return dao.buscarPorNombre(nombre);
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

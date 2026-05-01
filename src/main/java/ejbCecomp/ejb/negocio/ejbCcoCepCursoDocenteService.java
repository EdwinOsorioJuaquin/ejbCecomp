package ejbCecomp.ejb.negocio;

import ejbCecomp.ejb.dao.ejbCcoCepCursoDocenteDAOLocal;
import ejbCecomp.entidades.ejbCcoCepCursoDocente;
import jakarta.annotation.Resource;
import jakarta.ejb.Stateless;
import jakarta.ejb.TransactionManagement;
import jakarta.ejb.TransactionManagementType;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.UserTransaction;
import java.util.List;

/**
 * Servicio de negocio para grupos (curso docente).
 */
@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class ejbCcoCepCursoDocenteService implements ejbCcoCepCursoDocenteServiceLocal {

    @Resource
    UserTransaction ut;

    @Inject
    ejbCcoCepCursoDocenteDAOLocal dao;

    @PersistenceContext(unitName = "ejbCecompPU")
    private EntityManager em;

    @Override
    public ejbCcoCepCursoDocente crear(ejbCcoCepCursoDocente grupo) {
        try {
            ut.begin();
            grupo = dao.crear(grupo);
            ut.commit();
            return grupo;
        } catch (Exception e) {
            rollback();
        }
        return null;
    }

    @Override
    public ejbCcoCepCursoDocente actualizar(ejbCcoCepCursoDocente grupo) {
        try {
            ut.begin();
            grupo = dao.actualizar(grupo);
            ut.commit();
            return grupo;
        } catch (Exception e) {
            rollback();
        }
        return null;
    }

    @Override
    public ejbCcoCepCursoDocente buscarPorId(Integer id) {
        return dao.buscarPorId(id);
    }

    @Override
    public List<ejbCcoCepCursoDocente> listarTodos() {
        return dao.listarTodos();
    }

    @Override
    public List<ejbCcoCepCursoDocente> listarPorCurso(Integer idCurso) {
        return dao.listarPorCurso(idCurso);
    }

    /**
     * Cuenta la cantidad de preregistros en un grupo
     */
    @Override
    public Long contarPreregistros(Integer idGrupo) {

        TypedQuery<Long> q = em.createQuery(
            "SELECT COUNT(a) FROM CepCcoAluIns a WHERE a.idAd.idAd = :idGrupo",
            Long.class
        );

        q.setParameter("idGrupo", idGrupo);

        return q.getSingleResult();
    }

    /**
     * Lista los alumnos matriculados en un grupo
     */
    @Override
    public List<Object> listarMatriculados(Integer idGrupo) {

        TypedQuery<Object> q = em.createQuery(
            "SELECT m FROM CepCcoMatriculaCab m WHERE m.idAd.idAd = :idGrupo",
            Object.class
        );

        q.setParameter("idGrupo", idGrupo);

        return q.getResultList();
    }

    /**
     * Manejo de rollback
     */
    private void rollback() {
        try {
            ut.rollback();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
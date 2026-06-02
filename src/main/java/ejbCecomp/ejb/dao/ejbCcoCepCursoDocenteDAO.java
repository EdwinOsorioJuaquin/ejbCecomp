package ejbCecomp.ejb.dao;

import ejbCecomp.entidades.ejbCcoCepCursoDocente;
import jakarta.ejb.Stateless;
import jakarta.persistence.TypedQuery;
import java.util.List;

/**
 * Implementación DAO para grupos (curso docente).
 */
@Stateless
public class ejbCcoCepCursoDocenteDAO 
        extends ejbCcoGenericoDAO<ejbCcoCepCursoDocente> 
        implements ejbCcoCepCursoDocenteDAOLocal {

    /**
     * Obtiene todos los grupos registrados
     */
    @Override
    public List<ejbCcoCepCursoDocente> listarTodos() {

        TypedQuery<ejbCcoCepCursoDocente> q =
            em.createQuery("SELECT g FROM CepCursoDocente g", ejbCcoCepCursoDocente.class);

        return q.getResultList();
    }

    /**
     * Lista los grupos según el curso
     */
    @Override
    public List<ejbCcoCepCursoDocente> listarPorCurso(Integer idCurso) {

        TypedQuery<ejbCcoCepCursoDocente> q =
            em.createQuery(
                "SELECT g FROM CepCursoDocente g WHERE g.idCurso.idCurso = :idCurso",
                ejbCcoCepCursoDocente.class
            );

        q.setParameter("idCurso", idCurso);

        return q.getResultList();
    }
}
package ejbCecomp.ejb.negocio;

import ejbCecomp.entidades.ejbCcoCepCecGrupoCurso;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import java.util.List;

@Stateless
public class ejbCcoCepCecGrupoCursoService implements ejbCcoCepCecGrupoCursoServiceLocal {

    @PersistenceContext(unitName = "ejbCecompPU")
    private EntityManager em;

    @Override
    public List<ejbCcoCepCecGrupoCurso> listarTodos() {
        TypedQuery<ejbCcoCepCecGrupoCurso> query = em.createQuery(
            "SELECT g FROM CepCecGrupoCurso g",
            ejbCcoCepCecGrupoCurso.class
        );
        return query.getResultList();
    }
    
    @Override
    public ejbCcoCepCecGrupoCurso buscarPorId(Integer id) {
        return em.find(ejbCcoCepCecGrupoCurso.class, id);
    }
}
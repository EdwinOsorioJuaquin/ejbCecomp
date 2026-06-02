package ejbCecomp.ejb.negocio;

import ejbCecomp.entidades.ejbCcoCepCecCiclo;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import java.util.List;

@Stateless
public class ejbCcoCepCecCicloService implements ejbCcoCepCecCicloServiceLocal {

    @PersistenceContext(unitName = "ejbCecompPU")
    private EntityManager em;

    @Override
    public List<ejbCcoCepCecCiclo> listarTodos() {
        TypedQuery<ejbCcoCepCecCiclo> query = em.createQuery(
            "SELECT c FROM CepCecCiclo c",
            ejbCcoCepCecCiclo.class
        );
        return query.getResultList();
    }
    
    @Override
    public ejbCcoCepCecCiclo buscarPorId(Integer id) {
        return em.find(ejbCcoCepCecCiclo.class, id);
    }
}
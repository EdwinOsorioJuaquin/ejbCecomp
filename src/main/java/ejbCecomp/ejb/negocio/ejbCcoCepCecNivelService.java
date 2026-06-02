package ejbCecomp.ejb.negocio;

import ejbCecomp.entidades.ejbCcoCepCecNivel;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import java.util.List;

@Stateless
public class ejbCcoCepCecNivelService implements ejbCcoCepCecNivelServiceLocal {

    @PersistenceContext(unitName = "ejbCecompPU")
    private EntityManager em;

    @Override
    public List<ejbCcoCepCecNivel> listarTodos() {
        TypedQuery<ejbCcoCepCecNivel> query = em.createQuery(
            "SELECT n FROM CepCecNivel n",
            ejbCcoCepCecNivel.class
        );
        return query.getResultList();
    }
    
    @Override
    public ejbCcoCepCecNivel buscarPorId(Integer id) {
        return em.find(ejbCcoCepCecNivel.class, id);
    }
}
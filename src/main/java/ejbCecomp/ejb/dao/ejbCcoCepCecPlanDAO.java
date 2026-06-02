package ejbCecomp.ejb.dao;

import ejbCecomp.entidades.ejbCcoCepCecPlan;
import jakarta.ejb.Stateless;
import jakarta.persistence.TypedQuery;
import java.util.List;

@Stateless
public class ejbCcoCepCecPlanDAO extends ejbCcoGenericoDAO<ejbCcoCepCecPlan> implements ejbCcoCepCecPlanDAOLocal {

    @Override
    public List<ejbCcoCepCecPlan> listarTodos() {
        TypedQuery<ejbCcoCepCecPlan> query = em.createQuery("SELECT p FROM CepCecPlan p", ejbCcoCepCecPlan.class);
        return query.getResultList();
    }

    @Override
    public List<ejbCcoCepCecPlan> listarActivos() {
        TypedQuery<ejbCcoCepCecPlan> query = em.createQuery("SELECT p FROM CepCecPlan p WHERE p.estadoPland = true", ejbCcoCepCecPlan.class);
        return query.getResultList();
    }

    @Override
    public ejbCcoCepCecPlan buscarPorNombre(String nombre) {
        TypedQuery<ejbCcoCepCecPlan> query = em.createQuery("SELECT p FROM CepCecPlan p WHERE p.nomPland LIKE :nombre", ejbCcoCepCecPlan.class);
        query.setParameter("nombre", "%" + nombre + "%");
        return query.getResultList().stream().findFirst().orElse(null);
    }
}
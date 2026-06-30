package ejbCecomp.ejb.dao;

import ejbCecomp.entidades.ejbCcoCepCecAulaClass;
import jakarta.ejb.Stateless;
import jakarta.persistence.TypedQuery;
import java.util.List;

@Stateless
public class ejbCcoCepCecAulaClassDAO extends ejbCcoGenericoDAO<ejbCcoCepCecAulaClass> implements ejbCcoCepCecAulaClassDAOLocal {

    @Override
    public List<ejbCcoCepCecAulaClass> listarTodos() {
        TypedQuery<ejbCcoCepCecAulaClass> query = em.createQuery(
            "SELECT a FROM CepCecAulaClass a ORDER BY a.nomAula",
            ejbCcoCepCecAulaClass.class
        );
        return query.getResultList();
    }

    @Override
    public ejbCcoCepCecAulaClass buscarPorId(Integer id) {
        try {
            return em.find(ejbCcoCepCecAulaClass.class, id);
        } catch (Exception e) {
            return null;
        }
    }
}
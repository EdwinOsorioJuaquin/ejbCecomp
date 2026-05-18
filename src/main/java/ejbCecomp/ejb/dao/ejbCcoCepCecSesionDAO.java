package ejbCecomp.ejb.dao;

import ejbCecomp.entidades.ejbCcoCepCecSesion;
import jakarta.ejb.Stateless;
import jakarta.persistence.TypedQuery;
import java.util.List;

@Stateless
public class ejbCcoCepCecSesionDAO extends ejbCcoGenericoDAO<ejbCcoCepCecSesion> implements ejbCcoCepCecSesionDAOLocal {

    @Override
    public List<ejbCcoCepCecSesion> listarPorPlan(Integer idPlan) {
        TypedQuery<ejbCcoCepCecSesion> query = em.createQuery(
            "SELECT s FROM CepCecSesion s WHERE s.ejbCcoCepCecSesionPK.idPland = :idPlan", 
            ejbCcoCepCecSesion.class);
        query.setParameter("idPlan", idPlan);
        return query.getResultList();
    }
}
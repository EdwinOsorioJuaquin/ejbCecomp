package ejbCecomp.ejb.dao;

import ejbCecomp.entidades.ejbCcoCepCecSesion;
import ejbCecomp.entidades.ejbCcoCepCurso;
import ejbCecomp.entidades.ejbCcoCepCursoDocente;
import jakarta.ejb.Stateless;
import jakarta.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class ejbCcoCepCecSesionDAO extends ejbCcoGenericoDAO<ejbCcoCepCecSesion> implements ejbCcoCepCecSesionDAOLocal {

    @Override
    public List<ejbCcoCepCecSesion> listarPorPlan(Integer idPlan) {
        TypedQuery<ejbCcoCepCecSesion> query = em.createQuery(
            "SELECT s FROM CepCecSesion s WHERE s.cepCecSesionPK.idPland = :idPlan", 
            ejbCcoCepCecSesion.class);
        query.setParameter("idPlan", idPlan);
        return query.getResultList();
    }
    
    @Override
    public List<ejbCcoCepCecSesion> listarPorCurso(Integer idCurso) {
        try {
            // Obtener el plan del curso
            ejbCcoCepCurso curso = em.find(ejbCcoCepCurso.class, idCurso);
            if (curso == null || curso.getCepCecPlan() == null) {
                return new ArrayList<>();
            }

            Integer idPlan = curso.getCepCecPlan().getIdPland();

            TypedQuery<ejbCcoCepCecSesion> query = em.createQuery(
                "SELECT s FROM CepCecSesion s WHERE s.cepCecSesionPK.idPland = :idPlan ORDER BY s.cepCecSesionPK.idSesio",
                ejbCcoCepCecSesion.class
            );
            query.setParameter("idPlan", idPlan);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Error listarPorCurso: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
package ejbCecomp.ejb.dao;

import ejbCecomp.entidades.ejbCcoCepCecNotas;
import jakarta.ejb.Stateless;
import jakarta.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class ejbCcoCepCecNotasDAO extends ejbCcoGenericoDAO<ejbCcoCepCecNotas> implements ejbCcoCepCecNotasDAOLocal {

    @Override
    public List<ejbCcoCepCecNotas> listarPorMatricula(Integer idMtaAlu) {
        try {
            TypedQuery<ejbCcoCepCecNotas> query = em.createQuery(
                "SELECT n FROM CepCecNotas n WHERE n.cepCecNotasPK.idMtaAlu = :idMtaAlu",
                ejbCcoCepCecNotas.class
            );
            query.setParameter("idMtaAlu", idMtaAlu);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Error listarPorMatricula: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
package ejbCecomp.ejb.dao;

import ejbCecomp.entidades.ejbCcoCepHorarioDia;
import jakarta.ejb.Stateless;
import jakarta.persistence.TypedQuery;
import java.util.List;

@Stateless
public class ejbCcoCepHorarioDiaDAO extends ejbCcoGenericoDAO<ejbCcoCepHorarioDia> implements ejbCcoCepHorarioDiaDAOLocal {

    @Override
    public List<ejbCcoCepHorarioDia> listarPorGrupo(Integer idAd) {
        TypedQuery<ejbCcoCepHorarioDia> query = em.createQuery(
            "SELECT h FROM CepHorarioDia h WHERE h.cepCursoDocente.idAd = :idAd",
            ejbCcoCepHorarioDia.class
        );
        query.setParameter("idAd", idAd);
        return query.getResultList();
    }

    @Override
    public void eliminar(ejbCcoCepHorarioDia horario) {
        em.remove(em.merge(horario));
    }
}
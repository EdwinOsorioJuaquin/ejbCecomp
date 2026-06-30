package ejbCecomp.ejb.dao;

import ejbCecomp.entidades.ejbCcoCepHorarioHora;
import jakarta.ejb.Stateless;
import jakarta.persistence.TypedQuery;
import java.util.List;

@Stateless
public class ejbCcoCepHorarioHoraDAO extends ejbCcoGenericoDAO<ejbCcoCepHorarioHora> implements ejbCcoCepHorarioHoraDAOLocal {

    @Override
    public List<ejbCcoCepHorarioHora> listarActivos() {
        TypedQuery<ejbCcoCepHorarioHora> query = em.createQuery(
            "SELECT h FROM CepHorarioHora h WHERE h.estado = true",
            ejbCcoCepHorarioHora.class
        );
        return query.getResultList();
    }

    @Override
    public ejbCcoCepHorarioHora buscarPorId(Integer id) {
        try {
            return em.find(ejbCcoCepHorarioHora.class, id);
        } catch (Exception e) {
            return null;
        }
    }
}
package ejbCecomp.ejb.dao;

import ejbCecomp.entidades.ejbCcoEscPersonal;
import jakarta.ejb.Stateless;
import jakarta.persistence.TypedQuery;
import java.util.List;

@Stateless
public class ejbCcoEscPersonalDAO extends ejbCcoGenericoDAO<ejbCcoEscPersonal> implements ejbCcoEscPersonalDAOLocal {

    @Override
    public List<ejbCcoEscPersonal> listarTodos() {
        TypedQuery<ejbCcoEscPersonal> query = em.createQuery(
            "SELECT e FROM EscPersonal e JOIN FETCH e.drtPersonanatural",
            ejbCcoEscPersonal.class
        );
        return query.getResultList();
    }
    
    @Override
    public List<ejbCcoEscPersonal> listarActivos() {
        TypedQuery<ejbCcoEscPersonal> query = em.createQuery(
            "SELECT e FROM EscPersonal e JOIN FETCH e.drtPersonanatural WHERE e.condicion = 1",
            ejbCcoEscPersonal.class
        );
        return query.getResultList();
    }
}
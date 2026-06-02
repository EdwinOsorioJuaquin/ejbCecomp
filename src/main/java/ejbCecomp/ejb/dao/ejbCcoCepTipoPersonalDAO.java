package ejbCecomp.ejb.dao;

import ejbCecomp.entidades.ejbCcoCepTipoPersonal;
import jakarta.ejb.Stateless;
import jakarta.persistence.TypedQuery;
import java.util.List;

@Stateless
public class ejbCcoCepTipoPersonalDAO extends ejbCcoGenericoDAO<ejbCcoCepTipoPersonal> implements ejbCcoCepTipoPersonalDAOLocal {

    @Override
    public List<ejbCcoCepTipoPersonal> listarActivos() {
        TypedQuery<ejbCcoCepTipoPersonal> query = em.createQuery(
            "SELECT t FROM CepTipoPersonal t WHERE t.activo = true",
            ejbCcoCepTipoPersonal.class
        );
        return query.getResultList();
    }
    
    @Override
    public ejbCcoCepTipoPersonal buscarPorId(Short id) {
        return em.find(ejbCcoCepTipoPersonal.class, id);
    }
}
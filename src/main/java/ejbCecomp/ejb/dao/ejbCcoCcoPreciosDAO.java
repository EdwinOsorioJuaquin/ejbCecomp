
package ejbCecomp.ejb.dao;

import ejbCecomp.entidades.ejbCcoCcoPrecios;
import jakarta.ejb.Stateless;
import jakarta.persistence.TypedQuery;
import java.util.List;

/**
 *
 * @author Jael
 */
@Stateless
public class ejbCcoCcoPreciosDAO extends ejbCcoGenericoDAO<ejbCcoCcoPrecios> implements ejbCcoCcoPreciosDAOLocal {

    @Override
    public List<ejbCcoCcoPrecios> listarTodos() {
        TypedQuery<ejbCcoCcoPrecios> query =
            em.createQuery("SELECT c FROM CepPrecios c", ejbCcoCcoPrecios.class);

        return query.getResultList();
    }

    @Override
    public List<ejbCcoCcoPrecios> buscarPorConcepto(String concepto) {
        TypedQuery<ejbCcoCcoPrecios> query =
            em.createQuery(
                "SELECT c FROM CepPrecios c WHERE c.concepto LIKE :concepto",
                ejbCcoCcoPrecios.class
            );

        query.setParameter("concepto", "%" + concepto + "%");

        return query.getResultList();
    }

}

package ejbCecomp.ejb.dao;

import ejbCecomp.entidades.ejbCcoCepCecTema;
import jakarta.ejb.Stateless;
import jakarta.persistence.TypedQuery;
import java.util.List;

@Stateless
public class ejbCcoCepCecTemaDAO extends ejbCcoGenericoDAO<ejbCcoCepCecTema> implements ejbCcoCepCecTemaDAOLocal {

    @Override
    public List<ejbCcoCepCecTema> listarPorSesion(Integer idPland, Integer idSesio) {
        TypedQuery<ejbCcoCepCecTema> query = em.createQuery(
            "SELECT t FROM CepCecTema t WHERE t.ejbCcoCepCecTemaPK.idPland = :idPland AND t.ejbCcoCepCecTemaPK.idSesio = :idSesio", 
            ejbCcoCepCecTema.class);
        query.setParameter("idPland", idPland);
        query.setParameter("idSesio", idSesio);
        return query.getResultList();
    }
    
    @Override
    public List<ejbCcoCepCecTema> listarTodos() {
        TypedQuery<ejbCcoCepCecTema> query = em.createQuery("SELECT t FROM CepCecTema t", ejbCcoCepCecTema.class);
        return query.getResultList();
    }
}
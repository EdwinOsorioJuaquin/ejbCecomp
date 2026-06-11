package ejbCecomp.ejb.dao;

import ejbCecomp.entidades.ejbCcoCepCecTipoDesarrollo;
import jakarta.ejb.Stateless;
import jakarta.persistence.TypedQuery;
import java.util.List;

@Stateless
public class ejbCcoCepCecTipoDesarrolloDAO extends ejbCcoGenericoDAO<ejbCcoCepCecTipoDesarrollo> implements ejbCcoCepCecTipoDesarrolloDAOLocal {

    @Override
    public List<ejbCcoCepCecTipoDesarrollo> listarTodos() {
        TypedQuery<ejbCcoCepCecTipoDesarrollo> query = em.createQuery(
            "SELECT t FROM CepCecTipoDesarrollo t ORDER BY t.idCiclo",
            ejbCcoCepCecTipoDesarrollo.class
        );
        return query.getResultList();
    }

    @Override
    public ejbCcoCepCecTipoDesarrollo buscarPorId(Integer idCiclo) {
        try {
            return em.find(ejbCcoCepCecTipoDesarrollo.class, idCiclo);
        } catch (Exception e) {
            System.out.println("Error buscarPorId TipoDesarrollo: " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<ejbCcoCepCecTipoDesarrollo> listarActivos() {
        // Todos son activos por ahora, se puede ajustar si hay campo activo
        return listarTodos();
    }
}
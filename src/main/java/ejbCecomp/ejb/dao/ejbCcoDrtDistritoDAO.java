package ejbCecomp.ejb.dao;

import ejbCecomp.entidades.ejbCcoDrtDistrito;
import jakarta.ejb.Stateless;
import jakarta.persistence.TypedQuery;
import java.util.List;

@Stateless
public class ejbCcoDrtDistritoDAO extends ejbCcoGenericoDAO<ejbCcoDrtDistrito> implements ejbCcoDrtDistritoDAOLocal {

    @Override
    public List<ejbCcoDrtDistrito> listarTodos() {
        TypedQuery<ejbCcoDrtDistrito> query = em.createQuery(
            "SELECT d FROM DrtDistrito d ORDER BY d.nombreDist",
            ejbCcoDrtDistrito.class
        );
        return query.getResultList();
    }

    @Override
    public ejbCcoDrtDistrito buscarPorIdUbg(Integer idUbg) {
        try {
            TypedQuery<ejbCcoDrtDistrito> query = em.createQuery(
                "SELECT d FROM DrtDistrito d WHERE d.idUbg = :idUbg",
                ejbCcoDrtDistrito.class
            );
            query.setParameter("idUbg", idUbg);
            List<ejbCcoDrtDistrito> result = query.getResultList();
            return result.isEmpty() ? null : result.get(0);
        } catch (Exception e) {
            System.out.println("Error buscarPorIdUbg: " + e.getMessage());
            return null;
        }
    }

    @Override
    public ejbCcoDrtDistrito buscarPorId(Integer idPais, Integer idDpto, Integer idProv, Integer idDistrito) {
        try {
            TypedQuery<ejbCcoDrtDistrito> query = em.createQuery(
                "SELECT d FROM DrtDistrito d WHERE d.idPais = :idPais AND d.idDpto = :idDpto AND d.idProv = :idProv AND d.idDistrito = :idDistrito",
                ejbCcoDrtDistrito.class
            );
            query.setParameter("idPais", idPais);
            query.setParameter("idDpto", idDpto);
            query.setParameter("idProv", idProv);
            query.setParameter("idDistrito", idDistrito);
            List<ejbCcoDrtDistrito> result = query.getResultList();
            return result.isEmpty() ? null : result.get(0);
        } catch (Exception e) {
            System.out.println("Error buscarPorId: " + e.getMessage());
            return null;
        }
    }
}
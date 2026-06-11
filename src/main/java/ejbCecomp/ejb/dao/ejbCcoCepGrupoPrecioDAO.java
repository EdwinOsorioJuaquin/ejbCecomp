package ejbCecomp.ejb.dao;

import ejbCecomp.entidades.ejbCcoCepGrupoPrecio;
import jakarta.ejb.Stateless;
import jakarta.persistence.TypedQuery;
import java.util.List;

@Stateless
public class ejbCcoCepGrupoPrecioDAO extends ejbCcoGenericoDAO<ejbCcoCepGrupoPrecio> implements ejbCcoCepGrupoPrecioDAOLocal {

    @Override
    public List<ejbCcoCepGrupoPrecio> listarTodos() {
        TypedQuery<ejbCcoCepGrupoPrecio> query = em.createQuery(
            "SELECT p FROM CepGrupoPrecio p ORDER BY p.idGrupoPrecio DESC",
            ejbCcoCepGrupoPrecio.class
        );
        return query.getResultList();
    }

    @Override
    public List<ejbCcoCepGrupoPrecio> listarPorGrupo(Integer idAd) {
        TypedQuery<ejbCcoCepGrupoPrecio> query = em.createQuery(
            "SELECT p FROM CepGrupoPrecio p WHERE p.idAd = :idAd ORDER BY p.idGrupoPrecio DESC",
            ejbCcoCepGrupoPrecio.class
        );
        query.setParameter("idAd", idAd);
        return query.getResultList();
    }

    @Override
    public List<ejbCcoCepGrupoPrecio> listarPorGrupoActivos(Integer idAd) {
        TypedQuery<ejbCcoCepGrupoPrecio> query = em.createQuery(
            "SELECT p FROM CepGrupoPrecio p WHERE p.idAd = :idAd AND p.activo = 1",
            ejbCcoCepGrupoPrecio.class
        );
        query.setParameter("idAd", idAd);
        return query.getResultList();
    }

    @Override
    public ejbCcoCepGrupoPrecio buscarPorGrupoYTipo(Integer idAd, String tipoAlumno) {
        try {
            TypedQuery<ejbCcoCepGrupoPrecio> query = em.createQuery(
                "SELECT p FROM CepGrupoPrecio p WHERE p.idAd = :idAd AND p.tipoAlumno = :tipoAlumno AND p.activo = 1",
                ejbCcoCepGrupoPrecio.class
            );
            query.setParameter("idAd", idAd);
            query.setParameter("tipoAlumno", tipoAlumno);
            List<ejbCcoCepGrupoPrecio> result = query.getResultList();
            return result.isEmpty() ? null : result.get(0);
        } catch (Exception e) {
            System.out.println("Error buscarPorGrupoYTipo: " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<ejbCcoCepGrupoPrecio> listarActivos() {
        TypedQuery<ejbCcoCepGrupoPrecio> query = em.createQuery(
            "SELECT p FROM CepGrupoPrecio p WHERE p.activo = 1 ORDER BY p.idGrupoPrecio DESC",
            ejbCcoCepGrupoPrecio.class
        );
        return query.getResultList();
    }

    @Override
    public ejbCcoCepGrupoPrecio crear(ejbCcoCepGrupoPrecio precio) {
        em.persist(precio);
        return precio;
    }

    @Override
    public ejbCcoCepGrupoPrecio actualizar(ejbCcoCepGrupoPrecio precio) {
        return em.merge(precio);
    }
}
package ejbCecomp.ejb.dao;

import ejbCecomp.entidades.ejbCcoCepServicioPrecio;
import jakarta.ejb.Stateless;
import jakarta.persistence.TypedQuery;
import java.util.List;

@Stateless
public class ejbCcoCepServicioPrecioDAO extends ejbCcoGenericoDAO<ejbCcoCepServicioPrecio> implements ejbCcoCepServicioPrecioDAOLocal {

    @Override
    public List<ejbCcoCepServicioPrecio> listarTodos() {
        TypedQuery<ejbCcoCepServicioPrecio> query = em.createQuery(
            "SELECT s FROM CepServicioPrecio s ORDER BY s.tipoServicio, s.tipoAlumno",
            ejbCcoCepServicioPrecio.class
        );
        return query.getResultList();
    }

    @Override
    public List<ejbCcoCepServicioPrecio> listarPorTipoAlumno(String tipoAlumno) {
        TypedQuery<ejbCcoCepServicioPrecio> query = em.createQuery(
            "SELECT s FROM CepServicioPrecio s WHERE s.tipoAlumno = :tipoAlumno AND (s.activo = 1 OR s.activo IS NULL)",
            ejbCcoCepServicioPrecio.class
        );
        query.setParameter("tipoAlumno", tipoAlumno);
        return query.getResultList();
    }

    @Override
    public ejbCcoCepServicioPrecio buscarPorTipo(String tipoServicio, String tipoAlumno) {
        try {
            TypedQuery<ejbCcoCepServicioPrecio> query = em.createQuery(
                "SELECT s FROM CepServicioPrecio s WHERE s.tipoServicio = :tipoServicio AND s.tipoAlumno = :tipoAlumno AND (s.activo = 1 OR s.activo IS NULL)",
                ejbCcoCepServicioPrecio.class
            );
            query.setParameter("tipoServicio", tipoServicio);
            query.setParameter("tipoAlumno", tipoAlumno);
            List<ejbCcoCepServicioPrecio> result = query.getResultList();
            return result.isEmpty() ? null : result.get(0);
        } catch (Exception e) {
            System.out.println("Error buscarPorTipo: " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<ejbCcoCepServicioPrecio> listarActivos() {
        TypedQuery<ejbCcoCepServicioPrecio> query = em.createQuery(
            "SELECT s FROM CepServicioPrecio s WHERE s.activo = 1 OR s.activo IS NULL",
            ejbCcoCepServicioPrecio.class
        );
        return query.getResultList();
    }
}
package ejbCecomp.ejb.dao;

import ejbCecomp.entidades.ejbCcoVwCecompPagos;
import jakarta.ejb.Stateless;
import jakarta.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

@Stateless
public class ejbCcoVwCecompPagosDAO extends ejbCcoGenericoDAO<ejbCcoVwCecompPagos> implements ejbCcoVwCecompPagosDAOLocal {

    @Override
    public List<ejbCcoVwCecompPagos> listarTodos() {
        TypedQuery<ejbCcoVwCecompPagos> query = em.createQuery(
            "SELECT v FROM VwCecompPagos v ORDER BY v.fechaPago DESC",
            ejbCcoVwCecompPagos.class
        );
        return query.getResultList();
    }
    
    @Override
    public List<ejbCcoVwCecompPagos> buscarPorFiltros(String nombre, Date fechaInicio, Date fechaFin, 
                                                       Integer montoMin, Integer montoMax) {
        StringBuilder jpql = new StringBuilder("SELECT v FROM VwCecompPagos v WHERE 1=1");
        
        if (nombre != null && !nombre.trim().isEmpty()) {
            jpql.append(" AND (UPPER(v.estudiante) LIKE :nombre)");
        }
        if (fechaInicio != null) {
            jpql.append(" AND v.fechaPagoCecomp >= :fechaInicio");
        }
        if (fechaFin != null) {
            jpql.append(" AND v.fechaPagoCecomp <= :fechaFin");
        }
        if (montoMin != null) {
            jpql.append(" AND v.monto >= :montoMin");
        }
        if (montoMax != null) {
            jpql.append(" AND v.monto <= :montoMax");
        }
        
        jpql.append(" ORDER BY v.fechaPago DESC");
        
        TypedQuery<ejbCcoVwCecompPagos> query = em.createQuery(jpql.toString(), ejbCcoVwCecompPagos.class);
        
        if (nombre != null && !nombre.trim().isEmpty()) {
            query.setParameter("nombre", "%" + nombre.toUpperCase() + "%");
        }
        if (fechaInicio != null) {
            query.setParameter("fechaInicio", fechaInicio);
        }
        if (fechaFin != null) {
            query.setParameter("fechaFin", fechaFin);
        }
        if (montoMin != null) {
            query.setParameter("montoMin", montoMin);
        }
        if (montoMax != null) {
            query.setParameter("montoMax", montoMax);
        }
        
        return query.getResultList();
    }
    
    @Override
    public Long sumarMontosPorFiltros(String nombre, Date fechaInicio, Date fechaFin,
                                       Integer montoMin, Integer montoMax) {
        StringBuilder jpql = new StringBuilder("SELECT COALESCE(SUM(v.monto), 0) FROM VwCecompPagos v WHERE 1=1");
        
        if (nombre != null && !nombre.trim().isEmpty()) {
            jpql.append(" AND (UPPER(v.estudiante) LIKE :nombre)");
        }
        if (fechaInicio != null) {
            jpql.append(" AND v.fechaPagoCecomp >= :fechaInicio");
        }
        if (fechaFin != null) {
            jpql.append(" AND v.fechaPagoCecomp <= :fechaFin");
        }
        if (montoMin != null) {
            jpql.append(" AND v.monto >= :montoMin");
        }
        if (montoMax != null) {
            jpql.append(" AND v.monto <= :montoMax");
        }
        
        TypedQuery<Long> query = em.createQuery(jpql.toString(), Long.class);
        
        if (nombre != null && !nombre.trim().isEmpty()) {
            query.setParameter("nombre", "%" + nombre.toUpperCase() + "%");
        }
        if (fechaInicio != null) {
            query.setParameter("fechaInicio", fechaInicio);
        }
        if (fechaFin != null) {
            query.setParameter("fechaFin", fechaFin);
        }
        if (montoMin != null) {
            query.setParameter("montoMin", montoMin);
        }
        if (montoMax != null) {
            query.setParameter("montoMax", montoMax);
        }
        
        return query.getSingleResult();
    }
}
package ejbCecomp.ejb.dao;

import ejbCecomp.entidades.ejbCcoVtCecompPagos;
import jakarta.ejb.Stateless;
import jakarta.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Stateless
public class ejbCcoVtCecompPagosDAO extends ejbCcoGenericoDAO<ejbCcoVtCecompPagos> implements ejbCcoVtCecompPagosDAOLocal {

    @Override
    public List<ejbCcoVtCecompPagos> listarTodos() {
        TypedQuery<ejbCcoVtCecompPagos> query = em.createQuery("SELECT v FROM VtCecompPagos v ORDER BY v.fechaPago DESC",
            ejbCcoVtCecompPagos.class
        );
        return query.getResultList();
    }
    
    @Override
    public List<ejbCcoVtCecompPagos> buscarPorFiltros(String nombre, Date fechaInicio, Date fechaFin, 
                                                       Integer montoMin, Integer montoMax) {
        StringBuilder jpql = new StringBuilder("SELECT v FROM VtCecompPagos v WHERE 1=1");
        
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
        
        TypedQuery<ejbCcoVtCecompPagos> query = em.createQuery(jpql.toString(), ejbCcoVtCecompPagos.class);
        
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
        StringBuilder jpql = new StringBuilder("SELECT COALESCE(SUM(v.monto), 0) FROM VtCecompPagos v WHERE 1=1");
        
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
    
    @Override
    public List<ejbCcoVtCecompPagos> listarPagosNoUtilizadosPorAlumno(String dni) {
        try {
            TypedQuery<ejbCcoVtCecompPagos> query = em.createQuery(
                "SELECT p FROM VtCecompPagos p " +
                "WHERE p.dni = :dni " +
                "AND p.estadoVoucher = '1' " +
                "ORDER BY p.fechaPago DESC",
                ejbCcoVtCecompPagos.class
            );
            query.setParameter("dni", dni);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Error listarPagosNoUtilizadosPorAlumno: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
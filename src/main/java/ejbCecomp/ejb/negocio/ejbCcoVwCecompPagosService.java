package ejbCecomp.ejb.negocio;

import ejbCecomp.entidades.ejbCcoVtCecompPagos;
import jakarta.annotation.Resource;
import jakarta.ejb.Stateless;
import jakarta.ejb.TransactionManagement;
import jakarta.ejb.TransactionManagementType;
import jakarta.inject.Inject;
import jakarta.transaction.UserTransaction;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ejbCecomp.ejb.dao.ejbCcoVtCecompPagosDAOLocal;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class ejbCcoVwCecompPagosService implements ejbCcoVwCecompPagosServiceLocal {

    @Resource
    private UserTransaction ut;

    @Inject
    private ejbCcoVtCecompPagosDAOLocal dao;

    @Override
    public List<ejbCcoVtCecompPagos> listarTodos() {
        try {
            ut.begin();
            List<ejbCcoVtCecompPagos> lista = dao.listarTodos();
            ut.commit();
            return lista;
        } catch (Exception e) {
            try {
                ut.rollback();
            } catch (Exception ex) {
                Logger.getLogger(ejbCcoVwCecompPagosService.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        }
    }

    @Override
    public List<ejbCcoVtCecompPagos> buscarPorFiltros(String nombre, Date fechaInicio, Date fechaFin,
                                                       Integer montoMin, Integer montoMax) {
        try {
            ut.begin();
            List<ejbCcoVtCecompPagos> lista = dao.buscarPorFiltros(nombre, fechaInicio, fechaFin, montoMin, montoMax);
            ut.commit();
            return lista;
        } catch (Exception e) {
            try {
                ut.rollback();
            } catch (Exception ex) {
                Logger.getLogger(ejbCcoVwCecompPagosService.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        }
    }

    @Override
    public Long sumarMontosPorFiltros(String nombre, Date fechaInicio, Date fechaFin,
                                       Integer montoMin, Integer montoMax) {
        try {
            ut.begin();
            Long total = dao.sumarMontosPorFiltros(nombre, fechaInicio, fechaFin, montoMin, montoMax);
            ut.commit();
            return total;
        } catch (Exception e) {
            try {
                ut.rollback();
            } catch (Exception ex) {
                Logger.getLogger(ejbCcoVwCecompPagosService.class.getName()).log(Level.SEVERE, null, ex);
            }
            return 0L;
        }
    }

    @Override
    public List<ejbCcoVtCecompPagos> listarPagosNoUtilizadosPorAlumno(String dni) {
        try {
            ut.begin();
            List<ejbCcoVtCecompPagos> lista = dao.listarPagosNoUtilizadosPorAlumno(dni);
            ut.commit();
            return lista;
        } catch (Exception e) {
            try {
                ut.rollback();
            } catch (Exception ex) {
                Logger.getLogger(ejbCcoVwCecompPagosService.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        }
    }
}
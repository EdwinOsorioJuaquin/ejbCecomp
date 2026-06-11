package ejbCecomp.ejb.dao;

import ejbCecomp.entidades.ejbCcoVtCecompPagos;
import jakarta.ejb.Local;
import java.util.Date;
import java.util.List;

@Local
public interface ejbCcoVtCecompPagosDAOLocal extends ejbCcoGenericoDAOLocal<ejbCcoVtCecompPagos> {
    List<ejbCcoVtCecompPagos> listarTodos();
    List<ejbCcoVtCecompPagos> buscarPorFiltros(String nombre, Date fechaInicio, Date fechaFin, Integer montoMin, Integer montoMax);
    Long sumarMontosPorFiltros(String nombre, Date fechaInicio, Date fechaFin, Integer montoMin, Integer montoMax);
    List<ejbCcoVtCecompPagos> listarPagosNoUtilizadosPorAlumno(String dni);
}
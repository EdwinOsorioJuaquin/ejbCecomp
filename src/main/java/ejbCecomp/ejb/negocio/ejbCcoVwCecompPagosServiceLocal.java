package ejbCecomp.ejb.negocio;

import ejbCecomp.entidades.ejbCcoVwCecompPagos;
import jakarta.ejb.Local;
import java.util.Date;
import java.util.List;

@Local
public interface ejbCcoVwCecompPagosServiceLocal {
    List<ejbCcoVwCecompPagos> listarTodos();
    List<ejbCcoVwCecompPagos> buscarPorFiltros(String nombre, Date fechaInicio, Date fechaFin, Integer montoMin, Integer montoMax);
    Long sumarMontosPorFiltros(String nombre, Date fechaInicio, Date fechaFin, Integer montoMin, Integer montoMax);
}
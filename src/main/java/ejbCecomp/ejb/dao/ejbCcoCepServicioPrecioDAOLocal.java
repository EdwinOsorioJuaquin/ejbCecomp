package ejbCecomp.ejb.dao;

import ejbCecomp.entidades.ejbCcoCepServicioPrecio;
import jakarta.ejb.Local;
import java.util.List;

@Local
public interface ejbCcoCepServicioPrecioDAOLocal extends ejbCcoGenericoDAOLocal<ejbCcoCepServicioPrecio> {
    List<ejbCcoCepServicioPrecio> listarTodos();
    List<ejbCcoCepServicioPrecio> listarPorTipoAlumno(String tipoAlumno);
    ejbCcoCepServicioPrecio buscarPorTipo(String tipoServicio, String tipoAlumno);
    List<ejbCcoCepServicioPrecio> listarActivos();
}
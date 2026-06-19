package ejbCecomp.ejb.negocio;

import ejbCecomp.entidades.ejbCcoCepServicioPrecio;
import jakarta.ejb.Local;
import java.util.List;

@Local
public interface ejbCcoCepServicioPrecioServiceLocal {
    List<ejbCcoCepServicioPrecio> listarTodos();
    List<ejbCcoCepServicioPrecio> listarPorTipoAlumno(String tipoAlumno);
    ejbCcoCepServicioPrecio buscarPorTipo(String tipoServicio, String tipoAlumno);
    List<ejbCcoCepServicioPrecio> listarActivos();
    ejbCcoCepServicioPrecio crear(ejbCcoCepServicioPrecio precio);
    ejbCcoCepServicioPrecio actualizar(ejbCcoCepServicioPrecio precio);
    ejbCcoCepServicioPrecio buscarPorId(Integer id);
}
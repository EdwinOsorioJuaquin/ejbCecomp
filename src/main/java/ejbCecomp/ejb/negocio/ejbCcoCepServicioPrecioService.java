package ejbCecomp.ejb.negocio;

import ejbCecomp.ejb.dao.ejbCcoCepServicioPrecioDAOLocal;
import ejbCecomp.entidades.ejbCcoCepServicioPrecio;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.util.List;

@Stateless
public class ejbCcoCepServicioPrecioService implements ejbCcoCepServicioPrecioServiceLocal {

    @Inject
    private ejbCcoCepServicioPrecioDAOLocal dao;

    @Override
    public List<ejbCcoCepServicioPrecio> listarTodos() {
        return dao.listarTodos();
    }

    @Override
    public List<ejbCcoCepServicioPrecio> listarPorTipoAlumno(String tipoAlumno) {
        return dao.listarPorTipoAlumno(tipoAlumno);
    }

    @Override
    public ejbCcoCepServicioPrecio buscarPorTipo(String tipoServicio, String tipoAlumno) {
        return dao.buscarPorTipo(tipoServicio, tipoAlumno);
    }

    @Override
    public List<ejbCcoCepServicioPrecio> listarActivos() {
        return dao.listarActivos();
    }
}
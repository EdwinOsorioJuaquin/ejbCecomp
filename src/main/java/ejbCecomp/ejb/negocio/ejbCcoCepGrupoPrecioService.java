package ejbCecomp.ejb.negocio;

import ejbCecomp.ejb.dao.ejbCcoCepGrupoPrecioDAOLocal;
import ejbCecomp.entidades.ejbCcoCepGrupoPrecio;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import java.util.List;

@Stateless
public class ejbCcoCepGrupoPrecioService implements ejbCcoCepGrupoPrecioServiceLocal {

    @EJB
    private ejbCcoCepGrupoPrecioDAOLocal dao;

    @Override
    public List<ejbCcoCepGrupoPrecio> listarTodos() {
        return dao.listarTodos();
    }

    @Override
    public List<ejbCcoCepGrupoPrecio> listarPorGrupo(Integer idAd) {
        return dao.listarPorGrupo(idAd);
    }

    @Override
    public List<ejbCcoCepGrupoPrecio> listarPorGrupoActivos(Integer idAd) {
        return dao.listarPorGrupoActivos(idAd);
    }

    @Override
    public ejbCcoCepGrupoPrecio buscarPorGrupoYTipo(Integer idAd, String tipoAlumno) {
        return dao.buscarPorGrupoYTipo(idAd, tipoAlumno);
    }

    @Override
    public List<ejbCcoCepGrupoPrecio> listarActivos() {
        return dao.listarActivos();
    }

    @Override
    public ejbCcoCepGrupoPrecio crear(ejbCcoCepGrupoPrecio precio) {
        return dao.crear(precio);
    }

    @Override
    public ejbCcoCepGrupoPrecio actualizar(ejbCcoCepGrupoPrecio precio) {
        return dao.actualizar(precio);
    }
}
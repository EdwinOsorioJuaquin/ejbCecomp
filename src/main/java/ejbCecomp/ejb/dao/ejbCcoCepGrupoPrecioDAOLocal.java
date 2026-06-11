package ejbCecomp.ejb.dao;

import ejbCecomp.entidades.ejbCcoCepGrupoPrecio;
import jakarta.ejb.Local;
import java.util.List;

@Local
public interface ejbCcoCepGrupoPrecioDAOLocal extends ejbCcoGenericoDAOLocal<ejbCcoCepGrupoPrecio> {
    List<ejbCcoCepGrupoPrecio> listarTodos();
    List<ejbCcoCepGrupoPrecio> listarPorGrupo(Integer idAd);
    List<ejbCcoCepGrupoPrecio> listarPorGrupoActivos(Integer idAd);
    ejbCcoCepGrupoPrecio buscarPorGrupoYTipo(Integer idAd, String tipoAlumno);
    List<ejbCcoCepGrupoPrecio> listarActivos();
    ejbCcoCepGrupoPrecio crear(ejbCcoCepGrupoPrecio precio);
    ejbCcoCepGrupoPrecio actualizar(ejbCcoCepGrupoPrecio precio);
}
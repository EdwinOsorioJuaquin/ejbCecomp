package ejbCecomp.ejb.dao;

import ejbCecomp.entidades.ejbCcoCepCursoDocente;
import jakarta.ejb.Local;
import java.util.List;

@Local
public interface ejbCcoCepCursoDocenteDAOLocal extends ejbCcoGenericoDAOLocal<ejbCcoCepCursoDocente> {
    List<ejbCcoCepCursoDocente> listarTodos();
    List<ejbCcoCepCursoDocente> listarActivos();
    List<ejbCcoCepCursoDocente> listarConPrecios();
    ejbCcoCepCursoDocente buscarPorId(Integer id);
    List<ejbCcoCepCursoDocente> buscarPorCurso(Integer idCurso);
    Integer obtenerUltimoIdGrupo();
    ejbCcoCepCursoDocente guardarGrupo(ejbCcoCepCursoDocente grupo);
    ejbCcoCepCursoDocente actualizarGrupo(ejbCcoCepCursoDocente grupo);
    List<ejbCcoCepCursoDocente> listarGruposPorCodigoPago(String codigoPago);
}
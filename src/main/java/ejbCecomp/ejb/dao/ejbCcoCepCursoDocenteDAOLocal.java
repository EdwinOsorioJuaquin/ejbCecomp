package ejbCecomp.ejb.dao;

import ejbCecomp.entidades.ejbCcoCepCursoDocente;
import jakarta.ejb.Local;
import java.util.List;

@Local
public interface ejbCcoCepCursoDocenteDAOLocal extends ejbCcoGenericoDAOLocal<ejbCcoCepCursoDocente> {
    List<ejbCcoCepCursoDocente> listarTodos();
    List<ejbCcoCepCursoDocente> listarActivos();
    ejbCcoCepCursoDocente buscarPorId(Integer id);
    Integer obtenerUltimoIdGrupo();
    ejbCcoCepCursoDocente guardarGrupo(ejbCcoCepCursoDocente grupo);
    ejbCcoCepCursoDocente actualizarGrupo(ejbCcoCepCursoDocente grupo);
}
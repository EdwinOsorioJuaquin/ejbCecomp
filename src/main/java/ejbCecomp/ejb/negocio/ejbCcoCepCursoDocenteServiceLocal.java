package ejbCecomp.ejb.negocio;

import ejbCecomp.entidades.ejbCcoCepCursoDocente;
import jakarta.ejb.Local;
import java.util.List;

@Local
public interface ejbCcoCepCursoDocenteServiceLocal {
    ejbCcoCepCursoDocente crear(ejbCcoCepCursoDocente grupo);
    ejbCcoCepCursoDocente actualizar(ejbCcoCepCursoDocente grupo);
    ejbCcoCepCursoDocente buscarPorId(Integer id);
    List<ejbCcoCepCursoDocente> listarTodos();
    List<ejbCcoCepCursoDocente> listarActivos();
    Integer obtenerUltimoIdGrupo();
}
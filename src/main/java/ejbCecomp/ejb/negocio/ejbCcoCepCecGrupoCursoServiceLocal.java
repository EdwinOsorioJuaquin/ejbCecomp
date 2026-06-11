package ejbCecomp.ejb.negocio;

import ejbCecomp.entidades.ejbCcoCepCecGrupoCurso;
import jakarta.ejb.Local;
import java.util.List;

@Local
public interface ejbCcoCepCecGrupoCursoServiceLocal {
    List<ejbCcoCepCecGrupoCurso> listarTodos();
    List<ejbCcoCepCecGrupoCurso> listarActivos();
    ejbCcoCepCecGrupoCurso buscarPorId(Integer idGrupo);
}
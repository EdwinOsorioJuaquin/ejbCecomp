package ejbCecomp.ejb.dao;

import ejbCecomp.entidades.ejbCcoCepCecGrupoCurso;
import jakarta.ejb.Local;
import java.util.List;

@Local
public interface ejbCcoCepCecGrupoCursoDAOLocal extends ejbCcoGenericoDAOLocal<ejbCcoCepCecGrupoCurso> {
    List<ejbCcoCepCecGrupoCurso> listarTodos();
    List<ejbCcoCepCecGrupoCurso> listarActivos();
    ejbCcoCepCecGrupoCurso buscarPorId(Integer idGrupo);
}
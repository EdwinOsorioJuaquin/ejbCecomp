package ejbCecomp.ejb.negocio;

import ejbCecomp.clases.ejbCcoMatriculaDTO;
import ejbCecomp.entidades.ejbCcoCepCcoMatriculaCab;
import jakarta.ejb.Local;
import java.util.List;

@Local
public interface ejbCcoCepCcoMatriculaCabServiceLocal {
    ejbCcoCepCcoMatriculaCab crear(ejbCcoCepCcoMatriculaCab matricula);
    ejbCcoCepCcoMatriculaCab actualizar(ejbCcoCepCcoMatriculaCab matricula);
    ejbCcoCepCcoMatriculaCab buscarPorId(Integer id);
    List<ejbCcoCepCcoMatriculaCab> listarTodos();
    List<ejbCcoCepCcoMatriculaCab> listarPorGrupo(Integer idAd);
    List<ejbCcoCepCcoMatriculaCab> listarPorAlumno(Integer idDir);
    List<ejbCcoCepCcoMatriculaCab> listarActivos();
    List<ejbCcoMatriculaDTO> listarMatriculasDTO();
    List<ejbCcoMatriculaDTO> listarMatriculasPorGrupoDTO(Integer idAd);
    Integer obtenerUltimoIdMatricula();
}
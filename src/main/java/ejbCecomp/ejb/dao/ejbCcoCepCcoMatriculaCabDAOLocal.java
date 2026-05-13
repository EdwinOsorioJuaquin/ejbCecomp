package ejbCecomp.ejb.dao;

import ejbCecomp.entidades.ejbCcoCepCcoMatriculaCab;
import jakarta.ejb.Local;
import java.util.List;

@Local
public interface ejbCcoCepCcoMatriculaCabDAOLocal extends ejbCcoGenericoDAOLocal<ejbCcoCepCcoMatriculaCab> {
    List<ejbCcoCepCcoMatriculaCab> listarTodos();
    List<ejbCcoCepCcoMatriculaCab> listarPorGrupo(Integer idAd);
    List<ejbCcoCepCcoMatriculaCab> listarPorAlumno(Integer idDir);
    List<ejbCcoCepCcoMatriculaCab> listarActivos();
    ejbCcoCepCcoMatriculaCab buscarPorId(Integer id);
    Integer obtenerUltimoIdMatricula();
    ejbCcoCepCcoMatriculaCab guardarMatricula(ejbCcoCepCcoMatriculaCab matricula);
    ejbCcoCepCcoMatriculaCab actualizarMatricula(ejbCcoCepCcoMatriculaCab matricula);
}
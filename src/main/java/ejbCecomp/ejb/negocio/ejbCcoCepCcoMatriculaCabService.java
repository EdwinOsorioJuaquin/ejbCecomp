package ejbCecomp.ejb.negocio;

import ejbCecomp.clases.ejbCcoMatriculaDTO;
import ejbCecomp.ejb.dao.ejbCcoCepCcoMatriculaCabDAOLocal;
import ejbCecomp.entidades.ejbCcoCepCcoMatriculaCab;
import jakarta.annotation.Resource;
import jakarta.ejb.Stateless;
import jakarta.ejb.TransactionManagement;
import jakarta.ejb.TransactionManagementType;
import jakarta.inject.Inject;
import jakarta.transaction.UserTransaction;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class ejbCcoCepCcoMatriculaCabService implements ejbCcoCepCcoMatriculaCabServiceLocal {

    @Resource
    private UserTransaction ut;

    @Inject
    private ejbCcoCepCcoMatriculaCabDAOLocal dao;

    @Override
    public ejbCcoCepCcoMatriculaCab crear(ejbCcoCepCcoMatriculaCab matricula) {
        try {
            ut.begin();
            matricula = dao.guardarMatricula(matricula);
            ut.commit();
            return matricula;
        } catch (Exception e) {
            try {
                ut.rollback();
            } catch (Exception ex) {
                Logger.getLogger(ejbCcoCepCcoMatriculaCabService.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        }
    }

    @Override
    public ejbCcoCepCcoMatriculaCab actualizar(ejbCcoCepCcoMatriculaCab matricula) {
        try {
            ut.begin();
            matricula = dao.actualizarMatricula(matricula);
            ut.commit();
            return matricula;
        } catch (Exception e) {
            try {
                ut.rollback();
            } catch (Exception ex) {
                Logger.getLogger(ejbCcoCepCcoMatriculaCabService.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        }
    }

    @Override
    public ejbCcoCepCcoMatriculaCab buscarPorId(Integer id) {
        return dao.buscarPorId(id);
    }

    @Override
    public List<ejbCcoCepCcoMatriculaCab> listarTodos() {
        return dao.listarTodos();
    }

    @Override
    public List<ejbCcoCepCcoMatriculaCab> listarPorGrupo(Integer idAd) {
        return dao.listarPorGrupo(idAd);
    }

    @Override
    public List<ejbCcoCepCcoMatriculaCab> listarPorAlumno(Integer idDir) {
        return dao.listarPorAlumno(idDir);
    }

    @Override
    public List<ejbCcoCepCcoMatriculaCab> listarActivos() {
        return dao.listarActivos();
    }

    @Override
    public List<ejbCcoMatriculaDTO> listarMatriculasDTO() {
        List<ejbCcoCepCcoMatriculaCab> matriculas = dao.listarTodos();
        List<ejbCcoMatriculaDTO> dtos = new ArrayList<>();
        for (ejbCcoCepCcoMatriculaCab matricula : matriculas) {
            dtos.add(new ejbCcoMatriculaDTO(matricula));
        }
        return dtos;
    }

    @Override
    public List<ejbCcoMatriculaDTO> listarMatriculasPorGrupoDTO(Integer idAd) {
        List<ejbCcoCepCcoMatriculaCab> matriculas = dao.listarPorGrupo(idAd);
        List<ejbCcoMatriculaDTO> dtos = new ArrayList<>();
        for (ejbCcoCepCcoMatriculaCab matricula : matriculas) {
            dtos.add(new ejbCcoMatriculaDTO(matricula));
        }
        return dtos;
    }

    @Override
    public Integer obtenerUltimoIdMatricula() {
        return dao.obtenerUltimoIdMatricula();
    }
}
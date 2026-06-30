package ejbCecomp.ejb.negocio;

import ejbCecomp.ejb.dao.ejbCcoCepCursoDocenteDAOLocal;
import ejbCecomp.entidades.ejbCcoCepCursoDocente;
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
public class ejbCcoCepCursoDocenteService implements ejbCcoCepCursoDocenteServiceLocal {

    @Resource
    private UserTransaction ut;

    @Inject
    private ejbCcoCepCursoDocenteDAOLocal dao;

    @Override
    public ejbCcoCepCursoDocente crear(ejbCcoCepCursoDocente grupo) {
        try {
            ut.begin();
            grupo = dao.guardarGrupo(grupo);
            ut.commit();
            return grupo;
        } catch (Exception e) {
            try {
                ut.rollback();
            } catch (Exception ex) {
                Logger.getLogger(ejbCcoCepCursoDocenteService.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        }
    }

    @Override
    public ejbCcoCepCursoDocente actualizar(ejbCcoCepCursoDocente grupo) {
        try {
            ut.begin();
            grupo = dao.actualizarGrupo(grupo);
            ut.commit();
            return grupo;
        } catch (Exception e) {
            try {
                ut.rollback();
            } catch (Exception ex) {
                Logger.getLogger(ejbCcoCepCursoDocenteService.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        }
    }

    @Override
    public ejbCcoCepCursoDocente buscarPorId(Integer id) {
        try {
            ut.begin();
            ejbCcoCepCursoDocente resultado = dao.buscarPorId(id);
            ut.commit();
            return resultado;
        } catch (Exception e) {
            try {
                ut.rollback();
            } catch (Exception ex) {
                Logger.getLogger(ejbCcoCepCursoDocenteService.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        }
    }

    @Override
    public List<ejbCcoCepCursoDocente> listarTodos() {
        try {
            ut.begin();
            List<ejbCcoCepCursoDocente> lista = dao.listarTodos();
            ut.commit();
            return lista;
        } catch (Exception e) {
            try {
                ut.rollback();
            } catch (Exception ex) {
                Logger.getLogger(ejbCcoCepCursoDocenteService.class.getName()).log(Level.SEVERE, null, ex);
            }
            return new ArrayList<>();
        }
    }

    @Override
    public List<ejbCcoCepCursoDocente> listarActivos() {
        try {
            ut.begin();
            List<ejbCcoCepCursoDocente> lista = dao.listarActivos();
            ut.commit();
            return lista;
        } catch (Exception e) {
            try {
                ut.rollback();
            } catch (Exception ex) {
                Logger.getLogger(ejbCcoCepCursoDocenteService.class.getName()).log(Level.SEVERE, null, ex);
            }
            return new ArrayList<>();
        }
    }

    @Override
    public List<ejbCcoCepCursoDocente> listarConPrecios() {
        try {
            ut.begin();
            List<ejbCcoCepCursoDocente> lista = dao.listarConPrecios();
            ut.commit();
            return lista;
        } catch (Exception e) {
            try {
                ut.rollback();
            } catch (Exception ex) {
                Logger.getLogger(ejbCcoCepCursoDocenteService.class.getName()).log(Level.SEVERE, null, ex);
            }
            return new ArrayList<>();
        }
    }

    @Override
    public Integer obtenerUltimoIdGrupo() {
        return dao.obtenerUltimoIdGrupo();
    }

    @Override
    public List<ejbCcoCepCursoDocente> buscarPorCurso(Integer idCurso) {
        try {
            ut.begin();
            List<ejbCcoCepCursoDocente> lista = dao.buscarPorCurso(idCurso);
            ut.commit();
            return lista;
        } catch (Exception e) {
            try {
                ut.rollback();
            } catch (Exception ex) {
                Logger.getLogger(ejbCcoCepCursoDocenteService.class.getName()).log(Level.SEVERE, null, ex);
            }
            return new ArrayList<>();
        }
    }

    @Override
    public List<ejbCcoCepCursoDocente> listarGruposPorCodigoPago(String codigoPago) {
        try {
            ut.begin();
            List<ejbCcoCepCursoDocente> lista = dao.listarGruposPorCodigoPago(codigoPago);
            ut.commit();
            return lista;
        } catch (Exception e) {
            try {
                ut.rollback();
            } catch (Exception ex) {
                Logger.getLogger(ejbCcoCepCursoDocenteService.class.getName()).log(Level.SEVERE, null, ex);
            }
            return new ArrayList<>();
        }
    }
}
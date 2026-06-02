package ejbCecomp.ejb.dao;

import ejbCecomp.entidades.ejbCcoCepCursoDocente;
import jakarta.ejb.Stateless;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import java.util.List;

@Stateless
public class ejbCcoCepCursoDocenteDAO extends ejbCcoGenericoDAO<ejbCcoCepCursoDocente> implements ejbCcoCepCursoDocenteDAOLocal {

    @Override
    public List<ejbCcoCepCursoDocente> listarTodos() {
        TypedQuery<ejbCcoCepCursoDocente> query = em.createQuery(
            "SELECT g FROM CepCursoDocente g " +
            "JOIN FETCH g.cepPersonal " +
            "JOIN FETCH g.cepPersonal.idEsc " +
            "JOIN FETCH g.cepPersonal.idEsc.idDir " +
            "JOIN FETCH g.cepCurso " +
            "LEFT JOIN FETCH g.cepCecCiclo " +
            "LEFT JOIN FETCH g.cepCecNivel " +
            "LEFT JOIN FETCH g.cepCecGrupoCurso",
            ejbCcoCepCursoDocente.class
        );
        return query.getResultList();
    }
    
    @Override
    public List<ejbCcoCepCursoDocente> listarActivos() {
        TypedQuery<ejbCcoCepCursoDocente> query = em.createQuery(
            "SELECT g FROM CepCursoDocente g " +
            "JOIN FETCH g.cepPersonal " +
            "JOIN FETCH g.cepPersonal.idEsc " +
            "JOIN FETCH g.cepPersonal.idEsc.idDir " +
            "JOIN FETCH g.cepCurso " +
            "LEFT JOIN FETCH g.cepCecCiclo " +
            "LEFT JOIN FETCH g.cepCecNivel " +
            "LEFT JOIN FETCH g.cepCecGrupoCurso " +
            "WHERE g.estado = true",
            ejbCcoCepCursoDocente.class
        );
        return query.getResultList();
    }
    
    @Override
    public ejbCcoCepCursoDocente buscarPorId(Integer id) {
        TypedQuery<ejbCcoCepCursoDocente> query = em.createQuery(
            "SELECT g FROM CepCursoDocente g " +
            "JOIN FETCH g.cepPersonal " +
            "JOIN FETCH g.cepPersonal.idEsc " +
            "JOIN FETCH g.cepPersonal.idEsc.idDir " +
            "JOIN FETCH g.cepCurso " +
            "LEFT JOIN FETCH g.cepCecCiclo " +
            "LEFT JOIN FETCH g.cepCecNivel " +
            "LEFT JOIN FETCH g.cepCecGrupoCurso " +
            "WHERE g.idAd = :id",
            ejbCcoCepCursoDocente.class
        );
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
    
    @Override
    public Integer obtenerUltimoIdGrupo() {
        try {
            Query query = em.createNativeQuery("SELECT ISNULL(MAX(id_ad), 0) + 1 FROM cep_curso_docente");
            return (Integer) query.getSingleResult();
        } catch (Exception e) {
            return 1;
        }
    }
    
    @Override
    public ejbCcoCepCursoDocente guardarGrupo(ejbCcoCepCursoDocente grupo) {
        try {
            Query idQuery = em.createNativeQuery("SELECT ISNULL(MAX(id_ad), 0) + 1 FROM cep_curso_docente");
            Integer nextId = (Integer) idQuery.getSingleResult();
            grupo.setIdAd(nextId);
            
            Query insertQuery = em.createNativeQuery(
                "INSERT INTO cep_curso_docente (id_ad, id_personal, id_curso, id_dep, estado, fecha, id_ciclo, id_nivel, id_grupo, fecha_fin, cerra_aper) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"
            );
            
            insertQuery.setParameter(1, grupo.getIdAd());
            insertQuery.setParameter(2, grupo.getCepPersonal() != null ? grupo.getCepPersonal().getIdPersonal() : null);
            insertQuery.setParameter(3, grupo.getCepCurso() != null ? grupo.getCepCurso().getIdCurso() : null);
            insertQuery.setParameter(4, grupo.getIdDep());
            insertQuery.setParameter(5, grupo.getEstado() ? 1 : 0);
            insertQuery.setParameter(6, grupo.getFecha());
            insertQuery.setParameter(7, grupo.getCepCecCiclo() != null ? grupo.getCepCecCiclo().getIdCiclo() : null);
            insertQuery.setParameter(8, grupo.getCepCecNivel() != null ? grupo.getCepCecNivel().getIdNivel() : null);
            insertQuery.setParameter(9, grupo.getCepCecGrupoCurso() != null ? grupo.getCepCecGrupoCurso().getIdGrupo() : null);
            insertQuery.setParameter(10, grupo.getFechaFin());
            insertQuery.setParameter(11, grupo.getCerraAper() ? 1 : 0);
            
            insertQuery.executeUpdate();
            
            return grupo;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
    
    @Override
    public ejbCcoCepCursoDocente actualizarGrupo(ejbCcoCepCursoDocente grupo) {
        Query updateQuery = em.createNativeQuery(
            "UPDATE cep_curso_docente SET id_personal=?, id_curso=?, id_dep=?, estado=?, fecha=?, id_ciclo=?, id_nivel=?, id_grupo=?, fecha_fin=?, cerra_aper=? WHERE id_ad=?"
        );
        
        updateQuery.setParameter(1, grupo.getCepPersonal() != null ? grupo.getCepPersonal().getIdPersonal() : null);
        updateQuery.setParameter(2, grupo.getCepCurso() != null ? grupo.getCepCurso().getIdCurso() : null);
        updateQuery.setParameter(3, grupo.getIdDep());
        updateQuery.setParameter(4, grupo.getEstado() ? 1 : 0);
        updateQuery.setParameter(5, grupo.getFecha());
        updateQuery.setParameter(6, grupo.getCepCecCiclo() != null ? grupo.getCepCecCiclo().getIdCiclo() : null);
        updateQuery.setParameter(7, grupo.getCepCecNivel() != null ? grupo.getCepCecNivel().getIdNivel() : null);
        updateQuery.setParameter(8, grupo.getCepCecGrupoCurso() != null ? grupo.getCepCecGrupoCurso().getIdGrupo() : null);
        updateQuery.setParameter(9, grupo.getFechaFin());
        updateQuery.setParameter(10, grupo.getCerraAper() ? 1 : 0);
        updateQuery.setParameter(11, grupo.getIdAd());
        
        updateQuery.executeUpdate();
        return grupo;
    }
}
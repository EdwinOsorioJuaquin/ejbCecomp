package ejbCecomp.ejb.dao;

import ejbCecomp.entidades.ejbCcoCepCcoMatriculaCab;
import jakarta.ejb.Stateless;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import java.util.List;

@Stateless
public class ejbCcoCepCcoMatriculaCabDAO extends ejbCcoGenericoDAO<ejbCcoCepCcoMatriculaCab> implements ejbCcoCepCcoMatriculaCabDAOLocal {

    @Override
    public List<ejbCcoCepCcoMatriculaCab> listarTodos() {
        TypedQuery<ejbCcoCepCcoMatriculaCab> query = em.createQuery(
            "SELECT m FROM CepCcoMatriculaCab m " +
            "JOIN FETCH m.cepCursoDocente " +
            "JOIN FETCH m.cepCursoDocente.cepCurso " +
            "JOIN FETCH m.drtPersonanatural",
            ejbCcoCepCcoMatriculaCab.class
        );
        return query.getResultList();
    }
    
    @Override
    public List<ejbCcoCepCcoMatriculaCab> listarPorGrupo(Integer idAd) {
        TypedQuery<ejbCcoCepCcoMatriculaCab> query = em.createQuery(
            "SELECT m FROM CepCcoMatriculaCab m " +
            "JOIN FETCH m.drtPersonanatural " +
            "WHERE m.cepCursoDocente.idAd = :idAd",
            ejbCcoCepCcoMatriculaCab.class
        );
        query.setParameter("idAd", idAd);
        return query.getResultList();
    }
    
    @Override
    public List<ejbCcoCepCcoMatriculaCab> listarPorAlumno(Integer idDir) {
        TypedQuery<ejbCcoCepCcoMatriculaCab> query = em.createQuery(
            "SELECT m FROM CepCcoMatriculaCab m " +
            "JOIN FETCH m.cepCursoDocente " +
            "JOIN FETCH m.cepCursoDocente.cepCurso " +
            "WHERE m.drtPersonanatural.idDir = :idDir",
            ejbCcoCepCcoMatriculaCab.class
        );
        query.setParameter("idDir", idDir);
        return query.getResultList();
    }
    
    @Override
    public List<ejbCcoCepCcoMatriculaCab> listarActivos() {
        TypedQuery<ejbCcoCepCcoMatriculaCab> query = em.createQuery(
            "SELECT m FROM CepCcoMatriculaCab m " +
            "JOIN FETCH m.cepCursoDocente " +
            "JOIN FETCH m.drtPersonanatural " +
            "WHERE m.cepCursoDocente.estado = true",
            ejbCcoCepCcoMatriculaCab.class
        );
        return query.getResultList();
    }
    
    @Override
    public ejbCcoCepCcoMatriculaCab buscarPorId(Integer id) {
        try {
            TypedQuery<ejbCcoCepCcoMatriculaCab> query = em.createQuery(
                "SELECT m FROM CepCcoMatriculaCab m " +
                "JOIN FETCH m.cepCursoDocente " +
                "JOIN FETCH m.cepCursoDocente.cepCurso " +
                "JOIN FETCH m.drtPersonanatural " +
                "WHERE m.idMtaAlu = :id",
                ejbCcoCepCcoMatriculaCab.class
            );
            query.setParameter("id", id);
            return query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
    
    @Override
    public Integer obtenerUltimoIdMatricula() {
        try {
            Query query = em.createNativeQuery("SELECT ISNULL(MAX(id_mta_alu), 0) + 1 FROM cep_cco_matricula_cab");
            return (Integer) query.getSingleResult();
        } catch (Exception e) {
            return 1;
        }
    }
    
    @Override
    public ejbCcoCepCcoMatriculaCab guardarMatricula(ejbCcoCepCcoMatriculaCab matricula) {
        try {
            Query idQuery = em.createNativeQuery("SELECT ISNULL(MAX(id_mta_alu), 0) + 1 FROM cep_cco_matricula_cab");
            Integer nextId = (Integer) idQuery.getSingleResult();
            matricula.setIdMtaAlu(nextId);
            
            Query insertQuery = em.createNativeQuery(
                "INSERT INTO cep_cco_matricula_cab (id_mta_alu, id_ad, id_dir, nota_final) " +
                "VALUES (?, ?, ?, ?)"
            );
            
            insertQuery.setParameter(1, matricula.getIdMtaAlu());
            insertQuery.setParameter(2, matricula.getCepCursoDocente() != null ? matricula.getCepCursoDocente().getIdAd() : null);
            insertQuery.setParameter(3, matricula.getDrtPersonanatural() != null ? matricula.getDrtPersonanatural().getIdDir() : null);
            insertQuery.setParameter(4, matricula.getNotaFinal());
            
            insertQuery.executeUpdate();
            
            return matricula;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
    
    @Override
    public ejbCcoCepCcoMatriculaCab actualizarMatricula(ejbCcoCepCcoMatriculaCab matricula) {
        Query updateQuery = em.createNativeQuery(
            "UPDATE cep_cco_matricula_cab SET id_ad=?, id_dir=?, nota_final=? WHERE id_mta_alu=?"
        );
        
        updateQuery.setParameter(1, matricula.getCepCursoDocente() != null ? matricula.getCepCursoDocente().getIdAd() : null);
        updateQuery.setParameter(2, matricula.getDrtPersonanatural() != null ? matricula.getDrtPersonanatural().getIdDir() : null);
        updateQuery.setParameter(3, matricula.getNotaFinal());
        updateQuery.setParameter(4, matricula.getIdMtaAlu());
        
        updateQuery.executeUpdate();
        return matricula;
    }
}
package ejbCecomp.ejb.dao;

import ejbCecomp.entidades.ejbCcoCepPersonal;
import jakarta.ejb.Stateless;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import java.util.List;

@Stateless
public class ejbCcoCepPersonalDAO extends ejbCcoGenericoDAO<ejbCcoCepPersonal> implements ejbCcoCepPersonalDAOLocal {

    @Override
    public List<ejbCcoCepPersonal> listarTodos() {
        TypedQuery<ejbCcoCepPersonal> query = em.createQuery(
            "SELECT c FROM CepPersonal c " +
            "JOIN FETCH c.idEsc " +
            "JOIN FETCH c.idEsc.idDir " +
            "LEFT JOIN FETCH c.idTipoCecomp",
            ejbCcoCepPersonal.class
        );
        return query.getResultList();
    }
    
    @Override
    public List<ejbCcoCepPersonal> listarActivos() {
        TypedQuery<ejbCcoCepPersonal> query = em.createQuery(
            "SELECT c FROM CepPersonal c " +
            "JOIN FETCH c.idEsc " +
            "JOIN FETCH c.idEsc.idDir " +
            "LEFT JOIN FETCH c.idTipoCecomp " +
            "WHERE c.bandera = true",
            ejbCcoCepPersonal.class
        );
        return query.getResultList();
    }
    
    @Override
    public ejbCcoCepPersonal buscarPorId(Integer id) {
        TypedQuery<ejbCcoCepPersonal> query = em.createQuery(
            "SELECT c FROM CepPersonal c " +
            "JOIN FETCH c.idEsc " +
            "JOIN FETCH c.idEsc.idDir " +
            "LEFT JOIN FETCH c.idTipoCecomp " +
            "WHERE c.idPersonal = :id",
            ejbCcoCepPersonal.class
        );
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
    
    @Override
    public Integer obtenerUltimoIdPersonal() {
        try {
            Query query = em.createNativeQuery("SELECT ISNULL(MAX(id_personal), 0) + 1 FROM cep_personal");
            return (Integer) query.getSingleResult();
        } catch (Exception e) {
            return 1;
        }
    }
    
    @Override
    public ejbCcoCepPersonal guardarCepPersonal(ejbCcoCepPersonal cepPersonal) {
        try {
            Query idQuery = em.createNativeQuery("SELECT ISNULL(MAX(id_personal), 0) + 1 FROM cep_personal");
            Integer nextId = (Integer) idQuery.getSingleResult();
            cepPersonal.setIdPersonal(nextId);
            
            Query insertQuery = em.createNativeQuery(
                "INSERT INTO cep_personal (id_personal, fecha_ing, fecha_fin, id_esc, id_dep, bandera, id_tipo_cecomp) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)"
            );
            
            insertQuery.setParameter(1, cepPersonal.getIdPersonal());
            insertQuery.setParameter(2, cepPersonal.getFechaIng());
            insertQuery.setParameter(3, cepPersonal.getFechaFin());
            insertQuery.setParameter(4, cepPersonal.getEscPersonal()!= null ? cepPersonal.getEscPersonal().getIdEsc() : null);
            insertQuery.setParameter(5, cepPersonal.getIdDep());
            insertQuery.setParameter(6, cepPersonal.getBandera() ? 1 : 0);
            insertQuery.setParameter(7, cepPersonal.getCepTipoPersonal()!= null ? cepPersonal.getCepTipoPersonal().getIdTipoCecomp() : null);
            
            insertQuery.executeUpdate();
            
            return cepPersonal;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
    
    @Override
    public ejbCcoCepPersonal actualizarCepPersonal(ejbCcoCepPersonal cepPersonal) {
        Query updateQuery = em.createNativeQuery(
            "UPDATE cep_personal SET fecha_ing=?, fecha_fin=?, id_esc=?, id_dep=?, bandera=?, id_tipo_cecomp=? WHERE id_personal=?"
        );
        
        updateQuery.setParameter(1, cepPersonal.getFechaIng());
        updateQuery.setParameter(2, cepPersonal.getFechaFin());
        updateQuery.setParameter(3, cepPersonal.getEscPersonal()!= null ? cepPersonal.getEscPersonal().getIdEsc() : null);
        updateQuery.setParameter(4, cepPersonal.getIdDep());
        updateQuery.setParameter(5, cepPersonal.getBandera() ? 1 : 0);
        updateQuery.setParameter(6, cepPersonal.getCepTipoPersonal()!= null ? cepPersonal.getCepTipoPersonal().getIdTipoCecomp() : null);
        updateQuery.setParameter(7, cepPersonal.getIdPersonal());
        
        updateQuery.executeUpdate();
        return cepPersonal;
    }
}
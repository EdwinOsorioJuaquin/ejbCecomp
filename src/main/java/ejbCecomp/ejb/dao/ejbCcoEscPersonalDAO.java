package ejbCecomp.ejb.dao;

import ejbCecomp.entidades.ejbCcoEscPersonal;
import jakarta.ejb.Stateless;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class ejbCcoEscPersonalDAO extends ejbCcoGenericoDAO<ejbCcoEscPersonal> implements ejbCcoEscPersonalDAOLocal {

    @Override
    public List<ejbCcoEscPersonal> listarTodos() {
        TypedQuery<ejbCcoEscPersonal> query = em.createQuery(
            "SELECT e FROM EscPersonal e JOIN FETCH e.idDir",
            ejbCcoEscPersonal.class
        );
        return query.getResultList();
    }
    
    @Override
    public List<ejbCcoEscPersonal> listarActivos() {
        TypedQuery<ejbCcoEscPersonal> query = em.createQuery(
            "SELECT e FROM EscPersonal e JOIN FETCH e.idDir WHERE e.condicion = 1",
            ejbCcoEscPersonal.class
        );
        return query.getResultList();
    }
    
    @Override
    public ejbCcoEscPersonal buscarPorId(Integer id) {
        TypedQuery<ejbCcoEscPersonal> query = em.createQuery(
            "SELECT e FROM EscPersonal e JOIN FETCH e.idDir WHERE e.idEsc = :id",
            ejbCcoEscPersonal.class
        );
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
    
    @Override
    public ejbCcoEscPersonal buscarPorIdDir(Integer idDir) {
        try {
            TypedQuery<ejbCcoEscPersonal> query = em.createQuery(
                "SELECT e FROM EscPersonal e WHERE e.idDir.idDir = :idDir",
                ejbCcoEscPersonal.class
            );
            query.setParameter("idDir", idDir);
            List<ejbCcoEscPersonal> result = query.getResultList();
            return result.isEmpty() ? null : result.get(0);
        } catch (Exception e) {
            return null;
        }
    }
    
    @Override
    public Integer obtenerUltimoIdEsc() {
        try {
            TypedQuery<Integer> query = em.createQuery(
                "SELECT MAX(e.idEsc) FROM EscPersonal e",
                Integer.class
            );
            Integer maxId = query.getSingleResult();
            return maxId != null ? maxId + 1 : 1;
        } catch (Exception e) {
            return 1;
        }
    }
    
    @Override
    public List<ejbCcoEscPersonal> listarNoDocentesCecomp() {
        // Usar Native Query
        Query nativeQuery = em.createNativeQuery(
            "SELECT e.* FROM esc_personal e " +
            "LEFT JOIN cep_personal c ON e.id_esc = c.id_esc AND c.bandera = 1 " +
            "WHERE c.id_esc IS NULL",
            ejbCcoEscPersonal.class
        );
        return nativeQuery.getResultList();
    }
    
    // 🔥 NUEVO MÉTODO - Guardar con Native Query
    @Override
    public ejbCcoEscPersonal guardarEscPersonal(ejbCcoEscPersonal escPersonal) {
        try {
            // Obtener el siguiente ID disponible
            Query idQuery = em.createNativeQuery("SELECT ISNULL(MAX(id_esc), 0) + 1 FROM esc_personal");
            Integer nextId = (Integer) idQuery.getSingleResult();
            escPersonal.setIdEsc(nextId);
            
            // Insert con Native Query
            Query insertQuery = em.createNativeQuery(
                "INSERT INTO esc_personal (id_esc, id_estado, id_tipo, fecha_ing, condicion, ruc, especialidad, abrev_esp, fecha_cese, observaciones, id_dir) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"
            );
            
            insertQuery.setParameter(1, escPersonal.getIdEsc());
            insertQuery.setParameter(2, escPersonal.getIdEstado());
            insertQuery.setParameter(3, escPersonal.getIdTipo());
            insertQuery.setParameter(4, escPersonal.getFechaIng());
            insertQuery.setParameter(5, escPersonal.getCondicion());
            insertQuery.setParameter(6, escPersonal.getRuc());
            insertQuery.setParameter(7, escPersonal.getEspecialidad());
            insertQuery.setParameter(8, escPersonal.getAbrevEsp());
            insertQuery.setParameter(9, escPersonal.getFechaCese());
            insertQuery.setParameter(10, escPersonal.getObservaciones());
            insertQuery.setParameter(11, escPersonal.getDrtPersonanatural()!= null ? escPersonal.getDrtPersonanatural().getIdDir() : null);
            
            insertQuery.executeUpdate();
            
            return escPersonal;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
    
    // 🔥 NUEVO MÉTODO - Actualizar con Native Query
    @Override
    public ejbCcoEscPersonal actualizarEscPersonal(ejbCcoEscPersonal escPersonal) {
        Query updateQuery = em.createNativeQuery(
            "UPDATE esc_personal SET id_estado=?, id_tipo=?, fecha_ing=?, condicion=?, ruc=?, especialidad=?, abrev_esp=?, fecha_cese=?, observaciones=?, id_dir=? WHERE id_esc=?"
        );
        
        updateQuery.setParameter(1, escPersonal.getIdEstado());
        updateQuery.setParameter(2, escPersonal.getIdTipo());
        updateQuery.setParameter(3, escPersonal.getFechaIng());
        updateQuery.setParameter(4, escPersonal.getCondicion());
        updateQuery.setParameter(5, escPersonal.getRuc());
        updateQuery.setParameter(6, escPersonal.getEspecialidad());
        updateQuery.setParameter(7, escPersonal.getAbrevEsp());
        updateQuery.setParameter(8, escPersonal.getFechaCese());
        updateQuery.setParameter(9, escPersonal.getObservaciones());
        updateQuery.setParameter(10, escPersonal.getDrtPersonanatural()!= null ? escPersonal.getDrtPersonanatural().getIdDir() : null);
        updateQuery.setParameter(11, escPersonal.getIdEsc());
        
        updateQuery.executeUpdate();
        return escPersonal;
    }
}
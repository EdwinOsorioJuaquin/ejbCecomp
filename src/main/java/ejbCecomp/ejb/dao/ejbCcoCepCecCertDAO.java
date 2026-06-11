package ejbCecomp.ejb.dao;

import ejbCecomp.entidades.ejbCcoCepCecCert;
import jakarta.ejb.Stateless;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import java.util.List;

@Stateless
public class ejbCcoCepCecCertDAO extends ejbCcoGenericoDAO<ejbCcoCepCecCert> implements ejbCcoCepCecCertDAOLocal {

    @Override
    public List<ejbCcoCepCecCert> listarTodos() {
        TypedQuery<ejbCcoCepCecCert> query = em.createQuery(
            "SELECT c FROM CepCecCert c",
            ejbCcoCepCecCert.class
        );
        return query.getResultList();
    }
    
    @Override
    public ejbCcoCepCecCert buscarPorMatricula(Integer idMtaAlu) {
        try {
            TypedQuery<ejbCcoCepCecCert> query = em.createQuery(
                "SELECT c FROM CepCecCert c WHERE c.idMtaAlu.idMtaAlu = :idMtaAlu",
                ejbCcoCepCecCert.class
            );
            query.setParameter("idMtaAlu", idMtaAlu);
            List<ejbCcoCepCecCert> result = query.getResultList();
            return result.isEmpty() ? null : result.get(0);
        } catch (Exception e) {
            return null;
        }
    }
    
    @Override
    public List<ejbCcoCepCecCert> listarPorAlumno(Integer idDir) {
        Query query = em.createNativeQuery(
            "SELECT c.* FROM cep_cec_cert c " +
            "INNER JOIN cep_cco_matricula_cab m ON c.id_mta_alu = m.id_mta_alu " +
            "WHERE m.id_dir = ?",
            ejbCcoCepCecCert.class
        );
        query.setParameter(1, idDir);
        return query.getResultList();
    }

    @Override
    public Integer obtenerUltimoIdCert() {
        try {
            Query query = em.createNativeQuery("SELECT ISNULL(MAX(id_cert), 0) + 1 FROM cep_cec_cert");
            return (Integer) query.getSingleResult();
        } catch (Exception e) {
            return 1;
        }
    }
    
    @Override
    public ejbCcoCepCecCert guardarCertificado(ejbCcoCepCecCert certificado) {
        try {
            Query idQuery = em.createNativeQuery("SELECT ISNULL(MAX(id_cert), 0) + 1 FROM cep_cec_cert");
            Integer nextId = (Integer) idQuery.getSingleResult();
            certificado.setIdCert(nextId);
            
            Query insertQuery = em.createNativeQuery(
                "INSERT INTO cep_cec_cert (id_cert, id_mta_alu, fecha_cert, estado_cert, resol) " +
                "VALUES (?, ?, ?, ?, ?)"
            );
            
            insertQuery.setParameter(1, certificado.getIdCert());
            insertQuery.setParameter(2, certificado.getCepCcoMatriculaCab().getIdMtaAlu());
            insertQuery.setParameter(3, certificado.getFechaCert());
            insertQuery.setParameter(4, certificado.getEstadoCert() ? 1 : 0);
            insertQuery.setParameter(5, certificado.getResol());
            
            insertQuery.executeUpdate();
            
            return certificado;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
    
    @Override
    public ejbCcoCepCecCert actualizarCertificado(ejbCcoCepCecCert certificado) {
        Query updateQuery = em.createNativeQuery(
            "UPDATE cep_cec_cert SET fecha_cert=?, estado_cert=?, resol=? WHERE id_cert=?"
        );
        
        updateQuery.setParameter(1, certificado.getFechaCert());
        updateQuery.setParameter(2, certificado.getEstadoCert() ? 1 : 0);
        updateQuery.setParameter(3, certificado.getResol());
        updateQuery.setParameter(4, certificado.getIdCert());
        
        updateQuery.executeUpdate();
        return certificado;
    }
}
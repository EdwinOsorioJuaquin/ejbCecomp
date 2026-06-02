
package ejbCecomp.ejb.dao;

import ejbCecomp.entidades.ejbCcoCepCecCert;
import jakarta.ejb.Stateless;
import jakarta.persistence.TypedQuery;
import java.util.List;

/**
 * Implementación DAO para certificados.
 */
@Stateless
public class ejbCcoCepCecCertDAO extends ejbCcoGenericoDAO<ejbCcoCepCecCert> implements ejbCcoCepCecCertDAOLocal {

    /**
     * Lista todos los certificados
     */
    @Override
    public List<ejbCcoCepCecCert> listarTodos() {

        TypedQuery<ejbCcoCepCecCert> q =
            em.createQuery("SELECT c FROM CepCecCert c", ejbCcoCepCecCert.class);

        return q.getResultList();
    }

    /**
     * Lista certificados por alumno
     */
    @Override
    public List<ejbCcoCepCecCert> listarPorAlumno(Integer idAlumno) {

        TypedQuery<ejbCcoCepCecCert> q =
            em.createQuery(
                "SELECT c FROM CepCecCert c WHERE c.idMatriAlum = :idAlumno",
                ejbCcoCepCecCert.class
            );

        q.setParameter("idAlumno", idAlumno);

        return q.getResultList();
    }
}

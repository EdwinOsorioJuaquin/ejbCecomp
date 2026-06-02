package ejbCecomp.ejb.dao;

import ejbCecomp.entidades.ejbCcoCepCecCert;
import jakarta.ejb.Local;
import java.util.List;

@Local
public interface ejbCcoCepCecCertDAOLocal extends ejbCcoGenericoDAOLocal<ejbCcoCepCecCert> {
    List<ejbCcoCepCecCert> listarTodos();
    ejbCcoCepCecCert buscarPorMatricula(Integer idMtaAlu);
    List<ejbCcoCepCecCert> listarPorAlumno(Integer idDir);
    Integer obtenerUltimoIdCert();
    ejbCcoCepCecCert guardarCertificado(ejbCcoCepCecCert certificado);
    ejbCcoCepCecCert actualizarCertificado(ejbCcoCepCecCert certificado);
}
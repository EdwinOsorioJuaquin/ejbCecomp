package ejbCecomp.ejb.negocio;

import ejbCecomp.clases.ejbCcoCertificadoDTO;
import ejbCecomp.entidades.ejbCcoCepCecCert;
import jakarta.ejb.Local;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Local
public interface ejbCcoCepCecCertServiceLocal {
    ejbCcoCepCecCert crear(ejbCcoCepCecCert certificado);
    ejbCcoCepCecCert actualizar(ejbCcoCepCecCert certificado);
    ejbCcoCepCecCert buscarPorId(Integer id);
    List<ejbCcoCepCecCert> listarTodos();
    List<ejbCcoCertificadoDTO> listarCertificadosDTO();
    ejbCcoCepCecCert buscarPorMatricula(Integer idMtaAlu);
    boolean puedeCertificar(Integer idMtaAlu, Integer notaFinal);
    boolean yaTieneCertificado(Integer idMtaAlu);
    ejbCcoCepCecCert generarCertificado(Integer idMtaAlu, Integer resol, Date fechaCert);
    Integer obtenerUltimoIdCert();
    Map<String, Object> obtenerDatosCertificado(Integer idCert);
    List<ejbCcoCepCecCert> listarPorAlumno(Integer idDir);
}
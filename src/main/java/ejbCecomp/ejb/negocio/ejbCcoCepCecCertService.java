package ejbCecomp.ejb.negocio;

import ejbCecomp.clases.ejbCcoCertificadoDTO;
import ejbCecomp.ejb.dao.ejbCcoCepCecCertDAOLocal;
import ejbCecomp.ejb.dao.ejbCcoCepCcoMatriculaCabDAOLocal;
import ejbCecomp.entidades.ejbCcoCepCecCert;
import ejbCecomp.entidades.ejbCcoCepCcoMatriculaCab;
import ejbCecomp.entidades.ejbCcoCepCursoDocente;
import ejbCecomp.entidades.ejbCcoDrtPersonanatural;
import jakarta.annotation.Resource;
import jakarta.ejb.Stateless;
import jakarta.ejb.TransactionManagement;
import jakarta.ejb.TransactionManagementType;
import jakarta.inject.Inject;
import jakarta.transaction.UserTransaction;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class ejbCcoCepCecCertService implements ejbCcoCepCecCertServiceLocal {

    @Resource
    private UserTransaction ut;

    @Inject
    private ejbCcoCepCecCertDAOLocal dao;

    @Inject
    private ejbCcoCepCcoMatriculaCabDAOLocal daoMatricula;

    @Override
    public ejbCcoCepCecCert crear(ejbCcoCepCecCert certificado) {
        try {
            ut.begin();
            certificado = dao.guardarCertificado(certificado);
            ut.commit();
            return certificado;
        } catch (Exception e) {
            rollback();
            return null;
        }
    }

    @Override
    public ejbCcoCepCecCert actualizar(ejbCcoCepCecCert certificado) {
        try {
            ut.begin();
            certificado = dao.actualizarCertificado(certificado);
            ut.commit();
            return certificado;
        } catch (Exception e) {
            rollback();
            return null;
        }
    }

    @Override
    public ejbCcoCepCecCert buscarPorId(Integer id) {
        return dao.buscarPorId(id);
    }

    @Override
    public List<ejbCcoCepCecCert> listarTodos() {
        return dao.listarTodos();
    }

    @Override
    public List<ejbCcoCertificadoDTO> listarCertificadosDTO() {
        List<ejbCcoCepCecCert> certificados = dao.listarTodos();
        List<ejbCcoCertificadoDTO> dtos = new ArrayList<>();
        
        for (ejbCcoCepCecCert cert : certificados) {
            ejbCcoCepCcoMatriculaCab matricula = null;
            if (cert.getCepCcoMatriculaCab()!= null) {
                matricula = daoMatricula.buscarPorId(cert.getCepCcoMatriculaCab());
            }
            dtos.add(new ejbCcoCertificadoDTO(cert, matricula));
        }
        return dtos;
    }

    @Override
    public ejbCcoCepCecCert buscarPorMatricula(Integer idMtaAlu) {
        return dao.buscarPorMatricula(idMtaAlu);
    }

    @Override
    public boolean puedeCertificar(Integer idMtaAlu, Integer notaFinal) {
        if (idMtaAlu == null || notaFinal == null) return false;
        return notaFinal >= 14;
    }

    @Override
    public boolean yaTieneCertificado(Integer idMtaAlu) {
        return dao.buscarPorMatricula(idMtaAlu) != null;
    }

    @Override
    public Integer obtenerUltimoIdCert() {
        return dao.obtenerUltimoIdCert();
    }
    
    @Override
    public Map<String, Object> obtenerDatosCertificado(Integer idCert) {
        try {
            ejbCcoCepCecCert certificado = dao.buscarPorId(idCert);
            if (certificado == null) return null;

            ejbCcoCepCcoMatriculaCab matricula = certificado.getCepCcoMatriculaCab();
            if (matricula == null) return null;

            Map<String, Object> datos = new HashMap<>();

            datos.put("idCert", certificado.getIdCert());
            datos.put("fechaCert", certificado.getFechaCert());
            datos.put("resolucion", certificado.getResol());
            datos.put("estadoCert", certificado.getEstadoCert());

            if (matricula.getDrtPersonanatural() != null) {
                ejbCcoDrtPersonanatural persona = matricula.getDrtPersonanatural();
                datos.put("nombreCompleto", persona.getNombreCompleto());
                datos.put("dni", persona.getNumeroPndid());
                datos.put("direccion", persona.getDireccion());
                datos.put("email", persona.getEmailPrin());
                datos.put("celular", persona.getCelularPrin());
            }

            if (matricula.getCepCursoDocente() != null) {
                ejbCcoCepCursoDocente grupo = matricula.getCepCursoDocente();
                datos.put("notaFinal", matricula.getNotaFinal());

                if (grupo.getCepCurso()!= null) {
                    datos.put("nombreCurso", grupo.getCepCurso().getNomCurso());
                    datos.put("duracionCurso", grupo.getCepCurso().getDuracion());
                }

                if (grupo.getCepPersonal() != null && 
                    grupo.getCepPersonal().getEscPersonal()!= null &&
                    grupo.getCepPersonal().getEscPersonal().getDrtPersonanatural()!= null) {
                    datos.put("nombreDocente", grupo.getCepPersonal().getEscPersonal().getDrtPersonanatural().getNombreCompleto());
                }

                if (grupo.getCepCecGrupoCurso() != null) {
                    datos.put("nombreGrupo", grupo.getCepCecGrupoCurso().getNombre());
                }
            }

            return datos;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void rollback() {
        try {
            ut.rollback();
        } catch (Exception ex) {
            Logger.getLogger(ejbCcoCepCecCertService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public List<ejbCcoCepCecCert> listarPorAlumno(Integer idDir) {
        return dao.listarPorAlumno(idDir);
    }
    
    @Override
    public void actualizarVoucher(Integer idVoucher, String estado) {
        try {
            ut.begin();
            dao.actualizarVoucher(idVoucher, estado);
            ut.commit();
        } catch (Exception e) {
            try {
                ut.rollback();
            } catch (Exception ex) {
                System.out.println("Error rollback: " + ex.getMessage());
            }
            e.printStackTrace();
        }
    }
}
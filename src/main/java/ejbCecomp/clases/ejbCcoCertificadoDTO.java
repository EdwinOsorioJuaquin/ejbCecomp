package ejbCecomp.clases;

import ejbCecomp.entidades.*;
import lombok.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ejbCcoCertificadoDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    // Datos del certificado
    private ejbCcoCepCecCert certificado;
    private Integer idCert;
    private Date fechaCert;
    private Boolean estadoCert;
    private Integer resol;
    
    // Datos de la matrícula (desde MatriculaCab)
    private Integer idMtaAlu;
    private Integer notaFinal;
    
    // Datos del alumno (desde MatriculaCab -> ejbCcoDrtPersonanatural)
    private Integer idDir;
    private String nombreCompleto;
    private String dni;
    private String email;
    private String celular;
    
    // Datos del grupo (desde MatriculaCab -> ejbCcoCepCursoDocente)
    private Integer idAd;
    private String nombreCurso;
    private String nombreDocente;
    private String nombreNivel;
    private String nombreGrupo;
    
    public ejbCcoCertificadoDTO(ejbCcoCepCecCert certificado, ejbCcoCepCcoMatriculaCab matricula) {
        this.certificado = certificado;
        
        if (certificado != null) {
            this.idCert = certificado.getIdCert();
            this.fechaCert = certificado.getFechaCert();
            this.estadoCert = certificado.getEstadoCert();
            this.resol = certificado.getResol();
        }
        
        if (matricula != null) {
            this.idMtaAlu = matricula.getIdMtaAlu();
            this.notaFinal = matricula.getNotaFinal();
            
            // Alumno
            if (matricula.getDrtPersonanatural() != null) {
                ejbCcoDrtPersonanatural persona = matricula.getDrtPersonanatural();
                this.idDir = persona.getIdDir();
                this.nombreCompleto = persona.getNombreCompleto();
                this.dni = persona.getNumeroPndid();
                this.email = persona.getEmailPrin();
                this.celular = persona.getCelularPrin();
            }
            
            // Grupo
            if (matricula.getCepCursoDocente() != null) {
                ejbCcoCepCursoDocente grupo = matricula.getCepCursoDocente();
                this.idAd = grupo.getIdAd();
                
                if (grupo.getCepCurso()!= null) {
                    this.nombreCurso = grupo.getCepCurso().getNomCurso();
                }
                
                if (grupo.getCepPersonal() != null && 
                    grupo.getCepPersonal().getEscPersonal()!= null &&
                    grupo.getCepPersonal().getEscPersonal().getDrtPersonanatural()!= null) {
                    this.nombreDocente = grupo.getCepPersonal().getEscPersonal().getDrtPersonanatural().getNombreCompleto();
                }
                
//                if (grupo.getCepCecNivel() != null) {
//                    this.nombreNivel = grupo.getCepCecNivel().getNombreNivel();
//                }
                
                if (grupo.getCepCecGrupoCurso() != null) {
                    this.nombreGrupo = grupo.getCepCecGrupoCurso().getNombre();
                }
            }
        }
    }
}
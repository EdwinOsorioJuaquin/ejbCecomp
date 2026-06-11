package ejbCecomp.clases;

import ejbCecomp.entidades.*;
import lombok.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ejbCcoMatriculaDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private ejbCcoCepCcoMatriculaCab matricula;
    private Integer idMtaAlu;
    private Integer notaFinal;
    private Date fecha;
    private Date historialFecha;
    private Integer iduser;
    
    private Integer idAd;
    private String nombreCurso;
    private String nombreDocente;
    private String nombreTipoDesarrollo;
    private String nombreGrupo;
    
    private Integer idDir;
    private String nombreCompleto;
    private String dni;
    private String email;
    private String celular;
    
    private String tipoAlumno;
    private boolean seleccionado;
    
    public ejbCcoMatriculaDTO(ejbCcoCepCcoMatriculaCab matricula) {
        this.matricula = matricula;
        
        if (matricula != null) {
            this.idMtaAlu = matricula.getIdMtaAlu();
            this.notaFinal = matricula.getNotaFinal();
            
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
                
                // CORREGIDO: usar getTipoDesarrollo()
                if (grupo.getCepCecTipoDesarrollo()!= null) {
                    this.nombreTipoDesarrollo = grupo.getCepCecTipoDesarrollo().getNombreDesarrollo();
                }
                
                if (grupo.getCepCecGrupoCurso() != null) {
                    this.nombreGrupo = grupo.getCepCecGrupoCurso().getNombre();
                }
            }
            
            if (matricula.getDrtPersonanatural() != null) {
                ejbCcoDrtPersonanatural persona = matricula.getDrtPersonanatural();
                this.idDir = persona.getIdDir();
                this.nombreCompleto = persona.getNombreCompleto();
                this.dni = persona.getNumeroPndid();
                this.email = persona.getEmailPrin();
                this.celular = persona.getCelularPrin();
            }
        }
    }
}
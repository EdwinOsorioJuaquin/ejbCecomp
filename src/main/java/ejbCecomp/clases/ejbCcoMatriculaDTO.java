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
    
    // Datos de la matrícula
    private ejbCcoCepCcoMatriculaCab matricula;
    private Integer idMtaAlu;
    private Integer notaFinal;
    private Date fecha;
    private Date historialFecha;
    private Integer iduser;
    
    // Datos del grupo
    private Integer idAd;
    private String nombreCurso;
    private String nombreDocente;
    private String nombreCiclo;
    private String nombreNivel;
    private String nombreGrupo;
    
    // Datos del alumno (persona natural)
    private Integer idDir;
    private String nombreCompleto;
    private String dni;
    private String email;
    private String celular;
    
    // Tipo de alumno
    private String tipoAlumno;
    
    // Para búsqueda de alumnos
    private boolean seleccionado;
    
    public ejbCcoMatriculaDTO(ejbCcoCepCcoMatriculaCab matricula) {
        this.matricula = matricula;
        
        if (matricula != null) {
            this.idMtaAlu = matricula.getIdMtaAlu();
            this.notaFinal = matricula.getNotaFinal();
            
            // Grupo
            if (matricula.getCepCursoDocente() != null) {
                ejbCcoCepCursoDocente grupo = matricula.getCepCursoDocente();
                this.idAd = grupo.getIdAd();
                
                if (grupo.getCepCurso() != null) {
                    this.nombreCurso = grupo.getCepCurso().getNomCurso();
                }
                
                if (grupo.getCepPersonal() != null && 
                    grupo.getCepPersonal().getIdEsc() != null &&
                    grupo.getCepPersonal().getIdEsc().getIdDir() != null) {
                    this.nombreDocente = grupo.getCepPersonal().getIdEsc().getIdDir().getNombreCompleto();
                }
                
                if (grupo.getCepCecCiclo() != null) {
                    this.nombreCiclo = grupo.getCepCecCiclo().getNomCiclo();
                }
                
                if (grupo.getCepCecNivel() != null) {
                    this.nombreNivel = grupo.getCepCecNivel().getNombreNivel();
                }
                
                if (grupo.getCepCecGrupoCurso() != null) {
                    this.nombreGrupo = grupo.getCepCecGrupoCurso().getNombre();
                }
            }
            
            // Alumno
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
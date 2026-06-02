package ejbCecomp.clases;

import ejbCecomp.entidades.*;
import lombok.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ejbCcoGrupoDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    // Datos del grupo (cep_curso_docente)
    private ejbCcoCepCursoDocente grupo;
    private Integer idAd;
    private Date fecha;
    private Date fechaFin;
    private Boolean estado;
    private Boolean cerraAper;
    
    // Datos del docente (cep_personal)
    private Integer idPersonal;
    private String nombreDocente;
    private String especialidadDocente;
    
    // Datos del curso (cep_curso)
    private Integer idCurso;
    private String nombreCurso;
    private String abreviaturaCurso;
    
    // Datos del ciclo (cep_cec_ciclo)
    private Integer idCiclo;
    private String nombreCiclo;
    
    // Datos del nivel (cep_cec_nivel)
    private Integer idNivel;
    private String nombreNivel;
    
    // Datos del grupo curso (cep_cec_grupo_curso)
    private Integer idGrupo;
    private String nombreGrupo;
    
    public ejbCcoGrupoDTO(ejbCcoCepCursoDocente grupo) {
        this.grupo = grupo;
        
        if (grupo != null) {
            this.idAd = grupo.getIdAd();
            this.fecha = grupo.getFecha();
            this.fechaFin = grupo.getFechaFin();
            this.estado = grupo.getEstado();
            this.cerraAper = grupo.getCerraAper();
            
            // Docente
            if (grupo.getCepPersonal() != null) {
                this.idPersonal = grupo.getCepPersonal().getIdPersonal();
                if (grupo.getCepPersonal().getIdEsc() != null && 
                    grupo.getCepPersonal().getIdEsc().getIdDir() != null) {
                    this.nombreDocente = grupo.getCepPersonal().getIdEsc().getIdDir().getNombreCompleto();
                    this.especialidadDocente = grupo.getCepPersonal().getIdEsc().getEspecialidad();
                }
            }
            
            // Curso
            if (grupo.getCepCurso() != null) {
                this.idCurso = grupo.getCepCurso().getIdCurso();
                this.nombreCurso = grupo.getCepCurso().getNomCurso();
                this.abreviaturaCurso = grupo.getCepCurso().getAbreviatura();
            }
            
            // Ciclo
            if (grupo.getCepCecCiclo() != null) {
                this.idCiclo = grupo.getCepCecCiclo().getIdCiclo();
                this.nombreCiclo = grupo.getCepCecCiclo().getNomCiclo();
            }
            
            // Nivel
            if (grupo.getCepCecNivel() != null) {
                this.idNivel = grupo.getCepCecNivel().getIdNivel();
                this.nombreNivel = grupo.getCepCecNivel().getNombreNivel();
            }
            
            // Grupo Curso
            if (grupo.getCepCecGrupoCurso() != null) {
                this.idGrupo = grupo.getCepCecGrupoCurso().getIdGrupo();
                this.nombreGrupo = grupo.getCepCecGrupoCurso().getNombre();
            }
        }
    }
}
package ejbCecomp.clases;

import ejbCecomp.entidades.ejbCcoCepCurso;
import ejbCecomp.entidades.ejbCcoCepNivelModalidad;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ejbCcoCursoDTO {
    private ejbCcoCepCurso curso;
    private ejbCcoCepNivelModalidad nivel;
    private String nombreNivel;
    private String nombreCurso;
    private String duracion;
    private Boolean activo;
    private Integer idCurso;
    
    public ejbCcoCursoDTO(ejbCcoCepCurso curso) {
        this.curso = curso;
        this.idCurso = curso.getIdCurso();
        this.nombreCurso = curso.getNomCurso();
        this.duracion = curso.getDuracion();
        this.activo = curso.getBandera();
        
        if (curso.getCepNivelModalidad() != null) {
            this.nivel = curso.getCepNivelModalidad();
            this.nombreNivel = curso.getCepNivelModalidad().getNomNivMod();
        }
    }
    
        public String getNombreCurso() {
        return curso != null ? curso.getNomCurso() : "";
    }
    
    public String getDuracion() {
        return curso != null ? curso.getDuracion() : "";
    }
    
    public Boolean getActivo() {
        return curso != null ? curso.getBandera() : false;
    }
    
    public Integer getIdCurso() {
        return curso != null ? curso.getIdCurso() : null;
    }
}
package ejbCecomp.clases;

import ejbCecomp.entidades.*;
import lombok.*;
import java.io.Serializable;
import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ejbCcoCursoDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private ejbCcoCepCurso curso;
    private String nombreNivel;
    private String nombrePlan;
    
    public ejbCcoCursoDTO(ejbCcoCepCurso curso) {
        this.curso = curso;
        
        if (curso != null) {
            if (curso.getCepNivelModalidad() != null) {
                this.nombreNivel = curso.getCepNivelModalidad().getNomNivMod();
            }
            if (curso.getCepCecPlan() != null) {
                this.nombrePlan = curso.getCepCecPlan().getNomPland();
            }
        }
    }
}
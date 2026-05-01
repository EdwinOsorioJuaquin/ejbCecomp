package ejbCecomp.clases;

import ejbCecomp.entidades.ejbCcoCepCurso;
import ejbCecomp.entidades.ejbCcoCepNivelModalidad;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ejbCcoCursoDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private ejbCcoCepCurso curso;
    private ejbCcoCepNivelModalidad nivel;
    private String nombreNivel;
    private List<String> temas;

    public ejbCcoCursoDTO(ejbCcoCepCurso curso) {
        this.curso = curso;
        if (curso != null && curso.getCepNivelModalidad() != null) {
            this.nivel = curso.getCepNivelModalidad();
            this.nombreNivel = curso.getCepNivelModalidad().getNomNivMod();
        }
    }
}
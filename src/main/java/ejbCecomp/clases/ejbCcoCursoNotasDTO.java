package ejbCecomp.clases;

import ejbCecomp.entidades.ejbCcoCepCcoMatriculaCab;
import ejbCecomp.entidades.ejbCcoCepCursoDocente;
import lombok.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ejbCcoCursoNotasDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer idMtaAlu;
    private Integer idAd;
    private String nombreCurso;
    private String nombreGrupo;
    private Integer notaFinal;
    private String notaFinalFormateada;
    private List<ejbCcoNotasUnidadDTO> listaUnidades;
    
    public ejbCcoCursoNotasDTO(ejbCcoCepCcoMatriculaCab matricula) {
        if (matricula != null) {
            this.idMtaAlu = matricula.getIdMtaAlu();
            this.notaFinal = matricula.getNotaFinal();
            this.notaFinalFormateada = this.notaFinal != null ? String.valueOf(this.notaFinal) : "Pendiente";
            
            if (matricula.getCepCursoDocente() != null) {
                ejbCcoCepCursoDocente grupo = matricula.getCepCursoDocente();
                this.idAd = grupo.getIdAd();
                
                if (grupo.getCepCurso() != null) {
                    this.nombreCurso = grupo.getCepCurso().getNomCurso();
                }
                
                if (grupo.getCepCecGrupoCurso() != null) {
                    this.nombreGrupo = grupo.getCepCecGrupoCurso().getNombre();
                }
            }
            this.listaUnidades = new ArrayList<>();
        }
    }
}
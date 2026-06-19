package ejbCecomp.clases;

import ejbCecomp.entidades.ejbCcoCepCcoMatriculaCab;
import ejbCecomp.entidades.ejbCcoCepCursoDocente;
import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;
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
    private String modalidad;
    private BigDecimal notaFinal;
    private String notaFinalFormateada;
    private Integer totalTemas;
    private String promedioFormateado;
    private List<ejbCcoNotasUnidadDTO> listaUnidades;
    
    public ejbCcoCursoNotasDTO(ejbCcoCepCcoMatriculaCab matricula) {
        if (matricula != null) {
            this.idMtaAlu = matricula.getIdMtaAlu();
            
            if (matricula.getNotaFinal() != null) {
                this.notaFinal = BigDecimal.valueOf(matricula.getNotaFinal());
                this.notaFinalFormateada = String.format("%.1f", this.notaFinal);
            } else {
                this.notaFinal = null;
                this.notaFinalFormateada = "-";
            }
            
            if (matricula.getCepCursoDocente() != null) {
                ejbCcoCepCursoDocente grupo = matricula.getCepCursoDocente();
                this.idAd = grupo.getIdAd();
                
                if (grupo.getCepCurso() != null) {
                    this.nombreCurso = grupo.getCepCurso().getNomCurso();
                    if (grupo.getCepCurso().getCepNivelModalidad() != null) {
                        this.modalidad = grupo.getCepCurso().getCepNivelModalidad().getNomNivMod();
                    }
                }
                
                if (grupo.getCepCecGrupoCurso() != null) {
                    this.nombreGrupo = grupo.getCepCecGrupoCurso().getNombre();
                }
            }
            
            this.listaUnidades = new ArrayList<>();
            this.totalTemas = 0;
            this.promedioFormateado = "-";
        }
    }
    
    public void calcularPromedio() {
        if (listaUnidades != null && !listaUnidades.isEmpty()) {
            this.totalTemas = listaUnidades.size();

            int count = 0;
            double suma = 0;

            for (ejbCcoNotasUnidadDTO unidad : listaUnidades) {
                if (unidad.isTieneNota() && unidad.getNota() != null) {
                    suma += unidad.getNota();
                    count++;
                }
            }

            if (count > 0) {
                double promedio = suma / count;
                // Redondear a entero
                long redondeado = Math.round(promedio);
                this.promedioFormateado = String.valueOf(redondeado);
            } else {
                this.promedioFormateado = "-";
            }
        } else {
            this.totalTemas = 0;
            this.promedioFormateado = "-";
        }
    }
}
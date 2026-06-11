package ejbCecomp.clases;

import ejbCecomp.entidades.ejbCcoCepCcoMatriculaCab;
import ejbCecomp.entidades.ejbCcoCepCursoDocente;
import ejbCecomp.entidades.ejbCcoCepHorarioDia;
import lombok.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ejbCcoSolicitarCertificadoDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer idMtaAlu;
    private Integer notaFinal;
    private String nombreCurso;
    private String nombreGrupo;
    private String fechaInicio;
    private String fechaFin;
    private String horarios;
    private boolean tieneCertificado;
    
    public ejbCcoSolicitarCertificadoDTO(ejbCcoCepCcoMatriculaCab matricula, boolean tieneCertificado) {
        if (matricula != null) {
            this.idMtaAlu = matricula.getIdMtaAlu();
            this.notaFinal = matricula.getNotaFinal();
            this.tieneCertificado = tieneCertificado;
            
            if (matricula.getCepCursoDocente() != null) {
                ejbCcoCepCursoDocente grupo = matricula.getCepCursoDocente();
                
                if (grupo.getCepCurso() != null) {
                    this.nombreCurso = grupo.getCepCurso().getNomCurso();
                }
                
                if (grupo.getCepCecGrupoCurso() != null) {
                    this.nombreGrupo = grupo.getCepCecGrupoCurso().getNombre();
                }
                
                if (grupo.getFecha() != null) {
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    this.fechaInicio = sdf.format(grupo.getFecha());
                } else {
                    this.fechaInicio = "";
                }
                
                if (grupo.getFechaFin() != null) {
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    this.fechaFin = sdf.format(grupo.getFechaFin());
                } else {
                    this.fechaFin = "";
                }
                
                if (grupo.getCepHorarioDiaList() != null && !grupo.getCepHorarioDiaList().isEmpty()) {
                    StringBuilder sb = new StringBuilder();
                    for (ejbCcoCepHorarioDia horario : grupo.getCepHorarioDiaList()) {
                        if (horario.getCepHorarioHora() != null) {
                            String dia = getDiaSemana(horario.getDia());
                            sb.append(dia).append(" ");
                            sb.append(horario.getCepHorarioHora().getNomHora());
                            sb.append(" | ");
                        }
                    }
                    this.horarios = sb.length() > 0 ? sb.substring(0, sb.length() - 3) : "No definido";
                } else {
                    this.horarios = "No definido";
                }
            }
        }
    }
    
    private String getDiaSemana(Short dia) {
        if (dia == null) return "";
        switch (dia) {
            case 1: return "Lunes";
            case 2: return "Martes";
            case 3: return "Miércoles";
            case 4: return "Jueves";
            case 5: return "Viernes";
            case 6: return "Sábado";
            case 7: return "Domingo";
            default: return "Día " + dia;
        }
    }
}
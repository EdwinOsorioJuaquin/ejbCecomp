package ejbCecomp.clases;

import ejbCecomp.entidades.ejbCcoCepCursoDocente;
import ejbCecomp.entidades.ejbCcoCepGrupoPrecio;
import ejbCecomp.entidades.ejbCcoCepHorarioDia;
import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ejbCcoGrupoAlumnoDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private ejbCcoCepCursoDocente grupo;
    private Integer idAd;
    private String nombreCurso;
    private BigDecimal precio;
    private String codigoPago;
    private String costoFormateado;
    private String fechaInicioFormateada;
    private String fechaFinFormateada;
    private String horariosFormateados;
    private String tipoDesarrollo;
    private String nivelModalidad;
    private String nombreGrupo;
    private boolean seleccionado;

    public boolean isSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(boolean seleccionado) {
        this.seleccionado = seleccionado;
    }
    
    public ejbCcoGrupoAlumnoDTO(ejbCcoCepCursoDocente grupo) {
        this.grupo = grupo;
        
        if (grupo != null) {
            this.idAd = grupo.getIdAd();
            
            // Nombre del curso
            if (grupo.getCepCurso() != null) {
                this.nombreCurso = grupo.getCepCurso().getNomCurso();
                if (grupo.getCepCurso().getCepNivelModalidad() != null) {
                    this.nivelModalidad = grupo.getCepCurso().getCepNivelModalidad().getNomNivMod();
                }
            }
            
            // Precio (tomar el primero de la lista)
            if (grupo.getCepGrupoPrecioList() != null && !grupo.getCepGrupoPrecioList().isEmpty()) {
                ejbCcoCepGrupoPrecio precioObj = grupo.getCepGrupoPrecioList().get(0);
                this.precio = precioObj.getMonto();
                this.codigoPago = precioObj.getCodigoPago();
                this.costoFormateado = String.format("S/ %,.2f", precioObj.getMonto());
            } else {
                this.costoFormateado = "Consultar";
            }
            
            // Fechas
            if (grupo.getFecha() != null) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                this.fechaInicioFormateada = sdf.format(grupo.getFecha());
            } else {
                this.fechaInicioFormateada = "Por definir";
            }
            
            if (grupo.getFechaFin() != null) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                this.fechaFinFormateada = sdf.format(grupo.getFechaFin());
            } else {
                this.fechaFinFormateada = "Por definir";
            }
            
            // Horarios
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
                this.horariosFormateados = sb.length() > 0 ? sb.substring(0, sb.length() - 3) : "No definido";
            } else {
                this.horariosFormateados = "No definido";
            }
            
            // Tipo desarrollo
            if (grupo.getCepCecTipoDesarrollo() != null) {
                this.tipoDesarrollo = grupo.getCepCecTipoDesarrollo().getNombreDesarrollo();
            } else {
                this.tipoDesarrollo = "No especificado";
            }
            
            // Nombre del grupo
            if (grupo.getCepCecGrupoCurso() != null) {
                this.nombreGrupo = grupo.getCepCecGrupoCurso().getNombre();
            } else {
                this.nombreGrupo = "";
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
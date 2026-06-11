package ejbCecomp.clases;

import ejbCecomp.entidades.*;
import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ejbCcoGrupoDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    // Datos del grupo
    private ejbCcoCepCursoDocente grupo;
    private Integer idAd;
    private Date fecha;
    private Date fechaFin;
    private Boolean estado;
    private Boolean cerraAper;
    private String nombreTipoDesarrollo;
    
    // Datos del docente
    private Integer idPersonal;
    private String nombreDocente;
    private String especialidadDocente;
    
    // Datos del curso
    private Integer idCurso;
    private String nombreCurso;
    private String abreviaturaCurso;
    
    // Datos del grupo curso
    private Integer idGrupo;
    private String nombreGrupo;
    
    // ========== PRECIOS (tomar el primero de la lista) ==========
    private BigDecimal precio;
    private String codigoPago;
    
    public ejbCcoGrupoDTO(ejbCcoCepCursoDocente grupo) {
        this.grupo = grupo;
        
        if (grupo != null) {
            this.idAd = grupo.getIdAd();
            this.fecha = grupo.getFecha();
            this.fechaFin = grupo.getFechaFin();
            this.estado = grupo.getEstado();
            this.cerraAper = grupo.getCerraAper();
            
            // Tipo Desarrollo
            if (grupo.getCepCecTipoDesarrollo() != null) {
                this.nombreTipoDesarrollo = grupo.getCepCecTipoDesarrollo().getNombreDesarrollo();
            }
            
            // Docente
            if (grupo.getCepPersonal() != null) {
                this.idPersonal = grupo.getCepPersonal().getIdPersonal();
                if (grupo.getCepPersonal().getEscPersonal() != null && 
                    grupo.getCepPersonal().getEscPersonal().getDrtPersonanatural() != null) {
                    this.nombreDocente = grupo.getCepPersonal().getEscPersonal().getDrtPersonanatural().getNombreCompleto();
                    this.especialidadDocente = grupo.getCepPersonal().getEscPersonal().getEspecialidad();
                }
            }
            
            // Curso
            if (grupo.getCepCurso() != null) {
                this.idCurso = grupo.getCepCurso().getIdCurso();
                this.nombreCurso = grupo.getCepCurso().getNomCurso();
                this.abreviaturaCurso = grupo.getCepCurso().getAbreviatura();
            }
            
            // Grupo Curso
            if (grupo.getCepCecGrupoCurso() != null) {
                this.idGrupo = grupo.getCepCecGrupoCurso().getIdGrupo();
                this.nombreGrupo = grupo.getCepCecGrupoCurso().getNombre();
            }
            
            // ========== PRECIO (tomar el primero de la lista) ==========
            if (grupo.getCepGrupoPrecioList() != null && !grupo.getCepGrupoPrecioList().isEmpty()) {
                ejbCcoCepGrupoPrecio precioObj = grupo.getCepGrupoPrecioList().get(0);
                this.precio = precioObj.getMonto();
                this.codigoPago = precioObj.getCodigoPago();
            }
        }
    }
    
    public String getPrecioFormateado() {
        return precio != null ? String.format("S/ %,.2f", precio) : "S/ 0.00";
    }
    
    public String getFechaFormateada() {
        if (fecha != null) {
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
            return sdf.format(fecha);
        }
        return "";
    }
    
    public String getFechaFinFormateada() {
        if (fechaFin != null) {
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
            return sdf.format(fechaFin);
        }
        return "";
    }
    
    public String getEstadoTexto() {
        return estado != null && estado ? "ACTIVO" : "INACTIVO";
    }
}
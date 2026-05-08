package ejbCecomp.clases;

import ejbCecomp.entidades.*;
import lombok.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ejbCcoDocenteGeneralDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    // Datos de la persona natural
    private String dni;
    private String nombreCompleto;
    private String email;
    private String telefono;
    private String celular;
    private String direccion;
    private Date fechaNacimiento;
    
    // Datos del docente (esc_personal)
    private Integer idEsc;
    private Date fechaIng;
    private Integer condicion;
    private String especialidad;
    private String ruc;
    private String estado;
    
    public ejbCcoDocenteGeneralDTO(ejbCcoEscPersonal docente) {
        if (docente != null) {
            this.idEsc = docente.getIdEsc();
            this.fechaIng = docente.getFechaIng();
            this.condicion = docente.getCondicion();
            this.especialidad = docente.getEspecialidad();
            this.ruc = docente.getRuc();
            this.estado = (docente.getCondicion() != null && docente.getCondicion() == 1) ? "ACTIVO" : "INACTIVO";
            
            if (docente.getDrtPersonanatural() != null) {
                ejbCcoDrtPersonanatural persona = docente.getDrtPersonanatural();
                this.dni = persona.getNumeroPndid();
                this.nombreCompleto = persona.getNombreCompleto();
                this.email = persona.getEmailPrin();
                this.telefono = persona.getTelefonoPrin();
                this.celular = persona.getCelularPrin();
                this.direccion = persona.getDireccion();
                this.fechaNacimiento = persona.getFechaNac();
            }
        }
    }
}
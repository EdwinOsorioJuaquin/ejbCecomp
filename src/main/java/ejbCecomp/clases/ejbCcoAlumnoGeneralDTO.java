package ejbCecomp.clases;

import ejbCecomp.entidades.*;
import lombok.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ejbCcoAlumnoGeneralDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String tipo;           // "EXTERNO" o "UNIVERSIDAD"
    private String dni;
    private String nombreCompleto;
    private String email;
    private String celular;
    private String estado;          // "ACTIVO" o "INACTIVO"
    
    // Para externos
    private String correoLogin;
    
    // Para universidad
    private String codigoEstudiante;
    private String cicloNumero;
    
    public ejbCcoAlumnoGeneralDTO(ejbCcoCcoAlumnoExterno alumno) {
        this.tipo = "EXTERNO";
        
        if (alumno != null) {
            this.correoLogin = alumno.getCorreoLogin();
            this.estado = (alumno.getActivo() != null && alumno.getActivo() == 1) ? "ACTIVO" : "INACTIVO";
            
            if (alumno.getDrtPersonanatural() != null) {
                ejbCcoDrtPersonanatural persona = alumno.getDrtPersonanatural();
                this.dni = persona.getNumeroPndid();
                this.nombreCompleto = persona.getNombreCompleto();
                this.email = persona.getEmailPrin();
                this.celular = persona.getCelularPrin();
            }
        }
    }
    
    public ejbCcoAlumnoGeneralDTO(ejbCcoFxaEstudiante estudiante) {
        this.tipo = "UNIVERSIDAD";
        
        if (estudiante != null) {
            this.codigoEstudiante = estudiante.getCodigoEstudiante();
            this.cicloNumero = estudiante.getCicloNumero();
            this.estado = (estudiante.getActivo() != null && estudiante.getActivo() == 1) ? "ACTIVO" : "INACTIVO";
            
            if (estudiante.getDrtPersonanatural() != null) {
                ejbCcoDrtPersonanatural persona = estudiante.getDrtPersonanatural();
                this.dni = persona.getNumeroPndid();
                this.nombreCompleto = persona.getNombreCompleto();
                this.email = persona.getEmailPrin();
                this.celular = persona.getCelularPrin();
            }
        }
    }
}
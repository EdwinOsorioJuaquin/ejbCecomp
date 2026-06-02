package ejbCecomp.clases;

import ejbCecomp.entidades.*;
import lombok.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ejbCcoAlumnoExternoDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    // Datos del alumno externo
    private ejbCcoCcoAlumnoExterno alumno;
    
    // Datos de la persona natural (para mostrar en tablas)
    private String nombreCompleto;
    private String dni;
    private String email;
    private String telefono;
    private String celular;
    private String direccion;
    private Date fechaNacimiento;
    private Character sexo;
    
    public ejbCcoAlumnoExternoDTO(ejbCcoCcoAlumnoExterno alumno) {
        this.alumno = alumno;
        
        if (alumno != null && alumno.getDrtPersonanatural() != null) {
            ejbCcoDrtPersonanatural persona = alumno.getDrtPersonanatural();
            this.nombreCompleto = persona.getNombreCompleto();
            this.dni = persona.getNumeroPndid();
            this.email = persona.getEmailPrin();
            this.telefono = persona.getTelefonoPrin();
            this.celular = persona.getCelularPrin();
            this.direccion = persona.getDireccion();
            this.fechaNacimiento = persona.getFechaNac();
            this.sexo = persona.getSexo();
        }
    }
}
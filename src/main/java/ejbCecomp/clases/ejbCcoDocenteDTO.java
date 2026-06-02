package ejbCecomp.clases;

import ejbCecomp.entidades.*;
import lombok.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ejbCcoDocenteDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    // Datos de persona natural (drt_personanatural)
    private ejbCcoDrtPersonanatural persona;
    private String dni;
    private String nombreCompleto;
    private String email;
    private String celular;
    private String direccion;
    private Date fechaNacimiento;
    private Character sexo;
    
    // Datos de esc_personal
    private ejbCcoEscPersonal escPersonal;
    private Integer idEsc;
    private Integer idTipo;  // id_tipo de esc_personal (tipo de personal universitario)
    private String especialidad;
    private Date fechaIngUniv;
    private Integer condicionEsc;
    
    // Datos de cep_personal
    private ejbCcoCepPersonal cepPersonal;
    private Integer idPersonal;
    private Date fechaIngCecomp;
    private Short idTipoCecomp;
    private String tipoCecompNombre;
    private Boolean bandera;
    private String estado;
    
    public ejbCcoDocenteDTO(ejbCcoCepPersonal cepPersonal) {
        this.cepPersonal = cepPersonal;
        
        if (cepPersonal != null) {
            this.idPersonal = cepPersonal.getIdPersonal();
            this.fechaIngCecomp = cepPersonal.getFechaIng();
            this.bandera = cepPersonal.getBandera();
            this.estado = (cepPersonal.getBandera() != null && cepPersonal.getBandera()) ? "ACTIVO" : "INACTIVO";
            
            // Obtener tipo CEcomp
            if (cepPersonal.getIdTipoCecomp() != null) {
                this.idTipoCecomp = cepPersonal.getIdTipoCecomp().getIdTipoCecomp();
                this.tipoCecompNombre = cepPersonal.getIdTipoCecomp().getNombre();
            }
            
            // Obtener esc_personal
            if (cepPersonal.getIdEsc() != null) {
                this.escPersonal = cepPersonal.getIdEsc();
                this.idEsc = escPersonal.getIdEsc();
                this.idTipo = escPersonal.getIdTipo();
                this.especialidad = escPersonal.getEspecialidad();
                this.fechaIngUniv = escPersonal.getFechaIng();
                this.condicionEsc = escPersonal.getCondicion();
                
                // Obtener persona natural
                if (escPersonal.getIdDir() != null) {
                    this.persona = escPersonal.getIdDir();
                    this.dni = persona.getNumeroPndid();
                    this.nombreCompleto = persona.getNombreCompleto();
                    this.email = persona.getEmailPrin();
                    this.celular = persona.getCelularPrin();
                    this.direccion = persona.getDireccion();
                    this.fechaNacimiento = persona.getFechaNac();
                    this.sexo = persona.getSexo();
                }
            }
        }
    }
}
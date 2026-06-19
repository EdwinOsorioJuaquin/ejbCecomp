package ejbCecomp.clases;

import ejbCecomp.entidades.ejbCcoCepCecNotas;
import ejbCecomp.entidades.ejbCcoCepCecSesion;
import lombok.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ejbCcoNotasUnidadDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer idSesio;
    private String nombreUnidad;
    private Integer nota;
    private boolean tieneNota;
    
    public ejbCcoNotasUnidadDTO(ejbCcoCepCecSesion sesion, ejbCcoCepCecNotas notaEntity) {
        this.idSesio = sesion.getCepCecSesionPK().getIdSesio();
        this.nombreUnidad = sesion.getNombreSesion() != null ? sesion.getNombreSesion() : "Unidad " + this.idSesio;
        
        if (notaEntity != null && notaEntity.getNota() != null) {
            this.nota = notaEntity.getNota();
            this.tieneNota = true;
        } else {
            this.nota = null;
            this.tieneNota = false;
        }
    }
}
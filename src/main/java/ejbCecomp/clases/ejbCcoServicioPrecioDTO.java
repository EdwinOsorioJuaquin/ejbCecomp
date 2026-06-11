package ejbCecomp.clases;

import ejbCecomp.entidades.ejbCcoCepServicioPrecio;
import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ejbCcoServicioPrecioDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String tipoServicio;
    private String nombreServicio;
    private BigDecimal monto;
    private String codigoPago;
    
    public ejbCcoServicioPrecioDTO(ejbCcoCepServicioPrecio precio) {
        if (precio != null) {
            this.tipoServicio = precio.getTipoServicio();
            this.monto = precio.getMonto();
            this.codigoPago = precio.getCodigoPago();
            this.nombreServicio = getNombreServicioFromTipo(precio.getTipoServicio());
        }
    }
    
    private String getNombreServicioFromTipo(String tipoServicio) {
        if (tipoServicio == null) return "";
        switch (tipoServicio) {
            case "CERTIFICADO": return "Certificado de Estudios";
            case "DUPLICADO_CERTIFICADO": return "Duplicado de Certificado";
            case "DUPLICADO_NOTA": return "Duplicado de Notas";
            case "EXAMEN_SUFICIENCIA": return "Examen de Suficiencia";
            case "EXAMEN_EXTEMPORANEO": return "Examen Extemporáneo";
            default: return tipoServicio;
        }
    }
    
    public String getMontoFormateado() {
        return monto != null ? String.format("S/ %,.2f", monto) : "S/ 0.00";
    }
}
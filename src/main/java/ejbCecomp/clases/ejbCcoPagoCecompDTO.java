package ejbCecomp.clases;

import ejbCecomp.entidades.ejbCcoVtCecompPagos;
import lombok.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ejbCcoPagoCecompDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private ejbCcoVtCecompPagos pago;
    private String fechaFormateada;
    private String montoFormateado;
    
    //Para selección en matrícula y/o certificado
    private boolean seleccionado;
    
    public ejbCcoPagoCecompDTO(ejbCcoVtCecompPagos pago) {
        this.pago = pago;
        this.seleccionado = false;  // Inicialmente no seleccionado
        
        if (pago != null) {
            // Formatear fecha
            if (pago.getFechaPago() != null) {
                this.fechaFormateada = pago.getFechaPago();
            } else {
                this.fechaFormateada = "";
            }
            
            // Formatear monto
            if (pago.getMonto() != null) {
                this.montoFormateado = String.format("S/ %,.2f", pago.getMonto().doubleValue());
            } else {
                this.montoFormateado = "S/ 0.00";
            }
        }
    }
}
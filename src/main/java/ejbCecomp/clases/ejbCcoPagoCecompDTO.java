package ejbCecomp.clases;

import ejbCecomp.entidades.ejbCcoVwCecompPagos;
import lombok.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ejbCcoPagoCecompDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private ejbCcoVwCecompPagos pago;
    private String fechaFormateada;
    private String montoFormateado;
    
    public ejbCcoPagoCecompDTO(ejbCcoVwCecompPagos pago) {
        this.pago = pago;
        
        if (pago != null) {
            System.out.println("=== DTO Constructor ===");
            System.out.println("  Pago ID: " + pago.getIdNumPago());
            
            // Formatear fecha
            if (pago.getFechaPago() != null) {
                this.fechaFormateada = pago.getFechaPago();
                System.out.println("  fechaFormateada: " + this.fechaFormateada);
            } else {
                this.fechaFormateada = "";
                System.out.println("  fechaFormateada: vacío (fechaPago es null)");
            }
            
            // Formatear monto
            if (pago.getMonto() != null) {
                this.montoFormateado = String.format("S/ %,.2f", pago.getMonto().doubleValue());
                System.out.println("  montoFormateado: " + this.montoFormateado);
            } else {
                this.montoFormateado = "S/ 0.00";
                System.out.println("  montoFormateado: S/ 0.00 (monto es null)");
            }
            System.out.println("=====================");
        } else {
            System.out.println("=== DTO Constructor: pago es NULL ===");
        }
    }
}
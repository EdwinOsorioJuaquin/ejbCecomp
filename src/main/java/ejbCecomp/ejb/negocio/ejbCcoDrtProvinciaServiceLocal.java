package ejbCecomp.ejb.negocio;

import ejbCecomp.entidades.ejbCcoDrtProvincia;
import jakarta.ejb.Local;

@Local
public interface ejbCcoDrtProvinciaServiceLocal {
    ejbCcoDrtProvincia buscarPorId(int idPais, int idDpto, int idProv);
}
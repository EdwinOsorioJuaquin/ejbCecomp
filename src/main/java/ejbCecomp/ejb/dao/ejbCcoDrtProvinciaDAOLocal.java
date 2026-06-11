package ejbCecomp.ejb.dao;

import ejbCecomp.entidades.ejbCcoDrtProvincia;
import jakarta.ejb.Local;

@Local
public interface ejbCcoDrtProvinciaDAOLocal extends ejbCcoGenericoDAOLocal<ejbCcoDrtProvincia> {
    ejbCcoDrtProvincia buscarPorId(int idPais, int idDpto, int idProv);
}
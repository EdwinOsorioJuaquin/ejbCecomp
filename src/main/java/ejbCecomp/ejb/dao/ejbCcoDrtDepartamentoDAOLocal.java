package ejbCecomp.ejb.dao;

import ejbCecomp.entidades.ejbCcoDrtDepartamento;
import jakarta.ejb.Local;

@Local
public interface ejbCcoDrtDepartamentoDAOLocal extends ejbCcoGenericoDAOLocal<ejbCcoDrtDepartamento> {
    ejbCcoDrtDepartamento buscarPorId(int idPais, int idDpto);
}
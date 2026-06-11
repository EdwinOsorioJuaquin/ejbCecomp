package ejbCecomp.ejb.dao;

import ejbCecomp.entidades.ejbCcoDrtDistrito;
import jakarta.ejb.Local;
import java.util.List;

@Local
public interface ejbCcoDrtDistritoDAOLocal extends ejbCcoGenericoDAOLocal<ejbCcoDrtDistrito> {
    List<ejbCcoDrtDistrito> listarTodos();
    ejbCcoDrtDistrito buscarPorIdUbg(Integer idUbg);
    ejbCcoDrtDistrito buscarPorId(Integer idPais, Integer idDpto, Integer idProv, Integer idDistrito);
}
package ejbCecomp.ejb.negocio;

import ejbCecomp.entidades.ejbCcoDrtDistrito;
import jakarta.ejb.Local;
import java.util.List;

@Local
public interface ejbCcoDrtDistritoServiceLocal {
    List<ejbCcoDrtDistrito> listarTodos();
    ejbCcoDrtDistrito buscarPorIdUbg(Integer idUbg);
    ejbCcoDrtDistrito buscarPorId(Integer idPais, Integer idDpto, Integer idProv, Integer idDistrito);
}
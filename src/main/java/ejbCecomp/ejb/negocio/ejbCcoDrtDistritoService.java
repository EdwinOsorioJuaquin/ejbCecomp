package ejbCecomp.ejb.negocio;

import ejbCecomp.ejb.dao.ejbCcoDrtDistritoDAOLocal;
import ejbCecomp.entidades.ejbCcoDrtDistrito;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import java.util.List;

@Stateless
public class ejbCcoDrtDistritoService implements ejbCcoDrtDistritoServiceLocal {

    @EJB
    private ejbCcoDrtDistritoDAOLocal dao;

    @Override
    public List<ejbCcoDrtDistrito> listarTodos() {
        return dao.listarTodos();
    }

    @Override
    public ejbCcoDrtDistrito buscarPorIdUbg(Integer idUbg) {
        return dao.buscarPorIdUbg(idUbg);
    }

    @Override
    public ejbCcoDrtDistrito buscarPorId(Integer idPais, Integer idDpto, Integer idProv, Integer idDistrito) {
        return dao.buscarPorId(idPais, idDpto, idProv, idDistrito);
    }
}
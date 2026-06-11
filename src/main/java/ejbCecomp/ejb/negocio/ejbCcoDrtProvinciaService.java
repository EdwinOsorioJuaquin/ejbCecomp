package ejbCecomp.ejb.negocio;

import ejbCecomp.ejb.dao.ejbCcoDrtProvinciaDAOLocal;
import ejbCecomp.entidades.ejbCcoDrtProvincia;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

@Stateless
public class ejbCcoDrtProvinciaService implements ejbCcoDrtProvinciaServiceLocal {

    @EJB
    private ejbCcoDrtProvinciaDAOLocal dao;

    @Override
    public ejbCcoDrtProvincia buscarPorId(int idPais, int idDpto, int idProv) {
        return dao.buscarPorId(idPais, idDpto, idProv);
    }
}
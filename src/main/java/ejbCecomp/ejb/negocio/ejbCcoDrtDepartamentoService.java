package ejbCecomp.ejb.negocio;

import ejbCecomp.ejb.dao.ejbCcoDrtDepartamentoDAOLocal;
import ejbCecomp.entidades.ejbCcoDrtDepartamento;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

@Stateless
public class ejbCcoDrtDepartamentoService implements ejbCcoDrtDepartamentoServiceLocal {

    @EJB
    private ejbCcoDrtDepartamentoDAOLocal dao;

    @Override
    public ejbCcoDrtDepartamento buscarPorId(int idPais, int idDpto) {
        return dao.buscarPorId(idPais, idDpto);
    }
}
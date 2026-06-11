package ejbCecomp.ejb.dao;

import ejbCecomp.entidades.ejbCcoDrtDepartamento;
import ejbCecomp.entidades.ejbCcoDrtDepartamentoPK;
import jakarta.ejb.Stateless;
import jakarta.persistence.TypedQuery;

@Stateless
public class ejbCcoDrtDepartamentoDAO extends ejbCcoGenericoDAO<ejbCcoDrtDepartamento> implements ejbCcoDrtDepartamentoDAOLocal {

    @Override
    public ejbCcoDrtDepartamento buscarPorId(int idPais, int idDpto) {
        try {
            ejbCcoDrtDepartamentoPK pk = new ejbCcoDrtDepartamentoPK(idPais, idDpto);
            return em.find(ejbCcoDrtDepartamento.class, pk);
        } catch (Exception e) {
            System.out.println("Error buscarPorId: " + e.getMessage());
            return null;
        }
    }
}
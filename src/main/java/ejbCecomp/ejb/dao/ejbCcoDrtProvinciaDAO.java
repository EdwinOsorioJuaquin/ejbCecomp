package ejbCecomp.ejb.dao;

import ejbCecomp.entidades.ejbCcoDrtProvincia;
import ejbCecomp.entidades.ejbCcoDrtProvinciaPK;
import jakarta.ejb.Stateless;
import jakarta.persistence.TypedQuery;

@Stateless
public class ejbCcoDrtProvinciaDAO extends ejbCcoGenericoDAO<ejbCcoDrtProvincia> implements ejbCcoDrtProvinciaDAOLocal {

    @Override
    public ejbCcoDrtProvincia buscarPorId(int idPais, int idDpto, int idProv) {
        try {
            ejbCcoDrtProvinciaPK pk = new ejbCcoDrtProvinciaPK(idPais, idDpto, idProv);
            return em.find(ejbCcoDrtProvincia.class, pk);
        } catch (Exception e) {
            System.out.println("Error buscarPorId: " + e.getMessage());
            return null;
        }
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/StatelessEjbClass.java to edit this template
 */
package ejbCecomp.ejb.dao;

import ejbCecomp.entidades.ejbCcoCepCecHistorico;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

/**
 *
 * @author Edwin
 */
@Stateless
public class ejbCcoCepCecHistoricoDAO extends ejbCcoGenericoDAO<ejbCcoCepCecHistorico> implements ejbCcoCepCecHistoricoDAOLocal {
        
    @Override
    public ejbCcoCepCecHistorico buscarPorIdCert(Integer idCert) {

        try {

            return em.createQuery(
                    "SELECT h FROM CepCecHistorico h "
                    + "WHERE h.idCert = :idCert",
                    ejbCcoCepCecHistorico.class
            )
            .setParameter("idCert", idCert)
            .setMaxResults(1)
            .getSingleResult();

        } catch (Exception e) {

            return null;
        }
    }
    
}

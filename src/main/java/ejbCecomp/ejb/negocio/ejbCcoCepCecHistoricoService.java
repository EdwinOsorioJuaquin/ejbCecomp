/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/StatelessEjbClass.java to edit this template
 */
package ejbCecomp.ejb.negocio;

import ejbCecomp.ejb.dao.*;
import ejbCecomp.entidades.*;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

/**
 *
 * @author Edwin
 */
@Stateless
public class ejbCcoCepCecHistoricoService implements ejbCcoCepCecHistoricoServiceLocal {

    @EJB
    private ejbCcoCepCecHistoricoDAOLocal dao;
    
    @Override
    public ejbCcoCepCecHistorico buscarPorIdCert(Integer idCert) {
        return dao.buscarPorIdCert(idCert);
    }
}

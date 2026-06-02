/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/StatelessEjbClass.java to edit this template
 */
package ejbCecomp.ejb.dao;

import ejbCecomp.clases.ejbCcoCertificadoPendiente;
import jakarta.ejb.Stateless;
import java.util.List;

/**
 *
 * @author Edwin
 */
@Stateless
public class ejbCcoCepCecCertificadoDAO implements ejbCcoCepCecCertificadoDAOLocal {

    @Override
    public List<ejbCcoCertificadoPendiente> listarPendientesQR() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

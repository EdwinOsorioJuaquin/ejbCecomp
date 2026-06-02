/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/StatelessEjbClass.java to edit this template
 */
package ejbCecomp.ejb.negocio;

import ejbCecomp.ejb.dao.ejbCcoCcoCertificadoQrDAOLocal;
import ejbCecomp.entidades.ejbCcoCcoCertificadoQr;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

/**
 *
 * @author Edwin
 */
@Stateless
public class ejbCcoCcoCertificadoQrService implements ejbCcoCcoCertificadoQrServiceLocal {

    @EJB
    private ejbCcoCcoCertificadoQrDAOLocal dao;
    
     @Override
    public void guardarQR(ejbCcoCcoCertificadoQr qr) {

        dao.guardar(qr);
    }

    @Override
    public ejbCcoCcoCertificadoQr buscarPorCodigo(String codigo) {

        return dao.buscarPorCodigo(codigo);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/SessionLocal.java to edit this template
 */
package ejbCecomp.ejb.negocio;

import ejbCecomp.entidades.ejbCcoCcoCertificadoQr;
import jakarta.ejb.Local;

/**
 *
 * @author Edwin
 */
@Local
public interface ejbCcoCcoCertificadoQrServiceLocal {
    void guardarQR(ejbCcoCcoCertificadoQr qr);

    ejbCcoCcoCertificadoQr buscarPorCodigo(String codigo);
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/SessionLocal.java to edit this template
 */
package ejbCecomp.ejb.negocio;

import ejbCecomp.clases.ejbCcoCertificadoPendiente;
import ejbCecomp.entidades.ejbCcoCcoCertificadoQr;
import jakarta.ejb.Local;
import java.util.List;

/**
 *
 * @author Edwin
 */
@Local
public interface ejbCcoCcoCertificadoQrServiceLocal {
    void guardarQR(ejbCcoCcoCertificadoQr qr);

    ejbCcoCcoCertificadoQr buscarPorCodigo(String codigo);

    List<ejbCcoCertificadoPendiente> listarPendientesQr();

    boolean guardarQr(
            Integer idCertificado,
            String codigoQr,
            String urlValidacion,
            byte[] imagenQr);
    ejbCcoCcoCertificadoQr buscarPorCertificado(Integer idCert);
}

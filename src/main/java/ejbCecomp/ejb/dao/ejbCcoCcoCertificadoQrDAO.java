/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/StatelessEjbClass.java to edit this template
 */
package ejbCecomp.ejb.dao;

import ejbCecomp.entidades.ejbCcoCcoCertificadoQr;
import jakarta.ejb.Stateless;
import jakarta.persistence.NoResultException;

/**
 *
 * @author Edwin
 */
@Stateless
public class ejbCcoCcoCertificadoQrDAO extends ejbCcoGenericoDAO<ejbCcoCcoCertificadoQr> implements ejbCcoCcoCertificadoQrDAOLocal {

    // =========================
    // GUARDAR
    // =========================
    @Override
    public void guardar(ejbCcoCcoCertificadoQr qr){

        em.persist(qr);
    }

    // =========================
    // BUSCAR POR CODIGO
    // =========================
    @Override
    public ejbCcoCcoCertificadoQr buscarPorCodigo(String codigo) {

        try {

            String jpql = """
                SELECT DISTINCT q
                FROM CcoCertificadoQr q
                LEFT JOIN FETCH q.idCertificado
                WHERE q.codigoQr = :codigo
            """;

            return em.createQuery(jpql, ejbCcoCcoCertificadoQr.class)
                    .setParameter("codigo", codigo)
                    .getSingleResult();

        } catch (NoResultException e) {
            return null;

        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }
    }
}

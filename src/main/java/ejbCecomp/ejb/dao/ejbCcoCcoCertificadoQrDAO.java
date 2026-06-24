/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/StatelessEjbClass.java to edit this template
 */
package ejbCecomp.ejb.dao;

import ejbCecomp.clases.ejbCcoCertificadoPendiente;
import ejbCecomp.entidades.ejbCcoCcoCertificadoQr;
import ejbCecomp.entidades.ejbCcoCepCecCert;
import ejbCecomp.entidades.ejbCcoCepCecHistorico;
import jakarta.ejb.Stateless;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @Override
    public List<ejbCcoCertificadoPendiente> listarPendientesQr() {

        List<ejbCcoCertificadoPendiente> lista = new ArrayList<>();

        try {

            String jpql =
                    "SELECT c, h " +
                    "FROM CepCecCert c, CepCecHistorico h " +
                    "WHERE c.idCert = h.idCertHis " +  // ← CORREGIDO: h.idCert → h.idCertHis
                    "AND c.estadoCert = false " +
                    "AND h.notaMatHis >= 14";

            List<Object[]> resultado =
                            em
                            .createQuery(jpql, Object[].class)
                            .getResultList();

            for (Object[] fila : resultado) {

                ejbCcoCepCecCert cert =
                        (ejbCcoCepCecCert) fila[0];

                ejbCcoCepCecHistorico hist =
                        (ejbCcoCepCecHistorico) fila[1];

                ejbCcoCertificadoPendiente dto =
                        new ejbCcoCertificadoPendiente();

                dto.setIdCert(cert.getIdCert());

                dto.setIdMatricula(
                        cert.getCepCcoMatriculaCab().getIdMtaAlu()
                );

                dto.setAlumno(
                        hist.getNombreCompletoHis()
                );

                dto.setNota(
                        hist.getNotaMatHis()
                );

                dto.setTieneQr(
                        existeQr(cert.getIdCert())
                );

                lista.add(dto);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return lista;
    }
    
    private Boolean existeQr(Integer idCert) {

        String jpql =
                "SELECT COUNT(q) " +
                "FROM CcoCertificadoQr q " +
                "WHERE q.idCertificado.idCert = :idCert";

        Long cantidad =
                        em
                        .createQuery(jpql, Long.class)
                        .setParameter("idCert", idCert)
                        .getSingleResult();

        return cantidad > 0;
    }
    
    @Override
    public boolean guardarQr(Integer idCertificado, String codigoQr, String urlValidacion, byte[] imagenQr) {
        try {
            // Obtener siguiente ID manualmente
            Query idQuery = em.createNativeQuery("SELECT ISNULL(MAX(id_qr), 0) + 1 FROM cco_certificado_qr");
            Integer nextId = (Integer) idQuery.getSingleResult();

            // Insert con Native Query
            Query insertQuery = em.createNativeQuery(
                "INSERT INTO cco_certificado_qr (id_qr, id_certificado, codigo_qr, url_validacion, fecha_generacion, estado, qr_imagen) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)"
            );

            insertQuery.setParameter(1, nextId);
            insertQuery.setParameter(2, idCertificado);
            insertQuery.setParameter(3, codigoQr);
            insertQuery.setParameter(4, urlValidacion);
            insertQuery.setParameter(5, new Date());
            insertQuery.setParameter(6, "GENERADO");
            insertQuery.setParameter(7, imagenQr);

            insertQuery.executeUpdate();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    @Override
    public ejbCcoCcoCertificadoQr buscarPorCertificado(Integer idCert) {

        try {

            String jpql =
                    "SELECT q " +
                    "FROM CcoCertificadoQr q " +
                    "WHERE q.idCertificado.idCert = :idCert";

            return em.createQuery(
                    jpql,
                    ejbCcoCcoCertificadoQr.class)
                    .setParameter("idCert", idCert)
                    .getSingleResult();

        } catch (Exception e) {

            return null;
        }
    }
}
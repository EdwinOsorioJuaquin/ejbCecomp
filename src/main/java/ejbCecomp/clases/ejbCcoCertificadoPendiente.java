/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejbCecomp.clases;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Edwin
 */
public class ejbCcoCertificadoPendiente implements Serializable{

    private Integer idCert;
    private Integer idMatricula;
    private String alumno;
    private Integer nota;
    private Boolean tieneQr;
    private String estadoQr;

    public String getEstadoQr() {
        return estadoQr;
    }

    public void setEstadoQr(String estadoQr) {
        this.estadoQr = estadoQr;
    }

    public Integer getIdCert() {
        return idCert;
    }

    public void setIdCert(Integer idCert) {
        this.idCert = idCert;
    }

    public Integer getIdMatricula() {
        return idMatricula;
    }

    public void setIdMatricula(Integer idMatricula) {
        this.idMatricula = idMatricula;
    }

    public String getAlumno() {
        return alumno;
    }

    public void setAlumno(String alumno) {
        this.alumno = alumno;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public Boolean getTieneQr() {
        return tieneQr;
    }

    public void setTieneQr(Boolean tieneQr) {
        this.tieneQr = tieneQr;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejbCecomp.entidades;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Jael
 */
@Entity(name = "FxaEstudiante")
@Table(name = "fxa_estudiante")
@NamedQueries({
    @NamedQuery(name = "FxaEstudiante.findAll", query = "SELECT f FROM FxaEstudiante f"),
    @NamedQuery(name = "FxaEstudiante.findByIdAcexp", query = "SELECT f FROM FxaEstudiante f WHERE f.idAcexp = :idAcexp"),
    @NamedQuery(name = "FxaEstudiante.findByIdAmbito", query = "SELECT f FROM FxaEstudiante f WHERE f.idAmbito = :idAmbito"),
    @NamedQuery(name = "FxaEstudiante.findByIdEspecialidad", query = "SELECT f FROM FxaEstudiante f WHERE f.idEspecialidad = :idEspecialidad"),
    @NamedQuery(name = "FxaEstudiante.findByIdPlancur", query = "SELECT f FROM FxaEstudiante f WHERE f.idPlancur = :idPlancur"),
    @NamedQuery(name = "FxaEstudiante.findByCodigoEstudiante", query = "SELECT f FROM FxaEstudiante f WHERE f.codigoEstudiante = :codigoEstudiante"),
    @NamedQuery(name = "FxaEstudiante.findByPromSeccion", query = "SELECT f FROM FxaEstudiante f WHERE f.promSeccion = :promSeccion"),
    @NamedQuery(name = "FxaEstudiante.findByCicloNumero", query = "SELECT f FROM FxaEstudiante f WHERE f.cicloNumero = :cicloNumero"),
    @NamedQuery(name = "FxaEstudiante.findByActivo", query = "SELECT f FROM FxaEstudiante f WHERE f.activo = :activo"),
    @NamedQuery(name = "FxaEstudiante.findByAnulado", query = "SELECT f FROM FxaEstudiante f WHERE f.anulado = :anulado"),
    @NamedQuery(name = "FxaEstudiante.findBySituacion", query = "SELECT f FROM FxaEstudiante f WHERE f.situacion = :situacion"),
    @NamedQuery(name = "FxaEstudiante.findByDateinsert", query = "SELECT f FROM FxaEstudiante f WHERE f.dateinsert = :dateinsert"),
    @NamedQuery(name = "FxaEstudiante.findByMigrado", query = "SELECT f FROM FxaEstudiante f WHERE f.migrado = :migrado"),
    @NamedQuery(name = "FxaEstudiante.findByCodNivAcad", query = "SELECT f FROM FxaEstudiante f WHERE f.codNivAcad = :codNivAcad"),
    @NamedQuery(name = "FxaEstudiante.findByCodSitAcad", query = "SELECT f FROM FxaEstudiante f WHERE f.codSitAcad = :codSitAcad"),
    @NamedQuery(name = "FxaEstudiante.findByPromocionId", query = "SELECT f FROM FxaEstudiante f WHERE f.promocionId = :promocionId"),
    @NamedQuery(name = "FxaEstudiante.findByPassEnc", query = "SELECT f FROM FxaEstudiante f WHERE f.passEnc = :passEnc"),
    @NamedQuery(name = "FxaEstudiante.findByPassVerifica", query = "SELECT f FROM FxaEstudiante f WHERE f.passVerifica = :passVerifica"),
    @NamedQuery(name = "FxaEstudiante.findBySituacionIngreso", query = "SELECT f FROM FxaEstudiante f WHERE f.situacionIngreso = :situacionIngreso"),
    @NamedQuery(name = "FxaEstudiante.findByCorreoInstitucional", query = "SELECT f FROM FxaEstudiante f WHERE f.correoInstitucional = :correoInstitucional")})
public class ejbCcoFxaEstudiante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_acexp")
    private Integer idAcexp;
    @Size(max = 15)
    @Column(name = "id_ambito")
    private String idAmbito;
    @Size(max = 2)
    @Column(name = "id_especialidad")
    private String idEspecialidad;
    @Size(max = 3)
    @Column(name = "id_plancur")
    private String idPlancur;
    @Size(max = 3)
    @Column(name = "codigo_estudiante")
    private String codigoEstudiante;
    @Size(max = 150)
    @Column(name = "prom_seccion")
    private String promSeccion;
    @Size(max = 300)
    @Column(name = "ciclo_numero")
    private String cicloNumero;
    @Column(name = "activo")
    private Short activo;
    @Column(name = "anulado")
    private Short anulado;
    @Size(max = 2)
    @Column(name = "situacion")
    private String situacion;
    @Column(name = "dateinsert")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateinsert;
    @Column(name = "migrado")
    private Boolean migrado;
    @Size(max = 3)
    @Column(name = "cod_niv_acad")
    private String codNivAcad;
    @Size(max = 3)
    @Column(name = "cod_sit_acad")
    private String codSitAcad;
    @Column(name = "promocion_id")
    private Short promocionId;
    @Size(max = 150)
    @Column(name = "pass_enc")
    private String passEnc;
    @Size(max = 150)
    @Column(name = "pass_verifica")
    private String passVerifica;
    @Column(name = "situacion_ingreso")
    private Boolean situacionIngreso;
    @Size(max = 300)
    @Column(name = "correo_institucional")
    private String correoInstitucional;
    @JoinColumn(name = "id_direestudiante", referencedColumnName = "id_dir")
    @ManyToOne
    private ejbCcoDrtPersonanatural drtPersonanatural;

    public ejbCcoFxaEstudiante() {
    }

    public ejbCcoFxaEstudiante(Integer idAcexp) {
        this.idAcexp = idAcexp;
    }

    public Integer getIdAcexp() {
        return idAcexp;
    }

    public void setIdAcexp(Integer idAcexp) {
        this.idAcexp = idAcexp;
    }

    public String getIdAmbito() {
        return idAmbito;
    }

    public void setIdAmbito(String idAmbito) {
        this.idAmbito = idAmbito;
    }

    public String getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(String idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public String getIdPlancur() {
        return idPlancur;
    }

    public void setIdPlancur(String idPlancur) {
        this.idPlancur = idPlancur;
    }

    public String getCodigoEstudiante() {
        return codigoEstudiante;
    }

    public void setCodigoEstudiante(String codigoEstudiante) {
        this.codigoEstudiante = codigoEstudiante;
    }

    public String getPromSeccion() {
        return promSeccion;
    }

    public void setPromSeccion(String promSeccion) {
        this.promSeccion = promSeccion;
    }

    public String getCicloNumero() {
        return cicloNumero;
    }

    public void setCicloNumero(String cicloNumero) {
        this.cicloNumero = cicloNumero;
    }

    public Short getActivo() {
        return activo;
    }

    public void setActivo(Short activo) {
        this.activo = activo;
    }

    public Short getAnulado() {
        return anulado;
    }

    public void setAnulado(Short anulado) {
        this.anulado = anulado;
    }

    public String getSituacion() {
        return situacion;
    }

    public void setSituacion(String situacion) {
        this.situacion = situacion;
    }

    public Date getDateinsert() {
        return dateinsert;
    }

    public void setDateinsert(Date dateinsert) {
        this.dateinsert = dateinsert;
    }

    public Boolean getMigrado() {
        return migrado;
    }

    public void setMigrado(Boolean migrado) {
        this.migrado = migrado;
    }

    public String getCodNivAcad() {
        return codNivAcad;
    }

    public void setCodNivAcad(String codNivAcad) {
        this.codNivAcad = codNivAcad;
    }

    public String getCodSitAcad() {
        return codSitAcad;
    }

    public void setCodSitAcad(String codSitAcad) {
        this.codSitAcad = codSitAcad;
    }

    public Short getPromocionId() {
        return promocionId;
    }

    public void setPromocionId(Short promocionId) {
        this.promocionId = promocionId;
    }

    public String getPassEnc() {
        return passEnc;
    }

    public void setPassEnc(String passEnc) {
        this.passEnc = passEnc;
    }

    public String getPassVerifica() {
        return passVerifica;
    }

    public void setPassVerifica(String passVerifica) {
        this.passVerifica = passVerifica;
    }

    public Boolean getSituacionIngreso() {
        return situacionIngreso;
    }

    public void setSituacionIngreso(Boolean situacionIngreso) {
        this.situacionIngreso = situacionIngreso;
    }

    public String getCorreoInstitucional() {
        return correoInstitucional;
    }

    public void setCorreoInstitucional(String correoInstitucional) {
        this.correoInstitucional = correoInstitucional;
    }

    public ejbCcoDrtPersonanatural getDrtPersonanatural() {
        return drtPersonanatural;
    }

    public void setDrtPersonanatural(ejbCcoDrtPersonanatural drtPersonanatural) {
        this.drtPersonanatural = drtPersonanatural;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAcexp != null ? idAcexp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ejbCcoFxaEstudiante)) {
            return false;
        }
        ejbCcoFxaEstudiante other = (ejbCcoFxaEstudiante) object;
        if ((this.idAcexp == null && other.idAcexp != null) || (this.idAcexp != null && !this.idAcexp.equals(other.idAcexp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejbCecomp.entidades.FxaEstudiante[ idAcexp=" + idAcexp + " ]";
    }
    
}

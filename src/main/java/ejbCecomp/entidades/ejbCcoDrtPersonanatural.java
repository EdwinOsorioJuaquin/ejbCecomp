/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejbCecomp.entidades;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Jael
 */
@Entity(name="DrtPersonanatural")
@Table(name = "drt_personanatural")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DrtPersonanatural.findAll", query = "SELECT d FROM DrtPersonanatural d"),
    @NamedQuery(name = "DrtPersonanatural.findByIdDir", query = "SELECT d FROM DrtPersonanatural d WHERE d.idDir = :idDir"),
    @NamedQuery(name = "DrtPersonanatural.findByIdUbgNac", query = "SELECT d FROM DrtPersonanatural d WHERE d.idUbgNac = :idUbgNac"),
    @NamedQuery(name = "DrtPersonanatural.findByApMaterno", query = "SELECT d FROM DrtPersonanatural d WHERE d.apMaterno = :apMaterno"),
    @NamedQuery(name = "DrtPersonanatural.findByApPaterno", query = "SELECT d FROM DrtPersonanatural d WHERE d.apPaterno = :apPaterno"),
    @NamedQuery(name = "DrtPersonanatural.findByNombre", query = "SELECT d FROM DrtPersonanatural d WHERE d.nombre = :nombre"),
    @NamedQuery(name = "DrtPersonanatural.findBySexo", query = "SELECT d FROM DrtPersonanatural d WHERE d.sexo = :sexo"),
    @NamedQuery(name = "DrtPersonanatural.findByFechaNac", query = "SELECT d FROM DrtPersonanatural d WHERE d.fechaNac = :fechaNac"),
    @NamedQuery(name = "DrtPersonanatural.findByEstadoPernat", query = "SELECT d FROM DrtPersonanatural d WHERE d.estadoPernat = :estadoPernat"),
    @NamedQuery(name = "DrtPersonanatural.findByFechaIng", query = "SELECT d FROM DrtPersonanatural d WHERE d.fechaIng = :fechaIng"),
    @NamedQuery(name = "DrtPersonanatural.findByDireccion", query = "SELECT d FROM DrtPersonanatural d WHERE d.direccion = :direccion"),
    @NamedQuery(name = "DrtPersonanatural.findByIdUbgPro", query = "SELECT d FROM DrtPersonanatural d WHERE d.idUbgPro = :idUbgPro"),
    @NamedQuery(name = "DrtPersonanatural.findByObservacion", query = "SELECT d FROM DrtPersonanatural d WHERE d.observacion = :observacion"),
    @NamedQuery(name = "DrtPersonanatural.findByIdPdid", query = "SELECT d FROM DrtPersonanatural d WHERE d.idPdid = :idPdid"),
    @NamedQuery(name = "DrtPersonanatural.findByNumeroPndid", query = "SELECT d FROM DrtPersonanatural d WHERE d.numeroPndid = :numeroPndid"),
    @NamedQuery(name = "DrtPersonanatural.findByIdPnec", query = "SELECT d FROM DrtPersonanatural d WHERE d.idPnec = :idPnec"),
    @NamedQuery(name = "DrtPersonanatural.findByIdGrpsng", query = "SELECT d FROM DrtPersonanatural d WHERE d.idGrpsng = :idGrpsng"),
    @NamedQuery(name = "DrtPersonanatural.findByNombreCompleto", query = "SELECT d FROM DrtPersonanatural d WHERE d.nombreCompleto = :nombreCompleto"),
    @NamedQuery(name = "DrtPersonanatural.findByIdColegio", query = "SELECT d FROM DrtPersonanatural d WHERE d.idColegio = :idColegio"),
    @NamedQuery(name = "DrtPersonanatural.findByAnioEgresoCole", query = "SELECT d FROM DrtPersonanatural d WHERE d.anioEgresoCole = :anioEgresoCole"),
    @NamedQuery(name = "DrtPersonanatural.findByUpdateFlow", query = "SELECT d FROM DrtPersonanatural d WHERE d.updateFlow = :updateFlow"),
    @NamedQuery(name = "DrtPersonanatural.findByEmailPrin", query = "SELECT d FROM DrtPersonanatural d WHERE d.emailPrin = :emailPrin"),
    @NamedQuery(name = "DrtPersonanatural.findByTelefonoPrin", query = "SELECT d FROM DrtPersonanatural d WHERE d.telefonoPrin = :telefonoPrin"),
    @NamedQuery(name = "DrtPersonanatural.findByCelularPrin", query = "SELECT d FROM DrtPersonanatural d WHERE d.celularPrin = :celularPrin"),
    @NamedQuery(name = "DrtPersonanatural.findByUpdateSelf", query = "SELECT d FROM DrtPersonanatural d WHERE d.updateSelf = :updateSelf"),
    @NamedQuery(name = "DrtPersonanatural.findByOtroColegio", query = "SELECT d FROM DrtPersonanatural d WHERE d.otroColegio = :otroColegio"),
    @NamedQuery(name = "DrtPersonanatural.findByPswa", query = "SELECT d FROM DrtPersonanatural d WHERE d.pswa = :pswa"),
    @NamedQuery(name = "DrtPersonanatural.findByPswv", query = "SELECT d FROM DrtPersonanatural d WHERE d.pswv = :pswv"),
    @NamedQuery(name = "DrtPersonanatural.findByIdTipColegio", query = "SELECT d FROM DrtPersonanatural d WHERE d.idTipColegio = :idTipColegio"),
    @NamedQuery(name = "DrtPersonanatural.findByIdDirModifica", query = "SELECT d FROM DrtPersonanatural d WHERE d.idDirModifica = :idDirModifica"),
    @NamedQuery(name = "DrtPersonanatural.findByFechaModifica", query = "SELECT d FROM DrtPersonanatural d WHERE d.fechaModifica = :fechaModifica"),
    @NamedQuery(name = "DrtPersonanatural.findByDocumentoModifica", query = "SELECT d FROM DrtPersonanatural d WHERE d.documentoModifica = :documentoModifica"),
    @NamedQuery(name = "DrtPersonanatural.findByIdPais", query = "SELECT d FROM DrtPersonanatural d WHERE d.idPais = :idPais")})
public class ejbCcoDrtPersonanatural implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_dir")
    private Integer idDir;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_ubg_nac")
    private int idUbgNac;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ap_materno")
    private String apMaterno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ap_paterno")
    private String apPaterno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sexo")
    private Character sexo;
    @Column(name = "fecha_nac")
    @Temporal(TemporalType.DATE)
    private Date fechaNac;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado_pernat")
    private Character estadoPernat;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_ing")
    @Temporal(TemporalType.DATE)
    private Date fechaIng;
    @Size(max = 200)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_ubg_pro")
    private int idUbgPro;
    @Size(max = 250)
    @Column(name = "observacion")
    private String observacion;
    @Column(name = "id_pdid")
    private Integer idPdid;
    @Size(max = 250)
    @Column(name = "numero_pndid")
    private String numeroPndid;
    @Column(name = "id_pnec")
    private Integer idPnec;
    @Column(name = "id_grpsng")
    private Integer idGrpsng;
    @Size(max = 180)
    @Column(name = "nombre_completo")
    private String nombreCompleto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_colegio")
    private int idColegio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "anio_egreso_cole")
    private int anioEgresoCole;
    @Column(name = "update_flow")
    private Integer updateFlow;
    @Size(max = 250)
    @Column(name = "email_prin")
    private String emailPrin;
    @Size(max = 50)
    @Column(name = "telefono_prin")
    private String telefonoPrin;
    @Size(max = 50)
    @Column(name = "celular_prin")
    private String celularPrin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "update_self")
    private int updateSelf;
    @Size(max = 200)
    @Column(name = "otro_colegio")
    private String otroColegio;
    @Size(max = 50)
    @Column(name = "pswa")
    private String pswa;
    @Size(max = 50)
    @Column(name = "pswv")
    private String pswv;
    @Column(name = "id_tip_colegio")
    private Integer idTipColegio;
    @Column(name = "id_dir_modifica")
    private Integer idDirModifica;
    @Column(name = "fecha_modifica")
    @Temporal(TemporalType.DATE)
    private Date fechaModifica;
    @Size(max = 150)
    @Column(name = "documento_modifica")
    private String documentoModifica;
    @Column(name = "id_pais")
    private Integer idPais;
    @OneToMany(mappedBy = "drtPersonanatural")
    private List<ejbCcoEscPersonal> escPersonalList;
    @OneToMany(mappedBy = "drtPersonanatural")
    private List<ejbCcoFxaEstudiante> fxaEstudianteList;
    @OneToMany(mappedBy = "drtPersonanatural")
    private List<ejbCcoCcoAlumnoExterno> ccoAlumnoExternoList;
    @JoinColumn(name = "id_dir", referencedColumnName = "id_dir", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private ejbCcoDrtDirectorio drtDirectorio;
    @OneToMany(mappedBy = "drtPersonanatural")
    private List<ejbCcoCepCcoAluIns> cepCcoAluInsList;
    @OneToMany(mappedBy = "drtPersonanatural")
    private List<ejbCcoCepPagos> cepPagosList;
    @OneToMany(mappedBy = "drtPersonanatural")
    private List<ejbCcoCepCcoMatriculaCab> cepCcoMatriculaCabList;

    public ejbCcoDrtPersonanatural() {
    }

    public ejbCcoDrtPersonanatural(Integer idDir) {
        this.idDir = idDir;
    }

    public ejbCcoDrtPersonanatural(Integer idDir, int idUbgNac, String apMaterno, String apPaterno, String nombre, Character sexo, Character estadoPernat, Date fechaIng, int idUbgPro, int idColegio, int anioEgresoCole, int updateSelf) {
        this.idDir = idDir;
        this.idUbgNac = idUbgNac;
        this.apMaterno = apMaterno;
        this.apPaterno = apPaterno;
        this.nombre = nombre;
        this.sexo = sexo;
        this.estadoPernat = estadoPernat;
        this.fechaIng = fechaIng;
        this.idUbgPro = idUbgPro;
        this.idColegio = idColegio;
        this.anioEgresoCole = anioEgresoCole;
        this.updateSelf = updateSelf;
    }

    public Integer getIdDir() {
        return idDir;
    }

    public void setIdDir(Integer idDir) {
        this.idDir = idDir;
    }

    public int getIdUbgNac() {
        return idUbgNac;
    }

    public void setIdUbgNac(int idUbgNac) {
        this.idUbgNac = idUbgNac;
    }

    public String getApMaterno() {
        return apMaterno;
    }

    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }

    public String getApPaterno() {
        return apPaterno;
    }

    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public Character getEstadoPernat() {
        return estadoPernat;
    }

    public void setEstadoPernat(Character estadoPernat) {
        this.estadoPernat = estadoPernat;
    }

    public Date getFechaIng() {
        return fechaIng;
    }

    public void setFechaIng(Date fechaIng) {
        this.fechaIng = fechaIng;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getIdUbgPro() {
        return idUbgPro;
    }

    public void setIdUbgPro(int idUbgPro) {
        this.idUbgPro = idUbgPro;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Integer getIdPdid() {
        return idPdid;
    }

    public void setIdPdid(Integer idPdid) {
        this.idPdid = idPdid;
    }

    public String getNumeroPndid() {
        return numeroPndid;
    }

    public void setNumeroPndid(String numeroPndid) {
        this.numeroPndid = numeroPndid;
    }

    public Integer getIdPnec() {
        return idPnec;
    }

    public void setIdPnec(Integer idPnec) {
        this.idPnec = idPnec;
    }

    public Integer getIdGrpsng() {
        return idGrpsng;
    }

    public void setIdGrpsng(Integer idGrpsng) {
        this.idGrpsng = idGrpsng;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public int getIdColegio() {
        return idColegio;
    }

    public void setIdColegio(int idColegio) {
        this.idColegio = idColegio;
    }

    public int getAnioEgresoCole() {
        return anioEgresoCole;
    }

    public void setAnioEgresoCole(int anioEgresoCole) {
        this.anioEgresoCole = anioEgresoCole;
    }

    public Integer getUpdateFlow() {
        return updateFlow;
    }

    public void setUpdateFlow(Integer updateFlow) {
        this.updateFlow = updateFlow;
    }

    public String getEmailPrin() {
        return emailPrin;
    }

    public void setEmailPrin(String emailPrin) {
        this.emailPrin = emailPrin;
    }

    public String getTelefonoPrin() {
        return telefonoPrin;
    }

    public void setTelefonoPrin(String telefonoPrin) {
        this.telefonoPrin = telefonoPrin;
    }

    public String getCelularPrin() {
        return celularPrin;
    }

    public void setCelularPrin(String celularPrin) {
        this.celularPrin = celularPrin;
    }

    public int getUpdateSelf() {
        return updateSelf;
    }

    public void setUpdateSelf(int updateSelf) {
        this.updateSelf = updateSelf;
    }

    public String getOtroColegio() {
        return otroColegio;
    }

    public void setOtroColegio(String otroColegio) {
        this.otroColegio = otroColegio;
    }

    public String getPswa() {
        return pswa;
    }

    public void setPswa(String pswa) {
        this.pswa = pswa;
    }

    public String getPswv() {
        return pswv;
    }

    public void setPswv(String pswv) {
        this.pswv = pswv;
    }

    public Integer getIdTipColegio() {
        return idTipColegio;
    }

    public void setIdTipColegio(Integer idTipColegio) {
        this.idTipColegio = idTipColegio;
    }

    public Integer getIdDirModifica() {
        return idDirModifica;
    }

    public void setIdDirModifica(Integer idDirModifica) {
        this.idDirModifica = idDirModifica;
    }

    public Date getFechaModifica() {
        return fechaModifica;
    }

    public void setFechaModifica(Date fechaModifica) {
        this.fechaModifica = fechaModifica;
    }

    public String getDocumentoModifica() {
        return documentoModifica;
    }

    public void setDocumentoModifica(String documentoModifica) {
        this.documentoModifica = documentoModifica;
    }

    public Integer getIdPais() {
        return idPais;
    }

    public void setIdPais(Integer idPais) {
        this.idPais = idPais;
    }

    @XmlTransient
    public List<ejbCcoEscPersonal> getEscPersonalList() {
        return escPersonalList;
    }

    public void setEscPersonalList(List<ejbCcoEscPersonal> escPersonalList) {
        this.escPersonalList = escPersonalList;
    }

    @XmlTransient
    public List<ejbCcoFxaEstudiante> getFxaEstudianteList() {
        return fxaEstudianteList;
    }

    public void setFxaEstudianteList(List<ejbCcoFxaEstudiante> fxaEstudianteList) {
        this.fxaEstudianteList = fxaEstudianteList;
    }

    @XmlTransient
    public List<ejbCcoCcoAlumnoExterno> getCcoAlumnoExternoList() {
        return ccoAlumnoExternoList;
    }

    public void setCcoAlumnoExternoList(List<ejbCcoCcoAlumnoExterno> ccoAlumnoExternoList) {
        this.ccoAlumnoExternoList = ccoAlumnoExternoList;
    }

    public ejbCcoDrtDirectorio getDrtDirectorio() {
        return drtDirectorio;
    }

    public void setDrtDirectorio(ejbCcoDrtDirectorio drtDirectorio) {
        this.drtDirectorio = drtDirectorio;
    }

    @XmlTransient
    public List<ejbCcoCepCcoAluIns> getCepCcoAluInsList() {
        return cepCcoAluInsList;
    }

    public void setCepCcoAluInsList(List<ejbCcoCepCcoAluIns> cepCcoAluInsList) {
        this.cepCcoAluInsList = cepCcoAluInsList;
    }

    @XmlTransient
    public List<ejbCcoCepPagos> getCepPagosList() {
        return cepPagosList;
    }

    public void setCepPagosList(List<ejbCcoCepPagos> cepPagosList) {
        this.cepPagosList = cepPagosList;
    }

    @XmlTransient
    public List<ejbCcoCepCcoMatriculaCab> getCepCcoMatriculaCabList() {
        return cepCcoMatriculaCabList;
    }

    public void setCepCcoMatriculaCabList(List<ejbCcoCepCcoMatriculaCab> cepCcoMatriculaCabList) {
        this.cepCcoMatriculaCabList = cepCcoMatriculaCabList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDir != null ? idDir.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ejbCcoDrtPersonanatural)) {
            return false;
        }
        ejbCcoDrtPersonanatural other = (ejbCcoDrtPersonanatural) object;
        if ((this.idDir == null && other.idDir != null) || (this.idDir != null && !this.idDir.equals(other.idDir))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejbCecomp.entidades.DrtPersonanatural[ idDir=" + idDir + " ]";
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejbCecomp.entidades;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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
@Entity(name="EscPersonal")
@Table(name = "esc_personal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EscPersonal.findAll", query = "SELECT e FROM EscPersonal e"),
    @NamedQuery(name = "EscPersonal.findByIdEsc", query = "SELECT e FROM EscPersonal e WHERE e.idEsc = :idEsc"),
    @NamedQuery(name = "EscPersonal.findByIdEstado", query = "SELECT e FROM EscPersonal e WHERE e.idEstado = :idEstado"),
    @NamedQuery(name = "EscPersonal.findByIdTipo", query = "SELECT e FROM EscPersonal e WHERE e.idTipo = :idTipo"),
    @NamedQuery(name = "EscPersonal.findByFechaIng", query = "SELECT e FROM EscPersonal e WHERE e.fechaIng = :fechaIng"),
    @NamedQuery(name = "EscPersonal.findByCondicion", query = "SELECT e FROM EscPersonal e WHERE e.condicion = :condicion"),
    @NamedQuery(name = "EscPersonal.findByRuc", query = "SELECT e FROM EscPersonal e WHERE e.ruc = :ruc"),
    @NamedQuery(name = "EscPersonal.findByEspecialidad", query = "SELECT e FROM EscPersonal e WHERE e.especialidad = :especialidad"),
    @NamedQuery(name = "EscPersonal.findByAbrevEsp", query = "SELECT e FROM EscPersonal e WHERE e.abrevEsp = :abrevEsp"),
    @NamedQuery(name = "EscPersonal.findByFechaCese", query = "SELECT e FROM EscPersonal e WHERE e.fechaCese = :fechaCese"),
    @NamedQuery(name = "EscPersonal.findByObservaciones", query = "SELECT e FROM EscPersonal e WHERE e.observaciones = :observaciones")})
public class ejbCcoEscPersonal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_esc")
    private Integer idEsc;
    @Column(name = "id_estado")
    private Integer idEstado;
    @Column(name = "id_tipo")
    private Integer idTipo;
    @Column(name = "fecha_ing")
    @Temporal(TemporalType.DATE)
    private Date fechaIng;
    @Column(name = "condicion")
    private Integer condicion;
    @Size(max = 25)
    @Column(name = "ruc")
    private String ruc;
    @Size(max = 100)
    @Column(name = "especialidad")
    private String especialidad;
    @Size(max = 20)
    @Column(name = "abrev_esp")
    private String abrevEsp;
    @Column(name = "fecha_cese")
    @Temporal(TemporalType.DATE)
    private Date fechaCese;
    @Size(max = 400)
    @Column(name = "observaciones")
    private String observaciones;
    @JoinColumn(name = "id_dir", referencedColumnName = "id_dir")
    @ManyToOne
    private ejbCcoDrtPersonanatural idDir;
    @OneToMany(mappedBy = "idEsc")
    private List<ejbCcoCepPersonal> ejbCcoCepPersonalList;

    public ejbCcoEscPersonal() {
    }

    public ejbCcoEscPersonal(Integer idEsc) {
        this.idEsc = idEsc;
    }

    public Integer getIdEsc() {
        return idEsc;
    }

    public void setIdEsc(Integer idEsc) {
        this.idEsc = idEsc;
    }

    public Integer getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public Integer getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Integer idTipo) {
        this.idTipo = idTipo;
    }

    public Date getFechaIng() {
        return fechaIng;
    }

    public void setFechaIng(Date fechaIng) {
        this.fechaIng = fechaIng;
    }

    public Integer getCondicion() {
        return condicion;
    }

    public void setCondicion(Integer condicion) {
        this.condicion = condicion;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getAbrevEsp() {
        return abrevEsp;
    }

    public void setAbrevEsp(String abrevEsp) {
        this.abrevEsp = abrevEsp;
    }

    public Date getFechaCese() {
        return fechaCese;
    }

    public void setFechaCese(Date fechaCese) {
        this.fechaCese = fechaCese;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public ejbCcoDrtPersonanatural getIdDir() {
        return idDir;
    }

    public void setIdDir(ejbCcoDrtPersonanatural idDir) {
        this.idDir = idDir;
    }

    @XmlTransient
    public List<ejbCcoCepPersonal> getEjbCcoCepPersonalList() {
        return ejbCcoCepPersonalList;
    }

    public void setEjbCcoCepPersonalList(List<ejbCcoCepPersonal> ejbCcoCepPersonalList) {
        this.ejbCcoCepPersonalList = ejbCcoCepPersonalList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEsc != null ? idEsc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ejbCcoEscPersonal)) {
            return false;
        }
        ejbCcoEscPersonal other = (ejbCcoEscPersonal) object;
        if ((this.idEsc == null && other.idEsc != null) || (this.idEsc != null && !this.idEsc.equals(other.idEsc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejbCecomp.entidades.ejbCcoEscPersonal[ idEsc=" + idEsc + " ]";
    }
    
}

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
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Jael
 */
@Entity(name="DrtDirectorioClase")
@Table(name = "drt_directorio_clase")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DrtDirectorioClase.findAll", query = "SELECT d FROM DrtDirectorioClase d"),
    @NamedQuery(name = "DrtDirectorioClase.findByIdDclas", query = "SELECT d FROM DrtDirectorioClase d WHERE d.idDclas = :idDclas"),
    @NamedQuery(name = "DrtDirectorioClase.findByNombre", query = "SELECT d FROM DrtDirectorioClase d WHERE d.nombre = :nombre"),
    @NamedQuery(name = "DrtDirectorioClase.findByDescripcion", query = "SELECT d FROM DrtDirectorioClase d WHERE d.descripcion = :descripcion"),
    @NamedQuery(name = "DrtDirectorioClase.findByAbrevia", query = "SELECT d FROM DrtDirectorioClase d WHERE d.abrevia = :abrevia")})
public class ejbCcoDrtDirectorioClase implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_dclas")
    private Short idDclas;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "abrevia")
    private String abrevia;
    @OneToMany(mappedBy = "drtDirectorioClase")
    private List<ejbCcoDrtDirectorio> drtDirectorioList;

    public ejbCcoDrtDirectorioClase() {
    }

    public ejbCcoDrtDirectorioClase(Short idDclas) {
        this.idDclas = idDclas;
    }

    public ejbCcoDrtDirectorioClase(Short idDclas, String nombre, String descripcion, String abrevia) {
        this.idDclas = idDclas;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.abrevia = abrevia;
    }

    public Short getIdDclas() {
        return idDclas;
    }

    public void setIdDclas(Short idDclas) {
        this.idDclas = idDclas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAbrevia() {
        return abrevia;
    }

    public void setAbrevia(String abrevia) {
        this.abrevia = abrevia;
    }

    @XmlTransient
    public List<ejbCcoDrtDirectorio> getDrtDirectorioList() {
        return drtDirectorioList;
    }

    public void setDrtDirectorioList(List<ejbCcoDrtDirectorio> drtDirectorioList) {
        this.drtDirectorioList = drtDirectorioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDclas != null ? idDclas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ejbCcoDrtDirectorioClase)) {
            return false;
        }
        ejbCcoDrtDirectorioClase other = (ejbCcoDrtDirectorioClase) object;
        if ((this.idDclas == null && other.idDclas != null) || (this.idDclas != null && !this.idDclas.equals(other.idDclas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejbCecomp.entidades.DrtDirectorioClase[ idDclas=" + idDclas + " ]";
    }
    
}

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
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Jael
 */
@Entity(name = "CcoAlumnoExterno")
@Table(name = "cco_alumno_externo")
@NamedQueries({
    @NamedQuery(name = "CcoAlumnoExterno.findAll", query = "SELECT c FROM CcoAlumnoExterno c"),
    @NamedQuery(name = "CcoAlumnoExterno.findByIdCcoUsuEx", query = "SELECT c FROM CcoAlumnoExterno c WHERE c.idCcoUsuEx = :idCcoUsuEx"),
    @NamedQuery(name = "CcoAlumnoExterno.findByActivo", query = "SELECT c FROM CcoAlumnoExterno c WHERE c.activo = :activo"),
    @NamedQuery(name = "CcoAlumnoExterno.findByAnulado", query = "SELECT c FROM CcoAlumnoExterno c WHERE c.anulado = :anulado"),
    @NamedQuery(name = "CcoAlumnoExterno.findByCorreoLogin", query = "SELECT c FROM CcoAlumnoExterno c WHERE c.correoLogin = :correoLogin"),
    @NamedQuery(name = "CcoAlumnoExterno.findByPassword", query = "SELECT c FROM CcoAlumnoExterno c WHERE c.password = :password")})
public class ejbCcoCcoAlumnoExterno implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_cco_usu_ex")
    private Integer idCcoUsuEx;
    @Column(name = "activo")
    private Short activo;
    @Column(name = "anulado")
    private Short anulado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "correo_login")
    private String correoLogin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "password")
    private String password;
    @JoinColumn(name = "id_dir", referencedColumnName = "id_dir")
    @ManyToOne
    private ejbCcoDrtPersonanatural drtPersonanatural;

    public ejbCcoCcoAlumnoExterno() {
    }

    public ejbCcoCcoAlumnoExterno(Integer idCcoUsuEx) {
        this.idCcoUsuEx = idCcoUsuEx;
    }

    public ejbCcoCcoAlumnoExterno(Integer idCcoUsuEx, String correoLogin, String password) {
        this.idCcoUsuEx = idCcoUsuEx;
        this.correoLogin = correoLogin;
        this.password = password;
    }

    public Integer getIdCcoUsuEx() {
        return idCcoUsuEx;
    }

    public void setIdCcoUsuEx(Integer idCcoUsuEx) {
        this.idCcoUsuEx = idCcoUsuEx;
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

    public String getCorreoLogin() {
        return correoLogin;
    }

    public void setCorreoLogin(String correoLogin) {
        this.correoLogin = correoLogin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        hash += (idCcoUsuEx != null ? idCcoUsuEx.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ejbCcoCcoAlumnoExterno)) {
            return false;
        }
        ejbCcoCcoAlumnoExterno other = (ejbCcoCcoAlumnoExterno) object;
        if ((this.idCcoUsuEx == null && other.idCcoUsuEx != null) || (this.idCcoUsuEx != null && !this.idCcoUsuEx.equals(other.idCcoUsuEx))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejbCecomp.entidades.CcoAlumnoExterno[ idCcoUsuEx=" + idCcoUsuEx + " ]";
    }

    public void setFechaIng(Date date) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

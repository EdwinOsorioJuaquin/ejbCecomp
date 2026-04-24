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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Jael
 */
@Entity(name = "DrtDirectorio")
@Table(name = "drt_directorio")
@NamedQueries({
    @NamedQuery(name = "DrtDirectorio.findAll", query = "SELECT d FROM DrtDirectorio d"),
    @NamedQuery(name = "DrtDirectorio.findByIdDir", query = "SELECT d FROM DrtDirectorio d WHERE d.idDir = :idDir"),
    @NamedQuery(name = "DrtDirectorio.findByPspCxt", query = "SELECT d FROM DrtDirectorio d WHERE d.pspCxt = :pspCxt"),
    @NamedQuery(name = "DrtDirectorio.findByPspApp", query = "SELECT d FROM DrtDirectorio d WHERE d.pspApp = :pspApp"),
    @NamedQuery(name = "DrtDirectorio.findByPspUid", query = "SELECT d FROM DrtDirectorio d WHERE d.pspUid = :pspUid"),
    @NamedQuery(name = "DrtDirectorio.findByDateinsert", query = "SELECT d FROM DrtDirectorio d WHERE d.dateinsert = :dateinsert")})
public class ejbCcoDrtDirectorio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_dir")
    private Integer idDir;
    @Basic(optional = false)
    @NotNull
    @Column(name = "psp_cxt")
    private short pspCxt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "psp_app")
    private short pspApp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "psp_uid")
    private int pspUid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateinsert")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateinsert;
    @JoinColumn(name = "id_dclas", referencedColumnName = "id_dclas")
    @ManyToOne(optional = false)
    private ejbCcoDrtDirectorioClase drtDirectorioClase;
    @OneToOne(mappedBy = "drtDirectorio")
    private ejbCcoDrtPersonanatural drtPersonanatural;

    public ejbCcoDrtDirectorio() {
    }

    public ejbCcoDrtDirectorio(Integer idDir) {
        this.idDir = idDir;
    }

    public ejbCcoDrtDirectorio(Integer idDir, short pspCxt, short pspApp, int pspUid, Date dateinsert) {
        this.idDir = idDir;
        this.pspCxt = pspCxt;
        this.pspApp = pspApp;
        this.pspUid = pspUid;
        this.dateinsert = dateinsert;
    }

    public Integer getIdDir() {
        return idDir;
    }

    public void setIdDir(Integer idDir) {
        this.idDir = idDir;
    }

    public short getPspCxt() {
        return pspCxt;
    }

    public void setPspCxt(short pspCxt) {
        this.pspCxt = pspCxt;
    }

    public short getPspApp() {
        return pspApp;
    }

    public void setPspApp(short pspApp) {
        this.pspApp = pspApp;
    }

    public int getPspUid() {
        return pspUid;
    }

    public void setPspUid(int pspUid) {
        this.pspUid = pspUid;
    }

    public Date getDateinsert() {
        return dateinsert;
    }

    public void setDateinsert(Date dateinsert) {
        this.dateinsert = dateinsert;
    }

    public ejbCcoDrtDirectorioClase getDrtDirectorioClase() {
        return drtDirectorioClase;
    }

    public void setDrtDirectorioClase(ejbCcoDrtDirectorioClase drtDirectorioClase) {
        this.drtDirectorioClase = drtDirectorioClase;
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
        hash += (idDir != null ? idDir.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ejbCcoDrtDirectorio)) {
            return false;
        }
        ejbCcoDrtDirectorio other = (ejbCcoDrtDirectorio) object;
        if ((this.idDir == null && other.idDir != null) || (this.idDir != null && !this.idDir.equals(other.idDir))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejbCecomp.entidades.DrtDirectorio[ idDir=" + idDir + " ]";
    }
    
}

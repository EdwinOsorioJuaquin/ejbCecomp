/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejbCecomp.entidades;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Jael
 */
@Entity(name = "RcdConcepto")
@Table(name = "rcd_concepto")
@NamedQueries({
    @NamedQuery(name = "RcdConcepto.findAll", query = "SELECT r FROM RcdConcepto r"),
    @NamedQuery(name = "RcdConcepto.findByIdConcepto", query = "SELECT r FROM RcdConcepto r WHERE r.idConcepto = :idConcepto"),
    @NamedQuery(name = "RcdConcepto.findByNombre", query = "SELECT r FROM RcdConcepto r WHERE r.nombre = :nombre"),
    @NamedQuery(name = "RcdConcepto.findByTipo", query = "SELECT r FROM RcdConcepto r WHERE r.tipo = :tipo"),
    @NamedQuery(name = "RcdConcepto.findByIdPartida1", query = "SELECT r FROM RcdConcepto r WHERE r.idPartida1 = :idPartida1"),
    @NamedQuery(name = "RcdConcepto.findByIdPartida2", query = "SELECT r FROM RcdConcepto r WHERE r.idPartida2 = :idPartida2"),
    @NamedQuery(name = "RcdConcepto.findByCondicion", query = "SELECT r FROM RcdConcepto r WHERE r.condicion = :condicion")})
public class ejbCcoRcdConcepto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_concepto")
    private Integer idConcepto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 250)
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "id_partida_1")
    private Integer idPartida1;
    @Column(name = "id_partida_2")
    private Integer idPartida2;
    @Basic(optional = false)
    @NotNull
    @Column(name = "condicion")
    private long condicion;
    @OneToMany(mappedBy = "rcdConcepto")
    private List<ejbCcoRcdVoucher> rcdVoucherList;

    public ejbCcoRcdConcepto() {
    }

    public ejbCcoRcdConcepto(Integer idConcepto) {
        this.idConcepto = idConcepto;
    }

    public ejbCcoRcdConcepto(Integer idConcepto, String nombre, long condicion) {
        this.idConcepto = idConcepto;
        this.nombre = nombre;
        this.condicion = condicion;
    }

    public Integer getIdConcepto() {
        return idConcepto;
    }

    public void setIdConcepto(Integer idConcepto) {
        this.idConcepto = idConcepto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getIdPartida1() {
        return idPartida1;
    }

    public void setIdPartida1(Integer idPartida1) {
        this.idPartida1 = idPartida1;
    }

    public Integer getIdPartida2() {
        return idPartida2;
    }

    public void setIdPartida2(Integer idPartida2) {
        this.idPartida2 = idPartida2;
    }

    public long getCondicion() {
        return condicion;
    }

    public void setCondicion(long condicion) {
        this.condicion = condicion;
    }

    public List<ejbCcoRcdVoucher> getRcdVoucherList() {
        return rcdVoucherList;
    }

    public void setRcdVoucherList(List<ejbCcoRcdVoucher> rcdVoucherList) {
        this.rcdVoucherList = rcdVoucherList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idConcepto != null ? idConcepto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ejbCcoRcdConcepto)) {
            return false;
        }
        ejbCcoRcdConcepto other = (ejbCcoRcdConcepto) object;
        if ((this.idConcepto == null && other.idConcepto != null) || (this.idConcepto != null && !this.idConcepto.equals(other.idConcepto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejbCecomp.entidades.RcdConcepto[ idConcepto=" + idConcepto + " ]";
    }
    
}

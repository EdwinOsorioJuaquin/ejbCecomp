package ejbCecomp.ejb.negocio;

import ejbCecomp.entidades.ejbCcoDrtDepartamento;
import jakarta.ejb.Local;

@Local
public interface ejbCcoDrtDepartamentoServiceLocal {
    ejbCcoDrtDepartamento buscarPorId(int idPais, int idDpto);
}
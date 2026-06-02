package ejbCecomp.ejb.negocio;

import ejbCecomp.entidades.ejbCcoCepCecTema;
import jakarta.ejb.Local;
import java.util.List;

@Local
public interface ejbCcoCepCecTemaServiceLocal {
    ejbCcoCepCecTema crear(ejbCcoCepCecTema tema);
    ejbCcoCepCecTema actualizar(ejbCcoCepCecTema tema);
    ejbCcoCepCecTema buscarPorId(Integer idPland, Integer idSesio, Integer idTem);
    List<ejbCcoCepCecTema> listarPorSesion(Integer idPland, Integer idSesio);
    List<ejbCcoCepCecTema> listarTodos(); 
}
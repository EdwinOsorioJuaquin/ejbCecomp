
package ejbCecomp.ejb.dao;

import ejbCecomp.entidades.*;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;
import java.util.List;

@Stateless
public class ejbCcoFxaEstudianteDAO extends ejbCcoGenericoDAO<ejbCcoFxaEstudiante> implements ejbCcoFxaEstudianteDAOLocal{

    @Override
    public ejbCcoFxaEstudiante buscarPorCodigo(String codigoEstudiante) {
        List<ejbCcoFxaEstudiante> lstEstudiante;
        TypedQuery<ejbCcoFxaEstudiante> q=em.createQuery("SELECT object(u) FROM FxaEstudiante AS u WHERE u.codigoEstudiante=:codigo",ejbCcoFxaEstudiante.class);
        q.setParameter("codigo",codigoEstudiante);
        lstEstudiante=q.getResultList();
        if(lstEstudiante.isEmpty()){
            return null;
        }else{
            return lstEstudiante.get(0);
        }
    }

    @Override
    public List<ejbCcoFxaEstudiante> listarPromocion(Integer promocion, int idEscuela) {
        List<ejbCcoFxaEstudiante> lstEstudiante;
        TypedQuery<ejbCcoFxaEstudiante> q=em.createQuery("SELECT object(u) FROM FxaEstudiante AS u WHERE u.promocionId=:promocion and u.apsEspecialidad.idEspecialidad=:idEsp",ejbCcoFxaEstudiante.class);
        q.setParameter("promocion",promocion);
        q.setParameter("idEsp",idEscuela);
        lstEstudiante=q.getResultList();
        if(lstEstudiante.isEmpty()){
            return null;
        }else{
            return lstEstudiante;
        }
    }    
}

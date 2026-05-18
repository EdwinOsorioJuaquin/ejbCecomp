
package ejbCecomp.ejb.dao;

import ejbCecomp.entidades.*;
import jakarta.ejb.Local;
import java.util.List;

@Local
public interface ejbCcoFxaEstudianteDAOLocal extends ejbCcoGenericoDAOLocal<ejbCcoFxaEstudiante>{
    ejbCcoFxaEstudiante buscarPorCodigo(String codigoEstudiante);
    
    List<ejbCcoFxaEstudiante> listarPromocion(Integer promocion,int idEscuela);
    
    public List<ejbCcoFxaEstudiante> listarTodosActivos();
    
}


package ejbCecomp.ejb.negocio;

import ejbCecomp.ejb.dao.ejbCcoFxaEstudianteDAOLocal;
import ejbCecomp.entidades.ejbCcoFxaEstudiante;
import jakarta.annotation.Resource;
import jakarta.ejb.Stateless;
import jakarta.ejb.TransactionManagement;
import jakarta.ejb.TransactionManagementType;
import jakarta.inject.Inject;
import jakarta.transaction.*;
import java.util.logging.*;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class ejbCcoFxaEstudianteService implements ejbCcoFxaEstudianteServiceLocal {
    
    @Resource
    UserTransaction ut;
    
    @Inject
    ejbCcoFxaEstudianteDAOLocal daoFxaEstudiante;
    
    @Override
    public ejbCcoFxaEstudiante buscarPorCodigo(String codigoEstudiante) {
        return this.daoFxaEstudiante.buscarPorCodigo(codigoEstudiante);
    }

    @Override
    public ejbCcoFxaEstudiante crear(ejbCcoFxaEstudiante objEstudiante) {
        ejbCcoFxaEstudiante clsFxaEstudiante;
        try{
            ut.begin();
            clsFxaEstudiante=this.daoFxaEstudiante.crear(objEstudiante);
            ut.commit();
            return clsFxaEstudiante;
        } catch (NotSupportedException | RollbackException | HeuristicMixedException | HeuristicRollbackException | SecurityException | IllegalStateException | SystemException ex) {
            try {
                ut.rollback();
            } catch (IllegalStateException | SecurityException | SystemException ex1) {
                Logger.getLogger(ejbCcoFxaEstudianteService.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return null;
    }
    
}

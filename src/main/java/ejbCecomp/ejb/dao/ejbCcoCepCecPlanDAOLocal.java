package ejbCecomp.ejb.dao;

import ejbCecomp.entidades.ejbCcoCepCecPlan;
import jakarta.ejb.Local;
import java.util.List;

@Local
public interface ejbCcoCepCecPlanDAOLocal extends ejbCcoGenericoDAOLocal<ejbCcoCepCecPlan> {
    List<ejbCcoCepCecPlan> listarTodos();
    List<ejbCcoCepCecPlan> listarActivos();
    ejbCcoCepCecPlan buscarPorNombre(String nombre);
}
package ejbCecomp.ejb.negocio;

import ejbCecomp.entidades.ejbCcoCepCecPlan;
import jakarta.ejb.Local;
import java.util.List;

@Local
public interface ejbCcoCepCecPlanServiceLocal {
    ejbCcoCepCecPlan crear(ejbCcoCepCecPlan plan);
    ejbCcoCepCecPlan actualizar(ejbCcoCepCecPlan plan);
    ejbCcoCepCecPlan buscarPorId(Integer id);
    List<ejbCcoCepCecPlan> listarTodos();
    List<ejbCcoCepCecPlan> listarActivos();
    ejbCcoCepCecPlan buscarPorNombre(String nombre);
}
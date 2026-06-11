package ejbCecomp.ejb.negocio;

import ejbCecomp.ejb.dao.ejbCcoCepCecGrupoCursoDAOLocal;
import ejbCecomp.entidades.ejbCcoCepCecGrupoCurso;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import java.util.List;

@Stateless
public class ejbCcoCepCecGrupoCursoService implements ejbCcoCepCecGrupoCursoServiceLocal {

    @EJB
    private ejbCcoCepCecGrupoCursoDAOLocal dao;

    @Override
    public List<ejbCcoCepCecGrupoCurso> listarTodos() {
        return dao.listarTodos();
    }

    @Override
    public List<ejbCcoCepCecGrupoCurso> listarActivos() {
        return dao.listarActivos();
    }

    @Override
    public ejbCcoCepCecGrupoCurso buscarPorId(Integer idGrupo) {
        return dao.buscarPorId(idGrupo);
    }
}
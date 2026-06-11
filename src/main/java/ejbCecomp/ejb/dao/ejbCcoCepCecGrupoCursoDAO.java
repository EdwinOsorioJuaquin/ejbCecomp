package ejbCecomp.ejb.dao;

import ejbCecomp.entidades.ejbCcoCepCecGrupoCurso;
import jakarta.ejb.Stateless;
import jakarta.persistence.TypedQuery;
import java.util.List;

@Stateless
public class ejbCcoCepCecGrupoCursoDAO extends ejbCcoGenericoDAO<ejbCcoCepCecGrupoCurso> implements ejbCcoCepCecGrupoCursoDAOLocal {

    @Override
    public List<ejbCcoCepCecGrupoCurso> listarTodos() {
        TypedQuery<ejbCcoCepCecGrupoCurso> query = em.createQuery(
            "SELECT g FROM CepCecGrupoCurso g ORDER BY g.idGrupo",
            ejbCcoCepCecGrupoCurso.class
        );
        return query.getResultList();
    }

    @Override
    public List<ejbCcoCepCecGrupoCurso> listarActivos() {
        TypedQuery<ejbCcoCepCecGrupoCurso> query = em.createQuery(
            "SELECT g FROM CepCecGrupoCurso g WHERE g.estado = 1 ORDER BY g.idGrupo",
            ejbCcoCepCecGrupoCurso.class
        );
        return query.getResultList();
    }

    @Override
    public ejbCcoCepCecGrupoCurso buscarPorId(Integer idGrupo) {
        try {
            return em.find(ejbCcoCepCecGrupoCurso.class, idGrupo);
        } catch (Exception e) {
            System.out.println("Error buscarPorId: " + e.getMessage());
            return null;
        }
    }
}
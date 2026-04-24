
package ejbCecomp.ejb.dao;

import ejbCecomp.entidades.ejbCcoCepCurso;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;
import java.util.List;

/**
 * Implementación del DAO para la entidad Curso.
 * 
 * Contiene las consultas JPQL hacia la base de datos.
 */
@Stateless
public class ejbCcoCursoDAO extends ejbCcoGenericoDAO<ejbCcoCepCurso> implements ejbCcoCursoDAOLocal {
    /**
     * Lista todos los cursos.
     */
    @Override
    public List<ejbCcoCepCurso> listarTodos() {

        TypedQuery<ejbCcoCepCurso> query =
            em.createQuery("SELECT c FROM CepCurso c", ejbCcoCepCurso.class);

        return query.getResultList();
    }

    /**
     * Busca cursos por nombre usando LIKE.
     */
    @Override
    public List<ejbCcoCepCurso> buscarPorNombre(String nombre) {

        TypedQuery<ejbCcoCepCurso> query =
            em.createQuery(
                "SELECT c FROM CepCurso c WHERE c.nomCurso LIKE :nombre",
                ejbCcoCepCurso.class
            );

        query.setParameter("nombre", "%" + nombre + "%");

        return query.getResultList();
    }
}

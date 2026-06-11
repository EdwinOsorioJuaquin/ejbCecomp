package ejbCecomp.ejb.dao;

import ejbCecomp.entidades.ejbCcoCepCursoDocente;
import ejbCecomp.entidades.ejbCcoCepHorarioDia;
import jakarta.ejb.Stateless;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import java.util.List;
import org.hibernate.Hibernate;

@Stateless
public class ejbCcoCepCursoDocenteDAO extends ejbCcoGenericoDAO<ejbCcoCepCursoDocente> implements ejbCcoCepCursoDocenteDAOLocal {

    @Override
    public List<ejbCcoCepCursoDocente> listarTodos() {
        TypedQuery<ejbCcoCepCursoDocente> query = em.createQuery(
            "SELECT g FROM CepCursoDocente g " +
            "JOIN FETCH g.cepPersonal " +
            "JOIN FETCH g.cepPersonal.idEsc " +
            "JOIN FETCH g.cepPersonal.idEsc.idDir " +
            "JOIN FETCH g.cepCurso " +
            "LEFT JOIN FETCH g.cepCecGrupoCurso",
            ejbCcoCepCursoDocente.class
        );
        return query.getResultList();
    }
    
    @Override
    public List<ejbCcoCepCursoDocente> listarActivos() {
        TypedQuery<ejbCcoCepCursoDocente> query = em.createQuery(
            "SELECT g FROM CepCursoDocente g " +
            "JOIN FETCH g.cepPersonal " +
            "JOIN FETCH g.cepPersonal.idEsc " +
            "JOIN FETCH g.cepPersonal.idEsc.idDir " +
            "JOIN FETCH g.cepCurso " +
            "LEFT JOIN FETCH g.cepCecGrupoCurso " +
            "WHERE g.estado = true",
            ejbCcoCepCursoDocente.class
        );
        return query.getResultList();
    }
    
    @Override
    public List<ejbCcoCepCursoDocente> listarConPrecios() {
        // Primero obtener las entidades principales
        List<ejbCcoCepCursoDocente> lista = em.createQuery(
            "SELECT DISTINCT g FROM CepCursoDocente g " +
            "JOIN FETCH g.cepCurso " +
            "LEFT JOIN FETCH g.cepCecGrupoCurso " +
            "WHERE g.estado = true", 
            ejbCcoCepCursoDocente.class
        ).getResultList();

        // Luego inicializar las colecciones por separado
        for (ejbCcoCepCursoDocente item : lista) {
            Hibernate.initialize(item.getCepGrupoPrecioList());
            Hibernate.initialize(item.getCepHorarioDiaList());
            for (ejbCcoCepHorarioDia dia : item.getCepHorarioDiaList()) {
                Hibernate.initialize(dia.getCepHorarioHora());
            }
        }

        return lista;
    }
    
    @Override
    public ejbCcoCepCursoDocente buscarPorId(Integer id) {
        TypedQuery<ejbCcoCepCursoDocente> query = em.createQuery(
            "SELECT g FROM CepCursoDocente g " +
            "JOIN FETCH g.cepPersonal " +
            "JOIN FETCH g.cepPersonal.idEsc " +
            "JOIN FETCH g.cepPersonal.idEsc.idDir " +
            "JOIN FETCH g.cepCurso " +
            "LEFT JOIN FETCH g.cepCecGrupoCurso " +
            "WHERE g.idAd = :id",
            ejbCcoCepCursoDocente.class
        );
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
    
    @Override
    public List<ejbCcoCepCursoDocente> buscarPorCurso(Integer idCurso) {
        TypedQuery<ejbCcoCepCursoDocente> query = em.createQuery(
            "SELECT g FROM CepCursoDocente g WHERE g.idCurso = :idCurso",
            ejbCcoCepCursoDocente.class
        );
        query.setParameter("idCurso", idCurso);
        return query.getResultList();
    }
    
    @Override
    public Integer obtenerUltimoIdGrupo() {
        try {
            Query query = em.createNativeQuery("SELECT ISNULL(MAX(id_ad), 0) + 1 FROM cep_curso_docente");
            return (Integer) query.getSingleResult();
        } catch (Exception e) {
            return 1;
        }
    }
    
    @Override
    public ejbCcoCepCursoDocente guardarGrupo(ejbCcoCepCursoDocente grupo) {
        try {
            Query idQuery = em.createNativeQuery("SELECT ISNULL(MAX(id_ad), 0) + 1 FROM cep_curso_docente");
            Integer nextId = (Integer) idQuery.getSingleResult();
            grupo.setIdAd(nextId);
            
            Query insertQuery = em.createNativeQuery(
                "INSERT INTO cep_curso_docente (id_ad, id_personal, id_curso, id_dep, estado, fecha, id_grupo, fecha_fin, cerra_aper, id_tipo_desarrollo) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"
            );
            
            insertQuery.setParameter(1, grupo.getIdAd());
            insertQuery.setParameter(2, grupo.getCepPersonal() != null ? grupo.getCepPersonal().getIdPersonal() : null);
            insertQuery.setParameter(3, grupo.getCepCurso()!= null ? grupo.getCepCurso().getIdCurso() : null);
            insertQuery.setParameter(4, grupo.getIdDep());
            insertQuery.setParameter(5, grupo.getEstado() ? 1 : 0);
            insertQuery.setParameter(6, grupo.getFecha());
            insertQuery.setParameter(7, grupo.getCepCecGrupoCurso() != null ? grupo.getCepCecGrupoCurso().getIdGrupo() : null);
            insertQuery.setParameter(8, grupo.getFechaFin());
            insertQuery.setParameter(9, grupo.getCerraAper() ? 1 : 0);
            insertQuery.setParameter(10, grupo.getCepCecTipoDesarrollo());
            
            insertQuery.executeUpdate();
            
            return grupo;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
    
    @Override
    public ejbCcoCepCursoDocente actualizarGrupo(ejbCcoCepCursoDocente grupo) {
        Query updateQuery = em.createNativeQuery(
            "UPDATE cep_curso_docente SET id_personal=?, id_curso=?, id_dep=?, estado=?, fecha=?, id_grupo=?, fecha_fin=?, cerra_aper=?, id_tipo_desarrollo=? WHERE id_ad=?"
        );
        
        updateQuery.setParameter(1, grupo.getCepPersonal() != null ? grupo.getCepPersonal().getIdPersonal() : null);
        updateQuery.setParameter(2, grupo.getCepCurso()!= null ? grupo.getCepCurso().getIdCurso() : null);
        updateQuery.setParameter(3, grupo.getIdDep());
        updateQuery.setParameter(4, grupo.getEstado() ? 1 : 0);
        updateQuery.setParameter(5, grupo.getFecha());
        updateQuery.setParameter(6, grupo.getCepCecGrupoCurso() != null ? grupo.getCepCecGrupoCurso().getIdGrupo() : null);
        updateQuery.setParameter(7, grupo.getFechaFin());
        updateQuery.setParameter(8, grupo.getCerraAper() ? 1 : 0);
        updateQuery.setParameter(9, grupo.getCepCecTipoDesarrollo() != null ? 
                         grupo.getCepCecTipoDesarrollo().getIdCiclo() : null);
        updateQuery.setParameter(10, grupo.getIdAd());
        
        updateQuery.executeUpdate();
        return grupo;
    }
    
    @Override
    public List<ejbCcoCepCursoDocente> listarGruposPorCodigoPago(String codigoPago) {
        System.out.println("DAO - Buscando grupos con codigoPago: '" + codigoPago + "'");

        Query query = em.createNativeQuery(
            "SELECT DISTINCT cd.* FROM cep_curso_docente cd " +
            "INNER JOIN cep_grupo_precio gp ON cd.id_ad = gp.id_ad " +
            "WHERE gp.codigo_pago = ? AND cd.estado = 1",
            ejbCcoCepCursoDocente.class
        );
        query.setParameter(1, codigoPago);
        List<ejbCcoCepCursoDocente> resultado = query.getResultList();
        System.out.println("DAO - Resultados encontrados: " + resultado.size());

        // Inicializar las colecciones para evitar LazyInitializationException
        for (ejbCcoCepCursoDocente item : resultado) {
            Hibernate.initialize(item.getCepGrupoPrecioList());
            Hibernate.initialize(item.getCepHorarioDiaList());
            if (item.getCepHorarioDiaList() != null) {
                for (ejbCcoCepHorarioDia dia : item.getCepHorarioDiaList()) {
                    Hibernate.initialize(dia.getCepHorarioHora());
                }
            }
        }

        return resultado;
    }
}
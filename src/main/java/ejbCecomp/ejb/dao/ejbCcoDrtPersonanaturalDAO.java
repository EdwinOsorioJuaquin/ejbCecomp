package ejbCecomp.ejb.dao;

import ejbCecomp.entidades.ejbCcoDrtPersonanatural;
import jakarta.ejb.Stateless;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import java.util.List;

@Stateless
public class ejbCcoDrtPersonanaturalDAO extends ejbCcoGenericoDAO<ejbCcoDrtPersonanatural> implements ejbCcoDrtPersonanaturalDAOLocal {

    @Override
    public List<ejbCcoDrtPersonanatural> listarTodos() {
        TypedQuery<ejbCcoDrtPersonanatural> query = em.createQuery(
            "SELECT p FROM DrtPersonanatural p",
            ejbCcoDrtPersonanatural.class
        );
        return query.getResultList();
    }
    
    @Override
    public List<ejbCcoDrtPersonanatural> listarActivos() {
        TypedQuery<ejbCcoDrtPersonanatural> query = em.createQuery(
            "SELECT p FROM DrtPersonanatural p WHERE p.estadoPernat = 'A'",
            ejbCcoDrtPersonanatural.class
        );
        return query.getResultList();
    }
    
    @Override
    public ejbCcoDrtPersonanatural buscarPorDni(String dni) {
        try {
            TypedQuery<ejbCcoDrtPersonanatural> query = em.createQuery(
                "SELECT p FROM DrtPersonanatural p WHERE p.numeroPndid = :dni",
                ejbCcoDrtPersonanatural.class
            );
            query.setParameter("dni", dni);
            List<ejbCcoDrtPersonanatural> result = query.getResultList();
            return result.isEmpty() ? null : result.get(0);
        } catch (Exception e) {
            return null;
        }
    }
       
    @Override
    public Integer obtenerUltimoIdPersona() {
        try {
            Query query = em.createNativeQuery("SELECT ISNULL(MAX(id_dir), 0) + 1 FROM drt_personanatural");
            return (Integer) query.getSingleResult();
        } catch (Exception e) {
            return 1;
        }
    }
    
    @Override
    public ejbCcoDrtPersonanatural guardarPersona(ejbCcoDrtPersonanatural persona) {
        try {
            // 1. Obtener el siguiente ID disponible
            Query idQuery = em.createNativeQuery("SELECT ISNULL(MAX(id_dir), 0) + 1 FROM drt_personanatural");
            Integer nextId = (Integer) idQuery.getSingleResult();
            persona.setIdDir(nextId);

            // 2. Insertar en drt_directorio (requerido por la relación @OneToOne)
            Query insertDirectorio = em.createNativeQuery(
                "INSERT INTO drt_directorio (id_dir, id_dclas, psp_cxt, psp_app, psp_uid, dateinsert) " +
                "VALUES (?, ?, ?, ?, ?, GETDATE())"
            );
            insertDirectorio.setParameter(1, nextId);
            insertDirectorio.setParameter(2, 1);  // id_dclas por defecto
            insertDirectorio.setParameter(3, (short) 0);
            insertDirectorio.setParameter(4, (short) 0);
            insertDirectorio.setParameter(5, 0);
            insertDirectorio.executeUpdate();

            // 3. Insertar en drt_personanatural
            Query insertQuery = em.createNativeQuery(
                "INSERT INTO drt_personanatural (id_dir, ap_materno, ap_paterno, nombre, sexo, fecha_nac, direccion, celular_prin, email_prin, nombre_completo, estado_pernat, fecha_ing, update_self, id_ubg_nac, id_ubg_pro, id_colegio, anio_egreso_cole, numero_pndid) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"
            );

            insertQuery.setParameter(1, persona.getIdDir());
            insertQuery.setParameter(2, persona.getApMaterno());
            insertQuery.setParameter(3, persona.getApPaterno());
            insertQuery.setParameter(4, persona.getNombre());
            insertQuery.setParameter(5, String.valueOf(persona.getSexo()));
            insertQuery.setParameter(6, persona.getFechaNac());
            insertQuery.setParameter(7, persona.getDireccion());
            insertQuery.setParameter(8, persona.getCelularPrin());
            insertQuery.setParameter(9, persona.getEmailPrin());
            insertQuery.setParameter(10, persona.getNombreCompleto());
            insertQuery.setParameter(11, String.valueOf(persona.getEstadoPernat()));
            insertQuery.setParameter(12, persona.getFechaIng());
            insertQuery.setParameter(13, persona.getUpdateSelf());
            insertQuery.setParameter(14, persona.getIdUbgNac());
            insertQuery.setParameter(15, persona.getIdUbgPro());
            insertQuery.setParameter(16, persona.getIdColegio());
            insertQuery.setParameter(17, persona.getAnioEgresoCole());
            insertQuery.setParameter(18, persona.getNumeroPndid());

            insertQuery.executeUpdate();

            return persona;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
    
    @Override
    public ejbCcoDrtPersonanatural actualizarPersona(ejbCcoDrtPersonanatural persona) {
        Query updateQuery = em.createNativeQuery(
            "UPDATE drt_personanatural SET ap_materno=?, ap_paterno=?, nombre=?, sexo=?, fecha_nac=?, direccion=?, celular_prin=?, email_prin=?, nombre_completo=?, update_self=?, numero_pndid=? WHERE id_dir=?"
        );
        
        updateQuery.setParameter(1, persona.getApMaterno());
        updateQuery.setParameter(2, persona.getApPaterno());
        updateQuery.setParameter(3, persona.getNombre());
        updateQuery.setParameter(4, String.valueOf(persona.getSexo()));
        updateQuery.setParameter(5, persona.getFechaNac());
        updateQuery.setParameter(6, persona.getDireccion());
        updateQuery.setParameter(7, persona.getCelularPrin());
        updateQuery.setParameter(8, persona.getEmailPrin());
        updateQuery.setParameter(9, persona.getNombreCompleto());
        updateQuery.setParameter(10, persona.getUpdateSelf());
        updateQuery.setParameter(11, persona.getNumeroPndid());
        updateQuery.setParameter(12, persona.getIdDir());
        
        updateQuery.executeUpdate();
        return persona;
    }
}
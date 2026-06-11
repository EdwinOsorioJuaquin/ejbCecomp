package ejbCecomp.ejb.dao;

import ejbCecomp.clases.ejbCcoAlumnoExternoDTO;
import ejbCecomp.entidades.*;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class ejbCcoCcoAlumnoExternoDAO extends ejbCcoGenericoDAO<ejbCcoCcoAlumnoExterno> implements ejbCcoCcoAlumnoExternoDAOLocal {

    @Override
    public ejbCcoCcoAlumnoExterno buscarPorCorreo(String correo) {
        TypedQuery<ejbCcoCcoAlumnoExterno> query =
            em.createQuery(
                "SELECT u FROM CcoAlumnoExterno u WHERE u.correoLogin = :correo",
                ejbCcoCcoAlumnoExterno.class
            );
        query.setParameter("correo", correo);
        List<ejbCcoCcoAlumnoExterno> resultado = query.getResultList();
        return resultado.isEmpty() ? null : resultado.get(0);
    }
    
    @Override
    public List<ejbCcoCcoAlumnoExterno> listarAlumnosExternos() {
        TypedQuery<ejbCcoCcoAlumnoExterno> query =
            em.createQuery(
                "SELECT u FROM CcoAlumnoExterno u WHERE u.anulado = 0",
                ejbCcoCcoAlumnoExterno.class
            );
        return query.getResultList();
    }
   
    @Override
    public ejbCcoDrtPersonanatural guardarPersona(ejbCcoDrtPersonanatural persona) {
        try {
            // 1. Obtener el siguiente ID disponible
            Query idQuery = em.createNativeQuery("SELECT ISNULL(MAX(id_dir), 0) + 1 FROM drt_personanatural");
            Integer nextId = (Integer) idQuery.getSingleResult();
            persona.setIdDir(nextId);

            // 2. Insertar en drt_directorio
            Query insertDirectorio = em.createNativeQuery(
                "INSERT INTO drt_directorio (id_dir, id_dclas, psp_cxt, psp_app, psp_uid, dateinsert) " +
                "VALUES (?, ?, ?, ?, ?, GETDATE())"
            );
            insertDirectorio.setParameter(1, nextId);
            insertDirectorio.setParameter(2, 1);
            insertDirectorio.setParameter(3, (short) 0);
            insertDirectorio.setParameter(4, (short) 0);
            insertDirectorio.setParameter(5, 0);
            insertDirectorio.executeUpdate();

            // 3. Insertar en drt_personanatural - AGREGANDO numero_pndid
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
            insertQuery.setParameter(18, persona.getNumeroPndid());  // ← DNI aquí

            insertQuery.executeUpdate();

            return persona;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
   
    @Override
    public void guardarAlumnoExterno(ejbCcoCcoAlumnoExterno alumno) {
        // Obtener el siguiente ID disponible para alumno externo
        Query idQuery = em.createNativeQuery("SELECT ISNULL(MAX(id_cco_usu_ex), 0) + 1 FROM cco_alumno_externo");
        Integer nextId = (Integer) idQuery.getSingleResult();
        alumno.setIdCcoUsuEx(nextId);
        
        // Insert manual con Native Query
        Query insertQuery = em.createNativeQuery(
            "INSERT INTO cco_alumno_externo (id_cco_usu_ex, correo_login, password, activo, anulado, id_dir) " +
            "VALUES (?, ?, ?, ?, ?, ?)"
        );
        
        insertQuery.setParameter(1, alumno.getIdCcoUsuEx());
        insertQuery.setParameter(2, alumno.getCorreoLogin());
        insertQuery.setParameter(3, alumno.getPassword());
        insertQuery.setParameter(4, alumno.getActivo());
        insertQuery.setParameter(5, alumno.getAnulado());
        insertQuery.setParameter(6, alumno.getDrtPersonanatural().getIdDir());
        
        insertQuery.executeUpdate();
    }
   
    @Override
    public ejbCcoDrtPersonanatural actualizarPersona(ejbCcoDrtPersonanatural persona) {
        Query updateQuery = em.createNativeQuery(
            "UPDATE drt_personanatural SET ap_materno=?, ap_paterno=?, nombre=?, sexo=?, fecha_nac=?, direccion=?, celular_prin=?, email_prin=?, nombre_completo=? WHERE id_dir=?"
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
        updateQuery.setParameter(10, persona.getIdDir());
        
        updateQuery.executeUpdate();
        return persona;
    }
   
    @Override
    public void actualizarAlumnoExterno(ejbCcoCcoAlumnoExterno alumno) {
        Query updateQuery = em.createNativeQuery(
            "UPDATE cco_alumno_externo SET correo_login=?, password=?, activo=?, anulado=? WHERE id_cco_usu_ex=?"
        );
        
        updateQuery.setParameter(1, alumno.getCorreoLogin());
        updateQuery.setParameter(2, alumno.getPassword());
        updateQuery.setParameter(3, alumno.getActivo());
        updateQuery.setParameter(4, alumno.getAnulado());
        updateQuery.setParameter(5, alumno.getIdCcoUsuEx());
        
        updateQuery.executeUpdate();
    }

    @Override
    public void cambiarEstado(Integer idAlumno, short estado) {
        Query updateQuery = em.createNativeQuery(
            "UPDATE cco_alumno_externo SET activo=? WHERE id_cco_usu_ex=?"
        );
        updateQuery.setParameter(1, estado);
        updateQuery.setParameter(2, idAlumno);
        updateQuery.executeUpdate();
    }
   
    @Override
    public List<ejbCcoAlumnoExternoDTO> listarAlumnosExternosDTO() {
        // Usar Native Query con JOIN para obtener datos de ambas tablas
        Query query = em.createNativeQuery(
            "SELECT a.id_cco_usu_ex, a.correo_login, a.activo, a.anulado, " +
            "       p.id_dir, p.numero_pndid, p.nombre_completo, p.email_prin, p.celular_prin, p.direccion " +
            "FROM cco_alumno_externo a " +
            "JOIN drt_personanatural p ON a.id_dir = p.id_dir " +
            "WHERE a.anulado = 0"
        );
        
        List<Object[]> results = query.getResultList();
        List<ejbCcoAlumnoExternoDTO> dtos = new ArrayList<>();
        
        for (Object[] row : results) {
            ejbCcoCcoAlumnoExterno alumno = new ejbCcoCcoAlumnoExterno();
            alumno.setIdCcoUsuEx((Integer) row[0]);
            alumno.setCorreoLogin((String) row[1]);
            alumno.setActivo((Short) row[2]);
            alumno.setAnulado((Short) row[3]);
            
            ejbCcoDrtPersonanatural persona = new ejbCcoDrtPersonanatural();
            persona.setIdDir((Integer) row[4]);
            persona.setNumeroPndid((String) row[5]);
            persona.setNombreCompleto((String) row[6]);
            persona.setEmailPrin((String) row[7]);
            persona.setCelularPrin((String) row[8]);
            persona.setDireccion((String) row[9]);
            
            alumno.setDrtPersonanatural(persona);
            dtos.add(new ejbCcoAlumnoExternoDTO(alumno));
        }
        return dtos;
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
    public Integer obtenerUltimoIdAlumno() {
        try {
            Query query = em.createNativeQuery("SELECT ISNULL(MAX(id_cco_usu_ex), 0) + 1 FROM cco_alumno_externo");
            return (Integer) query.getSingleResult();
        } catch (Exception e) {
            return 1;
        }
    }
    
    @Override
    public ejbCcoCcoAlumnoExterno buscarPorIdDir(Integer idDir) {
        try {
            TypedQuery<ejbCcoCcoAlumnoExterno> query = em.createQuery(
                "SELECT a FROM CcoAlumnoExterno a WHERE a.drtPersonanatural.idDir = :idDir",
                ejbCcoCcoAlumnoExterno.class
            );
            query.setParameter("idDir", idDir);
            List<ejbCcoCcoAlumnoExterno> results = query.getResultList();
            return results.isEmpty() ? null : results.get(0);
        } catch (Exception e) {
            return null;
        }
    }
    
    @Override
    public ejbCcoCcoAlumnoExterno buscarPorCodigoAlu(String codigoAlu) {
        try {
            TypedQuery<ejbCcoCcoAlumnoExterno> query = em.createQuery(
                "SELECT a FROM CcoAlumnoExterno a WHERE a.codigoAlu = :codigo",
                ejbCcoCcoAlumnoExterno.class
            );
            query.setParameter("codigo", codigoAlu);
            List<ejbCcoCcoAlumnoExterno> result = query.getResultList();
            return result.isEmpty() ? null : result.get(0);
        } catch (Exception e) {
            System.out.println("Error buscarPorCodigoAlu: " + e.getMessage());
            return null;
        }
    }
}
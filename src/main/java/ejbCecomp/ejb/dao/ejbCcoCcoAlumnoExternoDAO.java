
package ejbCecomp.ejb.dao;

import ejbCecomp.entidades.*;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;
import java.util.List;

/**
 * Implementación del DAO para Alumno Externo.
 * 
 * Encargado de ejecutar consultas hacia la base de datos
 * usando JPA (JPQL).
 * 
 */
@Stateless
public class ejbCcoCcoAlumnoExternoDAO extends ejbCcoGenericoDAO<ejbCcoCcoAlumnoExterno> implements ejbCcoCcoAlumnoExternoDAOLocal {

    /**
     * Busca un alumno externo en la base de datos
     * utilizando su correo de login.
     * 
     * @param correo Correo del alumno
     * @return Objeto alumno si existe, null si no se encuentra
     */
    @Override
    public ejbCcoCcoAlumnoExterno buscarPorCorreo(String correo) {

        // Consulta JPQL usando el nombre definido en @Entity(name="CcoAlumnoExterno")
        TypedQuery<ejbCcoCcoAlumnoExterno> query =
            em.createQuery(
                "SELECT u FROM CcoAlumnoExterno u WHERE u.correoLogin = :correo",
                ejbCcoCcoAlumnoExterno.class
            );

        // Asignación del parámetro
        query.setParameter("correo", correo);

        // Ejecución de la consulta
        List<ejbCcoCcoAlumnoExterno> resultado = query.getResultList();

        // Retorna el primer resultado o null si la lista está vacía
        return resultado.isEmpty() ? null : resultado.get(0);
    }
    
    /**
    * Lista alumnos externos con datos de persona
    */
   @Override
    public List<ejbCcoCcoAlumnoExterno> listarAlumnosExternos() {

        TypedQuery<ejbCcoCcoAlumnoExterno> query =
            em.createQuery(
                "SELECT u FROM CcoAlumnoExterno u WHERE u.anulado = 0",
                ejbCcoCcoAlumnoExterno.class
            );

        return query.getResultList();
    }
   
   /**
    * Guarda persona natural
    */
   @Override
   public ejbCcoDrtPersonanatural  guardarPersona(ejbCcoDrtPersonanatural persona) {
        em.persist(persona);
        return persona;
   }
   
   /**
    * Guarda alumno externo
    */
   @Override
   public void guardarAlumnoExterno(ejbCcoCcoAlumnoExterno alumno) {
       em.persist(alumno);
   }
   
   /**
    * Actualiza datos de persona
    */
   @Override
   public ejbCcoDrtPersonanatural actualizarPersona(ejbCcoDrtPersonanatural persona) {
       return em.merge(persona);
   }
   
    @Override
    public void actualizarAlumnoExterno(ejbCcoCcoAlumnoExterno alumno) {
        em.merge(alumno);
    }

   /**
    * Cambia estado del alumno externo
    */
   @Override
   public void cambiarEstado(Integer idAlumno, short estado) {

       ejbCcoCcoAlumnoExterno alumno = em.find(ejbCcoCcoAlumnoExterno.class, idAlumno);

       if (alumno != null) {
           alumno.setActivo(estado);
           em.merge(alumno);
       }
   }
}


package ejbCecomp.ejb.dao;

public abstract interface ejbCcoGenericoDAOLocal<T> {
    T crear(T entidad);
    T actualizar(T entidad);
    T buscarPorId(Object id);
}

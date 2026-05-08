package ejbCecomp.ejb.negocio;

import ejbCecomp.ejb.dao.ejbCcoEscPersonalDAOLocal;
import ejbCecomp.entidades.ejbCcoEscPersonal;
import jakarta.annotation.Resource;
import jakarta.ejb.Stateless;
import jakarta.ejb.TransactionManagement;
import jakarta.ejb.TransactionManagementType;
import jakarta.inject.Inject;
import jakarta.transaction.UserTransaction;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class ejbCcoEscPersonalService implements ejbCcoEscPersonalServiceLocal {

    @Resource
    private UserTransaction ut;

    @Inject
    private ejbCcoEscPersonalDAOLocal dao;

    @Override
    public List<ejbCcoEscPersonal> listarTodos() {
        return dao.listarTodos();
    }

    @Override
    public List<ejbCcoEscPersonal> listarActivos() {
        return dao.listarActivos();
    }
}
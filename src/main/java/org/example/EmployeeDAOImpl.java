package org.example;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.SQLException;

@Repository("EmployeeDAOImpl")
@Transactional(propagation = Propagation.REQUIRED)

public class EmployeeDAOImpl implements EmployeeDAO {

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void save(Employee employee) throws SQLException {

    }

    @Override
    public Employee findById(long employeeId) throws SQLException {
        return null;
    }

    /**
     *
     * @return the entityManager
     */

    public EntityManager getEntityManager(){
        return entityManager;
    }

    /**
     *
     * @param entityManager the entityManager to set
     */

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

}

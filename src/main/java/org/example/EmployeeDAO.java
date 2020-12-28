package org.example;

import java.sql.SQLException;

public interface EmployeeDAO {

    void save(Employee employee) throws SQLException;

    Employee findById(long employeeId) throws SQLException;

}

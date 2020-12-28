package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class SpringDataDemo {
    public static void main(String[] args) throws SQLException {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring_configuration.xml");

       // Fetching the DAO from Spring Bean Factory
        EmployeeDAO employeeDAO= (EmployeeDAO)context.getBean("EmployeeDaoImpl");
        Employee employee = new Employee("employee123");

        //employee.setEmployeeId("1");

        //Save an employee Object using the configured Data Source
        employeeDAO.save(employee);
        System.out.println("Employee Saved with EmployeeId"+employee.getEmployeeName());

        // find an object using PrimaryKey
        Employee emp = employeeDAO.findById(employee.getEmployeeId());
        System.out.println(emp);

        //Close the ApplicationContext
        ((ConfigurableApplicationContext)context).close();

    }
}

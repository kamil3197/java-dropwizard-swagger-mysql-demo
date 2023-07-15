package org.kainos.ea.api;

import org.kainos.ea.cli.Employee;
import org.kainos.ea.cli.IPayable;
import org.kainos.ea.cli.SalesEmployee;
import org.kainos.ea.cli.Contractor;
import java.util.ArrayList;
import java.util.List;

public class EmployeeService {
    public List<IPayable> getEmployees(){
        Employee employee = new Employee(1, "Kamil", 20000);
        SalesEmployee salesEmployee = new SalesEmployee(1, "Kamil", 20000, 1000, 0.01f);
        Contractor contractor = new Contractor("Kamil", 1000, 10);

        List<IPayable> employees = new ArrayList<>();
        employees.add(employee);
        employees.add(salesEmployee);
        employees.add(contractor);
        for (IPayable e: employees) {
            System.out.println(e.calcPay());
//            System.out.println(e.calcBonus());
        }
        return employees;
    }
}

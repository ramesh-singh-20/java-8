package dao;

import model.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {
    public static List<model.Employee> getEmployess(){
        List employees= new ArrayList();
        List<Long> telephones1= new ArrayList<>();
        telephones1.add(1l);
        telephones1.add(2l);
        telephones1.add(3l);

        List<Long> telephones2= new ArrayList<>();
        telephones2.add(4l);
        telephones2.add(5l);

        List<Long> telephones3= new ArrayList<>();
        telephones3.add(6l);

        List<Long> telephones4= new ArrayList<>();
        telephones4.add(7l);

        model.Employee emp1= new model.Employee(1, "Emp1",
                "dep1", "email1", telephones1, 20000.00);
        model.Employee emp2= new model.Employee(2, "Emp2",
                "dep2", "email2", telephones2, 67000.00);
        model.Employee emp3= new model.Employee(3, "Emp3",
                "dep1", "email3", telephones3, 3400.00);
        model.Employee emp4= new model.Employee(4, "Emp4",
                "dep2", "email4", telephones4, 37000.00);

        employees.add(emp1);
        employees.add(emp3);
        employees.add(emp2);
        employees.add(emp4);

        return employees;
    }
}

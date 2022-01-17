package service;

import dao.EmployeeDao;
import model.Employee;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EmployeeService {
    public void sortEmployeesById(){
        List<Employee> employees= EmployeeDao.getEmployess();

        System.out.println("*******Before Sorting************");
        System.out.println(employees);

        //Sorting by Comparator
        /*Comparator<Employee> employeeComparator= new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getEmployeeId()- o2.getEmployeeId();
            }
        };

        System.out.println("*******After Sorting************");
        Collections.sort(employees, employeeComparator);
        System.out.println(employees);*/

        //Sorting by implementing Comparator in a lambda expression

        //Comparator<Employee> employeeComparator= (Employee e1, Employee e2) -> e1.getEmployeeId()-e2.getEmployeeId();

        System.out.println("*******After Sorting************");
        Collections.sort(employees, (e1, e2)-> {
            return e1.getEmployeeId()- e2.getEmployeeId();
        });
        System.out.println(employees);

        //Printing all employeesNames using Stream
        System.out.println("**********Employee Names***************");
        employees.stream().forEach(emp-> System.out.println(emp.getEmployeeName()));

    }
}

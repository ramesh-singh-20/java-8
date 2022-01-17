package service;

import dao.EmployeeDao;
import model.Employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

        /*System.out.println("*******After Sorting************");
        Collections.sort(employees, (e1, e2)-> {
            return e1.getEmployeeId()- e2.getEmployeeId();
        });
        System.out.println(employees);*/

        System.out.println("*****Sorting using Stream");
        employees.stream().sorted((o1, o2) -> o1.getEmployeeName().compareTo(o2.getEmployeeName()))
                .forEach(emp -> System.out.println(emp.getEmployeeName()));

        System.out.println("*****Sorting using Stream via dept");
        employees.stream().sorted(Comparator.comparing(Employee:: getDepartment).reversed())
                .forEach(emp -> System.out.println(emp));


        //Printing all employeesNames using Stream
        System.out.println("**********Employee Names***************");
        employees.stream().forEach(emp-> System.out.println(emp.getEmployeeName()));

        //Printing employees name with even employee id
        System.out.println("Printing employee names having even employee id.");
        employees.stream().filter(emp -> emp.getEmployeeId()%2== 0)
                .forEach(emp-> System.out.println(emp.getEmployeeName()));

        List<Employee> employeeEmptyList= new ArrayList<>();
        //Supplier functional interface demo
        System.out.println(employeeEmptyList.stream().findAny().orElseGet(()-> new Employee(0, "default",
                "default", "default", null )));

    }
}

package service;

import dao.EmployeeDao;
import model.Employee;

import java.util.*;
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
        System.out.println(employeeEmptyList.stream().findAny().orElseGet(()->
                new Employee(0, "default",
                "default", "default", null,0.0 )));

    }

    public void mapFunctions(){
        Map<String, Integer> map= new HashMap();
        map.put("f", 1);
        map.put("h", 2);
        map.put("c", 3);
        map.put("e", 4);
        map.put("d", 1);
        map.put("a", 2);
        map.put("g", 3);
        map.put("b", 4);

        System.out.println(map);
        map.forEach((k, v) -> System.out.println(k + ":"+ v));
        map.entrySet().stream().forEach((obj) -> System.out.println(obj));
        System.out.println("Printing only even values.");
        map.entrySet().stream().filter(obj -> obj.getValue()%2 ==0).forEach(obj -> System.out.println(obj));

        System.out.println("*******Sorted by Value*********");
        map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(obj-> System.out.println(obj));
    }

    public void sortMapUsingStreams(){
        Map<Employee, Integer> employeeMap= new TreeMap<>((o1, o2)-> (int)(o1.getSalary()-o2.getSalary()));
        System.out.println("*****Empty Map*********");
        System.out.println(employeeMap);
        List<Employee> employeeList= EmployeeDao.getEmployess();

        employeeList.stream().forEach(emp-> employeeMap.put(emp, emp.getEmployeeId()));
        /*System.out.println("*****Employee Map Sorted Using TreeMap*********");
        System.out.println(employeeMap);*/

        System.out.println("******Sorting Map via Value**********");
        employeeMap.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(obj-> System.out.println(obj));

        System.out.println("******Sorting Map Using Stream**********");
        employeeMap.entrySet().stream().sorted(Map.Entry.comparingByKey(((o1, o2) -> (int)
                (o1.getSalary()-o2.getSalary())))).forEach(obj -> System.out.println(obj));
    }

    public void mapAndFlatMap(){
        List<Employee> employeeList= EmployeeDao.getEmployess();
        System.out.println("*****Printing emails using map function********");
        List<String> emails= employeeList.stream().map(emp-> emp.getEmail()).collect(Collectors.toList());
        System.out.println(emails);

        System.out.println("*****Printing phones using map function********");
        List<List<Long>> phoneList= employeeList.stream().map(emp -> emp.getTelephoneNumbers())
                .collect(Collectors.toList());
        System.out.println(phoneList);

        System.out.println("*****Printing all phones using flatMap function********");
        List<Long> phones= employeeList.stream().flatMap(emp -> emp.getTelephoneNumbers().stream())
                .collect(Collectors.toList());
        System.out.println(phones);
    }
}

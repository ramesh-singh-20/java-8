import service.EmployeeService;

import java.util.HashMap;
import java.util.Map;

public class AppMain {
    public static void main(String[] args) {
        EmployeeService service= new EmployeeService();
        service.sortEmployeesById();

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
}

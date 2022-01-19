import parallel_stream.ParallelStreamExample;
import service.EmployeeService;

public class AppMain {
    public static void main(String[] args) throws Exception {
        EmployeeService service= new EmployeeService();
        //service.sortEmployeesById();
        //service.mapFunctions();
        //service.sortMapUsingStreams();
        //service.mapAndFlatMap();
        //System.out.println(service.getEmployeeByEmail("email2"));
        //System.out.println(service.longestString());
        //service.analyzeSalary("dep1");
        ParallelStreamExample.parallelStream();
    }
}

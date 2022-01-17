import service.EmployeeService;

public class AppMain {
    public static void main(String[] args) {
        EmployeeService service= new EmployeeService();
        service.sortEmployeesById();
    }
}

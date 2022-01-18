package model;

import java.util.List;
import java.util.Objects;

public class Employee {
    private Integer employeeId;
    private String employeeName;
    private String department;
    private String email;
    private List<Long> telephoneNumbers;
    private Double salary;

    public Employee(Integer employeeId,
                    String employeeName,
                    String department, String email,
                    List<Long> telephoneNumbers,
                    Double salary) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.department = department;
        this.email = email;
        this.telephoneNumbers = telephoneNumbers;
        this.salary= salary;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getDepartment() {
        return department;
    }

    public String getEmail() {
        return email;
    }

    public List<Long> getTelephoneNumbers() {
        return telephoneNumbers;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelephoneNumbers(List<Long> telephoneNumbers) {
        this.telephoneNumbers = telephoneNumbers;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", department='" + department + '\'' +
                ", email='" + email + '\'' +
                ", telephoneNumbers=" + telephoneNumbers +
                ", salary=" + salary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return employeeId == employee.employeeId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId);
    }
}

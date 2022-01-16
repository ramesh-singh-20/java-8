package model;

import java.util.List;
import java.util.Objects;

public class Employee {
    private long employeeId;
    private String employeeName;
    private String department;
    private String emails;
    private List<Long> telephoneNumbers;

    public Employee(long employeeId, String employeeName, String department, String emails, List<Long> telephoneNumbers) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.department = department;
        this.emails = emails;
        this.telephoneNumbers = telephoneNumbers;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getDepartment() {
        return department;
    }

    public String getEmails() {
        return emails;
    }

    public List<Long> getTelephoneNumbers() {
        return telephoneNumbers;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setEmails(String emails) {
        this.emails = emails;
    }

    public void setTelephoneNumbers(List<Long> telephoneNumbers) {
        this.telephoneNumbers = telephoneNumbers;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", department='" + department + '\'' +
                ", emails='" + emails + '\'' +
                ", telephoneNumbers=" + telephoneNumbers +
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

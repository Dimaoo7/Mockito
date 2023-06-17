package pro.sky.mockito.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class EmployeeMap  {
    @JsonProperty("firstName")
    private String firstname;
    @JsonProperty("lastName")
    private String lastName;
    private final int salary;
    private final int department;


    public EmployeeMap(String firstname, String lastName, int salary, int department) {
        this.firstname = firstname;
        this.lastName = lastName;
        this.salary = salary;
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public int getDepartment() {
        return department;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return firstname + " " + lastName ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeMap that = (EmployeeMap) o;
        return Objects.equals(firstname, that.firstname) && Objects.equals(lastName, that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastName);
    }

    @Override
    public String toString() {
        return "EmployeeMap{" +
                "firstname='" + firstname + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                ", department=" + department +
                '}';
    }

    public Object getFirstName() {
        return firstname;
    }
}

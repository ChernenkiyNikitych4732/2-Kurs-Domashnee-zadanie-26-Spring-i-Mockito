package sky.pro.course2homework.springandmockito.objects;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class Employee {
    private final String name;
    private final String surname;
    private final String middlename;
    private final Integer department;
    private final Integer salary;

    public Employee(String name, String surname, String middlename, Integer department, Integer salary) {
        this.name = StringUtils.capitalize(name.toLowerCase());
        this.surname = StringUtils.capitalize(surname.toLowerCase());
        this.middlename = StringUtils.capitalize(middlename.toLowerCase());
        this.department = department;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public int getSalary() {
        return salary;
    }

    public Integer getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", middlename='" + middlename + '\'' +
                ", department=" + department +
                ", salary=" + salary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(getName(), employee.getName()) && Objects.equals(getSurname(), employee.getSurname()) && Objects.equals(getMiddlename(), employee.getMiddlename()) && Objects.equals(getDepartment(), employee.getDepartment()) && Objects.equals(getSalary(), employee.getSalary());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSurname(), getMiddlename(), getDepartment(), getSalary());
    }
}

package sky.pro.course2homework.springandmockito.services;

import sky.pro.course2homework.springandmockito.objects.Employee;

import java.util.List;

public interface EmployeeService {

    Employee addEmployee(String Name, String Surname, String Middlename, Integer department, Integer salary);

    Employee removeEmployee(String  Name, String Surname, String Middlename, Integer department, Integer salary);

    String findEmployee(String  Name, String Surname, String Middlename, Integer department, Integer salary);

    List<Employee> aListOfEmployees();

}
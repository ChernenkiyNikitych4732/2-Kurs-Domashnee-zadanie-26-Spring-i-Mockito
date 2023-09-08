package sky.pro.course2homework.springandmockito.servicesTest;

import org.junit.jupiter.api.Test;
import sky.pro.course2homework.springandmockito.exceptions.EmployeeAlreadyAddedException;
import sky.pro.course2homework.springandmockito.exceptions.EmployeeNotFoundException;
import sky.pro.course2homework.springandmockito.exceptions.EmployeeStorageIsFullException;
import sky.pro.course2homework.springandmockito.objects.Employee;
import sky.pro.course2homework.springandmockito.services.EmployeeServiceImpl;


import static org.junit.jupiter.api.Assertions.*;
import static sky.pro.course2homework.springandmockito.generators.EmployeeGenerator.*;


class EmployeeServiceImplTest {

    private final EmployeeServiceImpl employeeService = new EmployeeServiceImpl();

    @Test
    void addEmployee_success() {
        String name = IVAN_NAME;
        String surname = IVAN_SURNAME;
        String middlename = IVAN_MIDDLE_NAME;
        int salary = IVAN_SALARY;
        int department = DEPARTMENT_ONE;
        Employee expected = getIvanDepOne();
        Employee actual = employeeService.addEmployee(name, surname, middlename, department, salary);
        assertEquals(expected, actual);
    }

    @Test
    void addEmployee_withEmployeeAlreadyAddedException() {
        String name =IVAN_NAME;
        String surname = IVAN_SURNAME;
        String middlename = IVAN_MIDDLE_NAME;
        int salary = IVAN_SALARY;
        int department = DEPARTMENT_ONE;
        employeeService.addEmployee(name, surname, middlename, department, salary);
        String expectedMessage = "Сотрудник уже существует";
        Exception exception = assertThrows(EmployeeAlreadyAddedException.class, () -> employeeService
                .addEmployee(name, surname, middlename, department, salary));
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void addEmployee_withEmployeeStorageIsFullException() {
        String name = IVAN_NAME;
        String surname = IVAN_SURNAME;
        String middleName = IVAN_MIDDLE_NAME;
        int salary = IVAN_SALARY;
        int department = DEPARTMENT_ONE;
        employeeService.addEmployee(IVAN_NAME, IVAN_MIDDLE_NAME, IVAN_MIDDLE_NAME, DEPARTMENT_ONE, IVAN_SALARY);
        String expectedMessage = "Список сотрудников переполнен";

        Exception exception = assertThrows(EmployeeStorageIsFullException.class, () -> employeeService
                .addEmployee(name, surname, middleName, department, salary));
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void removeEmployee_withEmployeeNotFoundException() {
        String name = VADIM_NAME;
        String surname =VADIM_SURNAME;
        String middleName =VADIM_MIDDLE_NAME;
        int salary =VADIM_SALARY;
        int department = DEPARTMENT_ONE;
        assertThrows(EmployeeNotFoundException.class, () -> employeeService.
                removeEmployee(name, surname, middleName, department, salary));
    }

    @Test
    void findEmployee_success() {
        String name = MAKAR_NAME;
        String surname = MAKAR_SURNAME;
        String middlename =MAKAR_MIDDLE_NAME;
        int salary =MAKAR_SALARY;
        int department = DEPARTMENT_ONE;
        employeeService.addEmployee(name, surname, middlename, department, salary);
        String expected = employeeService.findEmployee(name, surname, middlename, department, salary);
        String actual = "Макар Дмитриевич";
        assertEquals(expected, actual);
    }

    @Test
    void findEmployee_withEmployeeNotFoundException() {
        String name = IVAN_NAME;
        String surname =IVAN_SURNAME;
        String middleName = IVAN_MIDDLE_NAME;
        int salary = IVAN_SALARY;
        int department = DEPARTMENT_ONE;
        String expectedMessage = "Сотрудник не найден";
        Exception exception = assertThrows(EmployeeNotFoundException.class, () -> employeeService
                .findEmployee(name, surname, surname, department, salary));
        assertEquals(expectedMessage, exception.getMessage());
    }
}
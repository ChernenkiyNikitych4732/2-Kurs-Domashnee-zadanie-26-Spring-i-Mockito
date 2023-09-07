package sky.pro.course2homework.springandmockito.servicesTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import sky.pro.course2homework.springandmockito.exceptions.EmployeeNotFoundException;
import sky.pro.course2homework.springandmockito.objects.Employee;
import sky.pro.course2homework.springandmockito.services.DepartmentService;
import sky.pro.course2homework.springandmockito.services.EmployeeService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static sky.pro.course2homework.springandmockito.generators.EmployeeGenerator.*;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceTest {

    @Mock
    private EmployeeService employeeService;


    @InjectMocks
    private DepartmentService departmentService;

    @Test
    void employeeWithMinSalary_Success() {
        int department = DEPARTMENT_ONE;


        Employee expected = getIvanDepOne();
        Employee ivanDepOne = getIvanDepOne();
        Employee vadimDepOne = getVadimDepOne();
        Employee makarDepTwo =getMakarDeptwo();

        Mockito.when(employeeService.aListOfEmployees())
                .thenReturn(List.of(ivanDepOne,vadimDepOne,makarDepTwo));
        Employee actual = departmentService.employeeWithMinSalary(department);
        assertEquals(expected, actual);
        assertEquals(department, actual.getDepartment());
        assertFalse(ivanDepOne.getSalary() <ivanDepOne.getSalary());
        verify(employeeService).aListOfEmployees();
    }

    @Test
    void employeeWithMinSalary_EmployeeNotFoundException() {
        int department = DEPARTMENT_ONE;
        String expectedMessage = "Сотрудник с минимальной зарплатой не найден";

    }

    @Test
    void employeeWithMaxSalary_Success() {
        int department = DEPARTMENT_ONE;
        Employee expected = getIvanDepOne();
        Employee ivanDepOne = getIvanDepOne();
        Employee vadimDepOne = getVadimDepOne();
        Employee makarDepTwo = getMakarDeptwo();

        Mockito.when(employeeService.aListOfEmployees())
                .thenReturn(List.of(ivanDepOne,vadimDepOne, makarDepTwo));
        Employee actual = departmentService.employeeWithMaxSalary(department);
        assertEquals(expected, actual);
        assertEquals(department, actual.getDepartment());
        assertFalse(ivanDepOne.getSalary() < ivanDepOne.getSalary());
        verify(employeeService).aListOfEmployees();
    }

    @Test
    void employeeWithMaxSalary_EmployeeNotFoundException() {
        int department = DEPARTMENT_ONE;
        String expectedMessage = "Сотрудник с максимальной зарплатой не найден";

        Exception exception = assertThrows(EmployeeNotFoundException.class, () -> departmentService.employeeWithMaxSalary(department));
        assertEquals(expectedMessage, exception.getMessage());
        verify(employeeService).aListOfEmployees();
    }

    @Test
    void findEmployeeByDepartment_Success() {
        Integer department = DEPARTMENT_ONE;
        Employee ivanDepOne = getIvanDepOne();
        Employee vadimDepOne = getVadimDepOne();
        Employee makarDepTwo = getMakarDeptwo();
        Map<Integer, List<Employee>> actual = departmentService.findEmployeeByDepartment(department);
        verify(employeeService).aListOfEmployees();
    }

    @Test
    void findEmployeeByDepartment_WithNullDep() {
        Integer department = null;
        Employee ivanDepOne = getIvanDepOne();
        Employee vadimDepOne = getVadimDepOne();
        Employee makarDepTwo = getMakarDeptwo();
        Map<Integer, List<Employee>> actual = departmentService.findEmployeeByDepartment(department);
        verify(employeeService).aListOfEmployees();
    }
}
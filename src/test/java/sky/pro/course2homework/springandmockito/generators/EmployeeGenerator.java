package sky.pro.course2homework.springandmockito.generators;

import sky.pro.course2homework.springandmockito.objects.Employee;

public class EmployeeGenerator {
    public static final String IVAN_NAME = "Иван";
    public static final String IVAN_SURNAME = "Виноградов";
    public static final String IVAN_MIDDLE_NAME = "Максимович";
    public static final  int IVAN_SALARY = 320000;

    public static final  int DEPARTMENT_ONE = 1;
    public static final  int DEPARTMENT_TWO = 2;

    public static Employee getIvanDepOne() {
        return new Employee(IVAN_NAME, IVAN_SURNAME, IVAN_MIDDLE_NAME, DEPARTMENT_ONE, IVAN_SALARY);
    }

    public static final String VADIM_NAME = "Вадим";
    public static final String VADIM_SURNAME = "Егоров";
    public static final String VADIM_MIDDLE_NAME = "Маркович";
    public static final  int VADIM_SALARY = 320000;

    public static Employee getVadimDepOne() {
        return new Employee(VADIM_NAME, VADIM_SURNAME, VADIM_MIDDLE_NAME, DEPARTMENT_ONE, VADIM_SALARY);
    }

    public static final String MAKAR_NAME = "Макар";
    public static final String MAKAR_SURNAME = "Филатов";
    public static final String MAKAR_MIDDLE_NAME = "Дмитриевич";
    public static final  int MAKAR_SALARY = 320000;

    public static Employee getMakarDeptwo() {
        return new Employee(MAKAR_NAME, MAKAR_SURNAME, MAKAR_MIDDLE_NAME, DEPARTMENT_ONE, MAKAR_SALARY);
    }

}
package organization;
import java.util.*;

public class Department {

// разные подразделения	имеют разные имена
    private String departmentName;

// класс хранит	явным образом массив своих работников
    private Employee[] employees;

// конструктор может принимать имя подразделения (в	этом случае	количество работников =	0)
    public Department(String departmentName){
        this.departmentName = departmentName;
        employees = new Employee[0];
    }

// конструктор может принимать массив работников
    public  Department(Employee[] employees){
        this.employees = employees;
    }

// метод получения имени подразделения
    public String getDepartmentName(){
        return departmentName;
    }

// метод изменения имени подразделения
    public void setDepartmentName(String departmentName){
        this.departmentName = departmentName;
    }

// возвращающий	общее число	работников подразделения
    public int getEmployeesQuantity(){
        return this.employees.length;
    }

// возвращающий	суммарную зарплату всех	работников, относящихся	к данному подразделению
    public double getTotalSalary(){
        double totalSalary = 0;
        for (Employee employee:employees){
            totalSalary += employee.getSalary();
        }
        return totalSalary;
    }

// метод, возвращающий ссылку на работника по фамилии и имени
   public Employee getEmployee(String firstName, String lastName) {
        for (Employee employee:employees){
            if (employee.getFirstName()==firstName && employee.getLastName()==lastName){
                return employee;
            }
        }
        return null;
    }

// метод увольнения	работника (принимает в качестве	входных	параметров
// фамилию,	имя, должность работника, которого нужно удалить, удаляет
// соответствующий этим	данным элемент из массива работников);
    public void employeeDismission(String firstName, String lastName, JobTitles position){
        for (int i=0; i<employees.length; i++){
            if (employees[i].getFirstName() == firstName && employees[i].getLastName() == lastName && employees[i].getPosition() == position) {
                Employee[] tempArray = new Employee[employees.length-1];
                if(i!=employees.length-1){
                    System.arraycopy(employees, 0, tempArray,0,i);
                    System.arraycopy(employees, i+1, tempArray, i, tempArray.length - i);
                }else{
                    System.arraycopy(employees, 0, tempArray, 0, tempArray.length);
                }
                employees=tempArray;
            }
        }
    }

// создайте	метод приема работника на работу (принимает	в качестве входных
// параметров ссылку на	экземпляр класса Employee, расширяет массив	работников
// путем добавления	нового элемента	в конец	массива);
    public void hireEmployee(Employee employee){
        Employee[] tempArray = new Employee[employees.length+1];
        System.arraycopy(employees, 0, tempArray, 0, employees.length);
        tempArray[tempArray.length-1] = employee;
        employees = tempArray;
    }

// метод, возвращающий массив работников отдела
    public Employee[] getEmployees(){
        return employees;
    }

// метод, возвращающий массив работников отдела, отсортированный по
// фамилиям	(и если	одинаковые фамилии – то	по именам);
    public Employee[] sortedEmployees(){
        Comparator<Employee> employee_Name_Comparator
                = Comparator.comparing(Employee::getLastName)
                .thenComparing(Employee::getFirstName);
        Arrays.sort(employees, employee_Name_Comparator);
        return employees;
    }

}


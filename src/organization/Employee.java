package organization;

import java.util.*;

abstract public class Employee{

//каждый работник занимает определенную	должность
//каждый	работник	получает	определенное	жалование
//каждый	работник	характеризуется	именем	и	фамилией
//дата приема на работу (экземпляр класса Date);
//приватное	поле, содержащее должность сотрудника, должно быть экземпляром перечисления	JobTitles
    private JobTitles position;
    private double salary;
    private String firstName;
    private String lastName;
    private Date hireDate;

// конструктор может принимать имя и фамилию (должность – инженер, жалование – 30к руб.);
    public Employee(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }
// конструктор может принимать имя, фамилию, должность, жалование
    public Employee(String firstName, String lastName, JobTitles position, double salary){
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.salary = salary;
    }

// конструктор,	принимающий	имя, фамилию, должность, жалование, дату	приема
public Employee(String firstName, String lastName, JobTitles position, double salary, Date hireDate){
    this.firstName = firstName;
    this.lastName = lastName;
    this.position = position;
    this.salary = salary;
    this.hireDate = hireDate;
}

// метод получения имени
    public String getFirstName(){
        return firstName;
    }

// метод изменения имени
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

// метод получения фамилии
    public String getLastName(){
        return lastName;
    }

// метод изменения фамилии
    public void setLastName(String lastName){
        this.lastName = lastName;
    }

// метод получения должности
    public JobTitles getPosition(){
        return position;
    }

// метод изменения должности
    public void setPosition(JobTitles position){
        this.position = position;
    }

// метод получения жалования
    public double getSalary(){
        return salary;
    }

// метод изменения жалования
    public void setSalary(double salary){
        this.salary = salary;
    }

// метод получения даты приёма
    public Date getHireDate(){
        return this.hireDate;
    }

// метод изменения даты приёма
    public void setHireDate(Date hireDate){
        this.hireDate = hireDate;
    }

// абстрактный открытый	метод, возвращающий	ежемесячную	премию;
    abstract public double getMonthlyBonus();

}

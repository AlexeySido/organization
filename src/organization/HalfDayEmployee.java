package organization;

import java.util.Date;

public class HalfDayEmployee extends Employee{

// такие же	конструкторы, что и	в классе Employee
    public HalfDayEmployee(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public HalfDayEmployee(String firstName, String lastName, JobTitles position, double salary) {
        super(firstName, lastName, position, salary);
    }

    public HalfDayEmployee(String firstName, String lastName, JobTitles position, double salary, Date hireDate) {
        super(firstName, lastName, position, salary, hireDate);
    }

// Метод, возвращает ежемесячную премию. Этот метод возвращает 0.
    @Override
    public double getMonthlyBonus() {
        return 0;
    }
}

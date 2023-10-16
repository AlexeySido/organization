package organization;

import java.util.*;

public class FullDayEmployee extends Employee implements BusinessTraveller{

// приватное поле типа ArrayList<BusinessTravel> - этот	список будет
// содержать всю информацию	о командировках	сотрудника
// При создании экземпляра сотрудника, в конструкторах, это	поле инициируется списком нулевой длины
    ArrayList<BusinessTravel> businessTripInformation;

    public FullDayEmployee(String firstName, String lastName) {
        super(firstName = firstName, lastName = lastName);
        businessTripInformation = new ArrayList<BusinessTravel>(0);
    }

    // конструктор может принимать имя, фамилию, должность, жалование
    public FullDayEmployee(String firstName, String lastName, JobTitles position, double salary){
        super(firstName=firstName, lastName=lastName, position=position, salary=salary);
        businessTripInformation = new ArrayList<BusinessTravel>(0);
    }

    // конструктор,	принимающий	имя, фамилию, должность, жалование, дату	приема
    public FullDayEmployee(String firstName, String lastName, JobTitles position, double salary, Date hireDate){
        super(firstName, lastName, position, salary, hireDate);
    }

// Метода, возвращающий ежемесячную премию. Она вычисляется
// как число полных	лет, которые проработал	сотрудник в	компании,
// делённое на 20. Кроме	того, если зарплата	начисляется	в январе (то есть текущий
// месяц – январь), премия увеличивается на	размер оклада (для определения текущей
// даты	используется класс Calendar)
    @Override
    public double getMonthlyBonus() {
        //определим отработанное время в годах
        int workedTime = (int) ((new Date().getTime() - this.getHireDate().getTime())/24*60*60*1000*365);
        Calendar rightNow = Calendar.getInstance();//текущая дата
        if(rightNow.MONTH == 0){//-January
            return workedTime/20 + this.getSalary();
        }else{
            return workedTime/20;
        }
    }

// метод добавления	информации о командировке
    @Override
    public void setBusinessTripInformation(BusinessTravel businessTravel) {
        this.businessTripInformation.add(businessTravel);
    }

// метод удаления информации о командировке	(принимает параметр	дату отбытия);
    @Override
    public void resetBusinessTripInformation(Date departureDate) {
        //Cоздаём итератор, т.к. в ArrayList несколько элементов удаляются через iterator,
        //во-избежании конфликта одновременного удаления и перебора элементов
        Iterator<BusinessTravel> businessTravelIterator = businessTripInformation.iterator();
        while(businessTravelIterator.hasNext()) {//до тех пор, пока в списке есть элементы
            BusinessTravel nextBusinessTravel = businessTravelIterator.next();//получаем следующий элемент
            if (nextBusinessTravel.getDepartureDate().equals(departureDate)) {
                businessTravelIterator.remove();//удаляем объект с требуемой датой
            }
        }
    }

// метод, возвращающий (ссылку на) экземпляр класса	BusinessTravel по дате
// (если введенная дата	попадает в интервал	между началом и	концом командировки);
    @Override
    public BusinessTravel getBusinessTraveler(Date departureDate, Date returnDate) {
        for (BusinessTravel businessTravel: businessTripInformation){
            if (businessTravel.getDepartureDate()==departureDate && businessTravel.getReturnDate()==returnDate){
                return businessTravel;
            }
        }
        return null;
    }

// метод, возвращающий среднюю продолжительность командировок работника;
    @Override
    public int getAverageBusinessTripsDuration() {
        int businessTripDays = 0;
        for(BusinessTravel businessTravel: businessTripInformation){
            businessTripDays += businessTravel.getBusinessTripDays();
        }
        return businessTripDays/businessTripInformation.size();
    }

 // метод, возвращающий средний интервал между командировками в днях!!!!!!!!!!!!!!!!!!
    @Override
    public int getAverageBusinessTripGap() {
        ListIterator<BusinessTravel> businessTravelIterator = businessTripInformation.listIterator();
        int gap = 0;
        long prev = 0;
        long next;
        int index=0;
        while(businessTravelIterator.hasNext()) {//до тех пор, пока в списке есть элементы
            BusinessTravel nextBusinessTravel = businessTravelIterator.next();
            index = businessTravelIterator.nextIndex();//определяем индекс элемента в списке
            if (index==0){
                prev = nextBusinessTravel.getReturnDate().getTime();//дата возвращения 1-го. элемента
            }else{
                next = nextBusinessTravel.getDepartureDate().getTime();//дата отправления 2...n-го. элемента
                gap += (int)(next - prev)/(1000*60*60*24);//дни между командировками
                prev = nextBusinessTravel.getReturnDate().getTime();//дата возвращения 2...n-го. элемента
            }
        }
        System.out.println(gap/(index-1));
        return gap;
    }
}

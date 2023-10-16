package organization;

import java.util.*;

public class BusinessTravel {

//дата отбытия с предприятия в командировку
//дата прибытия
//стоимость	трансфера до места и назад
//суточные
    private Date departureDate;
    private Date returnDate;
    private double transferCosts;
    private double dailyAllowance;

// конструктор по умолчанию, не	инициирующий поля (пустой конструктор)
    public BusinessTravel(){};

// конструктор с параметрами: дата отбытия с предприятия в командировку, дата
// прибытия, стоимость трансфера до	места и	назад, суточные
    public BusinessTravel(Date departureDate, Date returnDate, double transferCosts, double dailyAllowance){
        this.departureDate = departureDate;
        this.returnDate = returnDate;
        this.transferCosts = transferCosts;
        this.dailyAllowance = dailyAllowance;
    }

// открытые	гетеры и сеттеры полей
    public Date getDepartureDate(){
        return this.departureDate;
    }

    public void setDepartureDate(Date departureDate){
        this.departureDate = departureDate;
    }

    public Date getReturnDate(){
        return this.returnDate;
    }

    public void setReturnDate(Date returnDate){
        this.returnDate = returnDate;
    }

    public double getTransferCosts(){
        return this.transferCosts;
    }

    public void setTransferCosts(double transferCosts){
        this.transferCosts = transferCosts;
    }

    public double getDailyAllowance(){
        return this.dailyAllowance;
    }

    public void setDailyAllowance(double dailyAllowance){
        this.dailyAllowance = dailyAllowance;
    }

// метод возвращающий число	полных дней	между датами отбытия и прибытия
    public int getBusinessTripDays(){
        int days = (int)((this.getReturnDate().getTime() - this.getDepartureDate().getTime())/(1000*60*60*24));
        return days;
    }

// метод, возвращающий общую сумму затраченных на командировку денег (трансфер + суточные *	кол-во дней)
    public double getTotalExpenses(){
        return this.getTransferCosts()+this.getDailyAllowance()*this.getBusinessTripDays();
    }
}

package organization;
import java.util.*;

public interface BusinessTraveller {

// метод добавления	информации о командировке
    void setBusinessTripInformation(BusinessTravel businessTravel);

// метод удаления информации о командировке	(принимает параметр	дату отбытия);
    void resetBusinessTripInformation(Date departureDate);

// метод, возвращающий (ссылку на) экземпляр класса	BusinessTravel по дате
// (если введенная дата	попадает в интервал	между началом и	концом командировки);
    BusinessTravel getBusinessTraveler(Date departureDate, Date returnDate);

// метод, возвращающий среднюю продолжительность командировок работника;
    int getAverageBusinessTripsDuration();

// метод, возвращающий средний интервал	между командировками в днях
    int getAverageBusinessTripGap();

}

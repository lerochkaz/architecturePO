package hw4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * Класс для работы с базой данных в той части, где это касается билетов
 */
public class TicketProvider {

    // region Methods

    /**
     * Метод получения всех билетов конкретного пассажира на определенную дату
     *
     * @param clientId - id пассажира, date - дата
     * @return список билетов
     *
     */
    public Collection<Ticket> searchTicket(int clientId, Date date) {
        // Предусловие - можно проверить, что такой пассажир в принципе существует, а
        // также что существуют хоть какие-то билеты в базе
        // В принципе можно еще проверить адекватность даты, но я рассчитываю на то,
        // что её вводят в специальную форму в виде календаря, которая сама по себе
        // осуществляет такую проверку.
        if (database.getCustomer(clientId) == null) {
            throw new RuntimeException("Такой пассажир не найден.");
        }
        if (database.getTickets().size() == 0) {
            throw new RuntimeException("Купленные билеты отсутствуют.");
        }
        // Выполнение подпрограммы:
        Collection<Ticket> tickets = new ArrayList<>();
        for (Ticket ticket : database.getTickets()) {
            if (ticket.getCustomerId() == clientId && ticket.getDate().equals(date))
                tickets.add(ticket);
        }
        // Постусловие
        if (tickets.size() == 0) {
            throw new RuntimeException("Не найдено билетов, соответствующих запросу.");
        }
        return tickets;
    }

    /**
     * Метод покупки билетика
     *
     * @param clientId - id пассажира, cardNo - номер карты
     *                 если билет успешно оплачен (в этой модели он успешно оплачен
     *                 всегда), добавляем его пассажиру и вообще в БД
     * @return true
     */
    public boolean buyTicket(int clientId, String cardNo) {
        // Предусловие - можно проверить, что такой пассажир в принципе существует
        if (database.getCustomer(clientId) == null) {
            throw new RuntimeException("Такой пассажир не найден.");
        }
        // Выполнение подпрограммы:
        int orderId = database.createTicketOrder(clientId);
        double amount = database.getTicketAmount();
        // Инвариант - в целом можно бы отнести то, что делает сторонний сервис оплатыю
        // к инварианту.
        // Если оплату произвести не удалось, то сторонний сервис и выбросит исключение.
        // Так как неизвестно, как там у них это реализовано, далее я все-таки
        // оборачиваю действия в условие.
        // paymentProvider.buyTicket(orderId, cardNo, amount);
        if (paymentProvider.buyTicket(orderId, cardNo, amount)) {
            if (database.getCustomer(clientId) != null) {
                Ticket boughtTicket = new Ticket();
                database.getCustomer(clientId).addTicketToCustomer(boughtTicket);
                database.getTickets().add(boughtTicket);
            }
        }
        return true;
    }

    /**
     * Метод позволяет "предъявить" билет для проезда: билет проверяется на
     * валидность
     * и в слчае успеха отмечается, что билет использован
     *
     * @param qrcode - qrcode билета
     * @return false - новый статус билета
     *
     */
    public boolean checkTicket(String qrcode) {
        // Предусловие - можно проверить адекватность введенного qrcode (допустим, пусть
        // будет длиннее 2 знаков)
        if (qrcode.length() < 2) {
            throw new RuntimeException("Некорректный qr-code.");
        }
        // Выполнение подпрограммы:
        for (Ticket ticket : database.getTickets()) {
            if (ticket.getQrcode().equals(qrcode)) {
                ticket.setEnable(false);
                // Save database ...
                return true;
            }
        }
        return false;
    }
    // endregion

    // region Constructors
    public TicketProvider(Database database, PaymentProvider paymentProvider) {
        this.database = database;
        this.paymentProvider = paymentProvider;
    }
    // endregion

    // region Fields
    private final Database database;
    private final PaymentProvider paymentProvider;
    // endregion
}

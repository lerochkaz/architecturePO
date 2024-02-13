package hw4;

import java.util.Collection;
import java.util.Date;

public class Program {

    /**
     * Разработать контракты и компоненты системы "Покупка онлайн билетов на автобус
     * в час пик".
     * <p>
     * 1. Предусловия.
     * 2. Постусловия.
     * 3. Инвариант.
     * 4. Определить абстрактные и конкретные классы.
     * 5. Определить интерфейсы.
     * 6. Реализовать наследование.
     * 7. Выявить компоненты.
     * 8. Разработать Диаграмму компонент использую нотацию UML 2.0. Общая без
     * деталей.
     */
    public static void main(String[] args) {
        // создается объект Core, в нем внутри сразу создаются БД и все три провайдера.
        // БД не пустая, там созданы 10 клиентов, и у каждого уже есть билетики
        Core core = new Core();
        MobileApp mobileApp = new MobileApp(core.getTicketProvider(), core.getCustomerProvider());
        BusStation busStation = new BusStation(core.getTicketProvider());

        // можно посмотреть список клиентов (пока их тут мало, можно просто выводить
        // всех):
        for (Customer customer : core.getDatabase().getCustomers()) {
            System.out.println(customer);
        }

        // пусть кто-нибудь куда-нибудь поедет, используя свой билет:
        Customer cust = core.getDatabase().getCustomer(5);

        busStation.goOnBus(cust);

        // пусть пассажир потратит все свои билеты (изначально у них по пять билетов):
        for (int i = 1; i <= 4; i++) {
            busStation.goOnBus(cust);
        }
        // теперь пусть попробует поехать снова (по логике программы его должны не
        // пустить и перекинуть на покупку билета):
        busStation.goOnBus(cust);

        // просто покупка билета:
        core.getTicketProvider().buyTicket(5, "gghk");
        System.out.println(cust);
    }

}

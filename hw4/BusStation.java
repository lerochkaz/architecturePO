package hw4;

// Автобусная станция (отдельный комплекс)

public class BusStation {

    private final TicketProvider ticketProvider;

    public BusStation(TicketProvider ticketProvider) {
        this.ticketProvider = ticketProvider;
    }

    public boolean checkTicket(String qrCode) {
        return ticketProvider.checkTicket(qrCode);
    }

    public void goOnBus(Customer passenger) {
        Boolean ok = false;
        for (Ticket ticket : passenger.getTickets()) {
            if (ticket.isEnable()) {
                ticket.setEnable(false);
                System.out.println("Проезд оплачен. Хорошей поездки!");
                ok = true;
                break;
            }
        }
        if (!ok) {
            System.out.println("У вас нет подходящих билетов. Переадресуем на страницу покупки билетов.");
            String cardNumber = "number to buy ticket";
            ok = ticketProvider.buyTicket(passenger.getId(), cardNumber);
        }
    }
}
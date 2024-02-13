package hw4;

import java.util.Collection;
import java.util.Date;

public class MobileApp {

    // region Methods
    public void searchTicket(Date date) {
        customer.setTickets(ticketProvider.searchTicket(customer.getId(), new Date()));
    }

    public boolean buyTicket(String cardNo) {
        return ticketProvider.buyTicket(customer.getId(), cardNo);
    }
    // endregion

    // region Constructors
    public MobileApp(TicketProvider ticketProvider, CustomerProvider customerProvider) {
        this.ticketProvider = ticketProvider;

        customer = customerProvider.getCustomer("login", "password");
    }
    // endregion

    // region Public Properties
    public Collection<Ticket> getTickets() {
        return customer.getTickets();
    }
    // endregion

    // region Fields
    private final Customer customer;
    private final TicketProvider ticketProvider;
    // endregion
}

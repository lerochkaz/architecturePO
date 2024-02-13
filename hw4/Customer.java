package hw4;

import java.util.ArrayList;
import java.util.Collection;

public class Customer {

    // region Methods
    public void addTicketToCustomer(Ticket newTicket) {
        tickets.add(newTicket);
        System.out.println("New ticket" + " added to " + this.login);
    }

    @Override
    public String toString() {
        return "Customer " + login + ", куплено билетов: " + getTickets().size();
    }

    // endregion

    // region Constructors

    {
        id = ++counter;
    }

    public Customer(String login, String password) {
        this.login = login;
        this.password = password;
        this.tickets = new ArrayList<>();
    }

    public Customer() {
        this.login = "login-" + id;
        this.password = "password-" + id;
        this.tickets = new ArrayList<>();
    }

    // endregion

    // region Public Properties
    public Collection<Ticket> getTickets() {
        return tickets;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTickets(Collection<Ticket> tickets) {
        this.tickets = tickets;
    }

    public int getId() {
        return id;
    }
    // endregion

    // region Fields
    private static int counter;
    private final int id;
    public String login;
    public String password;
    private Collection<Ticket> tickets;

    // endregion

}

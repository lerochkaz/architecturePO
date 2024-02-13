package hw4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Random;

public class Database {

    private static int counter;

    public Database() {

        for (int i = 1; i <= 10; i++) {
            String login = "Test customer " + i;
            String password = "Test password" + i;
            Customer customer = new Customer(login, password);
            customers.add(customer);
        }
        Random r = new Random();
        for (Customer customer : customers) {
            ArrayList<Ticket> t = new ArrayList<>();
            for (int i = 1; i <= 5; i++) {
                Ticket newTicket = new Ticket();
                newTicket.setCustomerId(customer.getId());
                newTicket.setQrcode(r.nextInt(1000, 5000));
                newTicket.setDate(new Date());
                t.add(newTicket);
                tickets.add(newTicket);
            }
            customer.setTickets(t);
        }
    }

    private Collection<Ticket> tickets = new ArrayList<>();
    private Collection<Customer> customers = new ArrayList<>();

    public Collection<Ticket> getTickets() {
        return tickets;
    }

    public Collection<Customer> getCustomers() {
        return customers;
    }

    public Customer getCustomer(int id) {
        for (Customer customer : getCustomers()) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        return null;
    }

    /**
     * Получить актуальную стоимость билета
     * 
     * @return
     */
    public double getTicketAmount() {
        return 55;
    }

    /**
     * Получить идентификатор заявки на покупку билета
     * 
     * @return
     */
    public int createTicketOrder(int clientId) {
        return ++counter;
    }

}

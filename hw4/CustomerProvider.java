package hw4;

/**
 * Класс для работы с базой данных в той части, где это касается пассажиров
 */
public class CustomerProvider {

    private final Database database;

    public CustomerProvider(Database database) {
        this.database = database;
    }

    /**
     * Метод получения конкретного пассажира из базы данных
     *
     * @param login, password данные пассажира
     * @return пассажир либо null, если пассажира с указанными данными в БД нет
     */
    public Customer getCustomer(String login, String password) {
        for (Customer customer : database.getCustomers()) {
            if (customer.login.equals(login) && customer.password.equals(password)) {
                return customer;
            }
        }
        return null;
    }

}

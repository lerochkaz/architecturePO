package hw4;

public class PaymentProvider {

    public boolean buyTicket(int orderId, String cardNo, double amount) {
        // Посылаем запрос на формирование заявки на проведение платежа в процессинговую
        // компанию (ProcessingCompany)
        System.out.println("Билетик куплен.");
        return true;
    }
}

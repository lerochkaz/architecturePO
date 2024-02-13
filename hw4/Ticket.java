package hw4;

import java.util.Date;

class Ticket {

    // region Methods
    @Override
    public String toString() {
        return "Ticket " + id + ", date: " + getDate().toString() + ", enable status: " + isEnable();
    }
    // endregion

    // region Constructors

    {
        id = ++counter;
    }
    // endregion

    // region Public Properties
    public int getId() {
        return id;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getQrcode() {
        return qrcode;
    }

    public void setQrcode(int Qrcode) {
        this.customerId = Qrcode;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    // endregion

    // region Fields

    private static int counter;
    private int id;
    private int customerId;
    private Date date;
    private String qrcode;

    private boolean enable = true;
    // endregion

}

package model.User;

public class Client extends Person{
    private String type;
    private double balance;
    private int rentCount;
    private boolean vip;

    public Client() {super();}

    public Client(String name, String email, String password, String type, double balance, int rentCount, boolean vip) {
        super(name, email, password);
        this.type = type;
        this.balance = balance;
        this.rentCount = rentCount;
        this.vip = vip;
    }

    public String getType() {
        return type;
    }

    public double getBalance() { return balance; }

    public int getRentCount() { return rentCount; }

    public boolean getVip() { return vip; }

    public void setType(String type) {
        this.type = type;
    }

    public void setBalance(double balance) { this.balance = balance; }

    public void setRentCount(int rentCount) { this.rentCount = rentCount; }

    public void setVip(boolean vip) { this.vip = vip; }
}

package model.User;

public class Client extends Person{
    private String type;
    private double balance;

    public Client() {super();}

    public Client(String name, String email, String password, String type, double balance) {
        super(name, email, password);
        this.type = type;
        this.balance = balance;
    }

    public String getType() {
        return type;
    }

    public double getBalance() { return balance; }

    public void setType(String type) {
        this.type = type;
    }

    public void setBalance(double balance) { this.balance = balance; }
}

package dto.Client;

public class ClientGetDTO {
    private int id;
    private String name;
    private String email;
    private String type;
    private double balance;
    private int rentCount;
    private boolean vip;

    public ClientGetDTO(
            int id,
            String name,
            String email,
            String type,
            double balance,
            int rentCount,
            boolean vip
    ) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.type = type;
        this.balance = balance;
        this.rentCount = rentCount;
        this.vip = vip;
    }

    public int getId() {return id;}
    public String getName() {return name;}
    public String getEmail() {return email;}
    public String getType() {return type;}
    public double getBalance() {return balance;}
    public int getRentCount() {return rentCount;}
    public boolean getVip() {return vip;}
}

package dto.Client;

public class ClientCreateDTO {
    private String name;
    private String email;
    private String password;
    private String type;
    private double balance;
    private int rentCount;
    private boolean vip;

    public ClientCreateDTO(
            String name,
            String email,
            String password,
            String type,
            double balance,
            int rentCount,
            boolean vip
    ) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.type = type;
        this.balance = balance;
        this.rentCount = rentCount;
        this.vip = vip;
    }

    public String getName() {return name;}
    public String getEmail() {return email;}
    public String getPassword() {return password;}
    public String getType() {return type;}
    public double getBalance() {return balance;}
    public int getRentCount() {return rentCount;}
    public boolean getVip() {return vip;}
}

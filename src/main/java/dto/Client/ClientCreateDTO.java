package dto.Client;

public class ClientCreateDTO {
    private String name;
    private String email;
    private String password;
    private String type;
    private double balance;

    public ClientCreateDTO(
            String name,
            String email,
            String password,
            String type,
            double balance
    ) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.type = type;
        this.balance = balance;
    }

    public String getName() {return name;}
    public String getEmail() {return email;}
    public String getPassword() {return password;}
    public String getType() {return type;}
    public double getBalance() {return balance;}
}

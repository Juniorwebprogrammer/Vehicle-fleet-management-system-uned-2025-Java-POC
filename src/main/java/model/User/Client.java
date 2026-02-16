package model.User;

public class Client extends Person{
    private String type;

    public Client() {super();}

    public Client(String name, String email, String password, String type) {
        super(name, email, password);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

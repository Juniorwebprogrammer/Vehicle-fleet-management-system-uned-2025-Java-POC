package dto.Client;

public class ClientGetDTO {
    private int id;
    private String name;
    private String email;
    private String type;

    public ClientGetDTO(
            int id,
            String name,
            String email,
            String type
    ) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.type = type;
    }

    public int getId() {return id;}
    public String getName() {return name;}
    public String getEmail() {return email;}
    public String getType() {return type;}
}

package dto.Client;

public class ClientPutDTO {
    private String name;
    private String email;

    public  ClientPutDTO(
            String name,
            String email
    ) {
        this.name = name;
        this.email = email;
    }

    public String getName() {return name;}
    public String getEmail() {return email;}
}

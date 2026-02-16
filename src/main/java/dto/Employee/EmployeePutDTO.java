package dto.Employee;

public class EmployeePutDTO {
    private String name;
    private String email;

    public EmployeePutDTO(
            String name,
            String email
    ) {
        this.name = name;
        this.email = email;
    }

    public String getName() {return name;}
    public String getEmail() {return email;}
}

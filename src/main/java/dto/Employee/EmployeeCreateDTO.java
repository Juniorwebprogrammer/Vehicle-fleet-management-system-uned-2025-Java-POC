package dto.Employee;

public class EmployeeCreateDTO {
    private String name;
    private String email;
    private String password;
    private String rol;

    public EmployeeCreateDTO(
            String name,
            String email,
            String password,
            String rol
    ) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.rol = rol;
    }

    public String getName() {return name;}
    public String getEmail() {return email;}
    public String getPassword() {return password;}
    public String getRol() {return rol;}
}

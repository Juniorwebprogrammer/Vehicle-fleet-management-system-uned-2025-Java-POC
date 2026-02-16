package model.User;

public class Employee extends Person{
    private String rol;

    public Employee() {super();}

    public Employee(String name, String email, String password, String rol) {
        super(name, email, password);
        this.rol = rol;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}

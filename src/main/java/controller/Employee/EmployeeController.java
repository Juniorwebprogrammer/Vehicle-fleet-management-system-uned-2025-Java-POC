package controller.Employee;

import dto.Employee.EmployeeCreateDTO;
import dto.Employee.EmployeeGetDTO;
import dto.Employee.EmployeePutDTO;
import model.User.Employee;
import service.Employee.EmployeeService;

import java.util.List;

public class EmployeeController {
    private EmployeeService employeeService = new EmployeeService();

    // Create new employee
    public void createEmployee(
            String name,
            String email,
            String password,
            String rol
    ) {
        EmployeeCreateDTO employeeCreateDTO = new EmployeeCreateDTO(
                name,
                email,
                password,
                rol
        );

        employeeService.createEmployee(employeeCreateDTO);

        System.out.println("Controller finish execution");
    }

    // Get a list of employees
    public List<EmployeeGetDTO> getEmployeeList() {
        return employeeService.getEmployeeList();
    }

    public EmployeeGetDTO getEmployeeById(int id) {
        return employeeService.getEmployeeById(id);
    }

    public void deleteEmployee(int id) {
        employeeService.deleteEmployee(id);
    }

    public void updateUser(EmployeePutDTO employeePutDTO, int id) {
        employeeService.updateUser(employeePutDTO, id);
    }

    public void updateRolEmployee(String rol, int id) {
        employeeService.updateRolEmployee(rol, id);
    }
}

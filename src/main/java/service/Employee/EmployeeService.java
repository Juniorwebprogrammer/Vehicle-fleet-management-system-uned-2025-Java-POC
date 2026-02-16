package service.Employee;

import dto.Employee.EmployeeCreateDTO;
import dto.Employee.EmployeeGetDTO;
import dto.Employee.EmployeePutDTO;
import model.User.Employee;
import repository.Employee.EmployeeRepository;

import java.util.List;

public class EmployeeService {
    private EmployeeRepository employeeRepository = new EmployeeRepository();
    public EmployeeGetDTO employeeGetDTO(Employee employee) {
        return  new EmployeeGetDTO(
                employee.getId(),
                employee.getName(),
                employee.getEmail(),
                employee.getRol()
        );
    }

    public EmployeeGetDTO createEmployee(EmployeeCreateDTO newEmployeeData) {
        Employee newEmployee = new Employee(
                newEmployeeData.getName(),
                newEmployeeData.getEmail(),
                newEmployeeData.getPassword(),
                newEmployeeData.getRol()
        );

        employeeRepository.createEmployee(newEmployee);

        return employeeGetDTO(newEmployee);
    }

    public List<EmployeeGetDTO> getEmployeeList() {
        List<Employee> employeeList = employeeRepository.getEmployeeList();

        return employeeList.stream()
                .map(this::employeeGetDTO)
                .toList();
    }

    public EmployeeGetDTO getEmployeeById(int id) {
        Employee employee = employeeRepository.getEmployeeById(id);

        if (employee == null) {
            return null;
        }

        return employeeGetDTO(employee);
    }

    public void deleteEmployee(int id) {
        employeeRepository.deleteEmployee(id);
    }

    public void updateUser(EmployeePutDTO employee, int id) {
        employeeRepository.updateUser(employee, id);
    }

    public void updateRolEmployee(String rol, int id) {
        employeeRepository.updateRolEmployee(rol, id);
    }
}

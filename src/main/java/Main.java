import controller.Client.ClientController;
import controller.Employee.EmployeeController;
import database.DatabaseSetup;
import dto.Client.ClientGetDTO;
import dto.Client.ClientPutDTO;
import dto.Employee.EmployeeGetDTO;
import dto.Employee.EmployeePutDTO;
import model.User.Employee;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        // Crear tablas si no existen
        DatabaseSetup.createUserTable();
        DatabaseSetup.createDockingStationsTable();
        DatabaseSetup.createVehicleTable();

        // Crear el controlador de empleados
        EmployeeController employeeController = new EmployeeController();

        /*// Registrar un empleado
        //System.out.println("Registrando empleado...");
        //employeeController.createEmployee("Junior", "junior@uned.es", "123456", "test");

        // Obtener la lista de empleados
        System.out.println("Llamando a get empleado...");
        List<EmployeeGetDTO> employees = employeeController.getEmployeeList();

        // Mostrar la lista en consola
        for (EmployeeGetDTO e : employees) {
            System.out.println("ID: " + e.getId());
            System.out.println("Nombre: " + e.getName());
            System.out.println("Email: " + e.getEmail());
            System.out.println("Rol: " + e.getRol());
            System.out.println("-------------------------");
        }

        System.out.println("Llamando a get by id empleado id: 1");
        EmployeeGetDTO employeeById = employeeController.getEmployeeById(1);

        if (employeeById != null) {
            System.out.println("ID: " + employeeById.getId());
            System.out.println("Nombre: " + employeeById.getName());
            System.out.println("Email: " + employeeById.getEmail());
            System.out.println("Rol: " + employeeById.getRol());
            System.out.println("-------------------------");
        } else {
            System.out.println("Empleado no encontrado");
        }

        System.out.println("Eliminando al empleado 1, luego comprobando si continua existiendo");
        employeeController.deleteEmployee(1);

        System.out.println("Comprobando existencia del empleado 1 después de eliminar");

        EmployeeGetDTO checkEmployee = employeeController.getEmployeeById(1);

        if (checkEmployee != null) {
            System.out.println("ID: " + checkEmployee.getId());
            System.out.println("Nombre: " + checkEmployee.getName());
            System.out.println("Email: " + checkEmployee.getEmail());
            System.out.println("Rol: " + checkEmployee.getRol());
            System.out.println("-------------------------");
        } else {
            System.out.println("Empleado no encontrado");
        }

        System.out.println("Actualizar el rol de empleado a Admin");
        employeeController.updateRolEmployee("Technical", 3);
        System.out.println("Comprobando rol cambiado del id 3");
        EmployeeGetDTO checkUpdateRolEmployee = employeeController.getEmployeeById(3);

        if (checkUpdateRolEmployee != null) {
            System.out.println("ID: " + checkUpdateRolEmployee.getId());
            System.out.println("Nombre: " + checkUpdateRolEmployee.getName());
            System.out.println("Email: " + checkUpdateRolEmployee.getEmail());
            System.out.println("Rol: " + checkUpdateRolEmployee.getRol());
            System.out.println("-------------------------");
        } else {
            System.out.println("Empleado no encontrado");
        }

        System.out.println("Actualizando información principal del usuario");
        EmployeePutDTO updateEmployeeInformation = new EmployeePutDTO("Junior García", "juniorgarcia@gmail.com");
        employeeController.updateUser(updateEmployeeInformation, 3);
        System.out.println("Comprobando información cambiada del id 3");
        EmployeeGetDTO checkUpdateInformationEmployee = employeeController.getEmployeeById(3);

        if (checkUpdateInformationEmployee != null) {
            System.out.println("ID: " + checkUpdateInformationEmployee.getId());
            System.out.println("Nombre: " + checkUpdateInformationEmployee.getName());
            System.out.println("Email: " + checkUpdateInformationEmployee.getEmail());
            System.out.println("Rol: " + checkUpdateInformationEmployee.getRol());
            System.out.println("-------------------------");
        } else {
            System.out.println("Empleado no encontrado");
        }*/

        // Crear el controlador de clientes
        ClientController clientController = new ClientController();

        /*System.out.println("Registrando cliente...");
        clientController.createClient("Junior García", "juniorgarcia2@uned.es", "123456", "test", 16.50);

        // Obtener la lista de clients
        System.out.println("Llamando a get clientes...");
        List<ClientGetDTO> clients = clientController.getClientList();

        // Mostrar la lista en consola
        for (ClientGetDTO client : clients) {
            System.out.println("ID: " + client.getId());
            System.out.println("Nombre: " + client.getName());
            System.out.println("Email: " + client.getEmail());
            System.out.println("Rol: " + client.getType());
            System.out.println("Balance " + client.getBalance());
            System.out.println("-------------------------");
        }

        System.out.println("Llamando a get by id client id: 6");
        ClientGetDTO clientById = clientController.getClientById(6);

        if (clientById != null) {
            System.out.println("ID: " + clientById.getId());
            System.out.println("Nombre: " + clientById.getName());
            System.out.println("Rol: " + clientById.getType());
            System.out.println("Balance " + clientById.getBalance());
            System.out.println("-------------------------");
        } else {
            System.out.println("Empleado no encontrado");
        }

        System.out.println("Eliminando al empleado 6, luego comprobando si continua existiendo");
        clientController.deleteClient(6);

        System.out.println("Comprobando existencia del empleado 6 después de eliminar");

        ClientGetDTO checkClientId = clientController.getClientById(6);

        if (checkClientId != null) {
            System.out.println("ID: " + checkClientId.getId());
            System.out.println("Nombre: " + checkClientId.getName());
            System.out.println("Rol: " + checkClientId.getType());
            System.out.println("-------------------------");
        } else {
            System.out.println("Empleado no encontrado");
        }

        System.out.println("Actualizando información principal del usuario");
        ClientPutDTO updateClientInformation = new ClientPutDTO("Junior García Díaz", "juniorgarciaDiaz@gmail.com");
        clientController.updateClient(updateClientInformation, 7);
        System.out.println("Comprobando información cambiada del id 7");
        ClientGetDTO checkUpdateInformationClient = clientController.getClientById(7);

        if (checkUpdateInformationClient != null) {
            System.out.println("ID: " + checkUpdateInformationClient.getId());
            System.out.println("Nombre: " + checkUpdateInformationClient.getName());
            System.out.println("Email: " + checkUpdateInformationClient.getEmail());
            System.out.println("Rol: " + checkUpdateInformationClient.getType());
            System.out.println("Balance " + checkUpdateInformationClient.getBalance());
            System.out.println("-------------------------");
        } else {
            System.out.println("Cliente no encontrado");
        }

        System.out.println("Actualizar el rol de cliente a premium");
        clientController.updateTypeClient("Premium", 7);
        System.out.println("Comprobando type cambiado del id 7");
        ClientGetDTO checkUpdateTypeClient = clientController.getClientById(7);

        if (checkUpdateTypeClient != null) {
            System.out.println("ID: " + checkUpdateTypeClient.getId());
            System.out.println("Nombre: " + checkUpdateTypeClient.getName());
            System.out.println("Email: " + checkUpdateTypeClient.getEmail());
            System.out.println("Rol: " + checkUpdateTypeClient.getType());
            System.out.println("Balance " + checkUpdateTypeClient.getBalance());
            System.out.println("-------------------------");
        } else {
            System.out.println("Cliente no encontrado");
        }*/

        // Actualizar balance de un cliente
        clientController.updateBalanceClient(2.0, 4);
    }
}

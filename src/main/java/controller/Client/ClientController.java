package controller.Client;

import dto.Client.ClientCreateDTO;
import dto.Client.ClientGetDTO;
import dto.Client.ClientPutDTO;
import service.Client.ClientService;

import java.util.List;

public class ClientController {
    private ClientService clientService = new ClientService();

    public void createClient(
            String name,
            String email,
            String password,
            String type,
            double balance
    ) {
        ClientCreateDTO clientCreateDTO = new ClientCreateDTO(
                name,
                email,
                password,
                type,
                balance
        );

        clientService.createClient(clientCreateDTO);

        System.out.println("Controller finish execution");
    }

    public List<ClientGetDTO> getClientList() {
        return clientService.getClientList();
    }

    public ClientGetDTO getClientById(int id) {
        return clientService.getClientByID(id);
    }

    public void deleteClient(int id) {
        clientService.deleteClient(id);
    }

    public void updateClient(ClientPutDTO clientPutDTO, int id) {
        clientService.updateClient(clientPutDTO, id);
    }

    public void updateTypeClient(String type, int id) {
        clientService.updateTypeClient(type, id);
    }

    public void updateBalanceClient(double balance, int id) throws Exception { clientService.updateBalanceClient(balance, id); }
}

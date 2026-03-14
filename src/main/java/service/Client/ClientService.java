package service.Client;

import dto.Client.ClientCreateDTO;
import dto.Client.ClientGetDTO;
import dto.Client.ClientPutDTO;
import model.User.Client;
import repository.Client.ClientRepository;

import java.util.List;

public class ClientService {
    private ClientRepository clientRepository = new ClientRepository();

    public ClientGetDTO clientGetDTO(Client client) {
        return new ClientGetDTO(
                client.getId(),
                client.getName(),
                client.getEmail(),
                client.getType(),
                client.getBalance()
        );
    }

    public ClientGetDTO createClient(ClientCreateDTO newClientData) {
        Client newClient = new Client(
                newClientData.getName(),
                newClientData.getEmail(),
                newClientData.getPassword(),
                newClientData.getType(),
                newClientData.getBalance()
        );

        clientRepository.createClient(newClient);

        return clientGetDTO(newClient);
    }

    public List<ClientGetDTO> getClientList() {
        List<Client> clientList = clientRepository.getclientList();

        return clientList.stream()
                .map(this::clientGetDTO)
                .toList();
    }

    public ClientGetDTO getClientByID(int id) {
        Client client = clientRepository.getClientById(id);

        if (client == null) {
            return null;
        }

        return clientGetDTO(client);
    }

    public void deleteClient(int id) {
        clientRepository.deleteClientId(id);
    }

    public void updateClient(ClientPutDTO clientPutDTO, int id) {
        clientRepository.updateClient(clientPutDTO, id);
    }

    public void updateTypeClient(String type, int id) {
        clientRepository.updateTypeClient(type, id);
    }

    public void updateBalanceClient(double balance, int id) throws Exception {
        if (balance < 0) {
            throw new Exception("El balance no puede ser inferior a cero");
        }

        clientRepository.updateBalanceClient(balance, id);
    }
}

package kz.dar.academy.backend.service.deprecated;

import kz.dar.academy.backend.model.ClientModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
public class ClientServiceOldImplementation implements ClientServiceOld {
    private static final HashMap<String, ClientModel> clientMap = new HashMap<>();


    static {
        ClientModel clientModel1 = new ClientModel(UUID.randomUUID().toString(), "Ivan", "Petrov",
                "DAR", "Engineer", "example1@gmail.com", 300000);
        ClientModel clientModel2 = new ClientModel(UUID.randomUUID().toString(), "Maria", "Petrova",
                "DAR", "Engineer", "example2@gmail.com", 200000);
        ClientModel clientModel3 = new ClientModel(UUID.randomUUID().toString(), "Ivan", "Smith",
                "DAR", "Engineer", "example3@gmail.com", 100000);
        clientMap.put(clientModel1.getClientId(), clientModel1);
        clientMap.put(clientModel2.getClientId(), clientModel2);
        clientMap.put(clientModel3.getClientId(), clientModel3);

    }

    @Override
    public void createClient(ClientModel clientModel) {
        clientModel.setClientId(UUID.randomUUID().toString());
    }

    @Override
    public List<ClientModel> getAllClients() {
        return new ArrayList<>(clientMap.values());
    }

    @Override
    public ClientModel getClientById(String clientId) {
        return clientMap.get(clientId);
    }

    @Override
    public void updateClientById(String clientId, ClientModel clientModel) {
        clientModel.setClientId(clientId);
        clientMap.put(clientId, clientModel);
    }

    @Override
    public void deleteClientById(String clientId) {
        clientMap.remove(clientId);
    }
}

package projects.adxmas.eshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projects.adxmas.eshop.dao.ClientRepository;
import projects.adxmas.eshop.dao.CreditCardRepository;
import projects.adxmas.eshop.entity.Client;
import projects.adxmas.eshop.entity.ItemObject;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    public List<Client> getAllClients() {
        return this.clientRepository.findAll();
    }

    public Client addClient(Client client) {
        return this.clientRepository.save(client);
    }

    public List<Client> deleteClientById(int id) {
        clientRepository.deleteById(id);
        return clientRepository.findAll();
    }

    //Updates item
    public Client updateClient(int id, Client client) {
        Client toUpdate = clientRepository.findById(id).orElseThrow();

        toUpdate.setfName(client.getfName());
        toUpdate.setlName(client.getlName());
        toUpdate.setCreditCardNumber(client.getCreditCardNumber());
        toUpdate.setEmail(client.getEmail());
        toUpdate.setNickName(client.getNickName());
        toUpdate.setPassword(client.getPassword());
        return clientRepository.save(toUpdate);
    }
}

package projects.adxmas.eshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import projects.adxmas.eshop.entity.Client;
import projects.adxmas.eshop.service.ClientService;

import java.util.List;

@RestController
@RequestMapping("/userdb")
public class ClientController {

    private final ClientService clientService;


    @Autowired
    public ClientController(ClientService clientService){
        this.clientService = clientService;
    }

    @GetMapping("/clients/getall")
    public List<Client> getClients() {
        return clientService.getAllClients();
    }

    @PutMapping("/clients/update/{id}")
    public Client updateClient(@PathVariable("id") int clientId, Client client){
        return clientService.updateClient(clientId, client);
    }

    @PostMapping("/clients/addclient")
    public Client addClient(Client client) {
        return clientService.addClient(client);
    }

    @DeleteMapping("/clients/delete/{id}")
    public List<Client> deleteClient(@PathVariable("id") int id) {
        return clientService.deleteClientById(id);
    }

}

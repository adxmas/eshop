package projects.adxmas.eshop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import projects.adxmas.eshop.entity.Client;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Integer> {

    Client findClientByCreditCardNumber(String owner);

}

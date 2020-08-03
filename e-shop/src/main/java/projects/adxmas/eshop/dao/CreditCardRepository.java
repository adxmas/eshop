package projects.adxmas.eshop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import projects.adxmas.eshop.entity.CreditCard;


public interface CreditCardRepository extends JpaRepository<CreditCard, Integer> {

    CreditCard findCreditCardByCreditCardNumber(String CCnumber);

    Integer findCreditCardIdByCreditCardNumber(String CCnumber);

}

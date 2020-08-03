package projects.adxmas.eshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projects.adxmas.eshop.dao.ClientRepository;
import projects.adxmas.eshop.dao.CreditCardRepository;
import projects.adxmas.eshop.dao.ItemRepository;
import projects.adxmas.eshop.entity.CreditCard;
import projects.adxmas.eshop.entity.ItemObject;

import java.util.List;
import java.util.Optional;

@Service
public class ShopService {


    private final ItemRepository itemRepository;
    private final ClientRepository clientRepository;
    private final CreditCardRepository creditCardRepository;

    @Autowired
    public ShopService(ItemRepository itemRepository, ClientRepository clientRepository, CreditCardRepository creditCardRepository) {
        this.itemRepository = itemRepository;
        this.clientRepository = clientRepository;
        this.creditCardRepository = creditCardRepository;
    }


    public List<ItemObject> getItems() {
        return this.itemRepository.findAll();
    }

    public ItemObject addItem(ItemObject itemObject) {
        return this.itemRepository.save(itemObject);
    }

    public List<ItemObject> deleteItemById(int id) {
        itemRepository.deleteById(id);
        return itemRepository.findAll();
    }

    //Updates item
    public ItemObject updateItem(int id, ItemObject itemObject) {
        ItemObject toUpdate = itemRepository.findById(id).orElse(null);

        toUpdate.setBrand(itemObject.getBrand());
        toUpdate.setName(itemObject.getName());
        toUpdate.setType(itemObject.getType());
        toUpdate.setPrice(itemObject.getPrice());
        toUpdate.setImgUrl(itemObject.getImgUrl());
        toUpdate.setAmountLeft(itemObject.getAmountLeft());
        return itemRepository.save(toUpdate);
    }

    //Updates credit card
    public CreditCard updateCard(int id, CreditCard creditCard) {
        CreditCard toUpdate = creditCardRepository.findById(id).orElse(null);

        toUpdate.setfName(creditCard.getfName());
        toUpdate.setlName(creditCard.getlName());
        toUpdate.setCreditCardNumber(creditCard.getCreditCardNumber());
        toUpdate.setCvc(creditCard.getCvc());
        toUpdate.setAmountInCard(creditCard.getAmountInCard());
        return creditCardRepository.save(toUpdate);
    }

    public List<ItemObject> purchaseItem(int itemId, String fName, String lName, String creditCardNumber) {
        if (
                (clientRepository.findClientByCreditCardNumber(creditCardNumber).getfName().equalsIgnoreCase(fName))
                 &&
                (clientRepository.findClientByCreditCardNumber(creditCardNumber).getlName().equalsIgnoreCase(lName))
        )
        {
            if (itemRepository.findById(itemId).get().getAmountLeft() > 0)
                {
                    itemRepository.findById(itemId).get().setAmountLeft(itemRepository.findById(itemId).get().getAmountLeft() - 1);

                    creditCardRepository.findCreditCardByCreditCardNumber(creditCardNumber).setAmountInCard(
                            creditCardRepository.findCreditCardByCreditCardNumber(creditCardNumber).getAmountInCard() -
                                    itemRepository.findById(itemId).get().getPrice()
                    );
                    System.out.println(creditCardRepository.findAll());
                }
        }

        // When item is bought, it reduces amountLeft by 1 and saves it to DB
        updateItem(itemId, itemRepository.getOne(itemId));
        /*updateCard(creditCardRepository.findCreditCardIdByCreditCardNumber(creditCardNumber),
                creditCardRepository.getOne(creditCardRepository.findCreditCardIdByCreditCardNumber(creditCardNumber)));*/

        return itemRepository.findAll();
    }

}

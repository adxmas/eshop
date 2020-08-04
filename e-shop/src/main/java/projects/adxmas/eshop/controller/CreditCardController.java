package projects.adxmas.eshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import projects.adxmas.eshop.entity.CreditCard;
import projects.adxmas.eshop.service.CardValidationService;
import projects.adxmas.eshop.service.ShopService;

import java.util.List;

@RestController
@RequestMapping("/bank")
public class CreditCardController {

    private final ShopService shopService;
    private final CardValidationService cardValidationService;

    @Autowired
    public CreditCardController(ShopService shopService, CardValidationService cardValidationService){
        this.shopService = shopService;
        this.cardValidationService = cardValidationService;
    }

    @GetMapping("/cards/getall")
    public List<CreditCard> getCards() {
        return shopService.getAllCards();
    }

    @PatchMapping("/cards/update/{id}")
    public CreditCard updateCard(@PathVariable("id") int cardId, CreditCard creditCard){
        return shopService.updateCard(cardId, creditCard);
    }

    @PostMapping("/cards/addcard")
    public CreditCard addCard(CreditCard creditCard) {
        if(cardValidationService.isCardValid(creditCard.getCreditCardNumber())){
            System.out.println("Card Number is Valid!");
            return shopService.addCard(creditCard);
        }
        else{
            System.out.println("Card Number is not Valid");
            return null;
        }

    }

    @DeleteMapping("/cards/delete/{id}")
    public List<CreditCard> deleteCreditCard(@PathVariable("id") int id) {
        return shopService.deleteCardById(id);
    }

}

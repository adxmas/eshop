package projects.adxmas.eshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projects.adxmas.eshop.dao.CreditCardRepository;

@Service
public class CardValidationService {

    private final CreditCardRepository creditCardRepository;

    @Autowired
    public CardValidationService(CreditCardRepository creditCardRepository){
        this.creditCardRepository = creditCardRepository;
    }

    public boolean isCardValid(String creditCardNumber){
        int sumOfOddPlaces = 0; int sumOfEvenPlaces = 0;
        int i = 1; int j = 0;
        int doubledEvenNumber = 0;
        int readyNumber = 0;
        while(i<creditCardNumber.length()){
            sumOfOddPlaces+=Integer.parseInt(String.valueOf(creditCardNumber.charAt(i)));
            i+=2;
        }
        while(j<creditCardNumber.length()){
            doubledEvenNumber = Integer.parseInt(String.valueOf(creditCardNumber.charAt(j)))*2;
            if(doubledEvenNumber >= 10){
                readyNumber = Integer.parseInt(String.valueOf(String.valueOf(doubledEvenNumber).charAt(0))) +
                        Integer.parseInt(String.valueOf(String.valueOf(doubledEvenNumber).charAt(1)));
            }else {
                readyNumber = doubledEvenNumber;
            }
            sumOfEvenPlaces+=readyNumber;
            j+=2;
        }
        System.out.println("SUM OF EVEN PLACES: " + sumOfEvenPlaces);
        System.out.println("SUM OF ODD PLACES: " + sumOfOddPlaces);
        System.out.println("TOTAL SUM: " + (sumOfEvenPlaces+sumOfOddPlaces));
        if((sumOfEvenPlaces+sumOfOddPlaces)%10==0){
            return true;
        }else{
            return false;
        }
    }



}

package projects.adxmas.eshop.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String fName;
    private String lName;
    private String creditCardNumber;
    private String Cvc;
    private double amountInCard;

    public CreditCard(int id, String fName, String lName, String creditCardNumber, String Cvc, double amountInCard){
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.creditCardNumber = creditCardNumber;
        this.Cvc = Cvc;
        this.amountInCard = amountInCard;
    }

    public CreditCard(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getCvc() {
        return Cvc;
    }

    public void setCvc(String cvc) {
        Cvc = cvc;
    }

    public double getAmountInCard() {
        return amountInCard;
    }

    public void setAmountInCard(double amountInCard) {
        this.amountInCard = amountInCard;
    }

    @Override
    public String toString() {
        return this.creditCardNumber + " " + this.amountInCard;
    }
}

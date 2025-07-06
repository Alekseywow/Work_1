package ru.data;

public abstract class Card {

    protected String cardholder;
    protected int balance;
    protected String cardNumber;
    protected PaymentSystem paymentSystem;

    public String getCardholder() {
        return cardholder;
    }

    public void setCardholder(String cardholder) {
        this.cardholder = cardholder;
    }

    public void setPaymentSystem(PaymentSystem paymentSystem) {
        this.paymentSystem = paymentSystem;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        if (balance < 0)
            return;
        else {
            System.out.println("added balance: " + balance);
            this.balance = balance;
        }
    }

    public Card(PaymentSystem paymentSystem) {
        this.paymentSystem = paymentSystem;
    }

    public PaymentSystem getPaymentSystem() {
        return paymentSystem;
    }

    protected boolean isBalanceGreaterOrEqualThan(int amount) {
        return balance >= amount;
    }

    public void payInCountry(Country country, int amount){
        if (isCountryValidForTheseCard(country) && isBalanceGreaterOrEqualThan(amount)) {
            balance = balance - amount;
            System.out.println("Accepted!");
        }
    }  // метод аналог фунции которая заключееа в фигурные скобки, вся логика описывается


    protected abstract boolean isCountryValidForTheseCard(Country country);

}

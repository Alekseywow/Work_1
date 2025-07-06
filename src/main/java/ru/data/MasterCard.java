package ru.data;

public class MasterCard extends Card{

    public MasterCard() {
        super(PaymentSystem.MASTERCARD);
    }

    protected boolean isCountryValidForTheseCard(Country country) {
        return true;
    }

}
package ru.data;

public class VisaCard extends Card{


    public VisaCard() {
        super(PaymentSystem.VISA);
    }


    public boolean isCountryValidForTheseCard(Country country) {
        return true;
    }
}

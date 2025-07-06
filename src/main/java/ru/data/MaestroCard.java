package ru.data;

import java.io.Serializable;

import static ru.data.Country.RU;
import static ru.data.PaymentSystem.MAESTRO;

public class MaestroCard  extends  Card implements ICard, Serializable {


    public MaestroCard() {
        super(MAESTRO);
    }

    @Override
    protected boolean isCountryValidForTheseCard(Country country) {
        return RU == country;
    }
}

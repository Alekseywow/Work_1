package page.components;

import page.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CalendareComponent {

    public void  setDate (String day, String month, String year) {



        $(".react-datepicker__month-select").$(byText(month)).click();
        $(".react-datepicker__year-select").$(byText(year)).click();
        $$(".react-datepicker__day:not(.react-datepicker__day--outside-month)").findBy(text(day)).click();
    }

}

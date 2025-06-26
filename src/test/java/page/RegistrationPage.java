package page;

import com.codeborne.selenide.SelenideElement;
import page.components.CalendareComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {

    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userPhoneInput = $("#userNumber"),
            calendareInput = $("#dateOfBirthInput"),
            subjectInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            currentAddress = $("#currentAddress"),
            stateCity = $("#state"),
            stateCityWrapper = $("#stateCity-wrapper"),
            cityState = $("#city"),
            submit = $("#submit");


    CalendareComponent calendareComponent = new CalendareComponent();


    public RegistrationPage openPage() {
        open("/automation-practice-form");
        //Проверка заголовков
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setUserEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGenderWrapper(String value) {
        genderWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userPhoneInput.setValue(value);

        return this;
    }

    public RegistrationPage setDateOfBrith(String day, String month, String year) {
        calendareInput.click();
        calendareComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setSubjectInput(String value) {
        subjectInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setHobbiesWrapper(String value) {
        hobbiesWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setUploadPicture(String value) {
        uploadPicture.uploadFromClasspath(value);

        return this;
    }

    public RegistrationPage setCurrentAddress(String value) {
        currentAddress.setValue(value);

        return this;
    }

    public RegistrationPage setStateCity(String value) {
        stateCity.click();
        stateCityWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setCityState(String value) {
        cityState.click();
        stateCityWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage btnSubmit() {
        submit.click();

        return this;
    }




    public RegistrationPage checkResult(String key, String value) {
        $(".table-responsive").$(byText(key)).parent()
                .shouldHave(text(value));

        return this;
    }

    public RegistrationPage negativeResult() {
        $(".table-responsive").shouldNotHave(visible);

        return this;
    }



}

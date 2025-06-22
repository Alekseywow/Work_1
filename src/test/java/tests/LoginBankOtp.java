package tests;

import static com.codeborne.selenide.Selenide.$;

public class LoginBankOtp {


    public void loginWithPassportAndCard(String card, String password) {

    }

    public void loginUsernameAndPassword(String userName, String password) {
        $("#username").setValue(userName);
        $("#password").setValue(password);
        $("#button-btn").click();
    }

}

package tests;

import static com.codeborne.selenide.Selenide.$;

public class LoginBankOtp2 {


    public void loginWithPassportAndCard(String card, String password) {

    }

    public HomeBankOtp loginUsernameAndPassword(String userName, String password) {
        $("#username").setValue(userName);
        $("#password").setValue(password);
        $("#button-btn").click();

        return new HomeBankOtp();
    }

}

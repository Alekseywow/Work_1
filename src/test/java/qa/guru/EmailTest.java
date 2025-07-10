package qa.guru;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class EmailTest {


    @Test // Запуск кейсов
    @DisplayName("Email должке быть отправлен новому юзеру") // В виде строчки написать название теста
    void emailShouldBeSentForNewUser() {
        System.out.println("Hello");
    }

    @Test // Запуск кейсов
    @DisplayName("Email должке быть отправлен забаненому юзеру")
    void emailShouldBeSentForBannedUser() {
        System.out.println("hello");
    }

    @Test // Запуск кейсов
    @DisplayName("Email должке быть отправлен в случае изменения PaymentMethod")
    @Disabled("JDK-141312")
    void emailShouldBeSentAfterChangePaymentMethod() {
        throw new AssertionError("падаем");
    }

}

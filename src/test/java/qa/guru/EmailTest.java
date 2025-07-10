package qa.guru;

import org.junit.jupiter.api.*;

@Disabled("SAVC-142421")
public class EmailTest {


    @Test // Запуск кейсов
    @DisplayName("Email должке быть отправлен новому юзеру") // В виде строчки написать название теста
    void emailShouldBeSentForNewUser() {
        System.out.println("Hello");
    }

    @Test // Запуск кейсов
    @Tag("SMOKE")
    @DisplayName("Email должке быть отправлен забаненому юзеру")
    void emailShouldBeSentForBannedUser() {
        System.out.println("hello");
    }

    @Test // Запуск кейсов
    @Tags({
            @Tag("SMOKE"),
            @Tag("WEB"),
    })
    @Tag("SMOKE")
    @DisplayName("Email должке быть отправлен в случае изменения PaymentMethod")
    void emailShouldBeSentAfterChangePaymentMethod() {
        throw new AssertionError("падаем");
    }

}

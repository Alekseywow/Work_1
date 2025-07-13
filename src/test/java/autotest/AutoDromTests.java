package autotest;

import autotest.data.CarName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import pages.AutoDromPage;

import java.util.List;
import java.util.stream.Stream;

public class AutoDromTests extends TestDromSetting{

AutoDromPage autoDromPage = new AutoDromPage();

    @BeforeEach
    void firstUp() {
        autoDromPage.openAutoPage();
    }


    @ValueSource(strings = {
            "BMW", "Changan", "Chery"
    })
    @ParameterizedTest (name = "Должен проверять наименование {0} автомобилей в поиске объявлений")
    @Tag("Smoke")
    void foundNameCar(String carNames) {
        autoDromPage.getCar(carNames);
    }


    @EnumSource (CarName.class)
    @ParameterizedTest (name = "Должен проверять наличение карточек автомобилей c маркой {0}")
    @Tag("Smoke")
    void foundPhotoCars (CarName carMarkNames) {
        autoDromPage.getCarName(carMarkNames.name())
                .checkCarsName();
    }

    static Stream<Arguments> findModelCars() {
        return Stream.of(
                Arguments.of(
                        CarName.BMW,
                List.of("1-Series", "2-Series", "2-Series Active Tourer", "3-Series", "3-Series Gran Turismo", "4-Series",
                        "5-Series", "5-Series Gran Turismo", "6-Series","6-Series Gran Turismo", "7-Series",
                        "M5", "X1", "X2", "X3", "X4", "X5", "X6", "X7")
                ),
                Arguments.of(
                        CarName.Changan,
                List.of("Alsvin", "CS35", "CS35 Plus", "CS55", "CS55 Plus", "CS75",
                        "CS75 Plus", "CS85 Coupe", " CS95", " CS95 Plus", "Deepal Shenlan S7",
                        "Eado Plus", " Hunter", " Hunter Plus", " Lamore", "UNI-K", "UNI-S",
                        " UNI-T", " UNI-V")
                )
        );
    }

    @MethodSource
    @ParameterizedTest(name = "Должен проверять модели автомобилей по их марке {0}")
    @Tag("Smoke")
    void findModelCars(CarName carName, List<String> models) {
        autoDromPage.getCarName(carName)
                .getModelCars(models);
    }




}

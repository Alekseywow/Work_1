package tests;

import org.junit.jupiter.api.Test;
import page.RegistrationPage;
import utils.TestData;

public class RegistrationWithPageObject extends TestBase{

    RegistrationPage registrationPage = new RegistrationPage();
    TestData testData = new TestData();

    @Test
    void formPracticeTest() {

        registrationPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setUserEmail(testData.userEmail)
                .setGenderWrapper(testData.genderWrapper)
                .setUserNumber(testData.userPhone)
                .setDateOfBrith(testData.brithData, testData.monthData, testData.yearData)
                .setSubjectInput(testData.subjectInput)
                .setHobbiesWrapper(testData.hobbiesWrapper)
                .setUploadPicture(testData.imgPicture)
                .setCurrentAddress(testData.currentAddress)
                .setStateCity(testData.stateCity)
                .setCityState(testData.cityState)
                .btnSubmit();


        registrationPage.checkResult("Student Name", testData.firstName + " " + testData.lastName)
                .checkResult("Student Email", testData.userEmail)
                .checkResult("Gender", testData.genderWrapper)
                .checkResult("Mobile", testData.userPhone)
                .checkResult("Date of Birth", testData.brithData + " " + testData.monthData + "," + testData.yearData)
                .checkResult("Subjects", testData.subjectInput)
                .checkResult("Hobbies", testData.hobbiesWrapper)
                .checkResult("Picture", testData.imgPicture)
                .checkResult("Address", testData.currentAddress)
                .checkResult("State and City", testData.stateCity + " " + testData.cityState);

    }

    @Test
    void formMinPracticTest(){
        registrationPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setGenderWrapper(testData.genderWrapper)
                .setUserNumber(testData.userPhone)
                .btnSubmit();

        registrationPage.checkResult("Student Name", testData.firstName + " " + testData.lastName)
                .checkResult("Gender", testData.genderWrapper)
                .checkResult("Mobile", testData.userPhone);
    }

    @Test
    void formNegativePracticTest() {
        registrationPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setGenderWrapper(testData.genderWrapper)
                .btnSubmit();

        registrationPage.negativeResult();
    }



}

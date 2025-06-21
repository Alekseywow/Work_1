package tests;

import org.junit.jupiter.api.*;

public class SimpleJUnitTest {

    int result;

    @BeforeAll
    static void beforeAll() {
        System.out.println("\n###   beforeAll()\n");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("###   beforeEach()");
        result = getResult();
    }

    @AfterEach
    void afterEach() {
        System.out.println("###   afterEach()\n");
        result = 0;
    }

    @AfterAll
    static void afterAll() {
        System.out.println("\n###   afterAll()\n");
    }

    @Test
    void firstTest() {
        System.out.println("###   firstTest()");
        Assertions.assertTrue(result > 1);
    }

    @Test
    void twoTest() {
        System.out.println("###   twoTest()");
        Assertions.assertTrue(result > 1);
    }

    @Test
    void secondTest() {
        System.out.println("###   secondTest()");
        Assertions.assertTrue(result > 1);
    }

    private int getResult() {
        return 3;
    }

}

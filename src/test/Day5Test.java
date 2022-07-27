import main.java.pl.dominik.Day5.Day5;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day5Test {

    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    private final Day5 day5 = new Day5();

    @BeforeEach
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    @AfterEach
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    private String getOutput() {
        return testOut.toString();
    }

    @Test
    void checkIntCodeComputerFirstVersion() throws Exception {
        provideInput("1");
        day5.runIntCodeComputerFirstVersion(day5.readNumberFromFile());
        assertEquals("Enter ID of system:\r\n0\r\n0\r\n0\r\n0\r\n0\r\n0\r\n0\r\n0\r\n0\r\n6745903", getOutput().trim());
    }

    @Test
    void checkIntCodeComputerSecondVersion() throws Exception {
        provideInput("5");
        day5.runIntCodeComputerSecondVersion(day5.readNumberFromFile());
        assertEquals("Enter ID of system:\r\n9168079", getOutput().trim());
    }

    @Test
    void checkIntCodeComputerSecondVersionPositionMode1() {
        provideInput("8");                                      //input equal 8, should output 1
        day5.runIntCodeComputerSecondVersion(new Integer[]{3, 9, 8, 9, 10, 9, 4, 9, 99, -1, 8});
        assertEquals("Enter ID of system:\r\n1", getOutput().trim());
    }

    @Test
    void checkIntCodeComputerSecondVersionPositionMode2() {
        provideInput("3");                                      //input not equal 8, should output 0
        day5.runIntCodeComputerSecondVersion(new Integer[]{3, 9, 8, 9, 10, 9, 4, 9, 99, -1, 8});
        assertEquals("Enter ID of system:\r\n0", getOutput().trim());
    }

    @Test
    void checkIntCodeComputerSecondVersionPositionMode3() {
        provideInput("3");                                      //input less than 8, should output 1
        day5.runIntCodeComputerSecondVersion(new Integer[]{3, 9, 7, 9, 10, 9, 4, 9, 99, -1, 8});
        assertEquals("Enter ID of system:\r\n1", getOutput().trim());
    }

    @Test
    void checkIntCodeComputerSecondVersionPositionMode4() {
        provideInput("11");                                      //input not less than 8, should output 0
        day5.runIntCodeComputerSecondVersion(new Integer[]{3, 9, 7, 9, 10, 9, 4, 9, 99, -1, 8});
        assertEquals("Enter ID of system:\r\n0", getOutput().trim());
    }

    @Test
    void checkIntCodeComputerSecondVersionImmediateMode1() {
        provideInput("8");                                        //input is equal 8, should output 1
        day5.runIntCodeComputerSecondVersion(new Integer[]{3, 3, 1108, -1, 8, 3, 4, 3, 99});
        assertEquals("Enter ID of system:\r\n1", getOutput().trim());
    }

    @Test
    void checkIntCodeComputerSecondVersionImmediateMode2() {
        provideInput("9");                                        //input is not equal 8, should output 0
        day5.runIntCodeComputerSecondVersion(new Integer[]{3, 3, 1108, -1, 8, 3, 4, 3, 99});
        assertEquals("Enter ID of system:\r\n0", getOutput().trim());
    }

    @Test
    void checkIntCodeComputerSecondVersionImmediateMode3() {
        provideInput("4");                                        //input is less than 8, should output 1
        day5.runIntCodeComputerSecondVersion(new Integer[]{3, 3, 1107, -1, 8, 3, 4, 3, 99});
        assertEquals("Enter ID of system:\r\n1", getOutput().trim());
    }

    @Test
    void checkIntCodeComputerSecondVersionImmediateMode4() {
        provideInput("14");                                      //input is not less than 8, should output 0
        day5.runIntCodeComputerSecondVersion(new Integer[]{3, 3, 1107, -1, 8, 3, 4, 3, 99});
        assertEquals("Enter ID of system:\r\n0", getOutput().trim());
    }

    @Test
    void checkIntCodeComputerSecondVersionImmediateModeJumpTest1() {
        provideInput("0");                                      //input is equal 0, should output 0
        day5.runIntCodeComputerSecondVersion(new Integer[]{3,3,1105,-1,9,1101,0,0,12,4,12,99,1});
        assertEquals("Enter ID of system:\r\n0", getOutput().trim());
    }

    @Test
    void checkIntCodeComputerSecondVersionImmediateModeJumpTest2() {
        provideInput("6");                                      //input is not equal 0, should output 1
        day5.runIntCodeComputerSecondVersion(new Integer[]{3,3,1105,-1,9,1101,0,0,12,4,12,99,1});
        assertEquals("Enter ID of system:\r\n1", getOutput().trim());
    }

    @Test
    void checkIntCodeComputerSecondVersionPositionModeJumpTest1() {
        provideInput("0");                                      //input is equal 0, should output 0
        day5.runIntCodeComputerSecondVersion(new Integer[]{3,12,6,12,15,1,13,14,13,4,13,99,-1,0,1,9});
        assertEquals("Enter ID of system:\r\n0", getOutput().trim());
    }

    @Test
    void checkIntCodeComputerSecondVersionPositionModeJumpTest2() {
        provideInput("6");                                      //input is not equal 0, should output 1
        day5.runIntCodeComputerSecondVersion(new Integer[]{3,12,6,12,15,1,13,14,13,4,13,99,-1,0,1,9});
        assertEquals("Enter ID of system:\r\n1", getOutput().trim());
    }

    @Test
    void checkIntCodeComputerSecondVersionLargerTest1() {
        provideInput("4");                                      //input is less than 8, should output 999
        day5.runIntCodeComputerSecondVersion(new Integer[]{3,21,1008,21,8,20,1005,20,22,107,8,21,20,1006,20,31,
                1106,0,36,98,0,0,1002,21,125,20,4,20,1105,1,46,104,
                999,1105,1,46,1101,1000,1,20,4,20,1105,1,46,98,99});
        assertEquals("Enter ID of system:\r\n999", getOutput().trim());
    }

    @Test
    void checkIntCodeComputerSecondVersionLargerTest2() {
        provideInput("8");                                      //input is equal 8, should output 1000
        day5.runIntCodeComputerSecondVersion(new Integer[]{3,21,1008,21,8,20,1005,20,22,107,8,21,20,1006,20,31,
                1106,0,36,98,0,0,1002,21,125,20,4,20,1105,1,46,104,
                999,1105,1,46,1101,1000,1,20,4,20,1105,1,46,98,99});
        assertEquals("Enter ID of system:\r\n1000", getOutput().trim());
    }

    @Test
    void checkIntCodeComputerSecondVersionLargerTest3() {
        provideInput("12");                                   //input is greater than 8, should output 1001
        day5.runIntCodeComputerSecondVersion(new Integer[]{3,21,1008,21,8,20,1005,20,22,107,8,21,20,1006,20,31,
                1106,0,36,98,0,0,1002,21,125,20,4,20,1105,1,46,104,
                999,1105,1,46,1101,1000,1,20,4,20,1105,1,46,98,99});
        assertEquals("Enter ID of system:\r\n1001", getOutput().trim());
    }


}


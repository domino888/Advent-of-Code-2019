package main.java.pl.dominik.Day9;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class IntcodeComputer {

    private int pointer = 0;
    private int relativeBase = 0;
    private boolean isRunning = true;
    private Integer[] integerArray;
    private final Queue<Integer> inputQueue = new LinkedList<>();
    private final Queue<Integer> outputQueue = new LinkedList<>();

    public IntcodeComputer(Integer[] iA) {
        int highest = Collections.max(Arrays.asList(iA));
        integerArray = new Integer[highest + 100];
        Arrays.fill(integerArray, 0);
        for (int i = 0; i < iA.length; i++) {
            integerArray[i] = iA[i];
        }
        //this.integerArray = Arrays.copyOf(integerArray, integerArray.length);
    }

    public boolean isRunning() {
        return isRunning;
    }

    public boolean hasOutput() {
        return !outputQueue.isEmpty();
    }

    public void setInput(int input) {
        inputQueue.add(input);
    }

    public int getOutput() throws Exception {
        if (outputQueue.peek() != null) {
            return outputQueue.poll();
        } else {
            throw new Exception("Output queue is empty");
        }
    }

    public void runIntCodeComputer() {
        boolean shouldPause = false;
        int[] instruction;
        while (isRunning && !shouldPause) {
            instruction = returnInstruction(integerArray[pointer]);
            switch (instruction[3]) {
                case 1: {
                    integerArray[integerArray[pointer + 3]] = getValueByParameter(instruction[2], pointer + 1)
                            + getValueByParameter(instruction[1], pointer + 2);
                    pointer += 4;
                    break;
                }
                case 2: {
                    integerArray[integerArray[pointer + 3]] = getValueByParameter(instruction[2], pointer + 1)
                            * getValueByParameter(instruction[1], pointer + 2);
                    pointer += 4;
                    break;
                }
                case 3: {
                    if (!inputQueue.isEmpty()) {
                        integerArray[integerArray[pointer + 1]] = inputQueue.poll();
                        pointer += 2;
                    } else {
                        shouldPause = true;
                    }
                    break;
                }
                case 4: {
                    outputQueue.add(getValueByParameter(instruction[2], pointer + 1));
                    pointer += 2;
                    break;
                }
                case 5: {
                    int counter = 3;
                    if (getValueByParameter(instruction[2], pointer + 1) != 0) {
                        pointer = getValueByParameter(instruction[1], pointer + 2);
                        counter = 0;
                    }
                    pointer += counter;
                    break;
                }
                case 6: {
                    int counter = 3;
                    if (getValueByParameter(instruction[2], pointer + 1) == 0) {
                        pointer = getValueByParameter(instruction[1], pointer + 2);
                        counter = 0;
                    }
                    pointer += counter;
                    break;
                }
                case 7: {
                    integerArray[integerArray[pointer + 3]] = (getValueByParameter(instruction[2], pointer + 1) < getValueByParameter(instruction[1], pointer + 2)) ? 1 : 0;
                    pointer += 4;
                    break;
                }
                case 8: {
                    integerArray[integerArray[pointer + 3]] = (getValueByParameter(instruction[2], pointer + 1) == getValueByParameter(instruction[1], pointer + 2)) ? 1 : 0;
                    pointer += 4;
                    break;
                }
                case 9: {
                    relativeBase += getValueByParameter(instruction[2], pointer + 1);
                    pointer += 2;
                    break;
                }
                case 99: {
                    isRunning = false;
                    break;
                }
                default:
                    break;
            }
        }
    }

    int getValueByParameter(int parameter, int pointer) {
        if (parameter == 0) {                       // position mode
            return integerArray[integerArray[pointer]];
        }
        if (parameter == 2) {                        // relative mode
            return integerArray[relativeBase + integerArray[pointer]];
        }
        return integerArray[pointer];               // immediate mode
    }

    private int[] returnInstruction(int number) {
        int[] parameterModeArray = new int[5];
        int[] instructionArray = new int[4];
        StringBuilder stringBuilder = new StringBuilder();
        String integerArrayString = stringBuilder.append(number).reverse().toString();
        for (int i = 0; i < integerArrayString.length(); i++) {
            parameterModeArray[4 - i] = Character.getNumericValue(integerArrayString.charAt(i));
        }
        System.arraycopy(parameterModeArray, 0, instructionArray, 0, 3);
        instructionArray[3] = Integer.parseInt(String.valueOf(parameterModeArray[3]) + parameterModeArray[4]);
        return instructionArray;
    }
}
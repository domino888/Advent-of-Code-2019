package pl.kanthak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Stage1 {

    public static void main(String[] args) {
        int pointer = 0;
        System.out.println("Enter instructions:");
        Scanner scanner = new Scanner(System.in);
        int[] integerArray = readNumbersFromConsole();

        loop: for (int i = 0; i < integerArray.length; i += pointer) {
            int[] instructionArray = returnInstructionArray(integerArray[i]);
            int parameterMode1 = instructionArray[2];
            int parameterMode2 = instructionArray[1];
            //int parameterMode3 = instructionArray[0];
            switch (instructionArray[3]) {
                case 1: {
                    pointer = 4;
                    if (parameterMode1 == 0) {
                        if (parameterMode2 == 0) {
                            integerArray[integerArray[i + 3]] = integerArray[integerArray[i + 1]] + integerArray[integerArray[i + 2]];
                        } else {
                            integerArray[integerArray[i + 3]] = integerArray[integerArray[i + 1]] + integerArray[i + 2];
                        }
                    } else {
                        if (parameterMode2 == 0) {
                            integerArray[integerArray[i + 3]] = integerArray[i + 1] + integerArray[integerArray[i + 2]];
                        } else {
                            integerArray[integerArray[i + 3]] = integerArray[i + 1] + integerArray[i + 2];
                        }
                    }
                    break;
                }
                case 2: {
                    pointer = 4;
                    if (parameterMode1 == 0) {
                        if (parameterMode2 == 0) {
                            integerArray[integerArray[i + 3]] = integerArray[integerArray[i + 1]] * integerArray[integerArray[i + 2]];
                        } else {
                            integerArray[integerArray[i + 3]] = integerArray[integerArray[i + 1]] * integerArray[i + 2];
                        }
                    } else {
                        if (parameterMode2 == 0) {
                            integerArray[integerArray[i + 3]] = integerArray[i + 1] * integerArray[integerArray[i + 2]];
                        } else {
                            integerArray[integerArray[i + 3]] = integerArray[i + 1] * integerArray[i + 2];
                        }
                    }
                    break;
                }
                case 3: {
                    pointer = 2;
                    System.out.println("Enter ID of system:");
                    integerArray[integerArray[i + 1]] = scanner.nextInt();
                    break;
                }
                case 4: {
                    pointer = 2;
                    if (parameterMode1 == 0) {
                        System.out.println(integerArray[integerArray[i + 1]]);
                    } else {
                        System.out.println(integerArray[i + 1]);
                    }
                    break;
                }
                case 99:
                    break loop;
            }
        }
    }

    public static int[] returnInstructionArray(int instruction) {
        int[] parameterModeArray = new int[5];
        int[] instructionArray = new int[4];
        StringBuilder stringBuilder = new StringBuilder();
        String integerArrayString = stringBuilder.append(instruction).reverse().toString();
        for (int i = 0; i < integerArrayString.length(); i++) {
            parameterModeArray[4 - i] = Character.getNumericValue(integerArrayString.charAt(i));
        }
        System.arraycopy(parameterModeArray, 0, instructionArray, 0, 3);
        instructionArray[3] = Integer.parseInt(String.valueOf(parameterModeArray[3]) + String.valueOf(parameterModeArray[4]));
        return instructionArray;
    }

    static public int[] readNumbersFromConsole() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        try {
            line = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] lineWithoutCommas = line.trim().split(",");
        int[] integerArray = new int[lineWithoutCommas.length];
        for (int i = 0; i < lineWithoutCommas.length; i++) {
            integerArray[i] = Integer.parseInt(lineWithoutCommas[i]);
        }
        return integerArray;
    }
}

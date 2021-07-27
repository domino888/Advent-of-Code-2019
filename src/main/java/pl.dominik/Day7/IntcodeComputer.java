package main.java.pl.dominik.Day7;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class IntcodeComputer {

    Integer[] integerArray;
    int inputPhaseSetting;
    int inputSignal;
    int output;
    int pointer;

    public IntcodeComputer(int inputPhaseSetting, int inputSignal, Integer[] integerArray) throws IOException {
        this.inputPhaseSetting = inputPhaseSetting;
        this.inputSignal = inputSignal;
        if(integerArray != null){
            this.integerArray = Arrays.copyOf(integerArray, integerArray.length);
        } else{
            this.integerArray = readNumberFromFile();
        }
    }

    public int getOutput() {
        return output;
    }

    public void setOutput(int output) {
        this.output = output;
    }

    public void runIntCodeComputer() throws IOException {
        pointer = 0;
        boolean flag = true;
        loop:
        for (int i = 0; i < integerArray.length; i += pointer) {
            int[] instructionArray = returnInstructionArray(integerArray[i]);
            int parameterMode1 = instructionArray[2];
            int parameterMode2 = instructionArray[1];
            int parameterMode3 = instructionArray[0];
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
                    if (flag) {
                        integerArray[integerArray[i + 1]] = inputPhaseSetting;
                        flag = false;
                    } else {
                        integerArray[integerArray[i + 1]] = inputSignal;
                    }
                    break;
                }
                case 4: {
                    pointer = 2;
                    if (parameterMode1 == 0) {
                        setOutput(integerArray[integerArray[i + 1]]);
                    } else {
                        setOutput(integerArray[i + 1]);
                    }
                    break;
                }
                case 5: {
                    pointer = 3;
                    if (parameterMode1 == 0) {
                        if (parameterMode2 == 0) {
                            if (integerArray[integerArray[i + 1]] != 0) {
                                i = integerArray[integerArray[i + 2]];
                                pointer = 0;
                            }
                        } else {
                            if (integerArray[integerArray[i + 1]] != 0) {
                                i = integerArray[i + 2];
                                pointer = 0;
                            }
                        }
                    } else {
                        if (parameterMode2 == 0) {
                            if (integerArray[i + 1] != 0) {
                                i = integerArray[integerArray[i + 2]];
                                pointer = 0;
                            }
                        } else {
                            if (integerArray[i + 1] != 0) {
                                i = integerArray[i + 2];
                                pointer = 0;
                            }
                        }
                    }
                    break;
                }
                case 6: {
                    pointer = 3;
                    if (parameterMode1 == 0) {
                        if (parameterMode2 == 0) {
                            if (integerArray[integerArray[i + 1]] == 0) {
                                i = integerArray[integerArray[i + 2]];
                                pointer = 0;
                            }
                        } else {
                            if (integerArray[integerArray[i + 1]] == 0) {
                                i = integerArray[i + 2];
                                pointer = 0;
                            }
                        }
                    } else {
                        if (parameterMode2 == 0) {
                            if (integerArray[i + 1] == 0) {
                                i = integerArray[integerArray[i + 2]];
                                pointer = 0;
                            }
                        } else {
                            if (integerArray[i + 1] == 0) {
                                i = integerArray[i + 2];
                                pointer = 0;
                            }
                        }
                    }
                    break;
                }
                case 7: {
                    pointer = 4;
                    if (parameterMode1 == 0) {
                        if (parameterMode2 == 0) {
                            if (integerArray[integerArray[i + 1]] < integerArray[integerArray[i + 2]]) {
                                integerArray[integerArray[i + 3]] = 1;
                            } else {
                                integerArray[integerArray[i + 3]] = 0;
                            }
                        } else {
                            if (integerArray[integerArray[i + 1]] < integerArray[i + 2]) {
                                integerArray[integerArray[i + 3]] = 1;
                            } else {
                                integerArray[integerArray[i + 3]] = 0;
                            }
                        }
                    } else {
                        if (parameterMode2 == 0) {
                            if (integerArray[i + 1] < integerArray[integerArray[i + 2]]) {
                                integerArray[integerArray[i + 3]] = 1;
                            } else {
                                integerArray[integerArray[i + 3]] = 0;
                            }
                        } else {
                            if (integerArray[i + 1] < integerArray[i + 2]) {
                                integerArray[integerArray[i + 3]] = 1;
                            } else {
                                integerArray[integerArray[i + 3]] = 0;
                            }
                        }
                    }
                    break;
                }
                case 8: {
                    pointer = 4;
                    if (parameterMode1 == 0) {
                        if (parameterMode2 == 0) {
                            if (integerArray[integerArray[i + 1]] == integerArray[integerArray[i + 2]]) {
                                integerArray[integerArray[i + 3]] = 1;
                            } else {
                                integerArray[integerArray[i + 3]] = 0;
                            }
                        } else {
                            if (integerArray[integerArray[i + 1]] == integerArray[i + 2]) {
                                integerArray[integerArray[i + 3]] = 1;
                            } else {
                                integerArray[integerArray[i + 3]] = 0;
                            }
                        }
                    } else {
                        if (parameterMode2 == 0) {
                            if (integerArray[i + 1] == integerArray[integerArray[i + 2]]) {
                                integerArray[integerArray[i + 3]] = 1;
                            } else {
                                integerArray[integerArray[i + 3]] = 0;
                            }
                        } else {
                            if (integerArray[i + 1] == integerArray[i + 2]) {
                                integerArray[integerArray[i + 3]] = 1;
                            } else {
                                integerArray[integerArray[i + 3]] = 0;
                            }
                        }
                    }
                    break;
                }
                case 99:
                    break loop;
            }
        }
    }

    private int[] returnInstructionArray(int instruction) {
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

    public Integer[] readNumberFromFile() throws IOException {
        Path path = Paths.get("src/main/resources/Day7/data.txt");
        BufferedReader reader = Files.newBufferedReader(path);
        String line = reader.readLine();

        String[] lineWithoutCommas = line.trim().split(",");
        Integer[] integerArray = new Integer[lineWithoutCommas.length];

        for (int i = 0; i < lineWithoutCommas.length; i++) {
            integerArray[i] = Integer.parseInt(lineWithoutCommas[i]);
        }
        return integerArray;
    }
}

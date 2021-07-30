package main.java.pl.dominik.Day7;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class IntcodeComputer {

    Integer[] integerArray;
    Queue<Integer> inputQueue = new LinkedList<>();
    Queue<Integer> outputQueue = new LinkedList<>();;

    public IntcodeComputer(Integer[] integerArray) {
        this.integerArray = Arrays.copyOf(integerArray, integerArray.length);
    }

    public void setInput(int input) {
        inputQueue.add(input);
    }

    public int getOutput() {
        if (outputQueue.peek() != null) {
            return outputQueue.poll();
        } else return Integer.MIN_VALUE;
    }

    public void runIntCodeComputer() {
        int pointer = 0;
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
                    integerArray[integerArray[i + 1]] = inputQueue.poll();
                    break;
                }
                case 4: {
                    pointer = 2;
                    if (parameterMode1 == 0) {
                        outputQueue.add(integerArray[integerArray[i + 1]]);
                    } else {
                        outputQueue.add(integerArray[i + 1]);
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
        instructionArray[3] = Integer.parseInt(String.valueOf(parameterModeArray[3]) + parameterModeArray[4]);
        return instructionArray;
    }
}
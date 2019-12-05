//package pl.kanthak;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//public class Stage1 {
//    public static void main(String[] args) {
//
//        Integer[] integerArray = readNumbersFromConsole();
//
//        for (int i = 0; i < integerArray.length; i += 4) {
//
//            switch (integerArray[i]) {
//                case 1: {
//                    integerArray[integerArray[i + 3]] = integerArray[integerArray[i + 1]] + integerArray[integerArray[i + 2]];
//                    break;
//                }
//                case 2: {
//                    integerArray[integerArray[i + 3]] = integerArray[integerArray[i + 1]] * integerArray[integerArray[i + 2]];
//                    break;
//                }
//                case 99:
//                    break;
//            }
//        }
//        for (Integer integer : integerArray) {
//            System.out.println(integer);
//        }
//        System.out.println(integerArray[0]);
//    }
//
//    static public Integer[] readNumbersFromConsole() {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        String line = null;
//
//        try {
//            line = bufferedReader.readLine();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        String[] lineWithoutCommas = line.trim().split(",");
//        Integer[] integerArray = new Integer[lineWithoutCommas.length];
//
//        for (int i = 0; i < lineWithoutCommas.length; i++) {
//            integerArray[i] = Integer.parseInt(lineWithoutCommas[i]);
//        }
//        return integerArray;
//    }
//}

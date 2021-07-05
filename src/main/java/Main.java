package main.java;

import main.java.pl.dominik.Day1.Day1;
import main.java.pl.dominik.Day2.Day2;
import main.java.pl.dominik.Day3.Day3;
import main.java.pl.dominik.Day4.Day4;
import main.java.pl.dominik.Day5.Day5;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("\nType day: (1-24)");
            switch (in.next()) {
                case "1":
                    executeDay1();
                    break;
                case "2":
                    executeDay2();
                    break;
                case "3":
                    executeDay3();
                    break;
                case "4":
                    executeDay4();
                    break;
                case "5":
                    executeDay5();
                    break;
                case "q":
                    return;
                default:
                    break;
            }
        }
    }

    private static void executeDay1() throws IOException {
        Day1 day1 = new Day1();
        day1.execute();
    }

    private static void executeDay2() throws IOException {
        Day2 day2 = new Day2();
        day2.execute();
    }

    private static void executeDay3() throws IOException {
        Day3 day3 = new Day3();
        day3.execute();
    }
    private static void executeDay4() throws IOException {
        Day4 day4 = new Day4();
        day4.execute();
    }
    private static void executeDay5() throws IOException {
        Day5 day5 = new Day5();
        day5.execute();
    }
}

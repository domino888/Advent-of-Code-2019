package main.java;

import main.java.pl.dominik.Day1.Day1;
import main.java.pl.dominik.Day2.Day2;
import main.java.pl.dominik.Day3.Day3;

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
}

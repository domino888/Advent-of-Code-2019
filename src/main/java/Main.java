package main.java;

import main.java.pl.dominik.Day1.Day1;
import main.java.pl.dominik.Day2.Day2;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException{

        executeDay1();
        executeDay2();

    }

    private static void executeDay1() throws IOException {
        Day1 day1 = new Day1();
        day1.execute();
    }

    private static void executeDay2() throws IOException {
        Day2 day2 = new Day2();
        day2.execute();
    }
}

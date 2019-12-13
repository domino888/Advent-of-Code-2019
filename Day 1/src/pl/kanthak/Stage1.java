package pl.kanthak;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Stage1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> massOfModules = new ArrayList<>();
        List<Integer> neededFuels = new ArrayList<>();
        String line;

        while (!(line = scanner.nextLine()).isEmpty()) {
            massOfModules.add(Integer.parseInt(line));
        }

        for (Integer mass : massOfModules) {
            mass = mass / 3 - 2;
            neededFuels.add(mass);
        }

        Integer fuelRequirements = neededFuels
                .stream()
                .reduce(0, Integer::sum);

        System.out.println(fuelRequirements);
    }

}

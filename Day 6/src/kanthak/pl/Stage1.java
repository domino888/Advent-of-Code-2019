package kanthak.pl;

import java.util.*;

public class Stage1 {

    public static void main(String[] args) {
        List<String> dataList = readDataFromConsole();
        Map<String, Planet> planetsMap = new HashMap<>();
        String[] splitArray;
        planetsMap.put("COM", new Planet("COM"));

        for (String s : dataList) {
            splitArray = s.split("\\)");
            planetsMap.put(splitArray[1], new Planet(splitArray[1]));
        }
        for (String s : dataList) {
            splitArray = s.split("\\)");
            planetsMap.get(splitArray[0]).addChild(planetsMap.get(splitArray[1]));
        }
        System.out.println("Total number of orbits: " + planetsMap.get("COM").getListSize(1));
    }

    static public List<String> readDataFromConsole() {
        Scanner scanner = new Scanner(System.in);
        List<String> dataList = new ArrayList<>();
        String line;

        while (!(line = scanner.nextLine()).isEmpty()) {
            dataList.add(line);
        }
        return dataList;
    }
}
package pl.kanthak;

import java.util.*;

public class Stage2 {

    static Map<String, Planet> planetsMap = new HashMap<>();

    public static void main(String[] args) {

        List<String> dataList = readDataFromConsole();
        String[] splitArray;
        planetsMap.put("COM", new Planet("COM"));
        planetsMap.get("COM").setParent(null);

        for (String s : dataList) {
            splitArray = s.split("\\)");
            planetsMap.put(splitArray[1], new Planet(splitArray[1]));
        }
        for (String s : dataList) {
            splitArray = s.split("\\)");
            planetsMap.get(splitArray[0]).addChild(planetsMap.get(splitArray[1]));
        }
        for (String s : dataList) {
            splitArray = s.split("\\)");
            planetsMap.get(splitArray[1]).setParent(planetsMap.get(splitArray[0]));
        }
        planetsMap.get("COM").setDepth(0);

        System.out.println(findDistanceBetweenPlanets(planetsMap.get("SAN").getParent(), planetsMap.get("YOU").getParent()));
    }

    public static int findDistanceBetweenPlanets(Planet planet1, Planet planet2) {
        Planet LCA = findLCA(planet1, planet2);
        return planet1.getDepth() + planet2.getDepth() - 2 * LCA.getDepth();
    }

    public static Planet findLCA(Planet planet1, Planet planet2) {
        List<Planet> path1 = planetsMap.get(planet1.name).getPathToRoot();
        List<Planet> path2 = planetsMap.get(planet2.name).getPathToRoot();
        Collections.reverse(path1);
        Collections.reverse(path2);

        if (path1.size() <= 0) {
            return planetsMap.get("COM");
        }
        if (path2.size() <= 0) {
            return planetsMap.get("COM");
        }
        int i;
        for (i = 0; i < path1.size() && i < path2.size(); i++) {
            if (!path1.get(i).getName().equals(path2.get(i).getName())) {
                break;
            }
        }
        return path1.get(i - 1);
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
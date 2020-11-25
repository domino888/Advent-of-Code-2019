package kanthak.pl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Planet {

    List<Planet> children;
    String name;

    public Planet(String data) {
        this.name = data;
        this.children = new ArrayList<>();
    }

    public void addChild(Planet planet) {
        children.add(planet);
    }

    public int getListSize(int multiplier) {
        List<Integer> recursiveValues = new ArrayList<>();
        int currentValue = multiplier * children.size();
        multiplier++;
        for (Planet child : children) {
            recursiveValues.add(child.getListSize(multiplier));
        }
        return currentValue + recursiveValues.stream().mapToInt(Integer::intValue).sum();
    }

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder(50);
        print(buffer, "", "");
        return buffer.toString();
    }

    private void print(StringBuilder buffer, String prefix, String childrenPrefix) {
        buffer.append(prefix);
        buffer.append(name);
        buffer.append('\n');
        if (children != null) {
            for (Iterator<Planet> it = children.iterator(); it.hasNext(); ) {
                Planet next = it.next();
                if (it.hasNext()) {
                    next.print(buffer, childrenPrefix + "├── ", childrenPrefix + "│   ");
                } else {
                    next.print(buffer, childrenPrefix + "└── ", childrenPrefix + "    ");
                }
            }
        }
    }
}

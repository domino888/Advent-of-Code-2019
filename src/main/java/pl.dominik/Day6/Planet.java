package main.java.pl.dominik.Day6;

import java.util.ArrayList;
import java.util.List;

public class Planet {

    List<Planet> children;
    Planet parent;
    String name;
    int depth;

    public Planet(String data) {
        this.name = data;
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Planet getParent() {
        return parent;
    }

    public void setParent(Planet parent) {
        this.parent = parent;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int parameter) {
        depth = parameter;
        for (Planet child : children) {
            child.setDepth(parameter + 1);
        }
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

    public List<Planet> getPathToRoot() {
        List<Planet> pathList = new ArrayList<>();
        if (parent != null) {
            pathList.add(parent);
            pathList.addAll(parent.getPathToRoot());
        }
        return pathList;
    }

    @Override
    public String toString() {
        return name;
    }
}
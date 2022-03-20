package main.java.pl.dominik.Day10;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Day10 {
    private int sizeOfMap;

    public void execute() throws IOException {
        System.out.println("Day 10: ");
        System.out.println("Part One result: " + getNumberOfDetectedAsteroids(readMapFromFile()));
    }

    public int getNumberOfDetectedAsteroids(char[][] map) {
        List<Asteroid> asteroids = loadAsteroids(map);
        setNeighboringAsteroids(asteroids);
        computeVectors(asteroids);
        computeVisibleAsteroids(asteroids);

        return 0;
    }

    public void computeVisibleAsteroids(List<Asteroid> asteroids){
        for(Asteroid asteroid :asteroids){
            asteroid.computeVisibleNeighbors(sizeOfMap);
        }
    }

    public void computeVectors(List<Asteroid> asteroids){
        for(Asteroid asteroid :asteroids){
            asteroid.computeVectors();
        }
    }

    public void setNeighboringAsteroids(List<Asteroid> asteroids) {
        for (Asteroid asteroid : asteroids) {
            List<Asteroid> neighbors = new ArrayList<>();
            for (Asteroid a : asteroids) {
                if (!asteroid.getPosition().equals(a.getPosition())) {
                    neighbors.add(new Asteroid(a.getPosition()));
                }
            }
            asteroid.setNeighbors(neighbors);
        }
    }

    public List<Asteroid> loadAsteroids(char[][] map) {
        List<Asteroid> asteroids = new ArrayList<>();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[j][i] == '#') {
                    asteroids.add(new Asteroid(new Position(j, i)));
                }
            }
        }
        return asteroids;
    }

    private char[][] readMapFromFile() throws IOException {
        Path path = Paths.get("src/main/resources/Day10/data.txt");
        BufferedReader reader = Files.newBufferedReader(path);
        String line;
        List<String> listOfLines = new ArrayList<>();
        while ((line = reader.readLine()) != null) {
            listOfLines.add(line);
        }
        sizeOfMap = listOfLines.size();
        char[][] map = new char[sizeOfMap][sizeOfMap];

        for (int i = 0; i < listOfLines.size(); i++) {
            for (int j = 0; j < listOfLines.get(i).length(); j++) {
                char ch = listOfLines.get(i).charAt(j);
                map[j][i] = ch;
            }
        }
        return map;
    }
}

package org.example;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.*;
import java.util.Collections;

public class Practice {
    public void main(String[] args) throws IOException {
        InputStream in = getClass().getClassLoader().getResourceAsStream("Practice.txt");
        List<String> lines = new BufferedReader(new InputStreamReader(in))
                .lines().toList();

        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();

        for (String line : lines) {
            String[] numbers = line.trim().split("\\s+"); // Split by one or more whitespace characters
            leftList.add(Integer.parseInt(numbers[0]));
            rightList.add(Integer.parseInt(numbers[1]));
        }

        Collections.sort(leftList);
        Collections.sort(rightList);

        int totalDistance = 0;
        for (int i = 0; i < leftList.size(); i++) {
            totalDistance += Math.abs(leftList.get(i) - rightList.get(i));
        }

        System.out.println("Total distance: " + totalDistance);
    }
}


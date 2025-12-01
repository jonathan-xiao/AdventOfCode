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


public class DayOne {
    void main() {
        InputStream in = getClass().getClassLoader().getResourceAsStream("DayOne.txt");
        List<String> lines = new BufferedReader(new InputStreamReader(in))
                .lines().toList();

        int point = 50;
        int count = 0;

        for (String line : lines) {
            char letter = line.charAt(0);
            int number = Integer.parseInt(line.substring(1));

            if (letter == 'R') {
                int passesDuring = (point + number - 1) / 100;
                point = (point + number) % 100;
                count += passesDuring;
                if (point == 0) count++;
            } else {
                int st = (100 - point) % 100;
                int passesDuring = (st + number - 1) / 100;
                point = ((point - number) % 100 + 100) % 100;
                count += passesDuring;
                if (point == 0) count++;
            }
        }

        System.out.println(count);
    }

}

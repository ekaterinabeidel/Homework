package org.example._2024_04_26.clinic;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    /*
    * 1 Создать класс Patient
    * 2 Сделать парсер из строки в Patient
    * 3 Сделать картотеку, которая находит пациентов по id или имени и фамилии.
    */

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(Path.of("patiens"));
        List<String> readList = new ArrayList<>();
        while (scanner.hasNextLine()) {
            readList.add(scanner.nextLine());
        }
        List<Patient> patientList = new ArrayList<>();
        for (String s : readList) {
            patientList.add(Parsing.getPatientFromFile(s));
        }
        System.out.println(patientList);
    }
}

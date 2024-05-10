package org.example._2024_04_26.clinic;

import java.time.LocalDate;

public class Parsing {
    public static Patient  getPatientFromFile(String info) {
        Patient patient = new Patient();
        String[] array = info.split(" ");
        patient.setId(Integer.parseInt(array[0]));
        patient.setName(array[1]);
        patient.setSurname(array[2]);
        patient.setDateOfBirth(LocalDate.parse(array[3]));
        return patient;
    }

}

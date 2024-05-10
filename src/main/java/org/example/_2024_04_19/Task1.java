package org.example._2024_04_19;

import java.util.ArrayList;
import java.util.List;

public class Task1 {
    /* Дан список строк.
        * Создайте метод, который выберет в новый список те строки, которые содержат адреса электронной почты.
        * Адреса можно найти по содержанию символа @ в строке.
    */
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("homework");
        strings.add("work");
        strings.add("example@gmail.com");
        strings.add("mail@web.de");
        System.out.println(extractWithEmails(strings));
    }
    public static List <String> extractWithEmails (List<String> original) {
        List<String> result = new ArrayList<>();
        for (String s : original) {
            if (s.contains("@")){
                result.add(s);
            }
        }
        return result;
    }


}

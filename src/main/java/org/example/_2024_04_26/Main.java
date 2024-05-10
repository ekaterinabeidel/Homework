package org.example._2024_04_26;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, List<Double>> nameToMarks = Map.of(
                "Tom", new ArrayList<>(),
                "Jerry", Arrays.asList(5.0, 5.0)
//                "Ban", List.of(4.0,4.0),
//                "Max", List.of(3.0,3.0),
//                "Alex", List.of(0.0,0.0)
        );

        System.out.println(getAverageMark(nameToMarks));
        System.out.println(getWordRepetition("Мы едем едем едем в далекие края"));
    }

    /* 2 Напишите метод, который принимает на вход строку и
     * возвращает набор уникальных слов из этой строки.
     */
    private static Set<String> getUniqueWords(String sentence) {
        Set<String> uniqueWords = new HashSet<>();
        return new HashSet<>(Arrays.asList(sentence.split(" ")));
    }

    /* Создайте программу для учета оценок студентов.
     * Используйте коллекцию Map, где ключ - это имя студента, а значение - список его оценок.
     * Реализуйте метод для подсчета средней оценки каждого студента.
     */
    private static Map<String, Double> getAverageMark(Map<String, List<Double>> nameToMarks) {
        Map<String, Double> nameToAverage = new HashMap<>();
        for (Map.Entry<String, List<Double>> e : nameToMarks.entrySet()) {
            double average = 0;
            for (Double m : e.getValue()) {
                average += m;
            }
//            if(!e.getValue().isEmpty()){
//                average/= e.getValue().size();
//            }
            average = !e.getValue().isEmpty() ? average / e.getValue().size() : 0;
            nameToAverage.put(e.getKey(), average);
        }
        return nameToAverage;


    }
    /* Реализуйте метод, который принимает на вход строку и возвращает Map,
     * где ключ - это слово, а значение - количество его повторений в строке
     */
    public static Map<String,Integer> getWordRepetition (String sentence) {
        Map<String,Integer> wordToCount = new HashMap<>();
        for (String word : sentence.split(" ")) {
            if (wordToCount.containsKey(word)){
                int current =  wordToCount.get(word);
                wordToCount.put(word,current+1);
            } else {
                wordToCount.put(word,1);
            }
        }
        return wordToCount;
    }

}

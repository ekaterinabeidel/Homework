package org.example._2024_05_03.event;

import org.example._2024_05_03.event.Event;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Event event1 = new Event(LocalDateTime.now(),"Summary");
        Event event2 = new Event(LocalDateTime.now().minusDays(1L),"Practice");
        Event event3 = new Event(LocalDateTime.of(2024,5, 6, 10,0),"Colloc");
        Event event4 = new Event(LocalDateTime.of(2024,5, 6, 10,0),"Additional");
        List<Event> events = new ArrayList<>(List.of(event2, event1, event3, event4));
        Collections.sort(events);
        events.forEach(event -> System.out.println(event));
    }
}
/*Создайте программу, которая работает с событиями. Каждое событие имеет дату и описание.
Используйте интерфейс Comparable для сортировки событий сначала по дате, затем по алфавиту описания.*/
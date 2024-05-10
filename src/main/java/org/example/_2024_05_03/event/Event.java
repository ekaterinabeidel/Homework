package org.example._2024_05_03.event;

import java.time.LocalDateTime;

public class Event implements Comparable<Event> {
    private final LocalDateTime dateTime;
    private final String description;

    public Event(LocalDateTime dateTime, String description) {
        this.dateTime = dateTime;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Event{" +
                "dateTime=" + dateTime +
                ", description='" + description + '\'' +
                '}';
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public int compareTo(Event o) {
        int result = this.dateTime.compareTo(o.dateTime);
        if (result == 0) result = this.description.compareTo(o.description);
        return result;
    }
}

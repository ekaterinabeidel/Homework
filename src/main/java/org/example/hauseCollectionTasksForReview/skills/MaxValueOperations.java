package org.example.hauseCollectionTasksForReview.skills;

import java.util.List;

public class MaxValueOperations {

    /*
    Общий алгоритм для операций с поиском наибольшего значения в коллекции
    Наибольшее_значение = Начальное_значение
    Для каждого элемента в коллекции:
         Если текущий элемент больше Наибольшего_значения:
              Обновить Наибольшее_значение
    Вернуть Наибольшее_значение
    */

    //Задание 4 (DetailedHouseCollectionTasks):
    //Определить, в каком доме самый большой процент квартир с коробками.
    public static House getHouseWithHighestPercentageOfFlatsWithBoxes(List<House> houses) {
        double maxPercentage = 0;
        House houseWithHighestPercentage = null;
        for (House house : houses) {
            int flatsWithBoxes = 0;
            for (Flat flat : house.flats) {
                if (!flat.roomList.isEmpty()) {
                    flatsWithBoxes++;
                }
            }
            double percentage = (double) flatsWithBoxes / house.flats.size();
            if (percentage > maxPercentage) {
                maxPercentage = percentage;
                houseWithHighestPercentage = house;
            }
        }
        return houseWithHighestPercentage;
    }

}

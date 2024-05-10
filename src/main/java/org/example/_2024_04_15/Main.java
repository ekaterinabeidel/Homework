package org.example._2024_04_15;

import com.github.javafaker.Faker;
import org.example._2024_04_15._enums.BankAccountCurrency;
import org.example._2024_04_15._enums.CarColor;
import org.example._2024_04_15._enums.CarModel;
import org.example._2024_04_15._enums.Country;


import java.util.Random;

public class Main {
    /*
     * Описание:
     * данная версия домашней работы homework_2024_04_15 содержит следующие методы:
     * Найти лиц, живущих на одной улице, но в разных домах.
     * Вывести список всех лиц без автомобилей (предполагая, что авто может быть null).
     * Определить количество лиц, имеющих спортивный автомобиль с мощностью более 300 л.с.
     * Найти и вывести имена и фамилии лиц, имеющих более одного счета (предполагая наличие списка счетов).
     * Вывести список лиц, чьи автомобили являются наиболее мощными в своем классе (спортивные/неспортивные).
     * Вывести всех лиц, живущих в домах, номера которых заканчиваются на "5".
     * Найти лиц с автомобилями определенной марки и цвета.
     * Вывести имена лиц, у которых зарплата выше среднего по массиву.
     * Определить лиц с наибольшим балансом на счету.
     * Вывести список лиц, чьи автомобили были куплены новыми (год выпуска авто равен текущему году).
     * Найти лиц, у которых есть автомобиль определенного цвета, но не спортивный.
     * Вывести список лиц, проживающих в квартирах (номер квартиры не равен 0).
     * Найти и вывести лиц, чьи автомобили имеют стоимость выше заданной.
     * Вывести имена и фамилии всех лиц, чьи автомобили имеют четное количество дверей.
     * Определить и вывести лицо, имеющего счет с наименьшим балансом.
     * Вывести список лиц, имеющих автомобили, которые стоят дороже их зарплаты.
     * Найти лиц, проживающих не в своей стране (предполагая, что есть поле гражданства в классе Person).
     * Определить количество лиц, у которых есть автомобили с количеством дверей больше 4.
     * Вывести список лиц, имеющих автомобиль той же марки, что и автомобиль первого лица в массиве.
     * Найти лиц, чей счет в определенной валюте является единственным с такой валютой в массиве.
     * Вывести список лиц, у которых нет автомобилей и живут в квартирах.
     * Использованы тип данных List.
     */

    public static void main(String[] args) {
        Random random = new Random();
        Faker faker = new Faker();

        Country[] countries = Country.values();
        CarModel[] carModels = CarModel.values();
        CarColor[] carColors = CarColor.values();
        BankAccountCurrency[] bankAccountCurrencies = BankAccountCurrency.values();

        Address[] addresses = new Address[10];
        for (int i = 0; i < addresses.length; i++) {
            addresses[i] = new Address(
                    countries[random.nextInt(countries.length)],
                    "Street " + random.nextInt(100),
                    random.nextInt(201),
                    random.nextInt(50)
            );
        }

       Car[] cars = new Car[10];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(
                    carModels[random.nextInt(carModels.length)],
                    random.nextInt(4) + 1,
                    faker.bool().bool(),
                    faker.number().numberBetween(70, 600),
                    faker.number().numberBetween(1000, 50000),
                    faker.number().numberBetween(2000, 2024),
                    carColors[random.nextInt(carColors.length)]
            );
        }

        BankAccount[] bankAccounts = new BankAccount[10];
        for (int i = 0; i < bankAccounts.length; i++) {
            for (int j = 0; j < bankAccounts.length; j++) {
                bankAccounts[i] = new BankAccount(
                        bankAccountCurrencies[random.nextInt(bankAccountCurrencies.length)],
                        faker.number().randomDouble(2, 0, 100000),
                        faker.number().numberBetween(0, 100000)
                );
            }

        }

        Person[] people = new Person[10];
        for (int i = 0; i < people.length; i++) {
            people[i] = new Person(
                    faker.name().firstName(),
                    faker.name().lastName(),
                    addresses[random.nextInt(addresses.length)],
                    faker.number().randomDouble(2, 2000, 5000),
                    cars[random.nextInt(cars.length)],
                    bankAccounts[random.nextInt(bankAccounts.length)]


            );
        }

        for (int i = 0; i < people.length; i++) {
            System.out.println(people[i]);

        }

    }


//    public static void findResidentsInDifferentHousesOnSameStreet(Person[] people) {
//        for (int i = 0; i < people.length; i++) {
//            if (people[i].getAddress().getStreet().equals("Street 50")) {
//                System.out.println(people[i]);
//            }
//        }
//    }

}


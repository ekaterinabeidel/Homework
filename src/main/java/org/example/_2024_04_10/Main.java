package org.example._2024_04_10;

import com.github.javafaker.Faker;
import org.example._2024_04_10._enums.BankAccountCurrency;
import org.example._2024_04_10._enums.CarColor;
import org.example._2024_04_10._enums.CarModel;
import org.example._2024_04_10._enums.Country;

import java.util.Random;

public class Main {
    /*
     * Описание:
     * данная версия домашней работы homework_2024_04_10 содержит четыре следующих метода:
     * Вывести имена и фамилии всех лиц, чьи автомобили не красные и не спортивные.
     * Найти и вывести среднюю зарплату всех лиц, проживающих в определенной стране.
     * Вывести информацию о всех лицах, у которых счет в определенной валюте превышает заданный баланс.
     * Перечислить всех, у кого автомобиль был выпущен до определенного года.
     * Использованы только массивы.
     * Следующая версия домашней работы homework_2024_04_15 будет содержать другие методы с использованием типа данных List
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
        System.out.println("Вывести имена и фамилии всех лиц, чьи автомобили не красные и не спортивные:");
        printNonRedNonSportCarsOwners(people);
        System.out.println("Найти и вывести среднюю зарплату всех лиц, проживающих в стране: AUSTRIA ");
        System.out.println(findAverageSalaryByCountry(people));
        ;
        System.out.println("Вывести информацию о всех лицах, у которых счет в  валюте EURO " +
                "превышает баланс: 15000");
        printPeopleWithBalanceAboveInCurrency(people);
        System.out.println("Перечислить всех, у кого автомобиль был выпущен до 2011 года: ");
        printPeopleWithCarsBeforeYearOfManufacture(people);
    }

    public static void printNonRedNonSportCarsOwners(Person[] people) {
        for (int i = 0; i < people.length; i++) {
            if (people[i].getCar().getCarColor() != CarColor.RED && people[i].getCar().isSports()) {

                System.out.println(
                        "name='" + people[i].getName() + '\'' +
                                ", surname='" + people[i].getSurname() + '\'');
//                                ", carColor=" + people[i].getCar().getCarColor() + '\'' +
//                                ", isSports=" + people[i].getCar().isSports());
            }
        }
    }

    public static double findAverageSalaryByCountry(Person[] people) {
        double totalSalary = 0;
        double totalNumberOfPeople = 0;
        for (int i = 0; i < people.length; i++) {
            if (people[i].getAddress().getCountry() == Country.AUSTRIA) {

                totalSalary += people[i].getSalary();
                totalNumberOfPeople++;
            }
        }
        return (totalNumberOfPeople > 0) ? (totalSalary / totalNumberOfPeople) : 0.0;
    }

    public static void printPeopleWithBalanceAboveInCurrency(Person[] people) {
        for (int i = 0; i < people.length; i++) {
            if (people[i].getBankAccounts().getBalance() >= 15000
                    && people[i].getBankAccounts().getBankAccountCurrency() == BankAccountCurrency.EURO) {
                System.out.println(people[i]);
            }
        }
    }

    public static void printPeopleWithCarsBeforeYearOfManufacture(Person[] people) {
        for (int i = 0; i < people.length; i++) {
            if (people[i].getCar().getYearOfManufacture() <= 2010) {
                System.out.println(people[i]);
            }
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


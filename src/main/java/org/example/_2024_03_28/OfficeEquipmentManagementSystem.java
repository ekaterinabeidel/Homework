package org.example._2024_03_28;

import com.github.javafaker.Faker;

public class OfficeEquipmentManagementSystem {
    public static void main(String[] args) {
        Faker faker = new Faker();
        OfficeEquipment[] officeEquipments = new OfficeEquipment[10];
        for (int i = 0; i < officeEquipments.length; i++) {
            int typeOfEquipment = faker.random().nextInt(9);
            switch (typeOfEquipment) {
                case 0:
                    officeEquipments[i] = Laptop.createRandomLaptop(faker);
                    break;
                case 1:
                    officeEquipments[i] = Monitor.createRandomMonitor(faker);
                    break;
                case 2:
                    officeEquipments[i] = Phone.createRandomPhone(faker);
                    break;
                case 3:
                    officeEquipments[i] = Printer.createRandomPrinter(faker);
                    break;
                case 4:
                    officeEquipments[i] = Projector.createRandomProjector(faker);
                    break;
                case 5:
                    officeEquipments[i] = Router.createRandomRouter(faker);
                    break;
                case 6:
                    officeEquipments[i] = Scanner.createRandomScanner(faker);
                    break;
                case 7:
                    officeEquipments[i] = Switch.createRandomSwitch(faker);
                    break;
                case 8:
                    officeEquipments[i] = Tablet.createRandomTablet(faker);
                    break;
            }
        }
        printAllEquipment(officeEquipments);
        printTotalPrice(officeEquipments);
        listByManufacturer(officeEquipments, "Ziemann-Batz");
        printOldestEquipment(officeEquipments);
        listByYear(officeEquipments, 2002);
        printCountOfOperational(officeEquipments);

    }

    public static void printAllEquipment(OfficeEquipment[] officeEquipment) {
        for (OfficeEquipment equipment : officeEquipment) {
            System.out.println("Type: " + equipment.getClass().getSimpleName());
            System.out.println("ID: " + equipment.getId());
            System.out.println("Model Name: " + equipment.getModelName());
            System.out.println("Manufacturer: " + equipment.getManufacturer());
            System.out.println("Year of Manufacture: " + equipment.getYearOfManufacture());
            System.out.println("Price: " + equipment.getPrice());
            System.out.println("Weight: " + equipment.getWeight());
            System.out.println("Is Operational: " + equipment.isOperational());
            System.out.println("--------------------------------------");
        }
    }

    public static double calculateTotalPrice(OfficeEquipment[] officeEquipment) {
        double cost = 0;
        for (OfficeEquipment equipment : officeEquipment) {
            cost += equipment.getPrice();
        }
        return cost;
    }

    public static void printTotalPrice(OfficeEquipment[] officeEquipments) {
        System.out.println(calculateTotalPrice(officeEquipments));
        System.out.println("--------------------------------------");
    }

    public static void listByManufacturer(OfficeEquipment[] officeEquipment, String manufacturer) {
        boolean found = false;
        for (OfficeEquipment equipment : officeEquipment) {
            if (equipment.getManufacturer().equalsIgnoreCase(manufacturer)) {
                found = true;
                printAllEquipment(officeEquipment);
            }
        }
        if (!found) {
            System.out.println("No equipment found for manufacturer: " + manufacturer);
            System.out.println("--------------------------------------");
        }

    }

    public static void listByYear(OfficeEquipment[] officeEquipment, int year) {
        boolean found = false;
        for (OfficeEquipment equipment : officeEquipment) {
            if (equipment.getYearOfManufacture() == year) {
                found = true;
                System.out.println("Equipment found for " + year + ":");
                System.out.println(equipment);
                System.out.println("--------------------------------------");
            }

        }
        if (!found) {
            System.out.println("No equipment found for year: " + year);
            System.out.println("--------------------------------------");
        }
    }

    public static OfficeEquipment findOldestEquipment(OfficeEquipment[] officeEquipment) {
        int minYear = officeEquipment[0].getYearOfManufacture();
        OfficeEquipment oldestEquipment = officeEquipment[0];

        for (int i = 1; i < officeEquipment.length; i++) {
            if (officeEquipment[i].getYearOfManufacture() < minYear) {
                minYear = officeEquipment[i].getYearOfManufacture();
                oldestEquipment = officeEquipment[i];
            }
        }
        return oldestEquipment;
    }

    public static void printOldestEquipment(OfficeEquipment[] officeEquipment) {
        System.out.println("Oldest Equipment: ");
        System.out.println(findOldestEquipment(officeEquipment).toString());
        System.out.println("--------------------------------------");

    }

    public static int countOperational(OfficeEquipment[] officeEquipment) {
        int count = 0;
        for (OfficeEquipment equipment : officeEquipment) {
            if (equipment.isOperational()) {
                count++;
            }
        }
        return count;
    }

    public static void printCountOfOperational(OfficeEquipment[] officeEquipments) {
        System.out.println("Number of operational equipment :");
        System.out.println(countOperational(officeEquipments));
        System.out.println("--------------------------------------");
    }

}


package org.example._2024_03_28;

import com.github.javafaker.Faker;
import lombok.*;

@Getter
@Setter

public class Laptop extends OfficeEquipment {
    private String processorType;
    private int ramSize;
    private double storageSize;
    private double batteryLife;
    private double screenSize;
    private String operatingSystem;
    private boolean isTouchscreen;

    public Laptop(int id, String modelName, String manufacturer, int yearOfManufacture, double price, double weight, boolean isOperational, String processorType, int ramSize, double storageSize, double batteryLife, double screenSize, String operatingSystem, boolean isTouchscreen) {
        super(id, modelName, manufacturer, yearOfManufacture, price, weight, isOperational);
        this.processorType = processorType;
        this.ramSize = ramSize;
        this.storageSize = storageSize;
        this.batteryLife = batteryLife;
        this.screenSize = screenSize;
        this.operatingSystem = operatingSystem;
        this.isTouchscreen = isTouchscreen;
    }

    public static Laptop createRandomLaptop(Faker faker) {
        return new Laptop(
                faker.number().randomDigit(),
                faker.app().name(),
                faker.company().name(),
                faker.number().numberBetween(2000, 2024),
                faker.number().randomDouble(2, 300, 3000),
                faker.number().randomDouble(2, 1, 15),
                faker.bool().bool(),
                faker.lorem().word(),
                faker.number().numberBetween(4, 32),
                faker.number().randomDouble(2, 128, 2048),
                faker.number().randomDouble(2, 2, 12),
                faker.number().randomDouble(2, 10, 17),
                faker.lorem().word(),
                faker.bool().bool()

        );
    }
}

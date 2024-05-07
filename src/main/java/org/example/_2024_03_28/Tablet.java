package org.example._2024_03_28;

import com.github.javafaker.Faker;
import lombok.*;

@Getter
@Setter

public class Tablet extends OfficeEquipment {
    private String screenSize;
    private int storageSize;
    private String operatingSystem;
    private int batteryLife;
    private boolean isCellular;
    private String cameraResolution;
    private String processorType;

    public Tablet(int id, String modelName, String manufacturer, int yearOfManufacture, int price, double weight,
                  boolean isOperational, String screenSize, int storageSize, String operatingSystem, int batteryLife,
                  boolean isCellular, String cameraResolution, String processorType) {
        super(id, modelName, manufacturer, yearOfManufacture, price, weight, isOperational);
        this.screenSize = screenSize;
        this.storageSize = storageSize;
        this.operatingSystem = operatingSystem;
        this.batteryLife = batteryLife;
        this.isCellular = isCellular;
        this.cameraResolution = cameraResolution;
        this.processorType = processorType;
    }

    public static Tablet createRandomTablet(Faker faker) {
        return new Tablet(
                faker.random().nextInt(1000),
                faker.lorem().word(),
                faker.company().name(),
                faker.number().numberBetween(2000, 2024),
                faker.number().numberBetween(100, 1000),
                faker.number().randomDouble(2, 1, 10),
                faker.random().nextBoolean(),
                faker.lorem().word(),
                faker.number().numberBetween(16, 512),
                faker.lorem().word(),
                faker.number().numberBetween(4, 24),
                faker.random().nextBoolean(),
                faker.lorem().word(),
                faker.lorem().word()
        );
    }
}


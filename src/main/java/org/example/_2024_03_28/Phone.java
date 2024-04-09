package org.example._2024_03_28;

import com.github.javafaker.Faker;
import lombok.*;

@Getter
@Setter

public class Phone extends OfficeEquipment {
    private String screenSize;
    private int storageSize;
    private String operatingSystem;
    private int batteryLife;
    private boolean isSmart;
    private String cameraResolution;
    private String processorType;

    public Phone(int id, String modelName, String manufacturer, int yearOfManufacture, int price, double weight,
                 boolean isOperational, String screenSize, int storageSize, String operatingSystem,
                 int batteryLife, boolean isSmart, String cameraResolution, String processorType) {
        super(id, modelName, manufacturer, yearOfManufacture, price, weight, isOperational);
        this.screenSize = screenSize;
        this.storageSize = storageSize;
        this.operatingSystem = operatingSystem;
        this.batteryLife = batteryLife;
        this.isSmart = isSmart;
        this.cameraResolution = cameraResolution;
        this.processorType = processorType;
    }

    public static Phone createRandomPhone(Faker faker) {
        return new Phone(
                faker.random().nextInt(1000),
                faker.lorem().word(),
                faker.company().name(),
                faker.number().numberBetween(2000, 2024),
                faker.number().numberBetween(100, 10000),
                faker.number().randomDouble(1, 1, 20),
                faker.bool().bool(),
                faker.lorem().word(),
                faker.number().numberBetween(16, 512),
                faker.lorem().word(),
                faker.number().numberBetween(1000, 5000),
                faker.bool().bool(),
                faker.lorem().word(),
                faker.lorem().word()
        );
    }
}

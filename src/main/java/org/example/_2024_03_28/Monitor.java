package org.example._2024_03_28;

import com.github.javafaker.Faker;
import lombok.*;

@Getter
@Setter
public class Monitor extends OfficeEquipment {
    private double screenSize;
    private double resolution;
    private String panelType;
    private int refreshRate;
    private boolean isCurved;
    private int ports;
    private boolean isHDR;

    public Monitor(int id, String modelName, String manufacturer, int yearOfManufacture, int price, double weight, boolean isOperational, double screenSize, double resolution, String panelType, int refreshRate, boolean isCurved, int ports, boolean isHDR) {
        super(id, modelName, manufacturer, yearOfManufacture, price, weight, isOperational);
        this.screenSize = screenSize;
        this.resolution = resolution;
        this.panelType = panelType;
        this.refreshRate = refreshRate;
        this.isCurved = isCurved;
        this.ports = ports;
        this.isHDR = isHDR;
    }

    public static Monitor createRandomMonitor(Faker faker) {
        return new Monitor(
                faker.random().nextInt(1000),
                faker.lorem().word(),
                faker.company().name(),
                faker.number().numberBetween(2000, 2024),
                faker.number().numberBetween(100, 10000),
                faker.number().randomDouble(1, 1, 20),
                faker.bool().bool(),
                faker.number().randomDouble(2, 10, 50),
                faker.number().randomDouble(2, 720, 3840),
                faker.lorem().word(),
                faker.number().numberBetween(60, 240),
                faker.bool().bool(),
                faker.number().numberBetween(1, 10),
                faker.bool().bool()
        );
    }
}

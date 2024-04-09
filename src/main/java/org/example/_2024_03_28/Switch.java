package org.example._2024_03_28;

import com.github.javafaker.Faker;
import lombok.*;

@Getter
@Setter

public class Switch extends OfficeEquipment {
    private int portCount;
    private int speed;
    private String layer;
    private String managementType;
    private boolean powerOverEthernet;
    private boolean stackable;
    private String formFactor;

    public Switch(int id, String modelName, String manufacturer, int yearOfManufacture, int price, double weight,
                  boolean isOperational, int portCount, int speed, String layer, String managementType,
                  boolean powerOverEthernet, boolean stackable, String formFactor) {
        super(id, modelName, manufacturer, yearOfManufacture, price, weight, isOperational);
        this.portCount = portCount;
        this.speed = speed;
        this.layer = layer;
        this.managementType = managementType;
        this.powerOverEthernet = powerOverEthernet;
        this.stackable = stackable;
        this.formFactor = formFactor;
    }

    public static Switch createRandomSwitch(Faker faker) {
        return new Switch(
                faker.random().nextInt(1000),
                faker.lorem().word(),
                faker.company().name(),
                faker.number().numberBetween(2000, 2024),
                faker.number().numberBetween(100, 1000),
                faker.number().randomDouble(2, 1, 10),
                faker.random().nextBoolean(),
                faker.number().numberBetween(8, 48),
                faker.number().numberBetween(100, 1000),
                faker.lorem().word(),
                faker.lorem().word(),
                faker.random().nextBoolean(),
                faker.random().nextBoolean(),
                faker.lorem().word()
        );
    }

}

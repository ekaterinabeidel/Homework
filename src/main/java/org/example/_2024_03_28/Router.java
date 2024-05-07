package org.example._2024_03_28;

import com.github.javafaker.Faker;
import lombok.*;

@Getter
@Setter

public class Router extends OfficeEquipment {
    private int speed;
    private String band;
    private String security;
    private int ports;
    private int range;
    private boolean isDualBand;
    private String connectivityType;

    public Router(int id, String modelName, String manufacturer, int yearOfManufacture, int price, double weight,
                  boolean isOperational, int speed, String band, String security, int ports, int range,
                  boolean isDualBand, String connectivityType) {
        super(id, modelName, manufacturer, yearOfManufacture, price, weight, isOperational);
        this.speed = speed;
        this.band = band;
        this.security = security;
        this.ports = ports;
        this.range = range;
        this.isDualBand = isDualBand;
        this.connectivityType = connectivityType;
    }

    public static Router createRandomRouter(Faker faker) {
        return new Router(
                faker.random().nextInt(1000),
                faker.lorem().word(),
                faker.company().name(),
                faker.number().numberBetween(2000, 2024),
                faker.number().numberBetween(100, 1000),
                faker.number().randomDouble(2, 1, 10),
                faker.random().nextBoolean(),
                faker.number().numberBetween(100, 1000),
                faker.lorem().word(),
                faker.lorem().word(),
                faker.number().numberBetween(4, 8),
                faker.number().numberBetween(100, 1000),
                faker.random().nextBoolean(),
                faker.lorem().word()
        );
    }
}

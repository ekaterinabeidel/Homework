package org.example._2024_03_28;

import lombok.*;
import com.github.javafaker.Faker;

@Getter
@Setter

public class Printer extends OfficeEquipment {
    private String printTechnology;
    private double printSpeed;
    private double maxResolution;
    private boolean isColor;
    private double paperSize;
    private String connectivity;
    private double dutyCycle;

    public Printer(int id, String modelName, String manufacturer, int yearOfManufacture, int price, double weight,
                   boolean isOperational, String printTechnology, double printSpeed, double maxResolution,
                   boolean isColor, double paperSize, String connectivity, double dutyCycle) {
        super(id, modelName, manufacturer, yearOfManufacture, price, weight, isOperational);
        this.printTechnology = printTechnology;
        this.printSpeed = printSpeed;
        this.maxResolution = maxResolution;
        this.isColor = isColor;
        this.paperSize = paperSize;
        this.connectivity = connectivity;
        this.dutyCycle = dutyCycle;
    }

    public static Printer createRandomPrinter(Faker faker) {
        return new Printer(
                faker.random().nextInt(1000),
                faker.lorem().word(),
                faker.company().name(),
                faker.number().numberBetween(2000, 2024),
                faker.number().numberBetween(100, 1000),
                faker.number().randomDouble(2, 1, 10),
                faker.random().nextBoolean(),
                faker.lorem().word(),
                faker.number().randomDouble(2, 1, 10),
                faker.number().randomDouble(2, 100, 1000),
                faker.random().nextBoolean(),
                faker.number().randomDouble(2, 10, 20),
                faker.lorem().word(),
                faker.number().randomDouble(2, 1000, 5000)
        );
    }

}

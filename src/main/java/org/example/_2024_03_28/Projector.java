package org.example._2024_03_28;

import com.github.javafaker.Faker;
import lombok.*;

@Getter
@Setter

public class Projector extends OfficeEquipment {
    private int lumens;
    private String resolution;
    private double contrastRatio;
    private int lampLife;
    private String projectionSize;
    private String connectivity;
    private boolean is3DReady;

    public Projector(int id, String modelName, String manufacturer, int yearOfManufacture, int price, double weight,
                     boolean isOperational, int lumens, String resolution, double contrastRatio, int lampLife,
                     String projectionSize, String connectivity, boolean is3DReady) {
        super(id, modelName, manufacturer, yearOfManufacture, price, weight, isOperational);
        this.lumens = lumens;
        this.resolution = resolution;
        this.contrastRatio = contrastRatio;
        this.lampLife = lampLife;
        this.projectionSize = projectionSize;
        this.connectivity = connectivity;
        this.is3DReady = is3DReady;
    }

    public static Projector createRandomProjector(Faker faker) {
        return new Projector(
                faker.random().nextInt(1000),
                faker.lorem().word(),
                faker.company().name(),
                faker.number().numberBetween(2000, 2024),
                faker.number().numberBetween(100, 1000),
                faker.number().randomDouble(2, 1, 10),
                faker.random().nextBoolean(),
                faker.number().numberBetween(1000, 5000),
                faker.lorem().word(),
                faker.number().randomDouble(2, 1000, 5000),
                faker.number().numberBetween(1000, 5000),
                faker.lorem().word(),
                faker.lorem().word(),
                faker.random().nextBoolean()
        );

    }
}

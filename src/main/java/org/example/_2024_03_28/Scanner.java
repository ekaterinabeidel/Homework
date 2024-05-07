package org.example._2024_03_28;

import com.github.javafaker.Faker;
import lombok.*;

@Getter
@Setter

public class Scanner extends OfficeEquipment {
    private int scanResolution;
    private double scanSpeed;
    private int colorDepth;
    private String maxPaperSize;
    private String connectivity;
    private boolean isDuplexScanning;
    private String scannerType;

    public Scanner(int id, String modelName, String manufacturer, int yearOfManufacture, int price, double weight,
                   boolean isOperational, int scanResolution, double scanSpeed, int colorDepth, String maxPaperSize,
                   String connectivity, boolean isDuplexScanning, String scannerType) {
        super(id, modelName, manufacturer, yearOfManufacture, price, weight, isOperational);
        this.scanResolution = scanResolution;
        this.scanSpeed = scanSpeed;
        this.colorDepth = colorDepth;
        this.maxPaperSize = maxPaperSize;
        this.connectivity = connectivity;
        this.isDuplexScanning = isDuplexScanning;
        this.scannerType = scannerType;
    }

    public static Scanner createRandomScanner(Faker faker) {
        return new Scanner(
                faker.random().nextInt(1000),
                faker.lorem().word(),
                faker.company().name(),
                faker.number().numberBetween(2000, 2024),
                faker.number().numberBetween(100, 1000),
                faker.number().randomDouble(2, 1, 10),
                faker.random().nextBoolean(),
                faker.number().numberBetween(100, 1000),
                faker.number().randomDouble(2, 1, 10),
                faker.number().numberBetween(8, 48),
                faker.lorem().word(),
                faker.lorem().word(),
                faker.random().nextBoolean(),
                faker.lorem().word()
        );
    }
}

package org.example._2024_03_28;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class OfficeEquipment {
    private int id;
    private String modelName;
    private String manufacturer;
    private int yearOfManufacture;
    private double price;
    private double weight;
    private boolean isOperational;

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " {" +
                "id=" + id +
                ", modelName='" + modelName + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", yearOfManufacture=" + yearOfManufacture +
                ", price=" + price +
                ", weight=" + weight +
                ", isOperational=" + isOperational +
                '}';
    }
}

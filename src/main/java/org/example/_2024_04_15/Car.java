package org.example._2024_04_15;
import lombok.*;
import org.example._2024_04_15._enums.CarColor;
import org.example._2024_04_15._enums.CarModel;


@Getter
@Setter
@AllArgsConstructor
public class Car {
    private CarModel carModel;
    private int numberOfDoors;
    private boolean isSports;
    private int horsePower;
    private double price;
    private int yearOfManufacture;
    private CarColor carColor;

    @Override
    public String toString() {
        return "Car{" +
                "carModel=" + carModel +
                ", numberOfDoors=" + numberOfDoors +
                ", isSports=" + isSports +
                ", horsePower=" + horsePower +
                ", price=" + price +
                ", yearOfManufacture=" + yearOfManufacture +
                ", carColor=" + carColor +
                '}';
    }
}

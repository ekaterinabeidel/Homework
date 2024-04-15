package org.example._2024_04_10;
import lombok.*;
import org.example._2024_04_10._enums.Country;

@Getter
@Setter
@AllArgsConstructor
public class Address {
    private Country country;
    private String street;
    private int houseNumber;
    private int apartmentNumber;




    @Override
    public String toString() {
        return "Address{" +
                "country=" + country +
                ", street='" + street + '\'' +
                ", houseNumber=" + houseNumber +
                ", apartmentNumber=" + apartmentNumber +
                '}';
    }
}

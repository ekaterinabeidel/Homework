package org.example._2024_04_15;
import lombok.*;
import org.example._2024_04_15._enums.BankAccountCurrency;


@Getter
@Setter
@AllArgsConstructor

public class BankAccount {
private BankAccountCurrency bankAccountCurrency;
private double balance;
private int accountNumber;

    @Override
    public String toString() {
         return "BankAccount{" +
                "bankAccountCurrency=" + bankAccountCurrency +
                ", balance=" + balance +
                ", accountNumber=" + accountNumber +
                '}';
    }
}

//package org.example._2024_04_19.banking;
//
//import java.time.LocalDate;
//import java.time.Month;
//import java.util.ArrayList;
//import java.util.List;
//
//public class Account {
//    private double balance;
//    private List<Transaction> transactions;
//    public Account(){
//        transactions = new ArrayList<>();
//
//    }
//
//    public void withdraw (double sum) {
//        if (sum < 0) throw new IllegalArgumentException("Sum incorrect");
//        if (sum > balance) throw new IllegalArgumentException("Insufficient funds");
//        transactions.add(new Transaction(-sum, LocalDate.now()));
//        balance -=sum;
//        }
//    }
//    public double deposit(double sum) {
//        if (sum < 0) throw new IllegalArgumentException("Sum incorrect");
//        transactions.add(new Transaction(sum, LocalDate.now()));
//        balance +=sum;
//    }
//    public List<Transaction> getTransactions() {
//        return new ArrayList<>(transactions);
//    }
//    public double incomes(Month month) {
//    for (Transaction t : transactions) {
//        int result = 0;
//        if(t.sum() > 0 && t.date().getMonth() == month) {
//            result +=t.sum();
//        }
//    }
//    return result;
//    }
//
//public double expences(Month month) {
//    for (Transaction t : transactions) {
//        int result = 0;
//        if(t.sum() > 0 && t.date().getMonth() == month) {
//            result +=t.sum();
//        }
//    }
//    return result;


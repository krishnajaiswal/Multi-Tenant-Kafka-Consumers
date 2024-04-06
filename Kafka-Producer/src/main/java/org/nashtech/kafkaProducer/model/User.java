package org.nashtech.kafkaProducer.model;

import lombok.Data;

@Data
public class User {

    private int employeeId;
    private String name;
    private int numberOfDaysWorked;
    private int baseSalary;
    private int bonus;
    private int taxDeduction;

    public User(int employeeId, String name, int numberOfDaysWorked, int baseSalary, int bonus, int taxDeduction) {
        this.employeeId = employeeId;
        this.name = name;
        this.numberOfDaysWorked = numberOfDaysWorked;
        this.baseSalary = baseSalary;
        this.bonus = bonus;
        this.taxDeduction = taxDeduction;
    }

    public User() {
    }
}

package com.nashtech.multiTenancyKafka.model;

public class JsonMessage {

    private int employeeId;
    private String tenantId;
    private String name;
    private int salary;

    public JsonMessage(String tenantId, int employeeId, String name, int salary) {
        this.tenantId = tenantId;
        this.employeeId = employeeId;
        this.name = name;
        this.salary = salary;
    }

    public JsonMessage() {

    }
}

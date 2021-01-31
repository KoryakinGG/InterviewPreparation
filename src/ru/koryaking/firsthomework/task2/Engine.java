package ru.koryaking.firsthomework.task2;

public class Engine {
    private int power;
    private String motorPowerType;
    private int numberOfCylinders;

    public Engine(int power, String motorPowerType, int numberOfCylinders) {
        this.power = power;
        this.motorPowerType = motorPowerType;
        this.numberOfCylinders = numberOfCylinders;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String getMotorPowerType() {
        return motorPowerType;
    }

    public void setMotorPowerType(String motorPowerType) {
        this.motorPowerType = motorPowerType;
    }

    public int getNumberOfCylinders() {
        return numberOfCylinders;
    }

    public void setNumberOfCylinders(int numberOfCylinders) {
        this.numberOfCylinders = numberOfCylinders;
    }

}

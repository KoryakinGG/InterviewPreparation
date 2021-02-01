package ru.koryaking.firsthomework.task2;

public class EngineLightWeightCar extends AbstractEngine {

    public EngineLightWeightCar(int power, String motorPowerType, int numberOfCylinders) {
        setPower(power);
        setMotorPowerType(motorPowerType);
        setNumberOfCylinders(numberOfCylinders);
    }
}

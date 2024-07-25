/**
 * Copyright (c) 2024 All Rights Reserved
 */
package org.example.entity;

import org.example.enums.ColorEnum;
import org.example.enums.VehicleTypeEnum;

import java.util.List;

/**
 * @author Yosepri Disyandro Berutu (yosepri.berutu@binus.ac.id)
 * @version $Id: Vehicle.java , v 0.1 2024-07-24 21.37 Yosepri Disyandro Berutu Exp $$
 */
public class Vehicle {

    /** registrationNumber*/
    private String registrationNumber;

    /** color */
    private ColorEnum color;

    /** vehicleType */
    private VehicleTypeEnum type;

    private Ticket ticket;


    public Vehicle() {
    }

    public Vehicle(String registrationNumber, ColorEnum color, VehicleTypeEnum type) {
        this.registrationNumber = registrationNumber;
        this.color = color;
        this.type = type;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public ColorEnum getColor() {
        return color;
    }

    public void setColor(ColorEnum color) {
        this.color = color;
    }

    public VehicleTypeEnum getType() {
        return type;
    }

    public void setType(VehicleTypeEnum type) {
        this.type = type;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}

/**
 * Copyright (c) 2024 All Rights Reserved
 */
package org.example.entity;

import org.example.enums.VehicleTypeEnum;

/**
 * @author Yosepri Disyandro Berutu (yosepri.berutu@binus.ac.id)
 * @version $Id: ParkingSlot.java , v 0.1 2024-07-24 21.42 Yosepri Disyandro Berutu Exp $$
 */
public class ParkingSlot {
    private VehicleTypeEnum allowedType;
    private int slotNumber;
    private Vehicle vehicle;

    public VehicleTypeEnum getAllowedType() {
        return allowedType;
    }

    public void setAllowedType(VehicleTypeEnum allowedType) {
        this.allowedType = allowedType;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(int slotNumber) {
        this.slotNumber = slotNumber;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}

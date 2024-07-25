/**
 * Copyright (c) 2024 All Rights Reserved
 */
package org.example.entity;

import java.util.List;

/**
 * @author Yosepri Disyandro Berutu (yosepri.berutu@binus.ac.id)
 * @version $Id: Floor.java , v 0.1 2024-07-24 21.44 Yosepri Disyandro Berutu Exp $$
 */
public class Floor {

    private int floorNumber;

    private List<ParkingSlot> parkingSlots;

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public List<ParkingSlot> getParkingSlots() {
        return parkingSlots;
    }

    public void setParkingSlots(List<ParkingSlot> parkingSlots) {
        this.parkingSlots = parkingSlots;
    }
}

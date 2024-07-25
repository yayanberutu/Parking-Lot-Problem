/**
 * Copyright (c) 2024 All Rights Reserved
 */
package org.example.entity;

import java.util.List;

/**
 * @author Yosepri Disyandro Berutu (yosepri.berutu@binus.ac.id)
 * @version $Id: ParkingLot.java , v 0.1 2024-07-24 21.48 Yosepri Disyandro Berutu Exp $$
 */
public class ParkingLot {
    private String parkingLotId;
    private int numberOfFloor;
    private int numberOfSlotPerFloor;
    private List<Floor> floors;

    public ParkingLot() {
    }

    public ParkingLot(String parkingLotId, int numberOfFloor, int numberOfSlotPerFloor) {
        this.parkingLotId = parkingLotId;
        this.numberOfFloor = numberOfFloor;
        this.numberOfSlotPerFloor = numberOfSlotPerFloor;
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public void setFloors(List<Floor> floors) {
        this.floors = floors;
    }

    public String getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(String parkingLotId) {
        this.parkingLotId = parkingLotId;
    }

    public int getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(int numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }

    public int getNumberOfSlotPerFloor() {
        return numberOfSlotPerFloor;
    }

    public void setNumberOfSlotPerFloor(int numberOfSlotPerFloor) {
        this.numberOfSlotPerFloor = numberOfSlotPerFloor;
    }

}

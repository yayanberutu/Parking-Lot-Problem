/**
 * Copyright (c) 2024 All Rights Reserved
 */
package org.example.entity;

/**
 * @author Yosepri Disyandro Berutu (yosepri.berutu@binus.ac.id)
 * @version $Id: Ticket.java , v 0.1 2024-07-24 21.47 Yosepri Disyandro Berutu Exp $$
 */
public class Ticket {
    private String parkingLotId;
    private String floorNo;
    private String slotNo;

    public String getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(String parkingLotId) {
        this.parkingLotId = parkingLotId;
    }

    public String getFloorNo() {
        return floorNo;
    }

    public void setFloorNo(String floorNo) {
        this.floorNo = floorNo;
    }

    public String getSlotNo() {
        return slotNo;
    }

    public void setSlotNo(String slotNo) {
        this.slotNo = slotNo;
    }
}

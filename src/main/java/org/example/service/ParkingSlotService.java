/**
 * Copyright (c) 2024 All Rights Reserved
 */
package org.example.service;

import org.example.entity.ParkingSlot;
import org.example.enums.VehicleTypeEnum;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yosepri Disyandro Berutu (yosepri.berutu@binus.ac.id)
 * @version $Id: ParkingSlotService.java , v 0.1 2024-07-24 22.57 Yosepri Disyandro Berutu Exp $$
 */
public class ParkingSlotService {

    public static List<ParkingSlot> buildParkingSlots(int numOfSlot) {
        List<ParkingSlot> parkingSlots = new ArrayList<>();

        for (int i = 1; i <= numOfSlot; i++) {
            ParkingSlot parkingSlot = new ParkingSlot();
            parkingSlot.setSlotNumber(i);
            if (i == 1) {
                parkingSlot.setAllowedType(VehicleTypeEnum.TRUCK);
            } else if (i == 2 || i == 3) {
                parkingSlot.setAllowedType(VehicleTypeEnum.BIKE);
            } else {
                parkingSlot.setAllowedType(VehicleTypeEnum.CAR);
            }

            parkingSlots.add(parkingSlot);
        }

        return parkingSlots;
    }
}

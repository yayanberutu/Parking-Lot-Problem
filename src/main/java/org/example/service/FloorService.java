/**
 * Copyright (c) 2024 All Rights Reserved
 */
package org.example.service;

import org.example.entity.Floor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yosepri Disyandro Berutu (yosepri.berutu@binus.ac.id)
 * @version $Id: FloorService.java , v 0.1 2024-07-24 22.46 Yosepri Disyandro Berutu Exp $$
 */
public class FloorService {

    public static List<Floor> buildFloors(int numOfFloors, int numOfSlotPerFloor) {
        List<Floor> floors = new ArrayList<>();
        for (int i = 0; i < numOfFloors; i++) {
            Floor floor = new Floor();
            floor.setFloorNumber(i+1);
            floor.setParkingSlots(ParkingSlotService.buildParkingSlots(numOfSlotPerFloor));
            floors.add(floor);
        }

        return floors;
    }
}

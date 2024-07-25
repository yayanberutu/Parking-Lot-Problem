/**
 * Copyright (c) 2024 All Rights Reserved
 */
package org.example;

import org.example.entity.Floor;
import org.example.entity.ParkingLot;
import org.example.entity.ParkingSlot;
import org.example.enums.VehicleTypeEnum;
import org.example.service.ParkingLotService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Yosepri Disyandro Berutu (yosepri.berutu@binus.ac.id)
 * @version $Id: ParkingLotServiceTest.java , v 0.1 2024-07-24 22.21 Yosepri Disyandro Berutu Exp $$
 */
public class ParkingLotServiceTest {

    @Test
    public void createParkingLotTest_notNullParkingLot(){
        ParkingLot parkingLot = null;
        parkingLot = ParkingLotService.createParkingLot("id1", 1, 1);
        Assertions.assertNotNull(parkingLot);
    }

    @Test void createParkingLotTest_correctParkingLotId(){
        String id = "id1";
        ParkingLot parkingLot = null;
        parkingLot = ParkingLotService.createParkingLot(id, 1, 1);

        Assertions.assertEquals(id, parkingLot.getParkingLotId());

    }

    @Test
    public void createParkingLotTest_notNullFloor(){
        ParkingLot parkingLot = null;
        parkingLot = ParkingLotService.createParkingLot("id2", 1, 1);

        Assertions.assertNotNull(parkingLot.getFloors());
    }

    @Test
    public void createParkingLotTest_correctNumOfFloor(){
        ParkingLot parkingLot = null;

        int numberOfFloors = 2;
        parkingLot = ParkingLotService.createParkingLot("id1", numberOfFloors, 1);

        Assertions.assertEquals(numberOfFloors, parkingLot.getFloors().size());
    }

    @Test
    void createParkingLotTest_notNullParkingSlot(){
        ParkingLot parkingLot = null;

        int numberOfFloors = 2;
        int numberOfSlotsPerFloor = 5;
        parkingLot = ParkingLotService.createParkingLot("id1", numberOfFloors, 1);

        for (Floor floor : parkingLot.getFloors()) {
            Assertions.assertNotNull(floor.getParkingSlots());
        }
    }

    @Test
    void createParkingLotTest_correctNumOfSlotPerFloor(){
        ParkingLot parkingLot = null;

        int numberOfFloors = 2;
        int numberOfSlotsPerFloor = 5;
        parkingLot = ParkingLotService.createParkingLot("id1", numberOfFloors, numberOfSlotsPerFloor);

        Assertions.assertEquals(numberOfFloors, parkingLot.getFloors().size());

        for (Floor floor : parkingLot.getFloors()) {
            Assertions.assertEquals(numberOfSlotsPerFloor, floor.getParkingSlots().size());
        }
    }

    @Test
    void createParkingLotTest_correctTypeOfVehicleInEachSlot(){
        ParkingLot parkingLot = null;
        int numberOfFloors = 2;
        int numberOfSlotsPerFloor = 5;
        parkingLot = ParkingLotService.createParkingLot("id1", numberOfFloors, numberOfSlotsPerFloor);

        for (Floor floor : parkingLot.getFloors()) {

            for (ParkingSlot parkingSlot : floor.getParkingSlots()) {
                if (parkingSlot.getSlotNumber() == 1) {
                    Assertions.assertEquals(VehicleTypeEnum.TRUCK, parkingSlot.getAllowedType());
                } else if (parkingSlot.getSlotNumber() == 2
                        || parkingSlot.getSlotNumber() == 3) {
                    Assertions.assertEquals(VehicleTypeEnum.BIKE, parkingSlot.getAllowedType());
                } else {
                    Assertions.assertEquals(VehicleTypeEnum.CAR, parkingSlot.getAllowedType());
                }
            }

        }
    }


}

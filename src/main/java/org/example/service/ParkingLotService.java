/**
 * Copyright (c) 2024 All Rights Reserved
 */
package org.example.service;

import org.example.entity.*;
import org.example.enums.ColorEnum;
import org.example.enums.VehicleTypeEnum;

/**
 * @author Yosepri Disyandro Berutu (yosepri.berutu@binus.ac.id)
 * @version $Id: ParkingLotService.java , v 0.1 2024-07-24 22.15 Yosepri Disyandro Berutu Exp $$
 */
public class ParkingLotService {

    public static ParkingLot createParkingLot(String parkingLotId, int numOfFloor, int numOfSlotPerFloor) {
        ParkingLot parkingLot = new ParkingLot(parkingLotId, numOfFloor, numOfSlotPerFloor);

        parkingLot.setFloors(FloorService.buildFloors(numOfFloor, numOfSlotPerFloor));
        return parkingLot;
    }

    public static String parkVehicle(ParkingLot parkingLot, String vehicleType, String regNo, String vehicleColor) {
        Vehicle vehicle = new Vehicle(regNo, ColorEnum.getByType(vehicleColor), VehicleTypeEnum.getByType(vehicleType));

        for (Floor floor : parkingLot.getFloors()) {
            for (ParkingSlot slot : floor.getParkingSlots()) {

                if (isAvailableSloot(slot, vehicle)) {
                    fillSlot(slot, vehicle);
                    return parkingLot.getParkingLotId() +  "_" + floor.getFloorNumber() + "_" + slot.getSlotNumber();
                }

            }
        }

        return "";
    }

    public static Vehicle unparkVehicle(ParkingLot parkingLot, String ticketId) {
        return unParkAndCheckExistVehicleAndCheckExistVehicle(parkingLot, ticketId);
    }

    public static void displayFreeCount(ParkingLot parkingLot, String vehicleType) {
        VehicleTypeEnum vehicleTypeEnum = VehicleTypeEnum.getByType(vehicleType);
        for (Floor floor : parkingLot.getFloors()) {

            int emptySlotCounter = 0;

            for (ParkingSlot slot : floor.getParkingSlots()) {
                if (slot.getAllowedType() == vehicleTypeEnum
                        && slot.getVehicle() == null) {
                    emptySlotCounter++;
                }
            }

            System.out.printf("No. of free slots for %s on Floor %d: %s\n", vehicleType, floor.getFloorNumber(), emptySlotCounter);
        }
    }

    public static void displayFreeSlot(ParkingLot parkingLot, String vehicleType) {
        VehicleTypeEnum vehicleTypeEnum = VehicleTypeEnum.getByType(vehicleType);

        for (Floor floor : parkingLot.getFloors()) {

            String emptySlotNumListStr = "";
            for (ParkingSlot slot : floor.getParkingSlots()) {
                if (slot.getAllowedType() == vehicleTypeEnum
                        && slot.getVehicle() == null) {
                    if (!emptySlotNumListStr.equals("")) {
                        emptySlotNumListStr += ",";
                    }
                    emptySlotNumListStr += String.valueOf(slot.getSlotNumber());
                }
            }

            System.out.printf("No. of free slots for %s on Floor %d: %s\n", vehicleType, floor.getFloorNumber(), emptySlotNumListStr);
        }
    }

    public static void displayOccupiedSlot(ParkingLot parkingLot, String vehicleType) {
        VehicleTypeEnum vehicleTypeEnum = VehicleTypeEnum.getByType(vehicleType);

        for (Floor floor : parkingLot.getFloors()) {

            String occupiedSlotNumListStr = "";
            for (ParkingSlot slot : floor.getParkingSlots()) {
                if (slot.getAllowedType() == vehicleTypeEnum
                        && slot.getVehicle() != null) {
                    if (!occupiedSlotNumListStr.equals("")) {
                        occupiedSlotNumListStr += ",";
                    }
                    occupiedSlotNumListStr += String.valueOf(slot.getSlotNumber());
                }
            }

            System.out.printf("Occupied slots for for %s on Floor %d: %s\n", vehicleType, floor.getFloorNumber(), occupiedSlotNumListStr);
        }
    }

    private static Vehicle unParkAndCheckExistVehicleAndCheckExistVehicle(ParkingLot parkingLot, String ticketId) {
        String splittedTicketId[] = ticketId.split("_");
        String parkingLotId = splittedTicketId[0];

        // need to substract with 1 because the index start from 0
        int floorNum = Integer.valueOf(splittedTicketId[1]) - 1;
        int slotNum = Integer.valueOf(splittedTicketId[2]) -1;

        try {
            Vehicle vehicle = parkingLot.getFloors().get(floorNum).getParkingSlots().get(slotNum).getVehicle();
            if (parkingLot.getParkingLotId().equals(parkingLotId)
                    && vehicle != null) {
                parkingLot.getFloors().get(floorNum).getParkingSlots().get(slotNum).setVehicle(null);
                return vehicle;
            }
        } catch (IndexOutOfBoundsException | NullPointerException e) {
            return null;
        }

        return null;
    }


    private static void fillSlot(ParkingSlot slot, Vehicle vehicle) {
        slot.setVehicle(vehicle);
    }

    private static boolean isAvailableSloot(ParkingSlot slot, Vehicle vehicle) {
        VehicleTypeEnum allowedType = slot.getAllowedType();
        return allowedType == vehicle.getType()
                && slot.getVehicle() == null;
    }
}

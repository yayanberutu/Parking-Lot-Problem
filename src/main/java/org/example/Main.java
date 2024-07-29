package org.example;

import org.example.entity.ParkingLot;
import org.example.entity.Vehicle;
import org.example.enums.CommandEnum;
import org.example.service.ParkingLotService;

import java.util.Scanner;

/**
 * @author Yosepri Disyandro Berutu (yosepri.berutu@binus.ac.id)
 * @version $Id: Main.java , v 0.1 2024-07-22 13.31 Yosepri Disyandro Berutu Exp $$
 */
public class Main {


    public static void main(String[] args) {
        String command = "";

        ParkingLot parkingLot = null;
        while (!command.equals("exit")) {
            Scanner scanner = new Scanner(System.in);
            command = scanner.nextLine();

            String finalCommand = reBuildCommand(command);
            String splittedCommand[] = command.split(" ");
            if (isValidCommand(finalCommand)) {
                if (finalCommand.equals(CommandEnum.CREATE_PARKING_LOT.getFullCommand())) {
                    parkingLot = createParkingLot(splittedCommand);
                } else if (finalCommand.equals(CommandEnum.PARK_VEHICLE.getFullCommand())) {
                    parkVehicle(splittedCommand, parkingLot);
                } else if (finalCommand.equals(CommandEnum.UNPARK_VEHICLE.getFullCommand())) {
                    unparkVehicle(splittedCommand, parkingLot);
                } else if (finalCommand.equals(CommandEnum.DISPLAY_FREE_COUNT.getFullCommand())) {
                    String vehicleType = splittedCommand[2];
                    ParkingLotService.displayFreeCount(parkingLot, vehicleType);
                } else if(finalCommand.equals(CommandEnum.DISPLAY_FREE_SLOTS.getFullCommand())) {
                    String vehicleType = splittedCommand[2];
                    ParkingLotService.displayFreeSlot(parkingLot, vehicleType);
                } else if(finalCommand.equals(CommandEnum.DISPLAY_OCCUPIED_SLOTS.getFullCommand())) {
                    String vehicleType = splittedCommand[2];
                    ParkingLotService.displayOccupiedSlot(parkingLot, vehicleType);
                }
            } else {
                command = "exit";
            }
        }
    }

    private static String reBuildCommand(String command) {
        String splittedCommand[] = command.split(" ");
        String finalCommand = splittedCommand[0];
        if (finalCommand.equals("display")) {
            finalCommand = finalCommand + " " + splittedCommand[1];
        }

        return finalCommand;
    }

    private static void unparkVehicle(String[] splittedCommand, ParkingLot parkingLot) {
        String ticketId = splittedCommand[1];
        Vehicle vehicle = ParkingLotService.unparkVehicle(parkingLot, ticketId);
        if (vehicle != null) {
            System.out.printf("Unparked vehicle with Registration Number: %s and Color: %s\n",
                    vehicle.getRegistrationNumber(), vehicle.getColor().getType());
        } else {
            System.out.println("Invalid Ticket");
        }
    }

    private static void parkVehicle(String[] splittedCommand, ParkingLot parkingLot) {
        String vehicleType = splittedCommand[1];
        String regNo = splittedCommand[2];
        String vehicleColor = splittedCommand[3];
        String ticketId = ParkingLotService.parkVehicle(parkingLot, vehicleType, regNo, vehicleColor);
        if (!ticketId.isEmpty()) {
            System.out.printf("Parked vehicle. Ticket ID: %s\n", ticketId);
        } else {
            System.out.println("Parking Lot Full");
        }
    }

    private static ParkingLot createParkingLot(String[] splittedCommand) {
        ParkingLot parkingLot;
        // will create parking lot
        String parkingLotId = splittedCommand[1];
        int numOfFloor = Integer.valueOf(splittedCommand[2]);
        int numOfSlotPerFloor = Integer.valueOf(splittedCommand[3]);

        parkingLot = ParkingLotService.createParkingLot(parkingLotId, numOfFloor, numOfSlotPerFloor);
        System.out.printf("Created parking lot with %d floors and %d slots per floor\n",
                parkingLot.getNumberOfFloor(), parkingLot.getNumberOfSlotPerFloor());

        return parkingLot;
    }

    private static boolean isValidCommand(String command) {
        return CommandEnum.isValidCommand(command);
    }
}
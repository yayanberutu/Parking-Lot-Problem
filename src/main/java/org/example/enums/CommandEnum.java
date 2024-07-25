/**
 * Copyright (c) 2024 All Rights Reserved
 */
package org.example.enums;

/**
 * @author Yosepri Disyandro Berutu (yosepri.berutu@binus.ac.id)
 * @version $Id: CommandEnum.java , v 0.1 2024-07-24 21.55 Yosepri Disyandro Berutu Exp $$
 */
public enum CommandEnum {
    CREATE_PARKING_LOT("create_parking_lot", "create_parking_lot"),
    PARK_VEHICLE("park_vehicle", "park_vehicle"),
    UNPARK_VEHICLE("unpark_vehicle", "unpark_vehicle"),
    DISPLAY_FREE_COUNT("display free_count", "display"),
    DISPLAY_FREE_SLOTS("display free_slots", "display"),
    DISPLAY_OCCUPIED_SLOTS("display occupied_slots", "display"),

    ;
    private String fullCommand;
    private String firstCommandStatement;

    CommandEnum(String fullCommand, String firstCommandStatement) {
        this.fullCommand = fullCommand;
        this.firstCommandStatement = firstCommandStatement;
    }

    public String getFullCommand() {
        return fullCommand;
    }

    public String getFirstCommandStatement() {
        return firstCommandStatement;
    }

    public static CommandEnum getCommandEnumByFullCommand(String fullCommand) {
        for (CommandEnum commandEnum : CommandEnum.values()) {
            if (commandEnum.getFullCommand().equals(fullCommand)) {
                return commandEnum;
            }
        }

        throw new IllegalArgumentException();
    }

    public static boolean isValidCommand(String fullCommand) {
        for (CommandEnum commandEnum : CommandEnum.values()) {
            if (commandEnum.getFullCommand().equals(fullCommand)) {
                return true;
            }
        }

        return false;
    }

}

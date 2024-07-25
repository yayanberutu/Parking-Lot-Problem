/**
 * Copyright (c) 2024 All Rights Reserved
 */
package org.example.enums;

/**
 * @author Yosepri Disyandro Berutu (yosepri.berutu@binus.ac.id)
 * @version $Id: VehicleTypeEnum.java , v 0.1 2024-07-24 21.38 Yosepri Disyandro Berutu Exp $$
 */
public enum VehicleTypeEnum {
    CAR("CAR"),

    BIKE("BIKE"),

    TRUCK("TRUCK")
    ;

    private String type;

    VehicleTypeEnum(String type) {
        this.type = type;
    }

    public static VehicleTypeEnum getByType(String type) {
        for (VehicleTypeEnum vehicleTypeEnum : VehicleTypeEnum.values()) {
            if (vehicleTypeEnum.getType().equals(type)) {
                return  vehicleTypeEnum;
            }
        }

        return null;
    }

    public String getType() {
        return type;
    }
}

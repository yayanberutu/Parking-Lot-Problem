/**
 * Copyright (c) 2024 All Rights Reserved
 */
package org.example.enums;

/**
 * @author Yosepri Disyandro Berutu (yosepri.berutu@binus.ac.id)
 * @version $Id: ColorEnum.java , v 0.1 2024-07-24 21.39 Yosepri Disyandro Berutu Exp $$
 */
public enum ColorEnum {
    RED("red"),
    GREEN("green"),
    BLUE("blue"),
    YELLOW("yellow"),
    WHITE("white"),

    ;

    private String type;

    ColorEnum(String type) {
        this.type = type;
    }

    public static ColorEnum getByType(String type) {
        for (ColorEnum colorEnum : ColorEnum.values()) {
            if (colorEnum.type.equals(type)) {
                return colorEnum;
            }
        }
        return null;
    }

    public String getType() {
        return type;
    }
}
